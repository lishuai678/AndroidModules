package com.example.myapplication.Project.HomePackage;

import android.util.Log;

import com.example.myapplication.Project.BasePackage.AbstractBasePersent;
import com.example.myapplication.Project.BasePackage.request.ApiServices;
import com.example.myapplication.Project.HomePackage.bean.HomeBean;

import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Subscription;


import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 2018/12/6.
 */

public class HomePresenter extends AbstractBasePersent<HomeMvpView> {
    private HomeModule homeModule;

    public HomePresenter() {
        this.homeModule = new HomeModule();
    }

    public void requestBanner(){
        Log.e("ls","99999999999999--1--"+getmMvpView());
        if (getmMvpView() != null){
            getmMvpView().requestLoading();
        }
        String str = null;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("appCode","1");
            str ="{\"request\":{\"body\":"+jsonObject.toString()+"}}";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("ls","99999999999999----"+str);
        final String finalStr = str;
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                homeModule.requestHomeData(finalStr, new Callback<HomeBean>() {
                    @Override
                    public void onResponse(Call<HomeBean> call, Response<HomeBean> response) {
                        if (getmMvpView() != null){
                            getmMvpView().requestSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<HomeBean> call, Throwable t) {
                        if (getmMvpView() != null){
                            getmMvpView().requestError(Log.getStackTraceString(t));
                        }
                    }
                });
            }
        }, 1000);

    }
    //使用rxandroid+retrofit进行请求
    public void loadDataByRxandroidRetrofit(){
//        Subscription subscription = new ApiServices().getHomeDataByRx(RequestBody.create(HomeModule.JSON,""))

    }


    public void interruptHttp(){
        if (homeModule != null){
            homeModule.intterHttp();
        }
    }
}
