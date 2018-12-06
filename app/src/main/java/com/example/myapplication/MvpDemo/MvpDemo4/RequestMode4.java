package com.example.myapplication.MvpDemo.MvpDemo4;

import com.example.myapplication.MvpDemo.MvpDemo4.bean.ApiService;
import com.example.myapplication.MvpDemo.MvpDemo4.bean.WeatherBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestMode4 {
    private static final String BASE_URL = "http://www.weather.com.cn/";
    private Call<WeatherBean> weatherBeanCall;

    public void request(String cityId, Callback<WeatherBean> callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        weatherBeanCall = apiService.requestWeather(cityId);
        weatherBeanCall.enqueue(callback);
    }

    public void interruptHttp(){
        if(weatherBeanCall != null && !weatherBeanCall.isCanceled()){
            weatherBeanCall.cancel();
        }
    }
}
