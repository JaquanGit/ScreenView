package com.zuicool.screenviewlibrary.screen.body;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.bean.Item;
import com.zuicool.screenviewlibrary.screen.body.title.ScreenBodyItemTitle;
import com.zuicool.screenviewlibrary.screen.constant.ScreenConstant;
import com.zuicool.screenviewlibrary.screen.item_view.ItemView;

import java.util.ArrayList;

/**
 * Created by jk on 2018/11/6.
 * 筛选Body Item，包括：标题组件、筛选item集合组件
 */

public class ScreenBodyItem extends LinearLayout implements IScreenBody, IScreenBodyItemSetUp {
    ScreenBodyItemTitle titleView;// 标题组件，包括：装饰竖线、标题文本
    GridView gridView;
    BodyAdapter adapter;
    Body body;// 数据源

    boolean isMultiChoose = false;

    int columnCount = ScreenConstant.DEFAULT_COLUMN_COUNT;// 列数
    float itemWidthPercent = ScreenConstant.DEFAULT_ITEM_WIDTH_PERCENT;// 文本宽度占单元格宽度百分比

    int activeResource, inActiveResource;
    int activeColor, inActiveColor;

    public ScreenBodyItem(Context context) {
        this(context, null);
    }

    public ScreenBodyItem(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScreenBodyItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
        gridView = new GridView(getContext());
        gridView.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        gridView.setGravity(Gravity.CENTER);
        gridView.setVerticalSpacing(getVerticalSpacing());
        gridView.setNumColumns(columnCount);
        initListener();
    }

