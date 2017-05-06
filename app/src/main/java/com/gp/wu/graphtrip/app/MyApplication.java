package com.gp.wu.graphtrip.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;

import com.gp.wu.graphtrip.constant.Constant;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;

/**
 * Created by wu on 2017/3/26.
 */

public class MyApplication extends Application{
    public static Typeface typeface;
    @Override
    public void onCreate() {
        super.onCreate();
        initBmob(this);
        typeface = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/lemeow.ttf");
    }

    private void initBmob(Context context){
        BmobConfig config = new BmobConfig.Builder(context)
                .setApplicationId(Constant.BMOB_APPID)
                //请求超时时间，默认15秒
//                .setConnectTimeout(10)
                //文件分片上传时每片的大小
//                .setUploadBlockSize(1024 * 1024)
                //文件的国旗时间，默认1800s
//                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);


    }
}
