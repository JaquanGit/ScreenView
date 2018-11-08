package com.zuicool.screenviewlibrary.screen.item_view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.bean.Item;
import com.zuicool.screenviewlibrary.screen.constant.ScreenConstant;

/**
 * Created by jk on 2018/10/31.
 * 筛选item组件
 */

public class ItemView extends LinearLayout implements IItemView {
    TextView tvText;
    int activeBackgroundResource;
    int inActiveBackgroundResource;
    int activeTextColor;
    int inActiveTextColor;

    public ItemView(Context context) {
        this(context, null);
    }

    public ItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inActiveBackgroundResource = R.drawable.solid_gray_corner_s;
        activeBackgroundResource = R.drawable.solid_white_stroke_red_corner_s;
        activeTextColor = getResources().getColor(R.color.red);
        inActiveTextColor = getResources().getColor(R.color.black);

        tvText = new TextView(getContext());

        addView(tvText);
        setGravity(Gravity.CENTER);
    }

    @Override
    public void show(Item item) {
        LayoutParams params = (LayoutParams) tvText.getLayoutParams();
        params.width = item.getItemWidth();
        tvText.setLayoutParams(params);

        if (item.getTextSize() <= 0) {
            item.setTextSize(ScreenConstant.DEFAULT_ITEM_TEXT_SIZE);
        }
        tvText.setTextSize(item.getTextSize());

        int padding = getTextPadding();
        tvText.setPadding(0, padding, 0, padding);

        tvText.setGravity(Gravity.CENTER);
        tvText.setText(item.getValue());

        if (item.isActive()) {
            showActive(item);
        } else {
            showInActive(item);
        }
    }

    private int getDefaultItemWidth() {
        return getResources().getDisplayMetrics().widthPixels / 8;
    }

    private int getTextPadding() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return metrics.heightPixels / 200;
    }

    @Override
    public void showActive(Item item) {
        tvText.setTextColor(activeTextColor);
        tvText.setBackgroundResource(activeBackgroundResource);
    }

    @Override
    public void showInActive(Item item) {
        tvText.setTextColor(inActiveTextColor);
        tvText.setBackgroundResource(inActiveBackgroundResource);
    }

    @Override
    public void setItemBgResource(int activeResource, int inActiveResource) {
        this.activeBackgroundResource = activeResource;
        this.inActiveBackgroundResource = inActiveResource;
    }

    @Override
    public void setItemTextColor(int activeColor, int inActiveColor) {
        this.activeTextColor = getResources().getColor(activeColor);
        this.inActiveTextColor = getResources().getColor(inActiveColor);
    }
}
