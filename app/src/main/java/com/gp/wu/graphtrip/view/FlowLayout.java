package com.gp.wu.graphtrip.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wu on 2017/5/4.
 */

public class FlowLayout extends ViewGroup{
    private static final String TAG = "FlowLayout";
    public FlowLayout(Context context) {
        super(context);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        //如果是wrap_content情况下，记录宽和高
        int width = 0;
        int height = 0;
        //记录每一行的宽度，width不断取最大宽度
        int lineWidth = 0;
        //每一行的高度，累加至height;
        int lineHeight = 0;

        int cCount = getChildCount();
        for(int i = 0; i < cCount; i++){
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.rightMargin + lp.leftMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if(lineWidth + childWidth > sizeWidth){
                width = Math.max(lineWidth, childWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            }else{
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }

            if(i == cCount - 1){
                width = Math.max(width, lineWidth);
                height += lineHeight;
            }

            setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight : height);
        }
    }

    private List<List<View>> mAllViews = new ArrayList<List<View>>();

    private List<Integer> mLineHeight = new ArrayList<Integer>();


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mAllViews.clear();
        mLineHeight.clear();
        int width = getWidth();
        int lineWidth = 0;
        int lineHeight = 0;
        List<View> lineViews = new ArrayList<View>();
        int cCount = getChildCount();
        for(int i = 0; i < cCount; i++){
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            if(childWidth + lp.leftMargin + lp.rightMargin + lineWidth > width){
                mLineHeight.add(lineHeight);
                mAllViews.add(lineViews);
                lineWidth = 0;
                lineViews = new ArrayList<View>();
            }
            lineWidth += childWidth + lp.leftMargin + lp.rightMargin;
            lineHeight = Math.max(lineHeight, childHeight + lp.topMargin + lp.bottomMargin);
            lineViews.add(child);
        }
        mLineHeight.add(lineHeight);
        mAllViews.add(lineViews);

        int left = 0;
        int top = 0;
        int lineNums = mAllViews.size();
        for(int i = 0; i < lineNums; i++){
            lineViews = mAllViews.get(i);
            lineHeight = mLineHeight.get(i);
            for(int j = 0; j < lineViews.size(); j++){
                View child = lineViews.get(j);
                if(child.getVisibility() == GONE){
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                child.layout(lc, tc, rc, bc);
                left += child.getMeasuredWidth() + lp.rightMargin + lp.leftMargin;
            }
            left = 0;
            top += lineHeight;
        }

    }
}
