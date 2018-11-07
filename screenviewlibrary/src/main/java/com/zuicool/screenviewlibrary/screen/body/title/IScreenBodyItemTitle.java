package com.zuicool.screenviewlibrary.screen.body.title;

/**
 * Created by jk on 2018/11/6.
 * 装饰竖线+标题文本，显示在筛选item上方，根据有无数据自动显示或不显示
 */

interface IScreenBodyItemTitle {
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

    /**
     * 设置文本
     *
     * @param title 标题文本（可以为空，为空组件不显示）
     */
    void setDataToView(String title);
}
