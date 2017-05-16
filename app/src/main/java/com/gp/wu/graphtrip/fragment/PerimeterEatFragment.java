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
import com.gp.wu.graphtrip.adapter.PerimeterEatAdapter;
import com.gp.wu.graphtrip.base.BaseFragment;
import com.gp.wu.graphtrip.bean.PerimeterEatBean;
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

public class PerimeterEatFragment extends BaseFragment {
    private String TAG = this.getClass().getSimpleName();
    private static final int EAT_CATE_ID = 78;
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

    private List<PerimeterEatBean.DataBean.ResBean> resBeanList;
    private PerimeterEatAdapter eatAdapter;
    private Call<PerimeterEatBean> call;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perimeter_eat, container, false);
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
        eatAdapter = new PerimeterEatAdapter(getContext(), resBeanList);
        layoutManager = new GridLayoutManager(getContext(), 1);
        rv_main.setLayoutManager(layoutManager);
        CustomGifHeader header = new CustomGifHeader(getActivity());
        refresh_view.setCustomHeaderView(header);
        rv_main.setAdapter(eatAdapter);
        load(true);

        refresh_view.setAutoLoadMore(true);
        refresh_view.setPinnedTime(1500);
        refresh_view.setMoveForHorizontal(true);
        eatAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));

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
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        page = 1;
                        resBeanList.clear();
                        load(true);
                    }
                });
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                load(false);
            }
        });
    }
    private void load(final boolean isRefresh){
        service = retrofit.create(SightPerimeterService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page++);
        map.put("type", "food");
        map.put("id", sightCityId);
        map.put("typename", "city");
        map.put("cateid", EAT_CATE_ID);
        map.put("lat", sightAddressBean.getData().getLat());
        map.put("lng", sightAddressBean.getData().getLng());
        map.put("bottom_coordinate", sightAddressBean.getData().getLat() + "," + sightAddressBean.getData().getLng());
        map.put("top_coordinate", sightAddressBean.getData().getLat() + "," + sightAddressBean.getData().getLng());
        map.put("resource", "poi");
        map.put("action", "maplist");

        Log.i("live_fragment", page + "\n" + "food" + "\n" + sightCityId + "\n" + "city" + "\n" + "" + sightAddressBean.getData().getLat() + "\n"
                + sightAddressBean.getData().getLng() + "\n" + "poi" + "\n" + EAT_CATE_ID + "\n" +  "maplist");

        call = service.getPerimeterEat(map);
        call.enqueue(new Callback<PerimeterEatBean>() {
            @Override
            public void onResponse(Call<PerimeterEatBean> call, Response<PerimeterEatBean> response) {
                Log.i("perimeter_eat_fragment", response.body().getError_code() + ".." + response.body().getResult());
                if(response.body().getData().getRes().size() > 0){
                    resBeanList.addAll(response.body().getData().getRes());
                    eatAdapter.notifyDataSetChanged();
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
            public void onFailure(Call<PerimeterEatBean> call, Throwable t) {
                Log.i("perimeter_eat_fragment", "fail");
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(call != null){
            call.cancel();
        }
    }
}
