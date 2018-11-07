package com.zuicool.screenviewlibrary.screen.dialog;

import android.view.View;

import com.zuicool.screenviewlibrary.screen.bean.Body;

/**
 * Created by jk on 2018/11/1.
 * 筛选弹框，最终使用的组件
 */

public interface IScreenDialog {
    /**
     * 设置数据源
     *
     * @param bodies 数据源
     */
    void setDataToView(Body... bodies);

    /**
     * 设置每行列数
     *
     * @param count 列数
     */
    void setUpColumnCount(int count);

    /**
     * dialog显示
     */
    void show();

    /**
     * dialog消失
     */
    void dismiss();

    /**
     * 显示在指定的组件下方
     *
     * @param view 指定的组件
     */
    void underBy(View view);

    /**
     * 点击“确定”按钮后的回调方法
     *
     * @param body 回调参数，传给使用者
     */
    void onResult(Body... body);

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
     * 设置ScreenBody样式
     *
     * @param resourceId drawableId
     */
    void setBodyBgResource(int resourceId);

    /**
     * 设置item字体大小
     *
     * @param textSize 字体大小，单位sp
     */
    void setItemTextSize(int textSize);

    /**
     * 设置“取消”和“确定”按钮字体大小
     *
     * @param textSize 字体大小，单位sp
     */
    void setFunctionButtonTextSize(int textSize);

    /**
     * 根据item占单元格百分比设置item宽度
     *
     * @param percent 单元格百分比，（0,1]
     */
    void setItemWidthPercent(float percent);

    /**
     * 设置单选或多选
     *
     * @param isMulti 单选或多选。true：多选；false：单选
     */
    void setMultiChoose(boolean isMulti);

    /**
     * 设置装饰竖线颜色
     *
     * @param color 形式：R.color.xx
     */
    void setDecorateColor(int color);

    /**
     * 设置标题文本字体大小
     *
     * @param size 单位：sp
     */
    void setTitleTextSize(int size);

    /**
     * 设置标题文本字体颜色
     *
     * @param color 形式：R.color.xx
     */
    void setTitleTextColor(int color);
}
