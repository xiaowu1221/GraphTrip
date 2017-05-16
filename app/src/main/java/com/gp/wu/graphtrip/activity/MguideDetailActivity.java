package com.gp.wu.graphtrip.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.gp.wu.graphtrip.bean.MguideDetailBean;
import com.gp.wu.graphtrip.net.MguideDetailData;
import com.gp.wu.graphtrip.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by wu on 2017/5/6.
 */

public class MguideDetailActivity extends BaseActivity{

    @BindView(R.id.iv_mguide_detail_photo)
    ImageView iv_mguide_detail_photo;
    @BindView(R.id.tv_mguide_detail_content)
    TextView tv_mguide_detail_content;
    @BindView(R.id.ll_mguide_detail)
    LinearLayout ll_mguide_detail;
    private String url;
    private String img;
    @Override
    public int setLayout() {
        return R.layout.activity_mguide_detail;
    }

    @Override
    public void initWidget() {
        GlideUtils.loadImageView(this, img, iv_mguide_detail_photo);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        MguideDetailData.getInstance().getMguideDetailData(url, new MguideDetailData.GetMguideDetailData() {
            @Override
            public void getDetailData(List<MguideDetailBean> detailBeanList, String content) {
                Log.i("mguide_detail_activity", content);
                addView(detailBeanList, content);
            }
        });
    }
    private void addView(final List<MguideDetailBean> detailBeanList, String content){
        if(null != tv_mguide_detail_content && null != ll_mguide_detail)
        tv_mguide_detail_content.setText(content);
        ll_mguide_detail.removeAllViews();
        for(int i = 0; i < detailBeanList.size(); i++){
            View view = LayoutInflater.from(this).inflate(R.layout.mguide_detail_item_poi, null);
            final CardView cv_item_mguide_detail = (CardView) view.findViewById(R.id.cv_item_mguide_detail);
            TextView tv_item_detail_position = (TextView) view.findViewById(R.id.tv_item_detail_position);
            tv_item_detail_position.setText(i + 1 + "");
            TextView tv_item_detail_title = (TextView) view.findViewById(R.id.tv_item_detail_title);
            tv_item_detail_title.setText(detailBeanList.get(i).getCnname());
            final ImageView iv_item_detail_photo = (ImageView) view.findViewById(R.id.iv_item_detail_photo);
            GlideUtils.loadImageView(getBaseContext(), detailBeanList.get(i).getPhoto(), iv_item_detail_photo);
            TextView tv_item_detail_content = (TextView) view.findViewById(R.id.tv_item_detail_content);
            tv_item_detail_content.setText(detailBeanList.get(i).getDetail());
            cv_item_mguide_detail.setTag(i);
            cv_item_mguide_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(getBaseContext(), detailBeanList.get((Integer) v.getTag()).getId() + "", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), SightDetailActivity.class);
                    intent.putExtra("bean", detailBeanList.get((Integer) v.getTag()));
                    iv_item_detail_photo.setTransitionName("share");
                    Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(MguideDetailActivity.this, iv_item_detail_photo, iv_item_detail_photo.getTransitionName()).toBundle();
                    startActivity(intent, bundle);
                }
            });
            ll_mguide_detail.addView(view);
        }
    }


    @Override
    public void getExtraData() {
        url = getIntent().getStringExtra("url");
        img = getIntent().getStringExtra("img");
    }
}
