package com.zuicool.screenviewlibrary.screen;

/**
 * Created by jk on 2018/11/7.
 * Title接口
 */

public interface ITitle {

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
