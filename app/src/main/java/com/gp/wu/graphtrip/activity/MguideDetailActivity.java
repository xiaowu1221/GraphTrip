package com.gp.wu.graphtrip.activity;

import android.animation.AnimatorInflater;
import android.animation.LayoutTransition;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wu on 2017/5/6.
 */

public class MguideDetailActivity extends BaseActivity{
    @BindView(R.id.ll_mguide_detail)
    LinearLayout ll_mguide_detail;
    @Override
    public int setLayout() {
        return R.layout.activity_mguide_detail;
    }

    @Override
    public void initWidget() {
        LayoutTransition transition = new LayoutTransition();
        transition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(getBaseContext(), R.animator.item_bottom_in));
        ll_mguide_detail.setLayoutTransition(transition);
        addText();
        addImage();
    }

    private void addText(){
        for(int i = 0; i < 10; i++){
            TextView textView = new TextView(getBaseContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textView.setLayoutParams(layoutParams);
            textView.setText("测试" + i);
            ll_mguide_detail.addView(textView);
        }
    }
    private void addImage(){
        for(int i = 0; i < 10; i++){
            ImageView imageView = new ImageView(getBaseContext());
            imageView.setBackground(getResources().getDrawable(R.drawable.ic_like));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(layoutParams);
            ll_mguide_detail.addView(imageView);
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void getExtraData() {

    }
}
