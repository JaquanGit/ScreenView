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
compile 'com.github.JaquanGit:ScreenView:v1.0'
```
3.使用方法：（详情见MainActivity.java）
```
// 初始化组件：
ScreenDialog dialog = new ScreenDialog(context);
// 设置数据源，数据源设置详情见MainActivity.java
dialog.setDataToView(getBody3());
// 显示在哪个组件下方
dialog.underBy(btnCustom2);
// 设置为多选
dialog.setMultiChoose(true);
// 设置Body样式
dialog.setBodyBgResource(R.drawable.solid_yellow_stroke_red_bottom_corner_s);
// 设置重置按钮和确定按钮样式
dialog.setUpFunctionButtonsResource(R.drawable.solid_yellow_bottom_right_corner_l, R.color.red,
                R.drawable.solid_green_bottom_left_corner_l, R.color.black);
// 设置列数
dialog.setUpColumnCount(5);
// 设置item宽度（%，0-1）
dialog.setItemWidthPercent(0.5f);
// 设置重置按钮和确定按钮的字体大小（sp）
dialog.setFunctionButtonTextSize(15);
// 设置item字体大小（sp）
dialog.setItemTextSize(10);
// 设置标题处装饰竖线
dialog.setDecorateColor(R.color.colorPrimary);
// 设置标题文字大小（sp）
dialog.setTitleTextSize(15);
// 设置标题字体颜色
dialog.setTitleTextColor(R.color.green);
// 设置点击确定按钮后的回调，获取筛选框内的数据，可查看哪些按钮已选中
dialog.setOnResultListener(new OnResultListener() {
    @Override
    public void onResult(Body... body) {
        // 将数据显示在TextView，用到了Gson库
        tvText.setText(new Gson().toJson(body));
    }
});
```
# ScreenShot
![image](https://github.com/JaquanGit/ScreenView/blob/master/screenshots/screen.gif)