    /**
     * 行间距为屏幕的百分之一
     *
     * @return 屏幕的百分之一
     */
    private int getVerticalSpacing() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int heightPixels = metrics.heightPixels;
        return heightPixels / 100;
    }

    @Override
    public void setUpBody(Body body) {
        this.body = body;

        String title = body.getTitle();
        if (title != null) {
            titleView = new ScreenBodyItemTitle(getContext());
            titleView.setDataToView(title);
            addView(titleView);
        }
        adapter = new BodyAdapter(body.getItems());
        gridView.setAdapter(adapter);
        addView(gridView);

    }

    @Override
    public void executeSingleChoose(Item item) {
        // 若item为选中状态，则不执行任何操作
        // 若item为失活状态，则将所有设为失活状态，将自身设为选中状态
        if (!item.isActive()) {
            for (Item it : body.getItems()) {
                it.setActive(false);
            }
            item.setActive(true);
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 多选
     *
     * @param item 按下按钮的数据
     */
    @Override
    public void executeMultiChoose(Item item) {
        // 若item为选中状态，若item是“全部”，则不执行任何操作；若item不是“全部”按钮，则将其设置为失活状态，同时判断其他item，若都是失活状态，则把“全部”设置为选中状态
        // 若item为失活状态，若item是“全部”，则将item设置为选中状态，同时将其他都设置为失活状态；若item不是“全部”，则将其设置为选中状态，同时将“全部”设置为失活状态
        if (item.isActive()) {
            if (!item.isGatherButton()) {
                item.setActive(false);
                if (isOtherItemAllInActive(item)) {
                    setGatherButtonActive();
                }
            }
        } else {
            if (item.isGatherButton()) {
                item.setActive(true);
                setInActiveExceptGatherButton();
            } else {
                item.setActive(true);
                setGatherButtonInActive();
            }
        }
    }

    @Override
    public void setUpColumnCount(int count) {
        this.columnCount = count;
        gridView.setNumColumns(count);
    }

    @Override
    public void setBgResource(int resourceId) {
        setBackgroundResource(resourceId);
    }

    @Override
    public void setItemTextSize(int spSize) {
        for (Item it : body.getItems()) {
            it.setTextSize(spSize);
        }
    }

    @Override
    public void setItemWidthPercent(float percent) {
        if (percent <= 0 || percent > 1) {
            percent = ScreenConstant.DEFAULT_ITEM_WIDTH_PERCENT;
        }
        this.itemWidthPercent = percent;
    }

    /**
     * 设置多选逻辑
     *
     * @param isMultiChoose 多选或单选；
     */
    public void setMultiChoose(boolean isMultiChoose) {
        this.isMultiChoose = isMultiChoose;
    }

    /**
     * 注意判空，这里titleView因没有相关数据可能为null，调用之前要判断
     *
     * @param color R.color.xx
     */
    @Override
    public void setDecorateColor(int color) {
        if (titleView != null) {
            titleView.setDecorateColor(color);
        }
    }

    @Override
    public void setTitleTextSize(int size) {
        if (titleView != null) {
            titleView.setTitleTextSize(size);
        }
    }

    @Override
    public void setTitleTextColor(int color) {
        if (titleView != null) {
            titleView.setTitleTextColor(color);
        }
    }

    @Override
    public void reset() {
        ArrayList<Item> items = body.getItems();
        for (Item item : items) {
            if (item.isGatherButton()) {
                item.setActive(true);
            } else {
                item.setActive(false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * 此方法执行时View已绘制，可获取View宽高
     */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        int gridViewWidth = gridView.getWidth();
        float itemWidth = gridViewWidth / columnCount * itemWidthPercent;
        setItemWidth((int) itemWidth);
    }

    private void initListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Item item = body.getItems().get(position);
                if (isMultiChoose) {
                    executeMultiChoose(item);
                } else {
                    executeSingleChoose(item);
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 设置item宽度，刷新adapter
     *
     * @param itemWidth item宽，单位px
     */
    private void setItemWidth(int itemWidth) {
        for (Item it : body.getItems()) {
            it.setItemWidth(itemWidth);
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * 剩下的全部为失活
     *
     * @param item 按下的按钮
     * @return 剩下的都为失活状态，返回true；只要有一个是选中状态，就返回false
     */
    private boolean isOtherItemAllInActive(Item item) {
        boolean allInActive = true;
        for (Item it : body.getItems()) {
            if (it != item) {
                if (it.isActive()) {
                    allInActive = false;
                    break;
                }
            }
        }
        return allInActive;
    }

    /**
     * 选中“全部”按钮
     */
    private void setGatherButtonActive() {
        for (Item it : body.getItems()) {
            if (it.isGatherButton()) {
                it.setActive(true);
            }
        }
    }

    /**
     * 失活“全部”按钮
     */
    private void setGatherButtonInActive() {
        for (Item it : body.getItems()) {
            if (it.isGatherButton()) {
                it.setActive(false);
            }
        }
    }

    /**
     * 除“全部”按钮外失活
     */
    private void setInActiveExceptGatherButton() {
        for (Item it : body.getItems()) {
            if (!it.isGatherButton()) {
                it.setActive(false);
            }
        }
    }

    @Override
    public void setItemBgResource(int activeResource, int inActiveResource) {
        if (activeResource != 0 && inActiveResource != 0) {
            this.activeResource = activeResource;
            this.inActiveResource = inActiveResource;
        }
    }

    @Override
    public void setItemTextColor(int activeColor, int inActiveColor) {
        if (activeColor != 0 && inActiveColor != 0) {
            this.activeColor = activeColor;
            this.inActiveColor = inActiveColor;
        }
    }

    private class BodyAdapter extends BaseAdapter {
        ArrayList<Item> items;

        BodyAdapter(ArrayList<Item> items) {
            this.items = items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ItemView view = new ItemView(getContext());
            Item item = items.get(position);
            if (activeResource != 0 && inActiveResource != 0) {
                view.setItemBgResource(activeResource, inActiveResource);
            }
            if (activeColor != 0 && inActiveColor != 0) {
                view.setItemTextColor(activeColor, inActiveColor);
            }
            view.show(item);
            return view;
        }
    }
}
