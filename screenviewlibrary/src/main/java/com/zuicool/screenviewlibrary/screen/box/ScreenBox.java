package com.zuicool.screenviewlibrary.screen.box;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.OnResetListener;
import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.body.ScreenBody;
import com.zuicool.screenviewlibrary.screen.dialog.IScreenDialog;
import com.zuicool.screenviewlibrary.screen.function_button.FunctionButtonRegionView;

/**
 * Created by jk on 2018/10/31.
 * 由筛选Body+底部按钮组成
 */

public class ScreenBox extends LinearLayout implements IScreenBox {
    ScreenBody screenBody;
    FunctionButtonRegionView buttonRegionView;// 底部按钮，包括：重置、确定

    public ScreenBox(Context context) {
        this(context, null);
    }

    public ScreenBox(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScreenBox(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);

        screenBody = new ScreenBody(getContext());
        screenBody.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        buttonRegionView = new FunctionButtonRegionView(getContext());
        buttonRegionView.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        addView(screenBody);
        addView(buttonRegionView);

        initListener();
    }

    @Override
    public void setUp(Body... bodies) {
        screenBody.setUpBody(bodies);
        screenBody.setBgResource(R.drawable.solid_white);
        buttonRegionView.setUp(bodies);
    }

    @Override
    public void setMultiChoose(boolean multiChoose) {
        screenBody.setMultiChoose(multiChoose);
    }

    @Override
    public void setDecorateColor(int color) {
        screenBody.setDecorateColor(color);
    }

    @Override
    public void setTitleTextSize(int size) {
        screenBody.setTitleTextSize(size);
    }

    @Override
    public void setTitleTextColor(int color) {
        screenBody.setTitleTextColor(color);
    }

    @Override
    public void reset() {
        screenBody.reset();
    }

    @Override
    public void setUpColumnCount(int count) {
        screenBody.setUpColumnCount(count);
    }

    @Override
    public void setDialog(IScreenDialog dialog) {
        buttonRegionView.setDialog(dialog);
    }

    @Override
    public void setUpFunctionButtonsResource(int btnConfirmBgRes, int btnConfirmTextColor, int btnCancelBgRes, int btnCancelTextColor) {
        buttonRegionView.setUpFunctionButtonsResource(btnConfirmBgRes, btnConfirmTextColor, btnCancelBgRes, btnCancelTextColor);
    }

    @Override
    public void setBodyBgResource(int resourceId) {
        screenBody.setBgResource(resourceId);
    }

    @Override
    public void setItemTextSize(int spSize) {
        screenBody.setItemTextSize(spSize);
    }

    @Override
    public void setFunctionButtonTextSize(int spSize) {
        buttonRegionView.setFunctionButtonTextSize(spSize);
    }

    @Override
    public void setItemWidthPercent(float percent) {
        screenBody.setItemWidthPercent(percent);
    }

    private void initListener() {
        // 重置回调
        buttonRegionView.setOnResetListener(new OnResetListener() {
            @Override
            public void onReset() {
                screenBody.reset();
            }
        });
    }
}
