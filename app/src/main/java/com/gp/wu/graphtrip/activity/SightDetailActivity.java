package com.gp.wu.graphtrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.gp.wu.graphtrip.bean.MguideDetailBean;
import com.gp.wu.graphtrip.bean.PlacePoiDetailBean;
import com.gp.wu.graphtrip.bean.SightAddressBean;
import com.gp.wu.graphtrip.net.PlacePoiData;
import com.gp.wu.graphtrip.net.impl.SightAddressService;
import com.gp.wu.graphtrip.utils.DensityUtils;
import com.gp.wu.graphtrip.utils.GlideUtils;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wu on 2017/4/25.
 */

public class SightDetailActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.rl_share)
    RelativeLayout rl_share;
    @BindView(R.id.iv_sight_detail_photo)
    ImageView iv_sight_detail_photo;

    @BindView(R.id.tv_sight_detail_cnname)
    TextView tv_sight_detail_cnname;
    @BindView(R.id.tv_sight_detail_enname)
    TextView tv_sight_detail_enname;


    @BindView(R.id.ll_sight_detail_address)
    LinearLayout ll_sight_detail_address;
    @BindView(R.id.ll_sight_detail_perimeter)
    LinearLayout ll_sight_detail_perimeter;
    @BindView(R.id.ll_sight_detail_discount)
    LinearLayout ll_sight_detail_discount;
    @BindView(R.id.ll_sight_detail_detail)
    LinearLayout ll_sight_detail_detail;
    @BindView(R.id.ll_sight_detail_route)
    LinearLayout ll_sight_detail_route;
    @BindView(R.id.ll_sight_detail_tip)
    LinearLayout ll_sight_detail_tip;

    private String url;
    private String sightCityId;

    private MguideDetailBean detailBean;
    private SightAddressBean sightAddressBean;

    private PopupWindow popupWindow;
    View popupView;
    private TextView tv_pop_sight_cnname;
    private TextView tv_pop_sight_address;
    private TextView tv_pop_sight_traffic;
    private Button btn_pop_sight_go;

    View rootView;
    @Override
    public int setLayout() {
        return R.layout.activity_sight_detail;
    }

    @Override
    public void initWidget() {
        rl_back.setOnClickListener(this);
        rl_share.setOnClickListener(this);
        ll_sight_detail_address.setOnClickListener(this);
        ll_sight_detail_perimeter.setOnClickListener(this);
        initPopupWindow();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        PlacePoiData.getInstance().getPoiData(url, new PlacePoiData.GetPoiData() {
            @Override
            public void poiData(PlacePoiDetailBean placePoiDetailBean) {
//                Toast.makeText(getBaseContext(), placePoiDetailBean.getCnname(), Toast.LENGTH_SHORT).show();
                setData(placePoiDetailBean);
            }
        });
    }

    private void setData(PlacePoiDetailBean placePoiDetailBean){
        tv_sight_detail_cnname.setText(placePoiDetailBean.getCnname());
        tv_sight_detail_enname.setText(placePoiDetailBean.getEnname());
        ll_sight_detail_address.setVisibility(View.VISIBLE);
        ll_sight_detail_perimeter.setVisibility(View.VISIBLE);
        addDiscountView(placePoiDetailBean);
        addDetailView(placePoiDetailBean);
        addRouteView(placePoiDetailBean);
        addTipView(placePoiDetailBean);
        loadSightAddress();
        sightCityId = placePoiDetailBean.getCityId();
    }

    /**
     * ll_sight_detail_discount
     */
    private void addDiscountView(final PlacePoiDetailBean placePoiDetailBean){
        if(placePoiDetailBean.getPoiDiscountList().size() > 0){
            ll_sight_detail_discount.setVisibility(View.VISIBLE);
            for(int i = 0; i < placePoiDetailBean.getPoiDiscountList().size(); i++){
                View discountView = LayoutInflater.from(this).inflate(R.layout.sight_detail_item_discount, null);
                TextView tv_sight_detail_discount_tag = (TextView) discountView.findViewById(R.id.tv_sight_detail_discount_tag);
                tv_sight_detail_discount_tag.setText(placePoiDetailBean.getPoiDiscountList().get(i).getTag());
                TextView tv_sight_detail_discount_location = (TextView) discountView.findViewById(R.id.tv_sight_detail_discount_location);
                tv_sight_detail_discount_location.setText(placePoiDetailBean.getPoiDiscountList().get(i).getLocation());
                TextView tv_sight_detail_discount_price = (TextView) discountView.findViewById(R.id.tv_sight_detail_discount_price);
                tv_sight_detail_discount_price.setText(placePoiDetailBean.getPoiDiscountList().get(i).getPrice());
                TextView tv_sight_detail_discount_content = (TextView) discountView.findViewById(R.id.tv_sight_detail_discount_content);
                tv_sight_detail_discount_content.setText(placePoiDetailBean.getPoiDiscountList().get(i).getContent());
//                Log.i("sight_detail_activity", placePoiDetailBean.getPoiDiscountList().size() + "" + placePoiDetailBean.getPoiDiscountList().get(i).getLocation());
                discountView.setTag(i);
                discountView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Toast.makeText(getBaseContext(), placePoiDetailBean.getPoiDiscountList().get((Integer) v.getTag()).getHref(), Toast.LENGTH_SHORT).show();
                    }
                });
                ll_sight_detail_discount.addView(discountView);
            }
        }else{
            ll_sight_detail_discount.setVisibility(View.GONE);
        }
    }
    /**
     * ll_sight_detail_detail
     */
    private void addDetailView(PlacePoiDetailBean placePoiDetailBean){
        if(placePoiDetailBean.getDetail() != ""){
            ll_sight_detail_detail.setVisibility(View.VISIBLE);
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(DensityUtils.dp2px(this, 16), DensityUtils.dp2px(this, 8),DensityUtils.dp2px(this, 16),DensityUtils.dp2px(this, 8));
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(14);
            textView.setTextColor(getResources().getColor(R.color.grey_800));
            textView.setText(placePoiDetailBean.getDetail());
            ll_sight_detail_detail.addView(textView);
        }else{
            ll_sight_detail_detail.setVisibility(View.GONE);
        }
    }
    /**
     * ll_sight_detail_route
     */
    private void addRouteView(PlacePoiDetailBean placePoiDetailBean){
        if(placePoiDetailBean.getPoiRouteBeanList().size() > 0){
            ll_sight_detail_route.setVisibility(View.VISIBLE);
            for(int i = 0; i < placePoiDetailBean.getPoiRouteBeanList().size(); i++){
                View routeView = LayoutInflater.from(this).inflate(R.layout.sight_detail_item_route, null);
                TextView tv_sight_detail_route_key = (TextView) routeView.findViewById(R.id.tv_sight_detail_route_key);
                tv_sight_detail_route_key.setText(placePoiDetailBean.getPoiRouteBeanList().get(i).getKey());
                TextView tv_sight_detail_route_value = (TextView) routeView.findViewById(R.id.tv_sight_detail_route_value);
                tv_sight_detail_route_value.setText(placePoiDetailBean.getPoiRouteBeanList().get(i).getValue());
                ll_sight_detail_route.addView(routeView);
            }
        }else{
            ll_sight_detail_route.setVisibility(View.GONE);
        }
    }
    /**
     * ll_sight_detail_tip
     */
    private void addTipView(PlacePoiDetailBean placePoiDetailBean){
        if(placePoiDetailBean.getTipContent() != ""){
            ll_sight_detail_tip.setVisibility(View.VISIBLE);
            TextView textView = new TextView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(DensityUtils.dp2px(this, 16), DensityUtils.dp2px(this, 8),DensityUtils.dp2px(this, 16),DensityUtils.dp2px(this, 8));
            textView.setLayoutParams(layoutParams);
            textView.setTextSize(14);
            textView.setTextColor(getResources().getColor(R.color.grey_800));
            textView.setText(placePoiDetailBean.getTipContent());
            ll_sight_detail_tip.addView(textView);
        }else{
            ll_sight_detail_tip.setVisibility(View.GONE);
        }
    }

    @Override
    public void getExtraData() {
        detailBean = (MguideDetailBean) getIntent().getSerializableExtra("bean");
        url = detailBean.getUrl();
        GlideUtils.loadImageView(this, detailBean.getPhoto(), iv_sight_detail_photo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_back:
                finish();
                break;
            case R.id.rl_share:
                break;

            /**
             * 查看地址和交通
             */
            case R.id.ll_sight_detail_address:
                showPop(sightAddressBean);
                break;
            /**
             * 查看周边
             */
            case R.id.ll_sight_detail_perimeter:
                if(sightAddressBean != null && sightCityId != null && sightCityId != ""){
                    Intent intent = new Intent(this, SightPerimeterActivity.class);
                    Bundle bundle =  new Bundle();
                    bundle.putSerializable("sight_address", sightAddressBean);
                    bundle.putString("sight_city_id", sightCityId);
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);
                }
                break;

            /**
             * popupwindow中去这里
             */
            case R.id.btn_pop_sight_go:
                dismissPop();
                if(sightAddressBean != null && sightAddressBean.getData() != null){
                    Intent intent = new Intent(this, ShowMapActivity.class);
                    intent.putExtra("lat", sightAddressBean.getData().getLat());
                    intent.putExtra("lng", sightAddressBean.getData().getLng());
                    startActivity(intent);

                }

                break;

        }
    }
    private Retrofit retrofit;
    private SightAddressService addressService;
    private void loadSightAddress(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://place.qyer.com/")
                .build();
        addressService = retrofit.create(SightAddressService.class);
        Call<SightAddressBean> call = addressService.getSightAddress(detailBean.getId());
        call.enqueue(new Callback<SightAddressBean>() {
            @Override
            public void onResponse(Call<SightAddressBean> call, Response<SightAddressBean> response) {
                sightAddressBean = response.body();
            }

            @Override
            public void onFailure(Call<SightAddressBean> call, Throwable t) {

            }
        });
    }
    public void initPopupWindow(){
        if(popupView == null){
            rootView = LayoutInflater.from(this).inflate(R.layout.activity_sight_detail, null);
            popupView = LayoutInflater.from(this).inflate(R.layout.pop_sight_detail_address, null);
            tv_pop_sight_cnname = (TextView) popupView.findViewById(R.id.tv_pop_sight_cnname);
            tv_pop_sight_address = (TextView) popupView.findViewById(R.id.tv_pop_sight_address);
            tv_pop_sight_traffic = (TextView) popupView.findViewById(R.id.tv_pop_sight_traffic);
            btn_pop_sight_go = (Button) popupView.findViewById(R.id.btn_pop_sight_go);
            btn_pop_sight_go.setOnClickListener(this);
        }
        if(popupWindow == null){
            popupWindow = new PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
            popupWindow.setAnimationStyle(R.style.SightDetailPopInOut);
        }
    }
    public void showPop(SightAddressBean sightAddressBean){
        tv_pop_sight_cnname.setText(sightAddressBean.getData().getName());
        tv_pop_sight_address.setText(sightAddressBean.getData().getAddress());
        tv_pop_sight_traffic.setText(sightAddressBean.getData().getTraffic());
        if(!popupWindow.isShowing()){
            popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
        }
    }
    public void dismissPop(){
        if(popupWindow.isShowing()){
            popupWindow.dismiss();
        }
    }

    @Override
    public void onBackPressed() {
        if(popupWindow.isShowing()){
            dismissPop();
        }else{
            super.onBackPressed();
        }
    }
}
