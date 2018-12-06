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



//package com.example.myapplication.MvpDemo;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.myapplication.MvpDemo.MvpDemo2.MvpPresenter2;
//import com.example.myapplication.MvpDemo.MvpDemo3.MvpPresenter3;
//import com.example.myapplication.MvpDemo.MvpDemo3.MvpRecyVView3;
//import com.example.myapplication.MvpDemo.MvpDemo3.base.AbstractBaseActivity;
//import com.example.myapplication.R;
//import com.google.gson.Gson;
//
///**
// * 第五步:对应demo3
// * 上面的问题：
// * 1.每个Activity都需要调用attach和detach两个方法，
// * 解决问题：
// * 我们可以将他们抽到基类中
// */
//
//public class MyRecyclerViewActivity extends AbstractBaseActivity<MvpRecyVView3,MvpPresenter3> implements MvpRecyVView3 {
//    private Button button;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_layout_demo);
//        initView();
//    }
//
//    @Override
//    protected MvpPresenter3 creatPresenter() {
//        return new MvpPresenter3();
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
//        getPresenter().getDatas("101010100");
//    }
//
//    @Override
//    public void requestLoading() {
//        button.setText("请求中,请稍后...");
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
//}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
package com.example.myapplication.MvpDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.MvpDemo.MvpDemo4.RequestPresenter4;
import com.example.myapplication.MvpDemo.MvpDemo4.RequestView4;
import com.example.myapplication.MvpDemo.MvpDemo4.bean.WeatherBean;
import com.example.myapplication.MvpDemo.MvpDemo4.mvpframework.factory.CreatePresenter;
import com.example.myapplication.MvpDemo.MvpDemo4.mvpframework.view.AbstractMvpAppCompatActivity;
import com.example.myapplication.R;
import com.google.gson.Gson;

/**
 * 第六步:对应demo4,终极封装
 * 上面的问题：
 * 1.在AbstractMvpActivity中，绑定View，解绑View这些方法，如果现在再创建一个AbstractMvpFragment或者
 * AbstractMvpView、或者是一个AbstractMvpXXX等，那么这些代码全部都要再写一遍，代码冗余，可以抽出去
 * <p>
 * 2.实现AbstractMvpActivity的实现类中创建Presenter的方法，每个实现类都要写new，这一步父类完全可以帮忙解决
 *
 * <p>
 * 3.如果Activity或者Fragment或者View等V层意外销毁，那么我们的Presenter也没有必要存在了，界面都没有了还
 * 要这个有什么用，但是如果又被重启
 * 那么我们还需要再恢复Presenter，也就是说让我们的Presenter和View的生命周期同步，这样才算完美
 * <p>
 * 4.创建Presenter的动作放到使用时再创建，可以稍微优化一下性能问题
 * <p>
 * 解决问题：
 * 1.使用代理模式将绑定和解绑view的操作抽离出来
 * 定义绑定解绑
 * <p>
 * 2.使用工厂模式和注解在上层统一创建Presenter
 * <p>
 * 3.序列化保存Presenter，销毁Presenter对象，如果View重建反序列化重新获取Presenter
 * <p>
 * 4.将Presenter的创建过程放入到获取Presenter的方法中，如果存在返回，不存在创建，保证Presenter不会为空
 * ，而且这样还可以保证在使用的时候再创建，节省内存资源
 */
@CreatePresenter(RequestPresenter4.class)
public class MyRecyclerViewActivity extends AbstractMvpAppCompatActivity<RequestView4, RequestPresenter4> implements  RequestView4 {
    Button demo_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_demo);
        initView();
    }

    private void initView() {
        demo_button = findViewById(R.id.demo_button);
        demo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getMvpPresenter().clickRequest("101010100");
            }
        });
    }

    @Override
    public void requestLoading() {
        demo_button.setText("请求数据中，，，，，");
    }

    @Override
    public void resultSuccess(WeatherBean result) {
        demo_button.setText(""+new Gson().toJson(result));
    }

    @Override
    public void resultFailure(String result) {
        demo_button.setText(result);
    }
}
