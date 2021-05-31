package com.example.sxwu_lian_wang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;

public class RemoteFragment extends Fragment {
    //1，继承Fragment（APP包下面）
    //2,如果实现Fragment的功能，必须实现两个方法
    //3，
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        //重写该方法的返回的布局视图
        return inflater.inflate(R.layout.fragment_remote, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
}
