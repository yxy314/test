package com.example.sxwu_lian_wang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;


import java.util.logging.FileHandler;

public class SettingFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        //重写该方法的返回的布局视图
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
