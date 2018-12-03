package com.example.myapplication.MvpDemo.MvpDemo2.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2018/12/3.
 */

public interface ApiService {
    /**
     * 请求天气接口
     * @param cityId 城市
     * @return
     */
    @GET("data/cityinfo/{cityId}.html")
    Call<WeatherBean> requestWeather(@Path("cityId") String cityId);
}
