package com.gp.wu.graphtrip.base;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.app.MyApplication;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.gp.wu.graphtrip.R.id.rl_base;

/**
 * Created by wu on 2017/3/24.
 */

public abstract class BaseActivity extends AppCompatActivity{


    private ArrayList<Activity> activityArrayList = new ArrayList<Activity>();
    protected final String TAG = this.getClass().getSimpleName();

    private Unbinder mUnbinder;
    public Typeface typeface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        activityArrayList.add(this);
        this.typeface = MyApplication.typeface;
        Log.i("BaseActivity_Create", getClass().getSimpleName());
        setMyContentView(setLayout());
        mUnbinder = ButterKnife.bind(this);
        initWidget();
        getExtraData();
        initData(savedInstanceState);
    }
    protected final void setMyContentView(int layoutResID){
            setContentView(layoutResID);
    }
//    public void showWhorl(){
//        Log.i("base_activity", "whorl view");
//        whorl_view.start();
//    }
//    public void dismissWhorl(){
//        whorl_view.stop();
//    }

    //返回布局id
    public abstract int setLayout();
    //初始化页面控件
    public abstract void initWidget();
    //初始化页面数据
    public abstract void initData(Bundle savedInstanceState);
    public abstract void getExtraData();

    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    /**
     * [含有Bundle通过Class打开编辑界面]
     *
     * @param cls
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("BaseActivity_Destroy", getClass().getSimpleName());
        activityArrayList.remove(this);
        mUnbinder.unbind();
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            return getResources().getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        finish();
    }
}
