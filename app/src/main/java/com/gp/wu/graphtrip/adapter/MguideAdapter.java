package com.gp.wu.graphtrip.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.activity.MguideDetailActivity;
import com.gp.wu.graphtrip.bean.MGuideBean;
import com.gp.wu.graphtrip.utils.GlideUtils;

import java.util.List;

/**
 * Created by wu on 2017/5/4.
 */

public class MguideAdapter extends BaseRecyclerAdapter<MguideAdapter.MguideAdapterViewHolder>{
    private List<MGuideBean.DataBean.ListBean> listBeanList;
    private int lastPosition = -1;
    Context context;

    public MguideAdapter(Context context, List<MGuideBean.DataBean.ListBean> listBeanList) {
        this.context = context;
        this.listBeanList = listBeanList;
    }

    @Override
    public MguideAdapterViewHolder getViewHolder(View view) {
        return new MguideAdapterViewHolder(view);
    }

    @Override
    public MguideAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_fragment_mguide, parent, false);
        MguideAdapterViewHolder viewHolder = new MguideAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MguideAdapterViewHolder holder, final int position, boolean isItem) {
        setAnimation(holder.rl_item_mguide, position);
        final MGuideBean.DataBean.ListBean listBean = listBeanList.get(position);
        GlideUtils.loadImageView(context, listBean.getPhoto(), holder.iv_item_mguide_photo);
        GlideUtils.loadImageView(context, listBean.getUserPhoto(), holder.iv_item_mguide_user_photo);
        holder.tv_item_mguide_text.setText(listBean.getTitle());
        holder.tv_item_mguide_title.setText(listBean.getText());
        holder.rl_item_mguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MguideDetailActivity.class);
                intent.putExtra("url", listBean.getUrl());
                intent.putExtra("img", listBean.getPhoto());
                holder.iv_item_mguide_photo.setTransitionName("mguide");
                Activity activity = (Activity) context;
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.iv_item_mguide_photo, holder.iv_item_mguide_photo.getTransitionName()).toBundle();
                context.startActivity(intent, bundle);
            }
        });
    }

    @Override
    public int getAdapterItemCount() {
        return listBeanList.size();
    }

    public class MguideAdapterViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout rl_item_mguide;
        private ImageView iv_item_mguide_photo;
        private ImageView iv_item_mguide_user_photo;
        private TextView tv_item_mguide_title;
        private TextView tv_item_mguide_text;
        public MguideAdapterViewHolder(View itemView) {
            super(itemView);
            rl_item_mguide = (LinearLayout) itemView.findViewById(R.id.rl_item_mguide);
            iv_item_mguide_photo = (ImageView) itemView.findViewById(R.id.iv_item_mguide_photo);
            iv_item_mguide_user_photo = (ImageView) itemView.findViewById(R.id.iv_item_mguide_user_photo);
            tv_item_mguide_title = (TextView) itemView.findViewById(R.id.tv_item_mguide_title);
            tv_item_mguide_text = (TextView) itemView.findViewById(R.id.tv_item_mguide_text);
        }
    }

    @Override
    public void onViewDetachedFromWindow(MguideAdapterViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.rl_item_mguide != null){
            holder.rl_item_mguide.clearAnimation();
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
