package com.zuicool.screenviewlibrary.screen.function_button;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.OnResetListener;
import com.zuicool.screenviewlibrary.screen.bean.Body;

/**
 * Created by jk on 2018/11/1.
 * “取消”按钮
 */

public class ResetButton extends AbsFunctionButton {
    OnResetListener onResetListener;

    public void setOnResetListener(OnResetListener onResetListener) {
        this.onResetListener = onResetListener;
    }

    public ResetButton(Context context) {
        super(context);
    }

    public ResetButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ResetButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void click() {
        if (onResetListener != null) {
            onResetListener.onReset();
        }
    }

    @Override
    public void initView() {
        tvButton = new TextView(getContext());
        tvButton.setText("重置");
        tvButton.setTextColor(getResources().getColor(R.color.black));
        addView(tvButton);
        setBackgroundResource(R.drawable.solid_white_bottom_left_corner_l);
    }

    @Override
    public void setUpBody(Body... body) {
        this.body = body;
    }
}
