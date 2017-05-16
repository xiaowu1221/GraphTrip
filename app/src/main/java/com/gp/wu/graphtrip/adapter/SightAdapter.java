package com.gp.wu.graphtrip.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.activity.SightDetailActivity;
import com.gp.wu.graphtrip.bean.MguideDetailBean;
import com.gp.wu.graphtrip.bean.SightBean;
import com.gp.wu.graphtrip.utils.GlideUtils;
import com.gp.wu.graphtrip.view.CircleImageView;

import java.util.List;

/**
 * Created by wu on 2017/4/22.
 */

public class SightAdapter extends BaseRecyclerAdapter<SightAdapter.SightAdapterViewHolder>{

    private List<SightBean.DataBean.ListBean> sightBeanList;
    private int lastPosition = -1;
    Context context;
    public SightAdapter(Context context, List<SightBean.DataBean.ListBean> sightBeanList) {
        this.context = context;
        this.sightBeanList = sightBeanList;
    }

    @Override
    public SightAdapterViewHolder getViewHolder(View view) {
        return new SightAdapterViewHolder(view);
    }

    @Override
    public SightAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_fragment_sight, parent, false);
        SightAdapterViewHolder viewHolder = new SightAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SightAdapterViewHolder holder, final int position, boolean isItem) {
        setAnimation(holder.rl_item_sight, position);
        final SightBean.DataBean.ListBean sightBean = sightBeanList.get(position);
        GlideUtils.loadImageView(context, sightBean.getPhoto(), holder.iv_item_photo);
        GlideUtils.loadImageView(context, sightBean.getComments().get(0).getUserPhoto(), holder.civ_item_user_photo);
        holder.tv_item_user_author.setText(sightBean.getComments().get(0).getAuthor());
        holder.tv_item_user_text.setText(sightBean.getComments().get(0).getText());
        holder.tv_item_cnname.setText(sightBean.getCnname());
        holder.tv_item_enname.setText(sightBean.getEnname());
        ViewCompat.setTransitionName(holder.iv_item_photo, String.valueOf(position) + "_image");
        holder.rl_item_sight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MguideDetailBean detailBean = new MguideDetailBean();
                detailBean.setId(sightBean.getId());
                detailBean.setCnname(sightBean.getCnname());
                detailBean.setUrl(sightBean.getUrl());
                detailBean.setPhoto(sightBean.getPhoto());
                Intent intent = new Intent(context, SightDetailActivity.class);
                intent.putExtra("bean", detailBean);
                holder.iv_item_photo.setTransitionName("share");
                Activity activity = (Activity) context;
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.iv_item_photo, holder.iv_item_photo.getTransitionName()).toBundle();
                context.startActivity(intent, bundle);
            }
        });
    }

    @Override
    public int getAdapterItemCount() {
        return sightBeanList.size();
    }

    public class SightAdapterViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout rl_item_sight;
        private ImageView iv_item_photo;
        private LinearLayout ll_item_user_comment;
        private CircleImageView civ_item_user_photo;
        private TextView tv_item_user_author;
        private TextView tv_item_user_text;
        private TextView tv_item_cnname;
        private TextView tv_item_enname;
        public SightAdapterViewHolder(View itemView) {
            super(itemView);
            rl_item_sight = (RelativeLayout) itemView.findViewById(R.id.rl_item_sight);
            iv_item_photo = (ImageView) itemView.findViewById(R.id.iv_item_photo);
            ll_item_user_comment = (LinearLayout) itemView.findViewById(R.id.ll_item_user_comment);
            civ_item_user_photo = (CircleImageView) itemView.findViewById(R.id.civ_item_user_photo);
            tv_item_user_author = (TextView) itemView.findViewById(R.id.tv_item_user_author);
            tv_item_user_text = (TextView) itemView.findViewById(R.id.tv_item_user_text);
            tv_item_cnname = (TextView) itemView.findViewById(R.id.tv_item_cnname);
            tv_item_enname = (TextView) itemView.findViewById(R.id.tv_item_enname);
        }
    }

    @Override
    public void onViewDetachedFromWindow(SightAdapterViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.rl_item_sight != null){
            holder.rl_item_sight.clearAnimation();
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
