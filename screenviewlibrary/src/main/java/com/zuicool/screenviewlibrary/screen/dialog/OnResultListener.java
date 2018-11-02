package com.zuicool.screenviewlibrary.screen.dialog;

import com.zuicool.screenviewlibrary.screen.bean.Body;

/**
 * Created by jk on 2018/11/2.
 * 响应筛选的回调接口，方便获取当前选中和失活的数据
 */

public interface OnResultListener {
    void onResult(Body body);
}
