package com.example.myapplication.MvpDemo.MvpDemo2;

import android.util.Log;
import com.example.myapplication.MvpDemo.MvpDemo2.base.AbstractMvpPersenter2;
import com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2018/11/29.
 */

public class MvpPresenter2 extends AbstractMvpPersenter2<MvpRcyVView2> {
    private MvpRcyVView2 mvpRcyVView;
    private MvpModelContract2 mvpModelContract2;

    public MvpPresenter2() {
        this.mvpModelContract2 = new MvpModelContract2();
    }

    public void getDatas(){
        if (mvpRcyVView != null){
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mvpModelContract2.request("101010100", new Callback<WeatherBean>() {
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
    public void attach(MvpRcyVView2 view){
        this.mvpRcyVView = view;
    }
    /**
     * 解绑定
     */
    public void detach(MvpRcyVView2 view){
        this.mvpRcyVView = null;
    }
    /**
     * 取消网络请求
     */
    public void interruptHttp(){this.mvpModelContract2.interruptHttp();}
}
