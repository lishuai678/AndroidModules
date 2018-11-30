package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.RecyView.MyRecyclerViewActivity;

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
}
