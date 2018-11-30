package com.example.myapplication.RecyView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 2018/11/29.
 */

public class MyRecyclerViewActivity extends AppCompatActivity implements MvpRcyVView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void requestSuccess() {

    }

    @Override
    public void requestFailure(String error) {

    }
}
