package com.gp.wu.graphtrip.activity;

import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by wu on 2017/5/12.
 */

public class ShowMapActivity extends BaseActivity{
    @BindView(R.id.mapView)
    TextureMapView mapView;
    BaiduMap baiduMap;
    UiSettings uiSettings;
    PoiSearch poiSearch;

    private String lat;
    private String lng;
    @Override
    public int setLayout() {
        SDKInitializer.initialize(getApplicationContext());
        return R.layout.activity_show_map;
    }

    @Override
    public void initWidget() {
        mapView = (TextureMapView) findViewById(R.id.mapView);
        baiduMap = mapView.getMap();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        LatLng point = new LatLng(Double.valueOf(lat), Double.valueOf(lng));
        BitmapDescriptor bitmap = BitmapDescriptorFactory.fromResource(R.drawable.ic_location);
        OverlayOptions options = new MarkerOptions()
                .position(point)
                .icon(bitmap);
        baiduMap.addOverlay(options);
        MapStatus mMapStatus = new MapStatus.Builder()
                .target(point)
                .zoom(18)
                .build();
        //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        //改变地图状态
        baiduMap.animateMapStatus(mMapStatusUpdate);
    }

    @Override
    public void getExtraData() {
        lat = getIntent().getStringExtra("lat");
        lng = getIntent().getStringExtra("lng");
    }
}
