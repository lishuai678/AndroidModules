package com.example.myapplication.Project.BasePackage.request;

import com.example.myapplication.Project.HomePackage.bean.HomeBean;

import org.json.JSONObject;


import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by admin on 2018/12/7.
 */

public interface ApiServices {
    //retrofit 一般情况下的写法
    @POST("backadmin/resourceDetailAppApi/findAllResourceInfoAndResourceDetail")
    Call<HomeBean> getHomeData(@Body RequestBody requestBody);

    //使用rxJava   +    retrofit
    @POST("backadmin/resourceDetailAppApi/findAllResourceInfoAndResourceDetail")
    Observable<HomeBean> getHomeDataByRx(@Body RequestBody requestBody);
}
