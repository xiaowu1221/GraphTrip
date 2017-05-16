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
import com.gp.wu.graphtrip.adapter.PerimeterGoAdapter;
import com.gp.wu.graphtrip.base.BaseFragment;
import com.gp.wu.graphtrip.bean.PerimeterCateBean;
import com.gp.wu.graphtrip.bean.PerimeterGoBean;
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

public class PerimeterGoFragment extends BaseFragment implements View.OnClickListener{
    private String TAG = this.getClass().getSimpleName();
    private static final int GO_CATE_ID = 0;
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

    private List<PerimeterCateBean.DataBean> dataBeenList = new ArrayList<>();
    private List<PerimeterGoBean.DataBean.ResBean> resBeanList;
    private PerimeterGoAdapter goAdapter;
    private int orderType = 0;

    private Call<PerimeterCateBean> call;
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perimeter_go, container, false);
    }

    @Override
    public void initData() {
        bundle = getArguments();

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
        goAdapter = new PerimeterGoAdapter(getContext(), resBeanList);
        layoutManager = new GridLayoutManager(getContext(), 1);
        rv_main.setLayoutManager(layoutManager);
        CustomGifHeader header = new CustomGifHeader(getActivity());
        refresh_view.setCustomHeaderView(header);
        rv_main.setAdapter(goAdapter);
        getType();
        load(true, orderType);

        refresh_view.setAutoLoadMore(true);
        refresh_view.setPinnedTime(1500);
        refresh_view.setMoveForHorizontal(true);
        goAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));

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
                        load(true, orderType);
                    }
                });
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                load(false, orderType);
            }
        });

    }

    private void getType(){
        service = retrofit.create(SightPerimeterService.class);
        call = service.getPerimeterCate();
        call.enqueue(new Callback<PerimeterCateBean>() {
            @Override
            public void onResponse(Call<PerimeterCateBean> call, Response<PerimeterCateBean> response) {
                if(response.body().getData().size() > 0){
                    dataBeenList.addAll(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<PerimeterCateBean> call, Throwable t) {

            }
        });
    }
    private void load(final boolean isRefresh, int orderType){
        service = retrofit.create(SightPerimeterService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page++);
        map.put("type", "fun");
        map.put("id", sightCityId);
        map.put("typename", "city");
        map.put("cateid", GO_CATE_ID);
        map.put("lat", sightAddressBean.getData().getLat());
        map.put("lng", sightAddressBean.getData().getLng());
        map.put("bottom_coordinate", sightAddressBean.getData().getLat() + "," + sightAddressBean.getData().getLng());
        map.put("top_coordinate", sightAddressBean.getData().getLat() + "," + sightAddressBean.getData().getLng());
        map.put("resource", "poi");
        map.put("action", "maplist");
        map.put("order_type", orderType + "");
        Call<PerimeterGoBean> call = service.getPerimeterGo(map);
        call.enqueue(new Callback<PerimeterGoBean>() {
            @Override
            public void onResponse(Call<PerimeterGoBean> call, Response<PerimeterGoBean> response) {
                if(response.body().getData().getRes().size() > 0){
                    resBeanList.addAll(response.body().getData().getRes());
                    goAdapter.notifyDataSetChanged();
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
            public void onFailure(Call<PerimeterGoBean> call, Throwable t) {
                Log.i("perimeter_go_fragment", "fail");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(call != null){
            call.cancel();
        }
    }
}
