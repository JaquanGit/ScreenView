package com.zuicool.screenviewlibrary.screen.body;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.bean.Item;

/**
 * Created by jk on 2018/10/31.
 * 基本筛选单元接口
 */

public interface IScreenBody {
    /**
     * 设置数据源
     *
     * @param body 标题+筛选item
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
}
