package com.example.myapplication.MvpDemo.MvpDemo1;

import android.util.Log;

import com.example.myapplication.MvpDemo.MvpDemo1.request.WeatherBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/11/29.
 */

public class MvpPresenter {
    private MvpRcyVView mvpRcyVView;
    private MvpModelContract mvpModelContract;

    public MvpPresenter() {
        this.mvpModelContract = new MvpModelContract();
    }

    public void getDatas(){
        if (mvpRcyVView != null){
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mvpModelContract.request("101010100", new Callback<WeatherBean>() {
                        @Override
                        public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                            if(mvpRcyVView != null){
                                mvpRcyVView.requestSuccess(response.body());
                            }
                        }

                        @Override
                        public void onFailure(Call<WeatherBean> call, Throwable t) {
                            if(mvpRcyVView != null){
                                mvpRcyVView.requestFailure(Log.getStackTraceString(t));
                            }
                        }
                    });
                }
            }, 1000);
        }
    }


    /**
     * 绑定
     */
    public void attach(MvpRcyVView view){
        this.mvpRcyVView = view;
    }
    /**
     * 解绑定
     */
    public void detach(MvpRcyVView view){
        this.mvpRcyVView = null;
    }
    /**
     * 取消网络请求
     */
    public void interruptHttp(){this.mvpModelContract.interruptHttp();}
}
