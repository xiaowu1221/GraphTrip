package com.gp.wu.graphtrip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.bean.PerimeterEatBean;

import java.util.List;

/**
 * Created by wu on 2017/4/30.
 */

public class PerimeterEatAdapter extends BaseRecyclerAdapter<PerimeterEatAdapter.PerimeterEatViewHolder> {

    private List<PerimeterEatBean.DataBean.ResBean> dataBeanList;
    private int lastPosition = -1;
    private Context context;

    public PerimeterEatAdapter(Context context, List<PerimeterEatBean.DataBean.ResBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public PerimeterEatViewHolder getViewHolder(View view) {
        return new PerimeterEatViewHolder(view);
    }

    @Override
    public PerimeterEatViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sight_perimeter_eat, parent, false);
        PerimeterEatViewHolder viewHolder = new PerimeterEatViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PerimeterEatViewHolder holder, int position, boolean isItem) {
        setAnimation(holder.ll_item_perimeter_eat, position);
        final PerimeterEatBean.DataBean.ResBean resBean = dataBeanList.get(position);
        holder.tv_perimeter_eat_position.setText(position + 1 + "");
        holder.tv_perimeter_eat_cnname.setText(resBean.getChinesename());
        holder.tv_perimeter_eat_rank.setText("No." + resBean.getRank());
        holder.tv_perimeter_eat_count.setText(resBean.getCount() + "");
        addTag(holder.ll_perimeter_eat_tag, resBean.getTags());
    }

    private void addTag(ViewGroup view, List<PerimeterEatBean.DataBean.ResBean.TagsBean> tagsBean){
        if(tagsBean == null || tagsBean.size() <= 0){
            view.setVisibility(View.GONE);
            return;
        }
        view.removeAllViews();
        for(int i = 0; i < (tagsBean.size() > 4 ? 4: tagsBean.size()); i++){
            PerimeterEatBean.DataBean.ResBean.TagsBean bean = tagsBean.get(i);
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

    public class PerimeterEatViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout ll_item_perimeter_eat;
        private TextView tv_perimeter_eat_position;
        private TextView tv_perimeter_eat_cnname;
        private LinearLayout ll_perimeter_eat_tag;
        private TextView tv_perimeter_eat_rank;
        private TextView tv_perimeter_eat_count;
        public PerimeterEatViewHolder(View itemView) {
            super(itemView);
            ll_item_perimeter_eat = (LinearLayout) itemView.findViewById(R.id.ll_item_perimeter_eat);
            tv_perimeter_eat_position = (TextView) itemView.findViewById(R.id.tv_perimeter_eat_position);
            tv_perimeter_eat_cnname = (TextView) itemView.findViewById(R.id.tv_perimeter_eat_cnname);
            ll_perimeter_eat_tag = (LinearLayout) itemView.findViewById(R.id.ll_perimeter_eat_tag);
            tv_perimeter_eat_rank = (TextView) itemView.findViewById(R.id.tv_perimeter_eat_rank);
            tv_perimeter_eat_count = (TextView) itemView.findViewById(R.id.tv_perimeter_eat_count);
        }
    }
    @Override
    public void onViewDetachedFromWindow(PerimeterEatViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.ll_item_perimeter_eat != null){
            holder.ll_item_perimeter_eat.clearAnimation();
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
