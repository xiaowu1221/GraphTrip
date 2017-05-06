package com.gp.wu.graphtrip.net.impl;

import com.gp.wu.graphtrip.bean.MGuideBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by wu on 2017/5/4.
 */

public interface MguideService {
    @GET("/mguide.php")
    Call<MGuideBean> getMguide(@QueryMap Map<String, Object> map);
}
