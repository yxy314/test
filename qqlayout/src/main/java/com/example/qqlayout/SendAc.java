package com.example.qqlayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SendAc extends Activity {
    Context context;
    ListView listView;
    List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
    String[] sensorNames = {"温度传感器","湿度传感器","大气压传感器","火焰传感器","人体红外传感器","噪声传感器","震动传感器",};
   // int[] sensorImages = {R.mipmap.temp_off,R.mipmap.humidity_off,R.mipmap.atmp_off,R.mipmap.fire_off,R.mipmap.body_off,R.mipmap.noise_off,R.mipmap.shake_off};
    //String[] names = {"宋江","林冲"};
    ArrayAdapter<String>adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_activity);
        context = this;
        initView();
    }

    private void initView() {
        getData();
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,sensorNames);
        listView.setAdapter(adapter);

        /*
        simpleAdapter的参数
        context：上下文
        date：数据，一般都是List
        res:所引用的界面的路径（Id）
        from：所需要的数据存储的地方（key）
        to：要展示的的控件id
         */
        SimpleAdapter simpleAdapter = new SimpleAdapter(context, dataList, R.layout.item_list,
                new String[]{"sensorName","sensorImage"},new int[]{R.id.sensorNameTextView,R.id.sensorImageView});
        listView.setAdapter(simpleAdapter);
    }
    public void getData(){
        for (int i = 0; i < sensorNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sensorName", sensorNames[i]);
            map.put("sensorImage", sensorImages[i]);
            dataList.add(map);
        }
    }
}