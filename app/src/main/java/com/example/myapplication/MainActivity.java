package com.example.myapplication;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etuser;
    private EditText etpass;
    private EditText etbirth;
    private Intent intent;
    private RadioButton rdman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trytu);
        System.out.println("onCteate");
        etuser = (EditText)findViewById(R.id.etUser);
        etpass = (EditText)findViewById(R.id.etPass);
        etbirth = (EditText)findViewById(R.id.etBirth);
        rdman = (RadioButton)findViewById(R.id.rdmale);
    }
    public void inputinfo(View v)
    {

        //检查各控件内容是否为空
        String name=etuser.getText().toString();
        String pass=etpass.getText().toString();
        String birth=etbirth.getText().toString();
        if(name.isEmpty() || pass.isEmpty() || birth.isEmpty()){
            Toast.makeText(MainActivity.this, "用户、命令和生日不能为空", Toast.LENGTH_LONG).show();
            return;
        }
        //检查生日控件格式
        if(!checkBirth(birth)){
            Toast.makeText(MainActivity.this, "出生年月日不合法（1911-11-11）", Toast.LENGTH_LONG).show();
            return;
        }
        //判断用户名和口令
      //  if(name.equals("123")&&pass.equals("123")){//去掉判断函数
            //创建显示意图
            Intent intent=new Intent(MainActivity.this,IdcardsysActivity.class);


            //传递参数
            if(rdman.isChecked())
                intent.putExtra("sex","男");
            else{
                intent.putExtra("sex","女");
            }
            intent.putExtra("username",name);
            intent.putExtra("password",pass);
            intent.putExtra("birthday",birth);
            //跳转到下一界面
            startActivity(intent);


    //    }



    }
    private boolean checkBirth(String birth){
        SimpleDateFormat format=new SimpleDateFormat("yyy-MM-dd");
        format.setLenient(false);
        try{
            Date date=format.parse(birth);
        }catch(ParseException e){
            //TODO Auto-generated catch block
            //e.printStackTrace();

            return false;
        }
        return true ;
    }

}
