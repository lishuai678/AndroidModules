package com.example.myapplication.Project.HomePackage.homeFragmentPak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Project.BasePackage.AbstractBaseFragment;
import com.example.myapplication.Project.HomePackage.homeFragmentPak.bean.HomeBean;
import com.example.myapplication.R;

/**
 * Created by admin on 2018/12/6.
 */

public class HomeFragment extends AbstractBaseFragment<HomeFMMvpView,HomeFMPresenter> implements HomeFMMvpView {
    private TextView textView;
    private RecyclerView recyclerView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_layout,null);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initData();
    }

    private void initData() {
        //单纯的mvp+retrofit
//        getPresenter().requestBanner();
        //mvp+retrofit+RxJava
        getPresenter().loadDataByRxandroidRetrofit();
    }

    private void initView() {
//        textView = findViewById(R.id.textview);
//        recyclerView = findViewById(R.id.recyclerView);
    }

    @Override
    protected HomeFMPresenter creatPresenter() {
        return new HomeFMPresenter();
    }

    @Override
    public void requestLoading() {
//        textView.setText("正在加载中………………");
    }

    @Override
    public void requestSuccess(HomeBean homeBean) {
//        textView.setText(new Gson().toJson(homeBean));
    }

    @Override
    public void requestError(String error) {
        textView.setText(error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null){
            getPresenter().interruptHttp();
        }
    }
}
