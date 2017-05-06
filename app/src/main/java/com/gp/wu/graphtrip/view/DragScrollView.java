package com.gp.wu.graphtrip.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by wu on 2017/4/27.
 */

public class DragScrollView extends ScrollView{

    private static final String TAG = "DragScrollView";


    private static final float MOVE_FACTOR = 0.5f;
    private static final int ANIM_TIME = 1000;
    private View contentView;
    private float startY;
    private float nowY;
    private Rect originalRect = new Rect();
    private boolean canPullDown = false;
    private boolean isMoved = false;
    private View zoomView;


    public DragScrollView(Context context) {
        super(context);
    }

    public DragScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onFinishInflate() {
        if(getChildCount() > 0){
            contentView = getChildAt(0);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(contentView == null){
            return;
        }
        originalRect.set(contentView.getLeft(), contentView.getTop(), contentView.getRight(), contentView.getBottom());
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(contentView == null){
            return super.dispatchTouchEvent(ev);
        }
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                canPullDown = isCanPullDown();
                startY = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                if(!isMoved){
                    break;
                }
                if(zoomView == null){
                    TranslateAnimation animation = new TranslateAnimation(0, 0, (nowY - startY) * MOVE_FACTOR, originalRect.top);
                    animation.setDuration(ANIM_TIME);
                    animation.setInterpolator(new DecelerateInterpolator());
                    contentView.startAnimation(animation);
                    contentView.layout(originalRect.left, originalRect.top, originalRect.right, originalRect.bottom);
                }else{

                }
                canPullDown = false;
                isMoved = false;

                break;
            case MotionEvent.ACTION_MOVE:
                if(!canPullDown){
                    startY = ev.getY();
                    canPullDown = isCanPullDown();
                    break;
                }
                nowY = ev.getY();
                int deltaY = (int) (nowY - startY);
                boolean shouldMove = canPullDown && deltaY > 0;
                if(shouldMove){
                    int offset = (int)(deltaY * MOVE_FACTOR);
                    if(zoomView != null){
                    }else{
                        contentView.layout(originalRect.left, originalRect.top + offset, originalRect.right, originalRect.bottom + offset);
                        isMoved = true;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    private boolean isCanPullDown(){
        return getScrollY() == 0 || contentView
                .getHeight() < getHeight() + getScrollY();
    }

    public void setZoomView(View zoomView){
        this.zoomView = zoomView;
    }
}
