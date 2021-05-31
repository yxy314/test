package com.example.exm01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    private String name = "q";
    private String pw = "q";
    private EditText etname;
    private EditText etpw;
    private ImageButton on;
    private ImageButton off;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = (EditText)findViewById(R.id.etName);
        etpw = (EditText)findViewById(R.id.etPw);

    }

    public void log(View v){
        if (name.equals((etname.getText().toString()))) {
            if (pw.equals(etpw.getText().toString())) {
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        }else if ((etname.getText().toString()).trim().equals("") && (etpw.getText().toString()).trim().equals("")) {
            Toast.makeText(this, "用户名或口令不能为空", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(this, "用户名或口令不正确", Toast.LENGTH_SHORT).show();
        }
    }
}