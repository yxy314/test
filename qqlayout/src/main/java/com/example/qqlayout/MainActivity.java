package com.example.qqlayout;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText userNameEditText, passwordEditText;
    Button loginButton;
    final String tag = "Main";

    SharedHeleper sharedHeleper;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        //实例化
        sharedHeleper = new SharedHeleper(context);
        initView();
    }

    public void initView() {
        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                String userName = userNameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (userName != null && userName.length() > 0) {
                    if (userName.equals("czie")) {
                        if (password != null && password.length() > 0) {
                            if (password.equals("123")) {
                                sharedHeleper.save("userName", userName);
                                sharedHeleper.save("password", password);
                                Log.d(tag, "登录成功，请稍后...");
                                // 跳转
//                              startActivity(new Intent(MainActivity.this,HomeActivity.class));跳转页面
                                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                            } else {
                                Log.d(tag, "密码错误，请重试");
                            }
                        }
                    } else {
                        Log.d(tag, "用户名不存在，请注册");
                    }
                } else {
                    Log.d(tag, "请输入用户名");
                }

            }
        });

    }

    protected void onStart() {
        super.onStart();
        String userNameString = sharedHeleper.read("userName");
        String passwordString = sharedHeleper.read("password");
        userNameEditText.setText(userNameString);
        passwordEditText.setText(passwordString);


    }


}