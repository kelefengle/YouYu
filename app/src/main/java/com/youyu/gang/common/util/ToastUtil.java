package com.youyu.gang.common.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Toast message util
 */
public class ToastUtil {

    public static void showShort(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showShort(Context c, int resId) {
        Toast.makeText(c, resId, Toast.LENGTH_SHORT).show();
    }

    public static void showNetError(Context c) {
        //Toast.makeText(c, R.string.network_request_failure, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context c, String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_LONG).show();
    }
    
    public static void showLong(Context c, int resId) {
        Toast.makeText(c, resId, Toast.LENGTH_LONG).show();
    }
}
