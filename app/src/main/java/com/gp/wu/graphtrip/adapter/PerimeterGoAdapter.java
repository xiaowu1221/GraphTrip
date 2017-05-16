package com.gp.wu.graphtrip.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.activity.SightDetailActivity;
import com.gp.wu.graphtrip.bean.GoDetailBean;
import com.gp.wu.graphtrip.bean.MguideDetailBean;
import com.gp.wu.graphtrip.bean.PerimeterGoBean;
import com.gp.wu.graphtrip.net.impl.GoDetailService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wu on 2017/5/3.
 */

public class PerimeterGoAdapter extends BaseRecyclerAdapter<PerimeterGoAdapter.PerimeterGoViewHolder>{
    private List<PerimeterGoBean.DataBean.ResBean> dataBeanList;
    private int lastPosition = -1;
    private Context context;
    private GoDetailBean.DataBean dataBean;
    private MguideDetailBean detailBean;

    public PerimeterGoAdapter(Context context, List<PerimeterGoBean.DataBean.ResBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public PerimeterGoViewHolder getViewHolder(View view) {
        return new PerimeterGoViewHolder(view);
    }

    @Override
    public PerimeterGoViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sight_perimeter_go, parent, false);
        PerimeterGoViewHolder viewHolder = new PerimeterGoViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PerimeterGoViewHolder holder, final int position, boolean isItem) {
        setAnimation(holder.ll_item_perimeter_go, position);
        final PerimeterGoBean.DataBean.ResBean resBean = dataBeanList.get(position);
        holder.tv_perimeter_go_position.setText(position + 1 + "");
        holder.tv_perimeter_go_cnname.setText(resBean.getChinesename() + "  " + resBean.getEnglishname());
        addTag(holder.ll_perimeter_go_tag, resBean.getTags());
        holder.tv_perimeter_go_rank.setText("No." + resBean.getRank());
        holder.tv_perimeter_go_count.setText(resBean.getCount() + "");
        holder.tv_perimeter_go_hotel_count.setText(resBean.getHotel_count() + "");
        holder.btn_perimeter_go_see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDetail(resBean.getId());
                Toast.makeText(context, "提示：：：", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDetail(final String id){
        detailBean = new MguideDetailBean();
        GoDetailService goDetailService;
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://place.qyer.com/")
                .build();
        goDetailService = retrofit.create(GoDetailService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("action", "getDetail");
        map.put("id", id);
        map.put("type", "fun");
        Call<GoDetailBean> call = goDetailService.getGoDetail(map);
        call.enqueue(new Callback<GoDetailBean>() {
            @Override
            public void onResponse(Call<GoDetailBean> call, Response<GoDetailBean> response) {
                dataBean = response.body().getData();
                detailBean.setId(id);
                detailBean.setPhoto(dataBean.getPhoto().get(0));
                detailBean.setUrl(dataBean.getUrl());
                detailBean.setCnname(dataBean.getChinesename());
                detailBean.setDetail(dataBean.getIntroduction());
                Intent intent = new Intent(context, SightDetailActivity.class);
                intent.putExtra("bean", detailBean);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<GoDetailBean> call, Throwable t) {
                Log.i("perimeter_go_adapter", "fail");
            }
        });
    }
    private void addTag(ViewGroup view, List<PerimeterGoBean.DataBean.ResBean.TagsBean> tagsBean){
        if(tagsBean == null || tagsBean.size() <= 0){
            view.setVisibility(View.GONE);
            return;
        }
        view.removeAllViews();
        for(int i = 0; i < (tagsBean.size() > 4 ? 4: tagsBean.size()); i++){
            PerimeterGoBean.DataBean.ResBean.TagsBean bean = tagsBean.get(i);
            TextView textView = new TextView(context);
            textView.setText(bean.getTag_name());
            textView.setBackground(context.getResources().getDrawable(R.drawable.sight_detail_item_discount_tag_bg));
            textView.setTextSize(14);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 0, 16, 0);
            textView.setLayoutParams(layoutParams);
            view.addView(textView);
        }
    }
    @Override
    public int getAdapterItemCount() {
        return dataBeanList.size();
    }

    public class PerimeterGoViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout ll_item_perimeter_go;
        private TextView tv_perimeter_go_position;
        private TextView tv_perimeter_go_cnname;
        private LinearLayout ll_perimeter_go_tag;
        private TextView tv_perimeter_go_rank;
        private TextView tv_perimeter_go_count;
        private TextView tv_perimeter_go_hotel_count;
        private Button btn_perimeter_go_see;
        public PerimeterGoViewHolder(View itemView) {
            super(itemView);
            ll_item_perimeter_go = (LinearLayout) itemView.findViewById(R.id.ll_item_perimeter_go);
            tv_perimeter_go_position = (TextView) itemView.findViewById(R.id.tv_perimeter_go_position);
            tv_perimeter_go_cnname = (TextView) itemView.findViewById(R.id.tv_perimeter_go_cnname);
            ll_perimeter_go_tag = (LinearLayout) itemView.findViewById(R.id.ll_perimeter_go_tag);
            tv_perimeter_go_rank = (TextView) itemView.findViewById(R.id.tv_perimeter_go_rank);
            tv_perimeter_go_count = (TextView) itemView.findViewById(R.id.tv_perimeter_go_count);
            tv_perimeter_go_hotel_count = (TextView) itemView.findViewById(R.id.tv_perimeter_go_hotel_count);
            btn_perimeter_go_see = (Button) itemView.findViewById(R.id.btn_perimeter_go_see);
        }
    }
    @Override
    public void onViewDetachedFromWindow(PerimeterGoViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.ll_item_perimeter_go != null){
            holder.ll_item_perimeter_go.clearAnimation();
        }
    }
    private void setAnimation(View viewToAnimate, int position){
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R
                    .anim.sight_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
