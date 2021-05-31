package com.example.qqlayout;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedHeleper {
    Context context;
    public SharedHeleper (){

    }

    public SharedHeleper(Context context) {
        this.context = context;
    }

    public void save(String key, String value) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Iot1911", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String read(String key) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Iot1911", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
