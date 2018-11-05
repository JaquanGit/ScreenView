# ScreenView 简介
Android 自定义筛选框，实现单选、多选逻辑和自定义弹框样式。
# 为什么要用 ScreenView ？
1.不需要你实现筛选的逻辑，只需要你按照我提供给你的数据结构（Bean）来初始化按钮文字。
2.同时点击弹框的“确定”按钮，可以获得由数据结构得出的选择后的数据，可以看出哪些项已被选中，哪些未被选中。你可以进一步通过你的操作进行你需要的处理。
3.组件支持自定义样式，包括：弹框背景、按钮选中和未选中样式（包括文字颜色）、筛选按钮文字大小、每行有几列筛选按钮。
4.即使你不进行自定义，原始的样式也挺好看，你可以直接使用。
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
3.具体使用：（详情见MainActivity.java）
```
// 初始化组件：
ScreenDialog dialog = new ScreenDialog(context);
// 设置数据结构（Bean）
dialog.setDataToView(getBody());
// 设置显示在哪个组件下方：
dialog.underBy(view);
// 设置为多选：（默认单选）
dialog.setMultiChoose(true);
// 设置筛选框背景样式：
dialog.setBodyBgResource(R.drawable.xx);
// 设置“取消”和“确定”按钮：（四个参数分别为：“确定”按钮背景样式，“确定”按钮文字颜色，“取消”按钮背景样式，“取消”按钮文字颜色）
dialog.setUpFunctionButtonsResource(R.drawable.xx, R.color.xx, R.drawable.xx, R.color.xx);
// 设置列数：（默认count==4）
dialog.setUpColumnCount(count);
// 设置单个筛选按钮对应单元格宽度：（单位：百分比 值：(0,1] 默认percent==0.8f）
dialog.setItemWidthPercent(percent);
// 设置筛选按钮文字大小：（单位：sp 默认：size==12）
dialog.setItemTextSize(size);
// 设置“取消”和“确定”按钮文字大小：（单位：sp 默认size==14）
dialog.setFunctionButtonTextSize(size);
```
