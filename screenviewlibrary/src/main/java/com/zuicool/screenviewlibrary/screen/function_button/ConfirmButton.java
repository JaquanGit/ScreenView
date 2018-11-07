package com.zuicool.screenviewlibrary.screen.function_button;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.util.LogUtil;

/**
 * Created by jk on 2018/11/1.
 * “确定”按钮
 */

public class ConfirmButton extends AbsFunctionButton {

    public ConfirmButton(Context context) {
        super(context);
    }

    public ConfirmButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ConfirmButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void click() {
        if (body == null) {
            LogUtil.log("body为null");
        }
        if (dialog != null) {
            dialog.onResult(body);
        } else {
            LogUtil.log("ConfirmButton dialog为null");
        }
        dismissDialog();
    }

    @Override
    public void initView() {
        tvButton = new TextView(getContext());
        tvButton.setText("确定");
        tvButton.setTextColor(getResources().getColor(R.color.white));
        addView(tvButton);
        setBackgroundResource(R.drawable.solid_red_bottom_right_corner_l);
    }

    @Override
    public void setUpBody(Body... body) {
        this.body = body;
    }
}
