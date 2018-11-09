# ScreenView 简介
Android 自定义筛选框，实现单选、多选逻辑和自定义弹框样式。
# 如何使用 ScreenView ？
1.root project 的 build.gradle 文件中添加 JitPack:
```
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
2.app 的 build.gradle 文件中添加 dependence：
```
compile 'com.github.JaquanGit:ScreenView:v2.1'
```
3.使用方法：（详情见MainActivity.java）
```
customDialog2 = new ScreenDialog(MainActivity.this);
// 设置数据源
customDialog2.setDataToView(getBody3());
// 设置显示在哪个组件下方
customDialog2.underBy(btnCustom2);
// 设置为多选
customDialog2.setMultiChoose(true);
// 设置Body背景样式
customDialog2.setBodyBgResource(R.drawable.solid_yellow_stroke_red_bottom_corner_s);
// 设置列数
customDialog2.setUpColumnCount(5);
// 设置装饰竖线颜色
customDialog2.setDecorateColor(R.color.colorPrimary);
// 设置标题字体大小（sp）
customDialog2.setTitleTextSize(15);
// 设置标题字体颜色
customDialog2.setTitleTextColor(R.color.green);
// 设置item占单元格百分比（0-1）
customDialog2.setItemWidthPercent(0.5f);
// 设置item字体大小
customDialog2.setItemTextSize(10);
// 设置item选中、未选中背景样式
customDialog2.setItemBgResource(R.drawable.solid_green_bottom_left_corner_l, R.drawable.solid_red_bottom_right_corner_l);
// 设置item选中、未选中字体颜色
customDialog2.setItemTextColor(R.color.red, R.color.yellow);
// 设置“重置”和“确定”按钮字体大小
customDialog2.setFunctionButtonTextSize(15);
// 设置“重置”和“确定”按钮背景样式
customDialog2.setUpFunctionButtonsResource(R.drawable.solid_yellow_bottom_right_corner_l, R.color.red,
    R.drawable.solid_green_bottom_left_corner_l, R.color.colorPrimary);
// 设置点击“确定”的回调
customDialog2.setOnResultListener(new OnResultListener() {
    @Override
    public void onResult(Body... body) {
        tvText.setText(new Gson().toJson(body));
    }
);
```
# ScreenShot
![image](https://github.com/JaquanGit/ScreenView/blob/master/screenshots/screen.gif)
