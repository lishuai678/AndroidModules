package com.example.myapplication.Project.HomePackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.myapplication.Project.BasePackage.AbstractBaseActivity;
import com.example.myapplication.Project.BasePackage.request.ApiServices;
import com.example.myapplication.Project.HomePackage.bean.HomeBean;
import com.example.myapplication.R;
import com.google.gson.Gson;

import org.reactivestreams.Subscription;

import okhttp3.RequestBody;

/**
 * Created by admin on 2018/12/6.
 */

public class HomeActivity extends AbstractBaseActivity<HomeMvpView,HomePresenter>  implements HomeMvpView{
    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();
        initData();
    }

    private void initData() {
//        getPresenter().requestBanner();
        getPresenter().loadDataByRxandroidRetrofit();
    }


    private void initView() {
        textView = findViewById(R.id.textview);
    }

    @Override
    protected HomePresenter creatPresenter() {
        return new HomePresenter();
    }

    @Override
    public void requestLoading() {
        textView.setText("正在加载中………………");
    }

    @Override
    public void requestSuccess(HomeBean homeBean) {
        textView.setText(new Gson().toJson(homeBean));
    }

    @Override
    public void requestError(String error) {
        textView.setText(error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null){
            getPresenter().interruptHttp();
        }
    }
}
