package com.gp.wu.graphtrip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andview.refreshview.recyclerview.BaseRecyclerAdapter;
import com.gp.wu.graphtrip.R;
import com.gp.wu.graphtrip.bean.Person;
import com.gp.wu.graphtrip.utils.DensityUtils;

import java.util.List;

/**
 * Created by wu on 2017/4/21.
 */

public class SimpleAdapter extends BaseRecyclerAdapter<SimpleAdapter.SimpleAdapterViewHolder>{

    private List<Person> list;
    private int largeCardHeight, smallCarHeight;

    public SimpleAdapter(List<Person> list, Context context){
        this.list = list;
        largeCardHeight = DensityUtils.dp2px(context, 150);
        smallCarHeight = DensityUtils.dp2px(context, 100);
    }

    @Override
    public SimpleAdapterViewHolder getViewHolder(View view) {
        return new SimpleAdapterViewHolder(view, false);
    }

    @Override
    public SimpleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType, boolean isItem) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_recycler_view, parent, false);
        SimpleAdapterViewHolder vh = new SimpleAdapterViewHolder(v, true);
        return vh;
    }

    @Override
    public void onBindViewHolder(SimpleAdapterViewHolder holder, int position, boolean isItem) {
        Person person = list.get(position);
        holder.nameTv.setText(person.getName());
        holder.ageTv.setText(person.getAge());
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams){
            holder.rootView.getLayoutParams().height = position % 2 != 0 ? largeCardHeight : smallCarHeight;
        }
    }

    @Override
    public int getAdapterItemCount() {
        Log.i("adapter", list.size() + "");
        return list.size();
    }

    public void setList(List<Person> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public void insert(Person person, int position) {
        insert(list, person, position);
    }

    public void remove(int position) {
        remove(list, position);
    }

    public void clear() {
        clear(list);
    }

    public class SimpleAdapterViewHolder extends RecyclerView.ViewHolder{

        public View rootView;
        public TextView nameTv;
        public TextView ageTv;
        public int position;

        public SimpleAdapterViewHolder(View itemView, boolean isItem) {
            super(itemView);
            if (isItem) {
                nameTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_name_tv);
                ageTv = (TextView) itemView.findViewById(R.id.recycler_view_test_item_person_age_tv);
                rootView = itemView.findViewById(R.id.card_view);
            }
        }
    }

    public Person getItem(int position) {
        if (position < list.size())
            return list.get(position);
        else
            return null;
    }
}
