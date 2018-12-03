package com.example.myapplication.MvpDemo.MvpDemo2.base;

/**
 * @description MVP架构中所有Presenter的基类
 */
public abstract class AbstractMvpPersenter2<V extends MvpView2> {
    /**
     * V层引用
     */
    private V mMvpView;

    /**
     * 绑定V层
     * @param v
     */
    public void attachMvpView(V v){
        this.mMvpView = v;
    }

    /**
     * 解除绑定V层
     */
    public void detachMvpView(){
        this.mMvpView = null;
    }

    /**
     * 获取V层引用
     * @return 返回V层
     */
    public V getMvpView() {
        return mMvpView;
    }
}
