package com.zuicool.screenviewlibrary.screen.body;

import com.zuicool.screenviewlibrary.screen.ITitle;

/**
 * Created by jk on 2018/11/6.
 * 设置Body属性的接口
 */
interface IScreenBody extends ITitle {

    /**
     * 设置每行的列数
     *
     * @param count 列数
     */
    void setUpColumnCount(int count);

    /**
     * 设置背景样式
     *
     * @param resourceId drawable资源
     */
    void setBgResource(int resourceId);

    /**
     * 设置item文字大小
     *
     * @param textSize 字体大小，单位sp
     */
    void setItemTextSize(int textSize);

    /**
     * 根据item占单元格的宽度百分比，设置item宽度
     *
     * @param percent 百分比 (0,1]
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
