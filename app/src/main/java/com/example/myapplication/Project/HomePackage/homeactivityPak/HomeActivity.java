package com.example.myapplication.Project.HomePackage.homeactivityPak;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.Project.BasePackage.AbstractBaseActivity;
import com.example.myapplication.Project.BasePackage.AbstractBasePersent;
import com.example.myapplication.Project.BasePackage.InterfaceBaseView;
import com.example.myapplication.Project.HomePackage.homeFragmentPak.HomeFragment;
import com.example.myapplication.Project.HomePackage.tab2Pak.tab2Fragment;
import com.example.myapplication.Project.HomePackage.tab3Pak.tab3Fragment;
import com.example.myapplication.Project.HomePackage.tab4Pak.tab4Fragment;
import com.example.myapplication.R;

/**
 * Created by admin on 2018/12/10.
 */

public class HomeActivity  extends AppCompatActivity{
    private RadioGroup tabs_rg;
    private SparseArray<Fragment> mFragmentSparseArray;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();
        iniClick();
    }

    private void iniClick() {
        tabs_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        mFragmentSparseArray.get(checkedId)).commit();
            }
        });
    }

    private void initView() {
        tabs_rg = findViewById(R.id.tabs_rg);
        mFragmentSparseArray = new SparseArray<>();

        mFragmentSparseArray.append(R.id.today_tab, new HomeFragment());
        mFragmentSparseArray.append(R.id.record_tab, new tab2Fragment());
        mFragmentSparseArray.append(R.id.contact_tab, new tab3Fragment());
        mFragmentSparseArray.append(R.id.settings_tab, new tab4Fragment());
        // 默认显示第一个
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mFragmentSparseArray.get(R.id.today_tab)).commit();
    }
}
