package com.example.myapplication.MvpDemo.MvpDemo4.mvpframework.factory;


import com.example.myapplication.MvpDemo.MvpDemo4.mvpframework.presenter.BaseMvpPresenter;
import com.example.myapplication.MvpDemo.MvpDemo4.mvpframework.view.BaseMvpView;

/**
 * @author 刘镓旗
 * @date 2017/11/17
 * @description Presenter工厂接口
 */
public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {

    /**
     * 创建Presenter的接口方法
     * @return 需要创建的Presenter
     */
    P createMvpPresenter();
}
