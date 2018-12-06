package com.example.myapplication.MvpDemo.MvpDemo4;


import com.example.myapplication.MvpDemo.MvpDemo4.bean.WeatherBean;
import com.example.myapplication.MvpDemo.MvpDemo4.mvpframework.view.BaseMvpView;

/**
 * @author 刘镓旗
 * @date 2017/11/17
 * @description
 */
public interface RequestView4 extends BaseMvpView {
    void requestLoading();
    void resultSuccess(WeatherBean result);
    void resultFailure(String result);
}
