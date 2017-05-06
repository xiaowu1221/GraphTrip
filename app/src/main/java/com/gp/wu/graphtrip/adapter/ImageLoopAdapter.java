package com.gp.wu.graphtrip.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gp.wu.graphtrip.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

/**
 * Created by wu on 2017/4/22.
 */

public class ImageLoopAdapter extends LoopPagerAdapter{
    int[] imgs = new int[]{R.mipmap.banner_cloud, R.mipmap.banner_clouds_moon, R.mipmap.banner_lightning, R.mipmap.banner_rain};
    public ImageLoopAdapter(RollPagerView viewPager) {
        super(viewPager);
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setImageResource(imgs[position]);
        return view;
    }

    @Override
    public int getRealCount() {
        return imgs.length;
    }
}
