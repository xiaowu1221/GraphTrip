package com.gp.wu.graphtrip.adapter;

import android.content.Context;
import android.graphics.Paint;
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
import com.gp.wu.graphtrip.bean.PerimeterLiveBean;

import java.util.List;

/**
 * Created by wu on 2017/5/2.
 */

public class PerimeterLiveAdapter extends BaseRecyclerAdapter<PerimeterLiveAdapter.PerimeterLiveViewHolder> {

    private List<PerimeterLiveBean.DataBean.ResBean> dataBeanList;
    private int lastPosition = -1;
    private Context context;

    public PerimeterLiveAdapter(Context context, List<PerimeterLiveBean.DataBean.ResBean> dataBeanList){
        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @Override
    public PerimeterLiveViewHolder getViewHolder(View view) {
        return new PerimeterLiveViewHolder(view);
    }

    @Override
    public PerimeterLiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_sight_perimeter_live, parent, false);
        PerimeterLiveViewHolder viewHolder = new PerimeterLiveViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PerimeterLiveViewHolder holder, final int position, boolean isItem) {
        setAnimation(holder.ll_item_perimeter_live, position);
        final PerimeterLiveBean.DataBean.ResBean resBean = dataBeanList.get(position);
        holder.tv_perimeter_live_position.setText(position + 1 + "");
        holder.tv_perimeter_live_cnname.setText(resBean.getHotel_chinesename());
        holder.tv_perimeter_live_enname.setText(resBean.getHotel_englishname());
        holder.tv_perimeter_live_star.setText(setHotelStar(resBean));
        holder.tv_perimeter_live_rank.setText(resBean.getHotel_rank() + "");
        holder.tv_perimeter_live_count.setText(resBean.getHotel_count() + "");
        holder.tv_perimeter_live_discount.setText("-" + resBean.getHotel_price_discount() + "%");
        holder.tv_perimeter_live_reference.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.tv_perimeter_live_reference.setText(resBean.getHotel_reference_price() + "元");
        holder.tv_perimeter_live_price.setText(resBean.getHotel_price() + "元");
        holder.btn_perimeter_live_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "暂不提供支持" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String setHotelStar(PerimeterLiveBean.DataBean.ResBean resBean){
        String star = "";
        Log.i("live_fragment", resBean.getHotel_qyer_star());
        if(resBean.getHotel_qyer_star() != null || resBean.getHotel_qyer_star() != ""){
            switch (Integer.parseInt(resBean.getHotel_qyer_star())){
                case 1:
                    star = "一星级";
                    break;
                case 2:
                    star = "二星级";
                    break;
                case 3:
                    star = "三星级";
                    break;
                case 4:
                    star = "四星级";
                    break;
                case 5:
                    star = "五星级";
                    break;
                default:
                    star = "";
                    break;
            }
        }
        return star;
    }


    @Override
    public int getAdapterItemCount() {
        return dataBeanList.size();
    }

    public class PerimeterLiveViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout ll_item_perimeter_live;
        private TextView tv_perimeter_live_position;
        private TextView tv_perimeter_live_cnname;
        private TextView tv_perimeter_live_enname;
        private TextView tv_perimeter_live_star;
        private TextView tv_perimeter_live_rank;
        private TextView tv_perimeter_live_count;
        private TextView tv_perimeter_live_discount;
        private TextView tv_perimeter_live_reference;
        private TextView tv_perimeter_live_price;
        private Button btn_perimeter_live_order;
        public PerimeterLiveViewHolder(View itemView) {
            super(itemView);
            ll_item_perimeter_live = (LinearLayout) itemView.findViewById(R.id.ll_item_perimeter_live);
            tv_perimeter_live_position = (TextView) itemView.findViewById(R.id.tv_perimeter_live_position);
            tv_perimeter_live_cnname = (TextView) itemView.findViewById(R.id.tv_perimeter_live_cnname);
            tv_perimeter_live_enname = (TextView) itemView.findViewById(R.id.tv_perimeter_live_enname);
            tv_perimeter_live_star = (TextView) itemView.findViewById(R.id.tv_perimeter_live_star);
            tv_perimeter_live_rank = (TextView) itemView.findViewById(R.id.tv_perimeter_live_rank);
            tv_perimeter_live_count = (TextView) itemView.findViewById(R.id.tv_perimeter_live_count);
            tv_perimeter_live_discount = (TextView) itemView.findViewById(R.id.tv_perimeter_live_discount);
            tv_perimeter_live_reference = (TextView) itemView.findViewById(R.id.tv_perimeter_live_reference);
            tv_perimeter_live_price = (TextView) itemView.findViewById(R.id.tv_perimeter_live_price);
            btn_perimeter_live_order = (Button) itemView.findViewById(R.id.btn_perimeter_live_order);
        }
    }
    @Override
    public void onViewDetachedFromWindow(PerimeterLiveViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.ll_item_perimeter_live != null){
            holder.ll_item_perimeter_live.clearAnimation();
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
