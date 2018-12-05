package com.example.myapplication.MvpDemo.MvpDemo3;
import com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean;
import com.example.myapplication.MvpDemo.MvpDemo3.base.MvpBaseView3;

/**
 * Created by admin on 2018/12/3.
 */

public interface MvpRecyVView3 extends MvpBaseView3 {
    void requestLoading();
    void requestSuccess(WeatherBean data);
    void requestFailure(String error);
}
