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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvText = (TextView) findViewById(R.id.textView);
        btnSingle = (Button) findViewById(R.id.btn_single_screen_dialog);
        btnMulti = (Button) findViewById(R.id.btn_multi_screen_dialog);
        btnCustom = (Button) findViewById(R.id.btn_custom);

        singleDialog = new ScreenDialog(MainActivity.this);
        singleDialog.setDataToView(getBody());
        singleDialog.underBy(btnSingle);

        multiDialog = new ScreenDialog(MainActivity.this);
        multiDialog.setDataToView(getBody());
        multiDialog.underBy(btnMulti);
        multiDialog.setMultiChoose(true);

        customDialog = new ScreenDialog(MainActivity.this);
        customDialog.setDataToView(getBody());
        customDialog.underBy(btnCustom);
        customDialog.setMultiChoose(true);

        customDialog.setBodyBgResource(R.drawable.solid_yellow_stroke_red_bottom_corner_s);
        customDialog.setUpFunctionButtonsResource(R.drawable.solid_yellow_bottom_right_corner_l, R.color.red,
                R.drawable.solid_green_bottom_left_corner_l, R.color.black);
        customDialog.setUpColumnCount(5);
        customDialog.setItemWidthPercent(0.5f);
        customDialog.setFunctionButtonTextSize(15);
        customDialog.setItemTextSize(10);

        btnSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singleDialog.show();
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiDialog.show();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }
        });

        singleDialog.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body body) {
                tvText.setText(new Gson().toJson(body.getItems()));
            }
        });

        multiDialog.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body body) {
                tvText.setText(new Gson().toJson(body.getItems()));
            }
        });

        customDialog.setOnResultListener(new OnResultListener() {
            @Override
            public void onResult(Body body) {
                tvText.setText(new Gson().toJson(body.getItems()));
            }
        });
    }

    Body getBody() {
        Body body = new Body();
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
        body.setItems(items);
        return body;
    }
}
