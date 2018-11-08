package com.zuicool.screenviewlibrary.screen.item_view;

import com.zuicool.screenviewlibrary.screen.IItem;
import com.zuicool.screenviewlibrary.screen.bean.Item;

/**
 * Created by jk on 2018/10/31.
 * Item按钮接口
 */

interface IItemView extends IItem {
    /**
     * 根据数据源item显示，如：选中、失活样式
     *
     * @param item 数据源
     */
    void show(Item item);

    /**
     * 显示选中样式
     *
     * @param item 按下的按钮的数据
     */
    void showActive(Item item);

    /**
     * 显示失活样式
     *
     * @param item 按下的按钮的数据
     */
    void showInActive(Item item);
}
