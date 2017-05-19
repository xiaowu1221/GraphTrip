package com.gp.wu.graphtrip.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.base.BaseActivity;
import com.gp.wu.graphtrip.net.NoteDetailData;
import com.gp.wu.graphtrip.utils.DensityUtils;
import com.gp.wu.graphtrip.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by wu on 2017/5/6.
 */

public class NoteDetailActivity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.ll_note_detail)
    LinearLayout ll_note_detail;
    @BindView(R.id.iv_note_detail_pic)
    ImageView iv_note_detail_pic;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;

    @BindView(R.id.rl_share)
    RelativeLayout rl_share;
    private String url;
    private String img;
    private int imageSize;
    @Override
    public int setLayout() {
        return R.layout.activity_note_detail;
    }

    @Override
    public void initWidget() {
        GlideUtils.loadImageView(this, img, iv_note_detail_pic);
        rl_back.setOnClickListener(this);
        rl_share.setVisibility(View.VISIBLE);
    }
    private void addView(List<String> data){
        ll_note_detail.removeAllViews();
        imageSize = 0;
        for(int i = 0; i < data.size(); i++){
            if(!data.get(i).startsWith("//pic")){
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(0, 0, 0, 8);
                TextView textView = new TextView(this);
                textView.setText(data.get(i));
                textView.setLayoutParams(layoutParams);
                ll_note_detail.addView(textView);
            }else{
                imageSize++;
                if(imageSize <= 15 && imageSize != 1){
                    ImageView imageView = new ImageView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dp2px(this, 208));
                    layoutParams.setMargins(0, 0, 0, 8);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    GlideUtils.loadImageView(this, "http:" + data.get(i), imageView);
                    imageView.setLayoutParams(layoutParams);
                    ll_note_detail.addView(imageView);
                }
            }
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        NoteDetailData.getInstance().getPoiData(url, new NoteDetailData.GetNoteDetailData() {
            @Override
            public void noteDetailData(List<String> dataList) {
                addView(dataList);
            }
        });
    }

    @Override
    public void getExtraData() {
        url = getIntent().getStringExtra("url");
        img = getIntent().getStringExtra("img");
        Log.i("note_detail_activity", url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_back:
                finish();
                break;
        }
    }
}
