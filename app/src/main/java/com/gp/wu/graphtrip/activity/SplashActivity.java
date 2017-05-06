package com.gp.wu.graphtrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.tt.whorlviewlibrary.WhorlView;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.whorl)
    WhorlView whorlView;
    @Override
    public int setLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initWidget() {
        whorlView.start();
    }

    @Override
    public void initData(Bundle savedInstanceState) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

    @Override
    public void getExtraData() {

    }
}