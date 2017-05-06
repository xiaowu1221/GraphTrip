package com.gp.wu.graphtrip.net.impl;

import com.gp.wu.graphtrip.bean.PerimeterCateBean;
import com.gp.wu.graphtrip.bean.PerimeterEatBean;
import com.gp.wu.graphtrip.bean.PerimeterGoBean;
import com.gp.wu.graphtrip.bean.PerimeterLiveBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wu on 2017/4/30.
 */

public interface SightPerimeterService {
    /**
     * http://place.qyer.com/map.php?action=maplist
     * action   maplist
     * type     fun
     * id       50
     * typename city
     * cateid   0   ""  78
     * page     1
     * lat
     * lng
     * resource poi
     */
    @POST("/map.php")
    @FormUrlEncoded
    Call<PerimeterEatBean> getPerimeterEat(@FieldMap Map<String, Object> map);

    @POST("/map.php")
    @FormUrlEncoded
    Call<PerimeterLiveBean> getPerimeterLive(@FieldMap Map<String, Object> map);

    @POST("/map.php")
    @FormUrlEncoded
    Call<PerimeterGoBean> getPerimeterGo(@FieldMap Map<String, Object> map);

    /**
     * http://place.qyer.com/map.php?action=poicate
     */
    @GET("map.php?action=poicate")
    Call<PerimeterCateBean> getPerimeterCate();
}
