package com.youyu.gang.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
public class BaseSharedPreferencesUtil {

    Context context;

    public BaseSharedPreferencesUtil(Context context){
        this.context = context;
    }

    protected Context getContext(){
        return this.context;
    }

    protected SharedPreferences getSharedPreferences(String name){
        return context.getSharedPreferences(name,Context.MODE_PRIVATE);
    }

}
