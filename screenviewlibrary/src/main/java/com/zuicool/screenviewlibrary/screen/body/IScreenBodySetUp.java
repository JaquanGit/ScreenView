package com.zuicool.screenviewlibrary.screen.body;

import com.zuicool.screenviewlibrary.screen.bean.Body;

/**
 * Created by jk on 2018/11/6.
 * Body的接口
 */

interface IScreenBodySetUp {
    /**
     * 设置数据源
     *
     * @param bodies 标题+筛选item
     */
    void setUpBody(Body... bodies);
}
