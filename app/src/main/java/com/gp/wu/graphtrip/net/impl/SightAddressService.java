package com.gp.wu.graphtrip.net.impl;

import com.gp.wu.graphtrip.bean.SightAddressBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by wu on 2017/4/29.
 */

public interface SightAddressService {
    @GET("/poi.php")
    Call<SightAddressBean> getSightAddress(@QueryMap Map<String, Object> map);
}
