package com.example.sxwu_lian_wang;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends Activity implements OnClickListener {


    ImageView menuSettingImageView, menuHomeImageView, menuEnvirImageView, menuRemoteImageView;
    TextView timeTextView;

    boolean isTimeStart = false;
    //创建各Fragment类的对象用于加载
    HomeFragment homeFragment;
    EnvoironmentFragment envoironmentFragment;
    RemoteFragment remoteFragment;
    SettingFragment settingFragment;
    FragmentManager fragmentManager = getFragmentManager();
    Fragment curFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initFragment();
    }


    public void initView() {
        // super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_home);
        menuSettingImageView = (ImageView) findViewById(R.id.menuSettingImageView);
        menuHomeImageView = (ImageView) findViewById(R.id.menuHomeImageView);
        menuEnvirImageView = (ImageView) findViewById(R.id.menuEnvirImageView);
        menuRemoteImageView = (ImageView) findViewById(R.id.menuRemoteImageView);
        timeTextView = (TextView) findViewById(R.id.timeTextView);

        menuSettingImageView.setOnClickListener(this);
        menuHomeImageView.setOnClickListener(this);
        menuEnvirImageView.setOnClickListener(this);
        menuRemoteImageView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.menuHomeImageView:
                imageSelect(menuHomeImageView);
                showFragment(homeFragment);
                break;

            case R.id.menuEnvirImageView:
                imageSelect(menuEnvirImageView);
                showFragment(envoironmentFragment);
                break;

            case R.id.menuRemoteImageView:
                imageSelect(menuRemoteImageView);
                showFragment(remoteFragment);

                break;

            case R.id.menuSettingImageView:
                imageSelect(menuSettingImageView);
                showFragment(settingFragment);
                break;


            default:
                break;

        }

    }

    public void imageSelect(ImageView imageView) {
        menuHomeImageView.setSelected(false);
        menuEnvirImageView.setSelected(false);
        menuRemoteImageView.setSelected(false);
        menuSettingImageView.setSelected(false);
        imageView.setSelected(true);
    }

    public void initFragment() {
        homeFragment = new HomeFragment();
        envoironmentFragment = new EnvoironmentFragment();
        remoteFragment = new RemoteFragment();
        settingFragment = new SettingFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout, homeFragment);
        transaction.add(R.id.frameLayout, envoironmentFragment);
        transaction.add(R.id.frameLayout, settingFragment);
        transaction.add(R.id.frameLayout, remoteFragment);
        transaction.hide(homeFragment);
        showFragment(homeFragment);
        transaction.commit();

    }

    public void showFragment(Fragment fragment) {
        if (fragment.equals(curFragment)) {
            return;
        }
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.hide(remoteFragment);
        transaction.hide(envoironmentFragment);
        transaction.hide(settingFragment);
        transaction.hide(homeFragment);
        transaction.show(fragment);//隐藏之后要显示出来。
        transaction.commit();
        curFragment = fragment;

    }

}
