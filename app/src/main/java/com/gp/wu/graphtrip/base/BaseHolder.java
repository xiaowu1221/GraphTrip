package com.gp.wu.graphtrip.base;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wu on 2017/4/13.
 */

public abstract class BaseHolder<M> extends ViewHolder{

    public BaseHolder(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
    }

    protected <T extends View>T getView(@IdRes int viewId){
        return (T)(itemView.findViewById(viewId));
    }
    /**
     * 获取Context实例
     * @return context
     */
    protected Context getContext() {
        return itemView.getContext();
    }

    /**
     * 设置数据
     * @param data 要显示的数据对象
     */
    public abstract void setData(M data);
}