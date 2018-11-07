package com.zuicool.screenviewlibrary.screen.body;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.bean.Item;

/**
 * Created by jk on 2018/11/6.
 * 筛选Body Item的接口
 */

interface IScreenBodyItemSetUp {
    /**
     * 设置Body数据源
     *
     * @param body 数据源
     */
    void setUpBody(Body body);

    /**
     * 执行单选
     *
     * @param item 按下按钮的数据
     */
    void executeSingleChoose(Item item);

    /**
     * 执行多选
     *
     * @param item 按下按钮的数据
     */
    void executeMultiChoose(Item item);

}
