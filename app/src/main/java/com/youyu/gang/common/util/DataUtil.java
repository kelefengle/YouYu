package com.youyu.gang.common.util;

import android.text.TextUtils;

import java.util.ArrayList;

/**
 * 数据辅助类
 */
public class DataUtil {

    public static boolean netDataIsEmpty(String data) {
        if (TextUtils.isEmpty(data) || "null".equals(data)) {
            return true;
        } else {
            return false;
        }
    }

    public static int stringToInt(String value) {
       int i=-1;
        if (!TextUtils.isEmpty(value)){
            try{
               i=Integer.parseInt(value);
            }catch (Exception e){}
        }

        return i;
    }

    public static int getArraMaxLen(ArrayList<String> data) {
        int len = 0;
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).toString().contains(".")) {
                if (len < data.get(i).length()) {
                    len = data.get(i).length();
                }
            }
        }
        return len;
    }
}

