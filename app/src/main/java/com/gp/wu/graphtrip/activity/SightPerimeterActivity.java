package com.gp.wu.graphtrip.activity;

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
import com.gp.wu.graphtrip.fragment.PerimeterEatFragment;
import com.gp.wu.graphtrip.fragment.PerimeterGoFragment;
import com.gp.wu.graphtrip.fragment.PerimeterLiveFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wu on 2017/4/29.
 */

public class SightPerimeterActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.btn_sight_perimeter_back)
    Button btn_sight_perimeter_back;
    @BindView(R.id.tl_type)
    TabLayout tl_type;
    @BindView(R.id.vp_type)
    ViewPager vp_type;
    Bundle bundle;

    private String[] tabs;
    MainPagerAdapter adapter;

    List<Fragment> list = new ArrayList<>();
    PerimeterEatFragment eatFragment;
    PerimeterLiveFragment liveFragment;
    PerimeterGoFragment goFragment;


    @Override
    public int setLayout() {
        return R.layout.activity_sight_perimeter;
    }

    @Override
    public void initWidget() {
        tabs = getResources().getStringArray(R.array.nav_tab);
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
            tl_type.addTab(tl_type.newTab().setCustomView(textView));
        }
        eatFragment = new PerimeterEatFragment();
        liveFragment = new PerimeterLiveFragment();
        goFragment = new PerimeterGoFragment();
        list.add(eatFragment);
        list.add(liveFragment);
        list.add(goFragment);
        adapter = new MainPagerAdapter(getSupportFragmentManager(), list, tabs);
        vp_type.setAdapter(adapter);
        vp_type.setOffscreenPageLimit(3);
        vp_type.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = tl_type.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tl_type.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp_type.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        btn_sight_perimeter_back.setOnClickListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void getExtraData() {
        bundle = getIntent().getBundleExtra("bundle");
        eatFragment.setArguments(bundle);
        liveFragment.setArguments(bundle);
        goFragment.setArguments(bundle);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sight_perimeter_back:
                finish();
                break;
        }
    }
}
