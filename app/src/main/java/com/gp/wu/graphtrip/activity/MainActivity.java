package com.gp.wu.graphtrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.adapter.MainPagerAdapter;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.gp.wu.graphtrip.fragment.Demo2Fragment;
import com.gp.wu.graphtrip.fragment.Demo3Fragment;
import com.gp.wu.graphtrip.fragment.DemoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wu on 2017/3/21.
 */

public class MainActivity extends BaseActivity{
    @BindView(R.id.btn_setting)
    Button btn_setting;
    @BindView(R.id.tl_main)
    TabLayout tl_main;
    @BindView(R.id.vp_main)
    ViewPager vp_main;

    private String[] tabs;

    MainPagerAdapter adapter;

    List<Fragment> list = new ArrayList<>();
    DemoFragment demoFragment;
    Demo2Fragment demo2Fragment;
    Demo3Fragment demo3Fragment;
    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        btn_setting.setTypeface(typeface);
        tabs = getResources().getStringArray(R.array.action_tab);
        for(int i = 0; i < tabs.length; i++){
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 0, 0);
            TextView textView = new TextView(this);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
            textView.setText(tabs[i]);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.headline));
            textView.setTypeface(typeface);
            textView.setTextColor(getResources().getColorStateList(R.color.action_tab_text_select));
            tl_main.addTab(tl_main.newTab().setCustomView(textView));
        }

        demoFragment = new DemoFragment();
        demo2Fragment = new Demo2Fragment();
        demo3Fragment = new Demo3Fragment();
        list.add(demoFragment);
        list.add(demo2Fragment);
        list.add(demo3Fragment);
        adapter = new MainPagerAdapter(getSupportFragmentManager(), list, tabs);
        vp_main.setAdapter(adapter);
        vp_main.setOffscreenPageLimit(3);
        vp_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = tl_main.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tl_main.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp_main.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void initData(Bundle savedInstanceState) {
    }

    @Override
    public void getExtraData() {

    }

    @OnClick(R.id.btn_setting)
    public void settting(){
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }
}
