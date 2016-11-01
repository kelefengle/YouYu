package com.youyu.gang.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

import java.math.BigDecimal;

/**
 * 程序工具类
 */
public class AppUtil {

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getWindowWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getWindowHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static void setWindowAlpha(Activity activity, float alpha) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = alpha;
        activity.getWindow().setAttributes(lp);
    }

    public static Bitmap getWindowBitm(Activity activity) {
        Bitmap bitmap ;
        View view = activity.getWindow().getDecorView();
        bitmap = Bitmap.createBitmap(getWindowWidth(activity), getWindowHeight(activity), Bitmap.Config.RGB_565);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    /**
     * @param screenWidth 手机屏幕的宽度
     * @param picWidth    原始图片所用分辨率的宽度
     * @param retainValue 保留小数位
     * @return 手机屏幕分辨率与原始图片分辨率的宽度比
     */
    public static double divideWidth(int screenWidth, int picWidth, int retainValue) {
        BigDecimal screenBD = new BigDecimal(Double.toString(screenWidth));
        BigDecimal picBD = new BigDecimal(Double.toString(picWidth));
        return screenBD.divide(picBD, retainValue, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static int dpToPx(Context context, int dp){
        return (int)(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()) + 0.5f);
    }

}
