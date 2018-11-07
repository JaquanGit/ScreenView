package com.zuicool.screenviewlibrary.screen.body.title;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuicool.screenviewlibrary.R;
import com.zuicool.screenviewlibrary.screen.constant.ScreenConstant;

/**
 * Created by jk on 2018/11/6.
 * 装饰竖线+标题文本，显示在筛选item上方，根据有无数据自动显示或不显示
 */

public class ScreenBodyItemTitle extends LinearLayout implements IScreenBodyItemTitle {
    View decorateLine;// 装饰竖线
    TextView tvTitle; // 标题文本

    public ScreenBodyItemTitle(Context context) {
        this(context, null);
    }

    public ScreenBodyItemTitle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScreenBodyItemTitle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(HORIZONTAL);
        decorateLine = new View(getContext());
        LayoutParams params = new LayoutParams(getDecorateLineWidth(), ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(20, 10, 0, 0);
        decorateLine.setLayoutParams(params);
        decorateLine.setBackgroundColor(getResources().getColor(R.color.red));

        tvTitle = new TextView(getContext());
        tvTitle.setTextColor(getResources().getColor(R.color.black));
        LinearLayout.LayoutParams textParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.setMargins(20, 10, 0, 0);
        tvTitle.setLayoutParams(textParams);
        tvTitle.setTextSize(ScreenConstant.DEFAULT_ITEM_TEXT_SIZE);

        addView(decorateLine);
        addView(tvTitle);
    }

    @Override
    public void setDataToView(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void setDecorateColor(int color) {
        decorateLine.setBackgroundColor(getResources().getColor(color));
    }

    @Override
    public void setTitleTextSize(int size) {
        tvTitle.setTextSize(size);
    }

    @Override
    public void setTitleTextColor(int color) {
        tvTitle.setTextColor(getResources().getColor(color));
    }

    /**
     * 设置装饰竖线宽度
     *
     * @return px，返回屏幕宽度的百分之一宽度
     */
    private int getDecorateLineWidth() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        return metrics.widthPixels / 100;
    }

}
