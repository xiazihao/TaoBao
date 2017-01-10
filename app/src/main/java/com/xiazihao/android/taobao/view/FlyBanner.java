package com.xiazihao.android.taobao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.xiazihao.android.taobao.R;

/**
 * Created by xiazihao on 2017/1/9.
 */

public class FlyBanner extends RelativeLayout {
    private boolean mPointsIsVisible;
    private int mPointPosition;
    private Drawable mPointContainerBackgroundDrawable;
    private ViewPager mViewPager;
    private LinearLayout mPointLinearLayout;

    public static final int CENTER = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;

    public FlyBanner(Context context) {
        super(context);
        init(context, null);
    }

    public FlyBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FlyBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public FlyBanner(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.FlyBanner);
        mPointsIsVisible = typedArray.getBoolean(R.styleable.FlyBanner_points_visibility, true);
        mPointPosition = typedArray.getInt(R.styleable.FlyBanner_points_position, CENTER);
        mPointContainerBackgroundDrawable = typedArray.getDrawable(R.styleable.FlyBanner_points_container_background);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fly_banner_view, this, true);
        mViewPager = (ViewPager) view.findViewById(R.id.fly_banner_view_pager);
        mViewPager.setAdapter(new ImagePagerAdapter());
        mPointLinearLayout = (LinearLayout) view.findViewById(R.id.fly_banner_point);

        if (mPointsIsVisible) {
            mPointLinearLayout.setVisibility(VISIBLE);
        } else {
            mPointLinearLayout.setVisibility(INVISIBLE);
        }
        RelativeLayout.LayoutParams pointLayoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pointLayoutParams.addRule(ALIGN_PARENT_BOTTOM);
        switch (mPointPosition) {
            case CENTER:
                pointLayoutParams.addRule(CENTER_HORIZONTAL);
                break;
            case LEFT:
                pointLayoutParams.addRule(ALIGN_PARENT_LEFT);
                break;
            case RIGHT:
                pointLayoutParams.addRule(ALIGN_PARENT_RIGHT);
                break;
        }
        mPointLinearLayout.setLayoutParams(pointLayoutParams);


        mPointLinearLayout.removeAllViews();
        LinearLayout.LayoutParams pointLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pointLayout.setMargins(10, 10, 10, 10);

        ImageView imageView = new ImageView(context);
        imageView.setEnabled(false);
        imageView.setLayoutParams(pointLayout);
        imageView.setImageResource(R.drawable.selector_fly_banner_point);
        mPointLinearLayout.addView(imageView);

        imageView = new ImageView(context);
        imageView.setEnabled(true);
        imageView.setLayoutParams(pointLayout);
        imageView.setImageResource(R.drawable.selector_fly_banner_point);
        mPointLinearLayout.addView(imageView);

    }

    private void addPoint() {

    }

    private class ImagePagerAdapter extends android.support.v4.view.PagerAdapter {
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(R.drawable.banner);
            container.addView(imageView);
            return imageView;
//            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
