package com.zuicool.screenviewlibrary.screen.bean;

import java.util.ArrayList;

/**
 * Created by jk on 2018/10/31.
 * 标题+筛选item集合
 * 作为一个数据单位，标题暂时没用到，筛选item集合是girdView数据源，girdView据此显示
 */

public class Body {
    private String title;// 标题，暂时没用到
    private ArrayList<Item> items;// 筛选item集合

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
