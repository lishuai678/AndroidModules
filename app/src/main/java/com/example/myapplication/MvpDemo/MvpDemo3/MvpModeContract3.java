package com.example.myapplication.MvpDemo.MvpDemo3;

import com.example.myapplication.MvpDemo.MvpDemo2.request.ApiService;
import com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean;
import com.example.myapplication.MvpDemo.MvpDemo3.request.ApiService3;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 2018/11/29.
 */

public class MvpModeContract3 {
    //    http://www.weather.com.cn/data/cityinfo/101010100.html//101010100
    private static final String BASE_URL = "http://www.weather.com.cn/";
    private Call<WeatherBean> weatherBeanCall;

    /**
     * 请求
     * @param cityId
     * @param callback
     */
    public void request(String cityId, Callback<WeatherBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//请求的结果转为实体类
                .build();

        ApiService3 apiService = retrofit.create(ApiService3.class);
        weatherBeanCall = apiService.requestWeather(cityId);
        weatherBeanCall.enqueue(callback);
    }

    /**
     * 取消网络请求
     */
    public void interruptHttp() {
        if(weatherBeanCall != null && !weatherBeanCall.isCanceled()){
            weatherBeanCall.cancel();
        }
    }
}
