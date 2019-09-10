#### QMUI-阴影布局部分

[QMUI 官网](https://qmuiteam.com/android/get-started/)

- 因为需要阴影布局部分
- Androidx
```groovy
    implementation 'com.github.SheTieJun:SimQUMI:ff51904954'
```

##### 其他： 如果返回使用 Android support

1.需要去掉`gradle.properties`中的

```
android.useAndroidX=true
android.enableJetifier=true
```

2.把Androidx包替换成Android support

3.或者使用分支qmui_wk 最近提交 
```groovy
    implementation 'com.github.SheTieJun:SimQUMI:6a8d9b1159'
```


