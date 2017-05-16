package com.gp.wu.graphtrip.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.XRefreshViewFooter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.adapter.ImageLoopAdapter;
import com.gp.wu.graphtrip.adapter.SightAdapter;
import com.gp.wu.graphtrip.base.BaseFragment;
import com.gp.wu.graphtrip.bean.SightBean;
import com.gp.wu.graphtrip.net.impl.SightService;
import com.gp.wu.graphtrip.view.CustomGifHeader;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;

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
 * Created by wu on 2017/3/28.
 */

public class DemoFragment extends BaseFragment{
    private String TAG = this.getClass().getSimpleName();

    @BindView(R.id.refresh_view)
    XRefreshView refresh_view;
    @BindView(R.id.rv_main)
    RecyclerView rv_main;

    GridLayoutManager layoutManager;

    private View headerView;
    private RollPagerView rpv_main;

    private int page = 1;
    private Retrofit retrofit;
    private SightService service;

    private List<SightBean.DataBean.ListBean> sightBeanList;
    private SightAdapter sightAdapter;

    private Call<SightBean> call;

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_1, container, false);
        return view;
    }

    @Override
    public void initData() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://place.qyer.com/china/alltravel/")
                .build();
        refresh_view.setPullLoadEnable(true);
        rv_main.setHasFixedSize(true);
        sightBeanList = new ArrayList<>();
        sightAdapter = new SightAdapter(getContext(), sightBeanList);
        layoutManager = new GridLayoutManager(getContext(), 1);
        rv_main.setLayoutManager(layoutManager);
        headerView = sightAdapter.setHeaderView(R.layout.view_banner_view, rv_main);
        rpv_main = (RollPagerView) headerView.findViewById(R.id.rpv_main);
        rpv_main.setAdapter(new ImageLoopAdapter(rpv_main));
        rpv_main.setAnimationDurtion(1000);
        rpv_main.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        CustomGifHeader header = new CustomGifHeader(getActivity());
        refresh_view.setCustomHeaderView(header);
        rv_main.setAdapter(sightAdapter);
        load(true);
        refresh_view.setAutoLoadMore(true);
        refresh_view.setPinnedTime(1500);
        refresh_view.setMoveForHorizontal(true);
        sightAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));

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
                        sightBeanList.clear();
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

    public void load(final boolean isRefresh){
        service = retrofit.create(SightService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("page", page++);
        map.put("type", "country");
        map.put("pid", 11);
        map.put("srot", 32);
        map.put("subsort", 0);
        map.put("isnominate", -1);
        map.put("haslastm", false);
        map.put("rank", 0);
        map.put("action", "list_json");

        call = service.getSight(map);
        call.enqueue(new Callback<SightBean>() {
            @Override
            public void onResponse(Call<SightBean> call, Response<SightBean> response) {
                if(response.body().getData().getList().size() > 0){
                    sightBeanList.addAll(response.body().getData().getList());
                    sightAdapter.notifyDataSetChanged();
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
            public void onFailure(Call<SightBean> call, Throwable t) {
                Log.i("demo_fragment_1", "fail");
            }
        });
    }

    /**
     * 生命周期
     */

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("fragment_demo_onAttach", TAG);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("fragment_demo_onAcCt", TAG);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("fragment_demo_onStart", TAG);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("fragment_demo_onResume", TAG);
        if(rpv_main != null){
            rpv_main.resume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("fragment_demo_onPause", TAG);

        if(rpv_main != null){
            rpv_main.pause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("fragment_demo_onStop", TAG);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("fragment_demo_DView", TAG);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("fragment_demo_onDestroy", TAG);
        if(call != null){
            call.cancel();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_demo_onDetach", TAG);
    }

}
