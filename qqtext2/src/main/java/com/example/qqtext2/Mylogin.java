package com.example.qqtext2;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class Mylogin extends Activity implements OnClickListener,OnCheckedChangeListener{
    private EditText medit_useracount;
    private EditText medit_password;
    private CheckBox mcheckbox_remember;
    private Button mbutton_login;
    private Intent mintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login_layout);
        medit_useracount=(EditText) findViewById(R.id.useraccount);
        medit_password=(EditText) findViewById(R.id.password);
        mcheckbox_remember=(CheckBox) findViewById(R.id.checkbox_remember);

        mbutton_login=(Button) findViewById(R.id.button_login);
        mintent=new Intent(getApplicationContext(),MainActivity.class);
        mbutton_login.setOnClickListener(this);
        //用于数据的回显，通过从info文件中获得数据
        //从而使点击back后再打开也是有数据的
        readaccount();

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_login:{

                //点击登录按钮后开启聊天界面 mcheckbox_remember.setOnCheckedChangeListener(this);
                startActivity(mintent);
                Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                //Mylogin.this.finish();
            }break;
            default:break;

        }

    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            //sharedpreferance非常适合保存零散的简单的数据，这里使用它来保存用户名和密码
            //路径data/data/……

            SharedPreferences sp=getSharedPreferences("info", MODE_PRIVATE);//设置属性，90%为私有
            //拿到SharedPreferences的编辑器
            Editor ed=sp.edit();
            //将数据放入
            ed.putString("name", medit_useracount.getText().toString());
            ed.putString("password", medit_password.getText().toString());
            //最后记得提交
            ed.commit();
        }
    }

    public void readaccount() {
        SharedPreferences sp=getSharedPreferences("info", MODE_PRIVATE);//90%为私有
        String name=sp.getString("name","");
        String password=sp.getString("password", "");
        medit_useracount.setText(name);
        medit_password.setText(password);
    }

}