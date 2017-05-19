package com.gp.wu.graphtrip.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.tt.whorlviewlibrary.WhorlView;

import butterknife.BindView;
import cn.bmob.v3.BmobUser;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.whorl)
    WhorlView whorlView;
    private boolean hasUser = false;

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

        AsyncGetSPData asyncGetSPData = new AsyncGetSPData();
        asyncGetSPData.execute();

    }

    private void getData(){
        BmobUser bmobUser = BmobUser.getCurrentUser();
        if(bmobUser != null){
            hasUser = true;
        }else{
            //缓存用户对象为空时， 可打开用户注册界面…
        }
    }
    public class AsyncGetSPData extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            getData();
            return "ok";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            jump();
        }
    }

    private void jump(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                if(hasUser){
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }else{
                    intent.setClass(SplashActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);
    }

    @Override
    public void getExtraData() {

    }
}