package com.youyu.gang.common.util;

import android.app.ProgressDialog;
import android.content.Context;

/**
 *
 */
public class DialogUtil {

    Context context;
    ProgressDialog dialog;

    public DialogUtil(Context context) {
        this.context = context;
        dialog = new ProgressDialog(context);
    }

    public void showDialog(String msg) {
        try{
            if (dialog != null) {
                dialog.setMessage(msg);
                dialog.show();
            } else {
                dialog = new ProgressDialog(context);
                dialog.setMessage(msg);
                dialog.show();
            }
        }catch (Exception e){}
    }

    public void cancelDialog() {
        try{
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }catch (Exception e){}
    }

    public void destroyDialog() {
        if (dialog != null) {
            dialog = null;
        }
    }
    public void notCanceledonTouchOutside(){
        dialog.setCanceledOnTouchOutside(false);
    }
}