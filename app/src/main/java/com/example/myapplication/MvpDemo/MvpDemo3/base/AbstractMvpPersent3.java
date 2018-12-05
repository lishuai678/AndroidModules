package com.example.myapplication.MvpDemo.MvpDemo3.base;

/**
 * Created by admin on 2018/12/3.
 */

public abstract class AbstractMvpPersent3<V extends MvpBaseView3>{
    private V mMvpView;

    /**
     * 绑定view
     */
    public void attach(V v){
        this.mMvpView = v;
    }
    /**
     * 解绑定
     */
    public void dettach(){
        this.mMvpView = null;
    }
    /**
     * 获取v层引用
     */
    public V getmMvpView(){
        return this.mMvpView;
    }
}
