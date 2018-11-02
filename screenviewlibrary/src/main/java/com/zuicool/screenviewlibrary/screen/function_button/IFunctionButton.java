package com.zuicool.screenviewlibrary.screen.function_button;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.dialog.IScreenDialog;

/**
 * Created by jk on 2018/11/1.
 * 功能按钮接口（“取消”和“确定”）
 */

public interface IFunctionButton {
    /**
     * 点击按钮
     */
    void click();

    /**
     * 初始化View
     */
    void initView();

    /**
     * 设置Body数据源，回调时使用，可获取当前选中和失活的数据
     *
     * @param body 数据源
     */
    void setUpBody(Body body);

    /**
     * 设置所在dialog，执行dialog消失等
     *
     * @param dialog 所在的dialog
     */
    void setDialog(IScreenDialog dialog);

    /**
     * dialog消失
     */
    void dismissDialog();

    /**
     * 设置背景
     *
     * @param resId drawable
     */
    void setUpBackgroundResource(int resId);

    /**
     * 设置文字颜色
     *
     * @param color 颜色
     */
    void setTextColor(int color);

    /**
     * 设置文字大小
     *
     * @param textSize 文字大小，单位sp
     */
    void setFunctionButtonTextSize(int textSize);
}
