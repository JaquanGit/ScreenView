package com.zuicool.screenviewlibrary.screen.function_button;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.bean.Body;

/**
 * Created by jk on 2018/11/1.
 * “取消”按钮
 */

public class CancelButton extends AbsFunctionButton {

    public CancelButton(Context context) {
        super(context);
    }

    public CancelButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CancelButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void click() {

    }

    @Override
    public void initView() {
        tvButton = new TextView(getContext());
        tvButton.setText("取消");
        tvButton.setTextColor(getResources().getColor(R.color.black));
        addView(tvButton);
        setBackgroundResource(R.drawable.solid_white_bottom_left_corner_l);
    }

    @Override
    public void setUpBody(Body body) {
        this.body = body;
    }
}
