package com.zuicool.screenviewlibrary.screen.function_button;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.dialog.IScreenDialog;
import com.zuicool.screenviewlibrary.screen.util.LogUtil;

/**
 * Created by jk on 2018/11/1.
 * “取消”和“确定”的抽象类
 */

public abstract class AbsFunctionButton extends LinearLayout implements IFunctionButton {
    Body body;
    TextView tvButton;
    IScreenDialog dialog;

    public AbsFunctionButton(Context context) {
        this(context, null);
    }

    public AbsFunctionButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AbsFunctionButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setGravity(Gravity.CENTER);
        int padding = getPadding();
        setPadding(0, padding, 0, padding);
        initView();
        initListener();
    }

    private int getPadding() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return metrics.heightPixels / 100;
    }

    private void initListener() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
                dismissDialog();
            }
        });
    }

    @Override
    public void setDialog(IScreenDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override
    public final void setUpBackgroundResource(int resId) {
        setBackgroundResource(resId);
    }

    @Override
    public final void setTextColor(int color) {
        if (tvButton != null) {
            tvButton.setTextColor(getResources().getColor(color));
        } else {
            LogUtil.log("tvButton为null");
        }
    }

    @Override
    public void setFunctionButtonTextSize(int spSize) {
        if (tvButton != null) {
            tvButton.setTextSize(spSize);
        }
    }
}
