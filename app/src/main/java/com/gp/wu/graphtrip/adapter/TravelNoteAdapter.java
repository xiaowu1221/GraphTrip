package com.gp.wu.graphtrip.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
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
import android.widget.Toast;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.bean.TravelNotesBean;
import com.gp.wu.graphtrip.utils.GlideUtils;
import com.gp.wu.graphtrip.view.CircleImageView;

import java.util.List;

/**
 * Created by wu on 2017/5/6.
 */

public class TravelNoteAdapter extends BaseRecyclerAdapter<TravelNoteAdapter.TravelNoteViewHolder> implements View.OnClickListener{
    private List<TravelNotesBean> notesBeanList;
    private int lastPosition = -1;
    Context context;

    private static final int NOTE_HREF = 0;
    private static final int NOTE_USER_HREF = 1;

    public TravelNoteAdapter(Context context, List<TravelNotesBean> notesBeanList){
        this.context = context;
        this.notesBeanList = notesBeanList;
    }

    @Override
    public TravelNoteViewHolder getViewHolder(View view) {
        return new TravelNoteViewHolder(view);
    }

    @Override
    public TravelNoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_fragment_travel_note, parent, false);
        TravelNoteViewHolder viewHolder = new TravelNoteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TravelNoteViewHolder holder, int position, boolean isItem) {
        setAnimation(holder.rl_item_travel_note, position);
        final TravelNotesBean notesBean = notesBeanList.get(position);
        GlideUtils.loadImageView(context, notesBean.getPicSrc(), holder.iv_item_note_pic);
        GlideUtils.loadImageView(context, notesBean.getFaceSrc(), holder.civ_item_user_photo);
        holder.tv_item_user_name.setText(notesBean.getNoteAnthor().split("：")[1] + "");
        holder.tv_item_note_view.setText(notesBean.getNoteViews() + "");
        holder.tv_item_note_msg.setText(notesBean.getNoteReplys() + "");
        holder.tv_item_note_like.setText(notesBean.getNoteLikes() + "");
        holder.tv_item_note_text.setText(notesBean.getNoteText() + "");
        holder.cv_item_note.setTag(NOTE_HREF);
        holder.cv_item_note.setOnClickListener(this);
        holder.ll_item_note_user.setTag(NOTE_USER_HREF);
        holder.ll_item_note_user.setOnClickListener(this);
    }

    @Override
    public int getAdapterItemCount() {
        return notesBeanList.size();
    }

    @Override
    public void onClick(View v) {
        int tag = (int) v.getTag();
        switch (tag){
            case NOTE_HREF:
                Toast.makeText(context, "cv_item_note", Toast.LENGTH_SHORT).show();
                break;
            case NOTE_USER_HREF:
                Toast.makeText(context, "ll_item_note_user", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class TravelNoteViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout rl_item_travel_note;
        private CardView cv_item_note;
        private ImageView iv_item_note_pic;
        private LinearLayout ll_item_note_user;
        private CircleImageView civ_item_user_photo;
        private TextView tv_item_user_name;
        private TextView tv_item_note_view;
        private TextView tv_item_note_msg;
        private TextView tv_item_note_like;
        private TextView tv_item_note_text;
        public TravelNoteViewHolder(View itemView) {
            super(itemView);
            rl_item_travel_note = (RelativeLayout) itemView.findViewById(R.id.rl_item_travel_note);
            cv_item_note = (CardView) itemView.findViewById(R.id.cv_item_note);
            iv_item_note_pic = (ImageView) itemView.findViewById(R.id.iv_item_note_pic);
            ll_item_note_user = (LinearLayout) itemView.findViewById(R.id.ll_item_note_user);
            civ_item_user_photo = (CircleImageView) itemView.findViewById(R.id.civ_item_user_photo);
            tv_item_user_name = (TextView) itemView.findViewById(R.id.tv_item_user_name);
            tv_item_note_view = (TextView) itemView.findViewById(R.id.tv_item_note_view);
            tv_item_note_msg = (TextView) itemView.findViewById(R.id.tv_item_note_msg);
            tv_item_note_like = (TextView) itemView.findViewById(R.id.tv_item_note_like);
            tv_item_note_text = (TextView) itemView.findViewById(R.id.tv_item_note_text);
        }
    }

    @Override
    public void onViewDetachedFromWindow(TravelNoteViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if(holder.rl_item_travel_note != null){
            holder.rl_item_travel_note.clearAnimation();
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
