package com.zuicool.screenviewlibrary.screen.function_button;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zuicool.screenviewlibrary.screen.OnResetListener;
import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.dialog.IScreenDialog;

/**
 * Created by jk on 2018/11/1.
 * 底部按钮的容器组件（“取消”和“确定”）
 */

public class FunctionButtonRegionView extends LinearLayout implements IFunctionButtonRegion {
    ConfirmButton confirmButton;
    ResetButton resetButton;
    OnResetListener onResetListener;

    public void setOnResetListener(OnResetListener onResetListener) {
        this.onResetListener = onResetListener;
    }

    public FunctionButtonRegionView(Context context) {
        this(context, null);
    }

    public FunctionButtonRegionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FunctionButtonRegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        confirmButton = new ConfirmButton(getContext());
        resetButton = new ResetButton(getContext());

        addView(resetButton);
        addView(confirmButton);

        // 设置两个按钮权重为1
        LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.weight = 1;

        resetButton.setLayoutParams(params);
        confirmButton.setLayoutParams(params);

        initListener();
    }

    @Override
    public void setUp(Body... body) {
        confirmButton.setUpBody(body);
    }

    @Override
    public void setDialog(IScreenDialog dialog) {
        confirmButton.setDialog(dialog);
        resetButton.setDialog(dialog);
    }

    @Override
    public void setUpFunctionButtonsResource(int btnConfirmBgRes, int btnConfirmTextColor, int btnCancelBgRes, int btnCancelTextColor) {
        confirmButton.setUpBackgroundResource(btnConfirmBgRes);
        confirmButton.setTextColor(btnConfirmTextColor);
        resetButton.setUpBackgroundResource(btnCancelBgRes);
        resetButton.setTextColor(btnCancelTextColor);
    }

    @Override
    public void setFunctionButtonTextSize(int spSize) {
        confirmButton.setFunctionButtonTextSize(spSize);
        resetButton.setFunctionButtonTextSize(spSize);
    }

    private void initListener() {
        resetButton.setOnResetListener(new OnResetListener() {
            @Override
            public void onReset() {
                if (onResetListener != null) {
                    onResetListener.onReset();
                }
            }
        });
    }
}
