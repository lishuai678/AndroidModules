package com.example.myapplication.RecyView;

import java.util.logging.Handler;

/**
 * Created by admin on 2018/11/29.
 */

public class MvpPresenter {
    private MvpRcyVView mvpRcyVView;
    private MvpModelContract mvpModelContract;

    public MvpPresenter() {
        this.mvpModelContract = new MvpModelContract();
    }

    public void getDatas(){
        if (mvpRcyVView != null){
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    mvpModelContract.
                }
            }, 1000);
        }
    }


    /**
     * 绑定
     */
    public void attach(MvpRcyVView view){
        this.mvpRcyVView = view;
    }
    /**
     * 解绑定
     */
    public void detach(MvpRcyVView view){
        this.mvpRcyVView = null;
    }
    /**
     * 取消网络请求
     */
    public void interruptHttp(){this.mvpModelContract.interruptHttp();}
}
