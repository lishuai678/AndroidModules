//package com.example.myapplication.MvpDemo;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//
//import com.example.myapplication.MvpDemo.MvpDemo1.MvpPresenter2;
//import com.example.myapplication.MvpDemo.MvpDemo1.MvpRcyVView2;
//import com.example.myapplication.MvpDemo.MvpDemo1.request.WeatherBean;
//import com.google.gson.Gson;
//
///**
// * Created by admin on 2018/11/29.
// *
// *
// *   第三步：对应demo1
// * 上面的问题：
// * 1.是会内存泄露，因为persenter一直持有Activity，如果一个发了一个请求，但是网络有点慢，这个时候退出Activity，那么请求回来后还是会调用
// * Activity的回调方法，这里还是因为一直持有的问题
// * 2.如果已经退出了当前界面，这个请求也没有用了，这个时候我们可以断开请求
// * <p>
// * 解决问题：
// * 1.增加绑定和解绑的方法来解决内存泄露和退出后还会回调的问题
// * 2、增加断开网络连接的方法
// */
//
//public class MyRecyclerViewActivity extends AppCompatActivity implements MvpRcyVView2 {
//    private MvpPresenter2 mvpPresenter;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mvpPresenter  = new MvpPresenter2();
//        mvpPresenter.attach(this);
//        initData();
//    }
//
//    private void initData() {
//        mvpPresenter.getDatas();
//    }
//
//
//    @Override
//    public void requestSuccess(WeatherBean data) {
//        Log.i("ls","data----"+new Gson().toJson(data));
//    }
//
//    @Override
//    public void requestFailure(String error) {
//        Log.i("ls","error----"+error);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mvpPresenter.detach(this);
//        mvpPresenter.interruptHttp();
//    }
//}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``
//
//package com.example.myapplication.MvpDemo;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.myapplication.MvpDemo.MvpDemo2.MvpPresenter2;
//import com.example.myapplication.MvpDemo.MvpDemo2.MvpRcyVView2;
//import com.example.myapplication.R;
//import com.google.gson.Gson;
//
///**
// * 第四步:对应demo2
// * 上面的问题：
// * 1.Presenter中attach和detach每个Presenter都需要定义这个方法
// * 解决问题：
// * 抽象出basePresenter
// * 但是如果抽象出BasePresenter，那么attach方法中的view就不能写死，那么就需要泛型设计
// */
//
//public class MyRecyclerViewActivity extends AppCompatActivity implements MvpRcyVView2 {
//    private MvpPresenter2 mvpPresenter2;
//    private Button button;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_layout_demo);
//
//        mvpPresenter2  = new MvpPresenter2();
//        mvpPresenter2.attach(this);
//        initView();
//
//    }
//
//    private void initView() {
//        button = findViewById(R.id.demo_button);
//        button.setText("开始请求");
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                initData();
//            }
//        });
//    }
//
//    private void initData() {
//        mvpPresenter2.getDatas();
//    }
//
//    @Override
//    public void requestSuccess(com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean data) {
//        String str = new Gson().toJson(data);
//        Log.i("ls","data----"+str);
//        button.setText(str);
//    }
//
//    @Override
//    public void requestFailure(String error) {
//        Log.i("ls","error----"+error);
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mvpPresenter2.detach(this);
//        mvpPresenter2.interruptHttp();
//    }
//}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`



package com.example.myapplication.MvpDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MvpDemo.MvpDemo2.MvpPresenter2;
import com.example.myapplication.MvpDemo.MvpDemo2.MvpRcyVView2;
import com.example.myapplication.R;
import com.google.gson.Gson;

/**
 * 第5步:对应demo2
 * 上面的问题：
 * 1.Presenter中attach和detach每个Presenter都需要定义这个方法
 * 解决问题：
 * 抽象出basePresenter
 * 但是如果抽象出BasePresenter，那么attach方法中的view就不能写死，那么就需要泛型设计
 */

public class MyRecyclerViewActivity extends AppCompatActivity implements MvpRcyVView2 {
    private MvpPresenter2 mvpPresenter2;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_demo);

        mvpPresenter2  = new MvpPresenter2();
        mvpPresenter2.attach(this);
        initView();

    }

    private void initView() {
        button = findViewById(R.id.demo_button);
        button.setText("开始请求");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });
    }

    private void initData() {
        mvpPresenter2.getDatas();
    }

    @Override
    public void requestSuccess(com.example.myapplication.MvpDemo.MvpDemo2.request.WeatherBean data) {
        String str = new Gson().toJson(data);
        Log.i("ls","data----"+str);
        button.setText(str);
    }

    @Override
    public void requestFailure(String error) {
        Log.i("ls","error----"+error);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpPresenter2.detach(this);
        mvpPresenter2.interruptHttp();
    }
}

