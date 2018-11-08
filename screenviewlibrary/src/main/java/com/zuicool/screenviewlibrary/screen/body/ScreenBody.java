package com.zuicool.screenviewlibrary.screen.body;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.zuicool.screenviewlibrary.screen.bean.Body;

/**
 * Created by jk on 2018/10/31.
 * 标题+筛选item集合组件，由多个筛选按钮组合的组件
 */

public class ScreenBody extends LinearLayout implements IScreenBody, IScreenBodySetUp {
    ScreenBodyItem screenBodyItems[];// 根据可变数组Body生成对应个数的组件

    public ScreenBody(Context context) {
        this(context, null);
    }

    public ScreenBody(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScreenBody(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
    }

    @Override
    public void setUpBody(Body... bodies) {
        if (bodies == null || bodies.length == 0) {
            return;
        }
        screenBodyItems = new ScreenBodyItem[bodies.length];
        for (int i = 0; i < screenBodyItems.length; i++) {
            screenBodyItems[i] = new ScreenBodyItem(getContext());
            screenBodyItems[i].setUpBody(bodies[i]);
            addView(screenBodyItems[i]);
        }
    }

    @Override
    public void setBgResource(int resourceId) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setBgResource(resourceId);
        }
    }

    @Override
    public void setItemTextSize(int textSize) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setItemTextSize(textSize);
        }
    }

    @Override
    public void setMultiChoose(boolean isMultiChoose) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setMultiChoose(isMultiChoose);
        }
    }

    @Override
    public void setDecorateColor(int color) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setDecorateColor(color);
        }
    }

    @Override
    public void setTitleTextSize(int size) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setTitleTextSize(size);
        }
    }

    @Override
    public void setTitleTextColor(int color) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setTitleTextColor(color);
        }
    }

    @Override
    public void reset() {
        for (ScreenBodyItem item : screenBodyItems) {
            item.reset();
        }
    }

    @Override
    public void setUpColumnCount(int count) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setUpColumnCount(count);
        }
    }

    @Override
    public void setItemWidthPercent(float percent) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setItemWidthPercent(percent);
        }
    }

    @Override
    public void setItemBgResource(int activeResource, int inActiveResource) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setItemBgResource(activeResource, inActiveResource);
        }
    }

    @Override
    public void setItemTextColor(int activeColor, int inActiveColor) {
        for (ScreenBodyItem item : screenBodyItems) {
            item.setItemTextColor(activeColor, inActiveColor);
        }
    }
}
