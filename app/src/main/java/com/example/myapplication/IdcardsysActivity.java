package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IdcardsysActivity extends Activity {
    private TextView info;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idcardsys);
        info = (TextView) findViewById(R.id.tvidinfo);
        Intent intent=getIntent();
        String name=intent.getStringExtra("username");

        String pass=intent.getStringExtra("password");

        String birth=intent.getStringExtra("birthday");
        String sex=intent.getStringExtra("sex");

        info.append("用户名："+name+"\n");
        info.append("家庭住址："+pass+"\n");
        info.append("生日："+birth+"\n");
        info.append("性别："+sex+"\n");

    }
    public void back(View v) {
        this.finish();
    }
}
