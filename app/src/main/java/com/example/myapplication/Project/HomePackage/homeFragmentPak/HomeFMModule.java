package com.example.myapplication.Project.HomePackage.homeFragmentPak;

import com.example.myapplication.Project.BasePackage.request.ApiServices;
import com.example.myapplication.Project.HomePackage.homeFragmentPak.bean.HomeBean;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2018/12/7.
 */

public class HomeFMModule {
    static  MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final String BASE_URL = "http://58.87.91.65:9565/";
    private Call<HomeBean> homeBeanCall;

    public void requestHomeData(String json_str, Callback<HomeBean> callback){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                .build();

        ApiServices apiServices = retrofit.create(ApiServices.class);
        RequestBody mybody = RequestBody.create(JSON,json_str);
        homeBeanCall = apiServices.getHomeData(mybody);
        homeBeanCall.enqueue(callback);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`




    public void intterHttp(){
        if (homeBeanCall != null && homeBeanCall.isCanceled()){
            homeBeanCall.cancel();
        }
    }
}
