package com.zuicool.screenviewlibrary.screen.body.title;

import com.zuicool.screenviewlibrary.screen.ITitle;

/**
 * Created by jk on 2018/11/6.
 * 装饰竖线+标题文本，显示在筛选item上方，根据有无数据自动显示或不显示
 */

interface IScreenBodyItemTitle extends ITitle {

    /**
     * 设置文本
     *
     * @param title 标题文本（可以为空，为空组件不显示）
     */
    void setDataToView(String title);
}
