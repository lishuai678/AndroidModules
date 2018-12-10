package com.example.myapplication.Project.HomePackage.homeFragmentPak;

import android.util.Log;

import com.example.myapplication.Project.BasePackage.AbstractBasePersent;
import com.example.myapplication.Project.BasePackage.request.ApiServices;
import com.example.myapplication.Project.BasePackage.request.RetrofitManager;
import com.example.myapplication.Project.HomePackage.homeFragmentPak.bean.HomeBean;

import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by admin on 2018/12/6.
 */

public class HomeFMPresenter extends AbstractBasePersent<HomeFMMvpView> {
    private HomeFMModule homeModule;
    HomeBean mhomeBean;

    public HomeFMPresenter() {
        this.homeModule = new HomeFMModule();
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
        RetrofitManager.getRetrofit().create(ApiServices.class)
                .getHomeDataByRx(RequestBody.create(HomeFMModule.JSON,finalStr))
                //在子线程访问数据
                .subscribeOn(Schedulers.io())
                //在主线程显示数据
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        mhomeBean = homeBean;
                    }
                    //onError(): 事件队列异常。在事件处理过程中出异常时，onError() 会被触发，
                    // 同时队列自动终止，不允许再有事件发出。
                    @Override
                    public void onError(Throwable throwable) {
                        if (getmMvpView() != null){
                            getmMvpView().requestError(Log.getStackTraceString(throwable));
                        }
                    }
                    //onCompleted(): 事件队列完结。RxJava 不仅把每个事件单独处理，还会把它们看做一个队列。
                    // RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
                    @Override
                    public void onComplete() {
                        if (getmMvpView() != null){
                            getmMvpView().requestSuccess(mhomeBean);
                        }
                    }
                });
    }

    public void interruptHttp(){
        if (homeModule != null){
            homeModule.intterHttp();
        }
    }
}
