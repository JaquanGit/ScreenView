package com.zuicool.screenviewlibrary.screen.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.box.ScreenBox;
import com.zuicool.screenviewlibrary.screen.util.LogUtil;


/**
 * Created by jk on 2018/11/1.
 * 筛选弹框dialog，最终用户使用
 */

public class ScreenDialog extends Dialog implements IScreenDialog {
    ScreenBox screenBox;
    View underByView;

    public ScreenDialog(@NonNull Context context) {
        super(context, R.style.FullScreenDialog);
        init();
    }

    private void init() {
        screenBox = new ScreenBox(getContext());
        setContentView(screenBox);
        setDialog();
    }

    @Override
    public void setDataToView(Body body) {
        screenBox.setUp(body);
    }

    @Override
    public void setUpColumnCount(int count) {
        screenBox.setUpColumnCount(count);
    }

    private void setDialog() {
        screenBox.setDialog(this);
    }

    public void show() {
        super.show();
        // 设置宽全屏，高自适应，紧贴顶部（方便设置指定组件时计算位置）
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.TOP;
        int[] location = getLocation();
        if (location != null) {
            params.y = location[1];
        }
        getWindow().setAttributes(params);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);// 取消默认padding影响
    }

    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void underBy(View view) {
        this.underByView = view;
    }

    private OnResultListener onResultListener;

    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }

    @Override
    public void onResult(Body body) {
        if (onResultListener != null) {
            onResultListener.onResult(body);
        }
    }

    @Override
    public void setUpFunctionButtonsResource(int btnConfirmBgRes, int btnConfirmTextColor, int btnCancelBgRes, int btnCancelTextColor) {
        screenBox.setUpFunctionButtonsResource(btnConfirmBgRes, btnConfirmTextColor, btnCancelBgRes, btnCancelTextColor);
    }

    @Override
    public void setBodyBgResource(int resourceId) {
        screenBox.setBodyBgResource(resourceId);
    }

    @Override
    public void setItemTextSize(int spSize) {
        screenBox.setItemTextSize(spSize);
    }

    @Override
    public void setFunctionButtonTextSize(int spSize) {
        screenBox.setFunctionButtonTextSize(spSize);
    }

    @Override
    public void setItemWidthPercent(float percent) {
        screenBox.setItemWidthPercent(percent);
    }

    @Override
    public void setMultiChoose(boolean isMulti) {
        screenBox.setMultiChoose(isMulti);
    }

    private int[] getLocation() {
        if (underByView != null) {
            int[] location = new int[2];
            underByView.getLocationInWindow(location);
            int x = location[0];
            int y = location[1];
            int width = underByView.getWidth();
            int height = underByView.getHeight();
            height = y - getStatusBarHeight() + height;
            return new int[]{width, height};
        } else {
            LogUtil.log("underByView为null");
            return null;
        }
    }

    /**
     * 获取状态栏高度，指定显示组件时使用
     *
     * @return 状态栏高度
     */
    private int getStatusBarHeight() {
        int resourceId = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getContext().getResources().getDimensionPixelSize(resourceId);
    }
}
