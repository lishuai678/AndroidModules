package com.example.myapplication.Project.HomePackage.homeFragmentPak;

import com.example.myapplication.Project.BasePackage.InterfaceBaseView;
import com.example.myapplication.Project.HomePackage.homeFragmentPak.bean.HomeBean;

/**
 * Created by admin on 2018/12/7.
 */

public interface HomeFMMvpView extends InterfaceBaseView{
    void requestLoading();
    void requestSuccess(HomeBean homeBean);
    void requestError(String error);
}
