package com.example.myapplication.MvpDemo.MvpDemo1;

import com.example.myapplication.MvpDemo.MvpDemo1.request.WeatherBean;

/**
 * Created by admin on 2018/11/29.
 */

public interface MvpRcyVView {
    void requestSuccess(WeatherBean data);
    void requestFailure(String error);
}
