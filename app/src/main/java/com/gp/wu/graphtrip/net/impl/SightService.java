package com.gp.wu.graphtrip.net.impl;

import com.gp.wu.graphtrip.bean.SightBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by wu on 2017/4/23.
 */

public interface SightService {
    @POST("/poi.php")
    @FormUrlEncoded
    Call<SightBean> getSight(@FieldMap Map<String, Object> map);
}
