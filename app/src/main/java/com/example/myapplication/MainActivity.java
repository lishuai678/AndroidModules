package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.MvpDemo.MyRecyclerViewActivity;
import com.example.myapplication.Project.HomePackage.homeFragmentPak.HomeFragment;
import com.example.myapplication.Project.HomePackage.homeactivityPak.HomeActivity;

public class MainActivity extends AppCompatActivity {
    private Button gongxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        gongxiang = findViewById(R.id.gongxiang);
        gongxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
    public void  zonghe(View view){
        Toast.makeText(MainActivity.this,"zonghe",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, HomeActivity
                .class);
        startActivity(intent);
    }
}
