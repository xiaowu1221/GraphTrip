package com.gp.wu.graphtrip.net.impl;

import com.gp.wu.graphtrip.bean.SightAddressBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wu on 2017/4/29.
 */

public interface SightAddressService {
    @GET("/poi.php?action=poijson")
    Call<SightAddressBean> getSightAddress(@Query("id") String id);
}
