package com.example.myapplication.MvpDemo.MvpDemo2;

import com.example.myapplication.MvpDemo.MvpDemo2.base.MvpView2;
import com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean;

/**
 * Created by admin on 2018/11/29.
 */

public interface MvpRcyVView2 extends MvpView2 {
    void requestSuccess(WeatherBean data);
    void requestFailure(String error);
}
