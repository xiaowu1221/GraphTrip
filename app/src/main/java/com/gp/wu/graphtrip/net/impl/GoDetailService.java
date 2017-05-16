package com.gp.wu.graphtrip.net.impl;

import com.gp.wu.graphtrip.bean.GoDetailBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by wu on 2017/5/7.
 */

public interface GoDetailService {
    @GET("map.php")
    Call<GoDetailBean> getGoDetail(@QueryMap Map<String, Object> map);

}
