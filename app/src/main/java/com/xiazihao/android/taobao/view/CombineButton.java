package com.xiazihao.android.taobao.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiazihao.android.taobao.R;

/**
 * Created by xiazihao on 2017/1/6.
 */

public class CombineButton extends LinearLayout {
    private ImageView mImageView;
    private TextView mTextView;

    public CombineButton(Context context) {
        super(context);
        init(context,null);
    }

    public CombineButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public CombineButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CombineButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {
        setOrientation(VERTICAL);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        setGravity(Gravity.CENTER);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.combine_button_view, this, true);
        mImageView = (ImageView) view.findViewById(R.id.combine_button_image_view);
        mTextView = (TextView) view.findViewById(R.id.combine_button_text_view);

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.CombineButton);
        if(typedArray != null){
            mTextView.setText(typedArray.getText(R.styleable.CombineButton_text));
            mImageView.setImageDrawable(typedArray.getDrawable(R.styleable.CombineButton_image));
            boolean isSelected = typedArray.getBoolean(R.styleable.CombineButton_selected,false);
            mImageView.setSelected(isSelected);
        }
    }

    public void setImageAndText(int imagRes, String text) {
        mImageView.setImageResource(imagRes);
        mTextView.setText(text);
    }
    public void setSelected(boolean selected){
        mImageView.setSelected(selected);
    }
}
