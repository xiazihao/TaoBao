package com.xiazihao.android.taobao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiazihao.android.taobao.R;

/**
 * Created by xiazihao on 2017/1/7.
 */
public class GridMenu extends LinearLayout {
    private CircleImageView mImageView;
    private TextView mTextView;

    public GridMenu(Context context) {
        super(context);
        init(context,null);
    }

    public GridMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public GridMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public GridMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.GridMenu);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu, this, true);
        mImageView = (CircleImageView) view.findViewById(R.id.menu_image_view);
        mTextView = (TextView) view.findViewById(R.id.menu_text_view);
        if(typedArray!= null) {
            mTextView.setText(typedArray.getText(R.styleable.GridMenu_text));
            mImageView.setImageResource(typedArray.getResourceId(R.styleable.GridMenu_image,R.drawable.art_collection));
        }
    }
}
