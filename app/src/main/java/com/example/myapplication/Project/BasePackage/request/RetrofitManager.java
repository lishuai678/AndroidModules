package com.example.myapplication.Project.BasePackage.request;

import com.example.myapplication.Project.constant.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by admin on 2018/12/8.
 */

public class RetrofitManager {
    private static String baseUrl = Constant.APPID;
    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)//必须与斜杠结尾
                .addConverterFactory(GsonConverterFactory.create())//定义string类型
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//适配器
                .build();
        return retrofit;
    }
}
