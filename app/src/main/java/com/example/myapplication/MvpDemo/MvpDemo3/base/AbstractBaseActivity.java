package com.example.myapplication.MvpDemo.MvpDemo3.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 2018/12/5.
 */

public  abstract class AbstractBaseActivity  <V extends MvpBaseView3, P extends  AbstractMvpPersent3<V>> extends AppCompatActivity implements  MvpBaseView3{
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null){
            presenter = creatPresenter();
        }
        if (presenter == null){throw new NullPointerException("presenter 不能为空");}
        //绑定view
        presenter.attach((V) this);
    }

    /**
     * 创建presenter
     * @return 子类自己创建需要的Presenter
     */
    protected  abstract P creatPresenter();

    public P getPresenter(){
        return presenter;
    }
}
