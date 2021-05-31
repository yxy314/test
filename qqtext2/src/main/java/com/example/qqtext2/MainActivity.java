package com.example.qqtext2;
import java.util.ArrayList;
import java.util.List;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.Html.ImageGetter;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends BaseAcitivity implements android.view.View.OnClickListener,OnItemClickListener{
    private ListView mlistview_content;
    private Button mbtn_leftsend;
    private Button mbtn_rightsend;
    private EditText medittext_words;
    private Button mbutton_back;
    private Button mbutton_biaoqing;
    private List<Message> mMessage=new ArrayList<Message>();;
    private LayoutInflater minflater;
    private View mview;
    private MessageAdapter madapter;
    private PopupWindow mpopwindow;
    private ExpressionSend expressionsend;

    private GridView mgridview;
    private List<Myexpression> mMyexpressions;
    private MyexpressionAdapter madaptergrid;
    private boolean flag;

    private Spanned span;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mlistview_content=generateFindViewById(R.id.listview);
        medittext_words=generateFindViewById(R.id.edittext_words);
        mbtn_leftsend=generateFindViewById(R.id.leftsend);
        mbtn_rightsend=generateFindViewById(R.id.rightsend);
        mbutton_back=generateFindViewById(R.id.button_back);
        mbutton_biaoqing=generateFindViewById(R.id.biaoqingsend);

        mpopwindow=new PopupWindow();
        mgridview=(GridView) findViewById(R.id.mygridview);
        minflater=getLayoutInflater();
        initData();
        madaptergrid=new MyexpressionAdapter(mMyexpressions,minflater);

        mgridview.setAdapter(madaptergrid);
        mgridview.requestFocus();

        mbtn_leftsend.setOnClickListener(this);
        mbtn_rightsend.setOnClickListener(this);
        mbutton_back.setOnClickListener(this);
        mbutton_biaoqing.setOnClickListener(this);

        mview=minflater.inflate(R.layout.message_layout, null);
        madapter=new MessageAdapter(mMessage,minflater);
        mlistview_content.setAdapter(madapter);

    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.leftsend:{
                leftmessage();

            }break;
            case R.id.rightsend:{
                rightmessage();
            }break;
            case R.id.biaoqingsend:{
                popwindow();//弹出gridview界面

            }break;
            case R.id.button_back:{
                MainActivity.this.finish();
            }break;
            default:break;
        }

    }


    public void leftmessage(){
        Message message=new Message(medittext_words.getText().subSequence(0, medittext_words.getText().toString().length()), 1);
        mMessage.add(message);
        madapter.notifyDataSetChanged();
        medittext_words.setText("");
    }

    public void rightmessage(){

        Message message=new Message(medittext_words.getText().subSequence(0, medittext_words.getText().toString().length()), 0);
        mMessage.add(message);
        madapter.notifyDataSetChanged();
        medittext_words.setText("");
    }
    private void popwindow() {
        if(flag){
            mgridview.setVisibility(View.VISIBLE);
            flag=!flag;
        }else{
            mgridview.setVisibility(View.GONE);
            flag=!flag;
        }
        mgridview.setOnItemClickListener(this);
        LayoutInflater inflater=getLayoutInflater();
        View popwindowview=inflater.inflate(R.layout.gridview, null);
        mpopwindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mpopwindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mpopwindow.setContentView(popwindowview);
        mpopwindow.setFocusable(false);
        mpopwindow.setOutsideTouchable(true);
        mpopwindow.showAsDropDown(mbutton_back);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {


        final int imggetterid=mMyexpressions.get(position).getImg_biaoqing();
        ImageGetter imggetter=new ImageGetter() {

            @Override
            public Drawable getDrawable(String source) {

                Drawable drawable=getResources().getDrawable(imggetterid);
                drawable.setBounds(0,0,40,40);
                return drawable;
            }
        };
        span=Html.fromHtml("<img src=''/>",imggetter,null);
        medittext_words.append(span);
    }

    private void initData() {
        mMyexpressions=new ArrayList<Myexpression>();

        Myexpression myexpression0=new Myexpression(R.drawable.dianwo);
        mMyexpressions.add(myexpression0);
        Myexpression myexpression1=new Myexpression(R.drawable.a);
        mMyexpressions.add(myexpression1);
        Myexpression myexpression2=new Myexpression(R.drawable.apple);
        mMyexpressions.add(myexpression2);
        Myexpression myexpression3=new Myexpression(R.drawable.xihan);
        mMyexpressions.add(myexpression3);
        Myexpression myexpression4=new Myexpression(R.drawable.xihuan);
        mMyexpressions.add(myexpression4);
        Myexpression myexpression5=new Myexpression(R.drawable.liuhan);
        mMyexpressions.add(myexpression5);

        Myexpression myexpression6=new Myexpression(R.drawable.kelian);
        mMyexpressions.add(myexpression6);
        Myexpression myexpression7=new Myexpression(R.drawable.heng);
        mMyexpressions.add(myexpression7);

        Myexpression myexpression8=new Myexpression(R.drawable.ganga);
        mMyexpressions.add(myexpression8);
        Myexpression myexpression9=new Myexpression(R.drawable.kaixin);
        mMyexpressions.add(myexpression9);


    }


}