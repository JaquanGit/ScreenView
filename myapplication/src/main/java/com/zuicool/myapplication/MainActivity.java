package com.zuicool.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zuicool.screenviewlibrary.screen.bean.Body;
import com.zuicool.screenviewlibrary.screen.bean.Item;
import com.zuicool.screenviewlibrary.screen.dialog.OnResultListener;
import com.zuicool.screenviewlibrary.screen.dialog.ScreenDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnSingle;
    ScreenDialog singleDialog;

    Button btnMulti;
    ScreenDialog multiDialog;

    Button btnCustom;
    ScreenDialog customDialog;

    Button btnCustom2;
    ScreenDialog customDialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvText = (TextView) findViewById(R.id.textView);

        // 单选
        btnSingle = (Button) findViewById(R.id.btn_single_screen_dialog);
        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleDialog.show();
            }
        });
        singleDialog = new ScreenDialog(MainActivity.this);
        singleDialog.setDataToView(getBody(), getBody2());
        singleDialog.underBy(btnSingle);
        singleDialog.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body... body) {
                tvText.setText(new Gson().toJson(body));
            }
        });

        // 多选
        btnMulti = (Button) findViewById(R.id.btn_multi_screen_dialog);
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiDialog.show();
            }
        });
        multiDialog = new ScreenDialog(MainActivity.this);
        multiDialog.setDataToView(getBody(), getBody2());
        multiDialog.underBy(btnMulti);
        multiDialog.setMultiChoose(true);
        multiDialog.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body... body) {
                tvText.setText(new Gson().toJson(body));
            }
        });

        // 自定义
        btnCustom = (Button) findViewById(R.id.btn_custom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });
        customDialog = new ScreenDialog(MainActivity.this);
        customDialog.setDataToView(getBody(), getBody2());
        customDialog.underBy(btnCustom);
        customDialog.setMultiChoose(true);
        customDialog.setBodyBgResource(R.drawable.solid_yellow_stroke_red_bottom_corner_s);
        customDialog.setUpFunctionButtonsResource(R.drawable.solid_yellow_bottom_right_corner_l, R.color.red,
                R.drawable.solid_green_bottom_left_corner_l, R.color.white);
        customDialog.setUpColumnCount(5);
        customDialog.setItemWidthPercent(0.5f);
        customDialog.setFunctionButtonTextSize(15);
        customDialog.setItemTextSize(10);
        customDialog.setDecorateColor(R.color.colorPrimary);
        customDialog.setTitleTextSize(15);
        customDialog.setTitleTextColor(R.color.green);
        customDialog.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body... body) {
                tvText.setText(new Gson().toJson(body));
            }
        });

        // 自定义2
        btnCustom2 = (Button) findViewById(R.id.btn_custom2);
        btnCustom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog2.show();
            }
        });
        customDialog2 = new ScreenDialog(MainActivity.this);
        customDialog2.setDataToView(getBody3());
        customDialog2.underBy(btnCustom2);
        customDialog2.setMultiChoose(true);
        customDialog2.setBodyBgResource(R.drawable.solid_yellow_stroke_red_bottom_corner_s);
        customDialog2.setUpFunctionButtonsResource(R.drawable.solid_yellow_bottom_right_corner_l, R.color.red,
                R.drawable.solid_green_bottom_left_corner_l, R.color.colorPrimary);
        customDialog2.setUpColumnCount(5);
        customDialog2.setItemWidthPercent(0.5f);
        customDialog2.setFunctionButtonTextSize(15);
        customDialog2.setItemTextSize(10);
        customDialog2.setDecorateColor(R.color.colorPrimary);
        customDialog2.setTitleTextSize(15);
        customDialog2.setTitleTextColor(R.color.green);
        customDialog2.setItemBgResource(R.drawable.solid_green_bottom_left_corner_l, R.drawable.solid_red_bottom_right_corner_l);
        customDialog2.setItemTextColor(R.color.red, R.color.yellow);
        customDialog2.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body... body) {
                tvText.setText(new Gson().toJson(body));
            }
        });
    }

    Body getBody() {
        Body body = new Body();
        body.setTitle("文本");
        ArrayList<Item> items = new ArrayList<>();
        Item gather = new Item();
        gather.setValue("全部");
        gather.setKey(-1);
        gather.setActive(true);
        items.add(gather);

        Item item = new Item();
        item.setValue("111");
        item.setKey(1);
        items.add(item);

        Item item2 = new Item();
        item2.setValue("222");
        item2.setKey(2);
        items.add(item2);

        Item item3 = new Item();
        item3.setValue("333");
        item3.setKey(3);
        items.add(item3);

        Item item4 = new Item();
        item4.setValue("444");
        item4.setKey(4);
        items.add(item4);

        Item item5 = new Item();
        item5.setValue("555");
        item5.setKey(5);
        items.add(item5);
        body.setItems(items);
        return body;
    }

    Body getBody2() {
        Body body = new Body();
        body.setTitle("文本2");
        ArrayList<Item> items = new ArrayList<>();
        Item gather = new Item();
        gather.setValue("全部");
        gather.setKey(-1);
        gather.setActive(true);
        items.add(gather);

        Item item = new Item();
        item.setValue("555");
        item.setKey(5);
        items.add(item);

        Item item2 = new Item();
        item2.setValue("666");
        item2.setKey(6);
        items.add(item2);

        Item item3 = new Item();
        item3.setValue("777");
        item3.setKey(7);
        items.add(item3);

        Item item4 = new Item();
        item4.setValue("888");
        item4.setKey(8);
        items.add(item4);
        body.setItems(items);

        Item item5 = new Item();
        item5.setValue("999");
        item5.setKey(9);
        items.add(item5);
        body.setItems(items);
        return body;
    }

    Body getBody3() {
        Body body = new Body();
        ArrayList<Item> items = new ArrayList<>();
        Item gather = new Item();
        gather.setValue("全部");
        gather.setKey(-1);
        gather.setActive(true);
        items.add(gather);

        Item item = new Item();
        item.setValue("555");
        item.setKey(5);
        items.add(item);

        Item item2 = new Item();
        item2.setValue("666");
        item2.setKey(6);
        items.add(item2);

        Item item3 = new Item();
        item3.setValue("777");
        item3.setKey(7);
        items.add(item3);

        Item item4 = new Item();
        item4.setValue("888");
        item4.setKey(8);
        items.add(item4);
        body.setItems(items);

        Item item5 = new Item();
        item5.setValue("999");
        item5.setKey(9);
        items.add(item5);
        body.setItems(items);
        return body;
    }

}
