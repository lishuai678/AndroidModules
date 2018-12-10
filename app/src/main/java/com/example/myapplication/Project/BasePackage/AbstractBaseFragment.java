package com.example.myapplication.Project.BasePackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by admin on 2018/12/10.
 */

public abstract class AbstractBaseFragment<V extends InterfaceBaseView, P extends AbstractBasePersent<V>> extends Fragment implements InterfaceBaseView{
    private P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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