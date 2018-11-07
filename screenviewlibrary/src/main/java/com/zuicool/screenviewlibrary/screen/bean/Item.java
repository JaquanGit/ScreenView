package com.zuicool.screenviewlibrary.screen.bean;

/**
 * Created by jk on 2018/10/31.
 * 筛选item数据源
 */

public class Item {
    private int key;// id（我将“全部”按钮的key设为-1，可做特殊处理）
    private String value;// 按钮显示的文本
    private boolean isActive;// 选中状态或失活（未选中）状态，选中为true、失活为false
    transient private int textSize;// 字体大小，单位sp
    transient private int itemWidth;// item的宽度，单位px

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isGatherButton() {
        return key == -1;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int spSize) {
        this.textSize = spSize;
    }

    public int getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
    }
}
