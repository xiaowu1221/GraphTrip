package com.gp.wu.graphtrip.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.adapter.PerimeterLiveAdapter;
import com.gp.wu.graphtrip.base.BaseFragment;
import com.gp.wu.graphtrip.bean.PerimeterLiveBean;
import com.gp.wu.graphtrip.bean.SightAddressBean;
import com.gp.wu.graphtrip.net.impl.SightPerimeterService;
import com.gp.wu.graphtrip.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wu on 2017/4/29.
 */

public class PerimeterLiveFragment extends BaseFragment {
    private String TAG = this.getClass().getSimpleName();
    private static final int LIVE_CATE_ID = 0;
    Bundle bundle;
    @BindView(R.id.refresh_view)
    XRefreshView refresh_view;
    @BindView(R.id.rv_main)
    RecyclerView rv_main;
    GridLayoutManager layoutManager;

    private SightAddressBean sightAddressBean;
    private String sightCityId;
    private int page = 1;
    private Retrofit retrofit;
    private SightPerimeterService service;

    private List<PerimeterLiveBean.DataBean.ResBean> resBeanList;
    private PerimeterLiveAdapter liveAdapter;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perimeter_live, container, false);
    }

    @Override
    public void initData() {
        bundle = getArguments();
        sightAddressBean = (SightAddressBean) bundle.get("sight_address");
        sightCityId = (String) bundle.get("sight_city_id");
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://place.qyer.com/")
                .build();
        refresh_view.setPullLoadEnable(true);
        rv_main.setHasFixedSize(true);
        resBeanList = new ArrayList<>();
        liveAdapter = new PerimeterLiveAdapter(getContext(), resBeanList);
        layoutManager = new GridLayoutManager(getContext(), 1);
        rv_main.setLayoutManager(layoutManager);
        CustomGifHeader header = new CustomGifHeader(getActivity());
        refresh_view.setCustomHeaderView(header);
        rv_main.setAdapter(liveAdapter);
        load(true);

        refresh_view.setAutoLoadMore(true);
        refresh_view.setPinnedTime(1500);
        refresh_view.setMoveForHorizontal(true);
        liveAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));

//        xRefreshView1.setPullRefreshEnable(false);
        //设置在下拉刷新被禁用的情况下，是否允许界面被下拉,默认是true
//        xRefreshView1.setMoveHeadWhenDisablePullRefresh(false);
//        xRefreshView1.enablePullUpWhenLoadCompleted(false);
//		xRefreshView1.setPullLoadEnable(false);
//        xRefreshView1.enableRecyclerViewPullUp(false);
        //设置静默加载时提前加载的item个数
//		xRefreshView1.setPreLoadCount(2);
        refresh_view.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener(){
            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        resBeanList.clear();
                        load(true);
                    }
                }, 0);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                load(false);
            }
        });
    }
    public void load(final boolean isRefresh){
        service = retrofit.create(SightPerimeterService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("action", "maplist");
        map.put("page", page++);
        map.put("type", "hotel");
        map.put("id", sightCityId + "");
        map.put("typename", "city");
        map.put("cateid", "0");
        map.put("lat", sightAddressBean.getData().getLat() + "");
        map.put("lng", sightAddressBean.getData().getLng() + "");
        map.put("bottom_coordinate", sightAddressBean.getData().getLat() + "," + sightAddressBean.getData().getLng());
        map.put("top_coordinate", sightAddressBean.getData().getLat() + "," + sightAddressBean.getData().getLng());
        map.put("resource", "poi");

        Log.i("live_fragment", page + "\n" + "hotel" + "\n" + sightCityId + "\n" + "city" + "\n" + "" + sightAddressBean.getData().getLat() + "\n"
        + sightAddressBean.getData().getLng() + "\n" + "poi" + "\n" + "0" + "\n" +  "maplist");

        Call<PerimeterLiveBean> call = service.getPerimeterLive(map);
        call.enqueue(new Callback<PerimeterLiveBean>() {
            @Override
            public void onResponse(Call<PerimeterLiveBean> call, Response<PerimeterLiveBean> response) {
                if(response.body().getData().getRes().size() > 0){
                    resBeanList.addAll(response.body().getData().getRes());
                    liveAdapter.notifyDataSetChanged();
                }else{
                    refresh_view.setLoadComplete(true);
                }
                if(isRefresh){
                    refresh_view.stopRefresh();
                }else{
                    refresh_view.stopLoadMore();
                }
            }

            @Override
            public void onFailure(Call<PerimeterLiveBean> call, Throwable t) {
                Log.i("perimeter_live_fragment", "fail");
                Log.i("perimeter_live_fragment", t.getMessage().toString());
                Log.i("perimeter_live_fragment", call.toString());
            }
        });
    }
}
