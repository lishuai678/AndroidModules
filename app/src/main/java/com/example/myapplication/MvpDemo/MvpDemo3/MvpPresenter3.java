package com.example.myapplication.MvpDemo.MvpDemo3;

import android.util.Log;

import com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean;
import com.example.myapplication.MvpDemo.MvpDemo3.base.AbstractMvpPersent3;

import java.util.logging.Handler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/12/3.
 */

public class MvpPresenter3 extends AbstractMvpPersent3<MvpRecyVView3> {
    private MvpModeContract3 mvpModeContract3;

    public MvpPresenter3() {
        this.mvpModeContract3 = new MvpModeContract3();
    }
    public void getDatas(final String cityid){
        if (getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mvpModeContract3.request(cityid, new Callback<WeatherBean>() {
                    @Override
                    public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                        if (getmMvpView() != null){
                            getmMvpView().requestSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherBean> call, Throwable t) {
                        if (getmMvpView() != null){
                            getmMvpView().requestFailure(Log.getStackTraceString(t));
                        }
                    }
                });
            }
        }, 1000);
    }
    public void interruptHttp(){
        mvpModeContract3.interruptHttp();
    }
}
