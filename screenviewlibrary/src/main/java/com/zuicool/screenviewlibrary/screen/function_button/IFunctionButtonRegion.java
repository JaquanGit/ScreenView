package com.zuicool.screenviewlibrary.screen.function_button;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.dialog.IScreenDialog;

/**
 * Created by jk on 2018/11/1.
 * 底部按钮容器组件接口（“取消”和“确定”）
 */

interface IFunctionButtonRegion {
    /**
     * 设置Body数据源，方便点击按钮获取当前选中和失活的数据
     *
     * @param body 数据源
     */
    void setUp(Body... body);

    /**
     * 所在的dialog，方便执行dialog消失
     *
     * @param dialog 所在的dialog
     */
    void setDialog(IScreenDialog dialog);

    /**
     * 设置“取消”和“确定”按钮
     *
     * @param btnConfirmBgRes     “确定”按钮背景
     * @param btnConfirmTextColor “确定”按钮字体颜色
     * @param btnCancelBgRes      “取消”按钮背景
     * @param btnCancelTextColor  “取消”按钮字体颜色
     */
    void setUpFunctionButtonsResource(int btnConfirmBgRes, int btnConfirmTextColor,
                                      int btnCancelBgRes, int btnCancelTextColor);

    /**
     * 设置按钮文字大小
     *
     * @param textSize 文字大小，单位sp
     */
    void setFunctionButtonTextSize(int textSize);
}
