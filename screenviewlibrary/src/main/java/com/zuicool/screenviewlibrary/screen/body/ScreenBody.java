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
import android.widget.TextView;

import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.bean.Item;
import com.zuicool.screenviewlibrary.screen.constant.ScreenConstant;
import com.zuicool.screenviewlibrary.screen.item_view.ItemView;

import java.util.ArrayList;

/**
 * Created by jk on 2018/10/31.
 * 标题+筛选item集合组件，由多个筛选按钮组合的组件
 */

public class ScreenBody extends LinearLayout implements IScreenBody {
    GridView gridView;
    BodyAdapter adapter;
    Body body;

    boolean isMultiChoose = false;

    int columnCount = ScreenConstant.DEFAULT_COLUMN_COUNT;
    float itemWidthPercent = ScreenConstant.DEFAULT_ITEM_WIDTH_PERCENT;

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
        if (body.getItems() == null) {
            return;
        }
        this.body = body;
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
     * 此方法执行时View已绘制，可获取View宽高
     */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        int gridViewWidth = gridView.getWidth();
        float itemWidth = gridViewWidth / columnCount * itemWidthPercent;
        setItemWidth((int) itemWidth);
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

    class BodyAdapter extends BaseAdapter {
        ArrayList<Item> items;

        public BodyAdapter(ArrayList<Item> items) {
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
            view.show(item);
            return view;
        }

        // TODO: 2018/10/31 Holder
        class Holder {
            TextView tvText;
        }
    }
}
