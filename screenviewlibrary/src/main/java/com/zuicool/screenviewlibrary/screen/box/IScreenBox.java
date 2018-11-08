package com.zuicool.screenviewlibrary.screen.box;

import com.zuicool.screenviewlibrary.screen.IItem;
import com.zuicool.screenviewlibrary.screen.ITitle;
import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.dialog.IScreenDialog;

/**
 * Created by jk on 2018/10/31.
 * 筛选item集合+按钮容器组合
 */

interface IScreenBox extends ITitle, IItem {
    /**
     * 设置数据源
     *
     * @param bodies 数据源，可变数组
     */
    void setUp(Body... bodies);

    /**
     * 设置每行列数
     *
     * @param count 列数
     */
    void setUpColumnCount(int count);

    /**
     * 设置所在dialog，方便dialog消失执行
     *
     * @param dialog 所在dialog
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
     * 设置Body组件背景
     *
     * @param resourceId drawableId
     */
    void setBodyBgResource(int resourceId);

    /**
     * 设置筛选item字体大小
     *
     * @param textSize 字体大小，单位px
     */
    void setItemTextSize(int textSize);

    /**
     * 设置“取消”和“确定”按钮字体大小
     *
     * @param textSize 字体大小，单位sp
     */
    void setFunctionButtonTextSize(int textSize);

    /**
     * 筛选item占单元格百分比设置item宽度
     *
     * @param percent 百分比 （0,1]
     */
    void setItemWidthPercent(float percent);

    /**
     * 设置多选或单选
     *
     * @param isMultiChoose true：多选；false：单选
     */
    void setMultiChoose(boolean isMultiChoose);

    /**
     * 筛选项重置
     */
    void reset();

}
