package com.zuicool.screenviewlibrary.screen;

/**
 * Created by jk on 2018/11/8.
 */

public interface IItem {

    /**
     * 设置选中和失活样式
     *
     * @param activeResource   选中样式，drawable
     * @param inActiveResource 失活样式，drawable
     */
    void setItemBgResource(int activeResource, int inActiveResource);

    /**
     * 设置选中和失活的字体颜色
     *
     * @param activeColor   选中颜色
     * @param inActiveColor 失活颜色
     */
    void setItemTextColor(int activeColor, int inActiveColor);
}
