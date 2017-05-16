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
import com.gp.wu.graphtrip.adapter.TravelNoteAdapter;
import com.gp.wu.graphtrip.base.BaseFragment;
import com.gp.wu.graphtrip.bean.TravelNotesBean;
import com.gp.wu.graphtrip.net.TravelNoteData;
import com.gp.wu.graphtrip.view.CustomGifHeader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wu on 2017/3/30.
 */

public class Demo3Fragment extends BaseFragment {
    private String TAG = this.getClass().getSimpleName();
    @BindView(R.id.refresh_view)
    XRefreshView refresh_view;
    @BindView(R.id.rv_main)
    RecyclerView rv_main;

    GridLayoutManager layoutManager;
    int page = 1;
    private static final String NOTE_URL = "http://place.qyer.com/china/travel-notes/new/page";

    private List<TravelNotesBean> beanList;
    private TravelNoteAdapter noteAdapter;
    @Override
    public View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo_3, container, false);
    }

    @Override
    public void initData() {
        refresh_view.setPullLoadEnable(true);
        rv_main.setHasFixedSize(true);
        beanList = new ArrayList<>();
        noteAdapter = new TravelNoteAdapter(getContext(), beanList);
        layoutManager = new GridLayoutManager(getContext(), 1);
        rv_main.setLayoutManager(layoutManager);
        CustomGifHeader header = new CustomGifHeader(getActivity());
        refresh_view.setCustomHeaderView(header);
        rv_main.setAdapter(noteAdapter);
        load(true);
        refresh_view.setAutoLoadMore(true);
        refresh_view.setPinnedTime(1500);
        refresh_view.setMoveForHorizontal(true);
        noteAdapter.setCustomLoadMoreView(new XRefreshViewFooter(getActivity()));

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
                        beanList.clear();
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
        if(isRefresh){
            page = 1;
            TravelNoteData.getInstance().getPoiData(NOTE_URL + page + "", new TravelNoteData.GetTravelNotesData() {
                @Override
                public void getNotesData(List<TravelNotesBean> notesBeanList) {
                    if(notesBeanList.size() <= 0){
                        refresh_view.setLoadComplete(true);
                    }else{
                        beanList.addAll(notesBeanList);
                        noteAdapter.notifyDataSetChanged();
                    }
                    if(null != refresh_view){
                        if(isRefresh){
                            refresh_view.stopRefresh();
                        }else{
                            refresh_view.stopLoadMore();
                        }
                    }

                }
            });
        }else{
            page++;
            TravelNoteData.getInstance().getPoiData(NOTE_URL + page + "", new TravelNoteData.GetTravelNotesData() {
                @Override
                public void getNotesData(List<TravelNotesBean> notesBeanList) {
                    if(notesBeanList.size() <= 0){
                        refresh_view.setLoadComplete(true);
                    }else{
                        beanList.addAll(notesBeanList);
                        noteAdapter.notifyDataSetChanged();
                    }
                    if(null != refresh_view){
                        if(isRefresh){
                            refresh_view.stopRefresh();
                        }else{
                            refresh_view.stopLoadMore();
                        }
                    }
                }
            });
        }

    }

























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
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("fragment_demo_onPause", TAG);
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

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("fragment_demo_onDetach", TAG);
    }
}