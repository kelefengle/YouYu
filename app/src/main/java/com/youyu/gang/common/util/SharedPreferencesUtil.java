package com.youyu.gang.common.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 */
public class SharedPreferencesUtil extends BaseSharedPreferencesUtil{

    final String WE_CHAT_INFO = "we_chat_info";
    final String ACTION = "action";
    final String LOGIN_STATUS = "login_status";
    final String LOGIN_TOKEN = "login_token";
    final String PAY_STATUS = "pay_status";

    public SharedPreferencesUtil(Context context) {
        super(context);
    }

    private SharedPreferences getWeChatInfo() {
        return getSharedPreferences(WE_CHAT_INFO);
    }

    public void setAction(String action) {
        getWeChatInfo().edit().putString(ACTION, action).commit();
    }

    public String getAction() {
        return getWeChatInfo().getString(ACTION, "");
    }

    public void setPayStatus(int payStatus) {
        getWeChatInfo().edit().putInt(PAY_STATUS, payStatus).commit();
    }

    public int getPayStatus() {
        return getWeChatInfo().getInt(PAY_STATUS, -1);
    }

    public void setLoginStatus(int loginStatus) {
        getWeChatInfo().edit().putInt(LOGIN_STATUS, loginStatus).commit();
    }

    public int getLoginStatus() {
        return getWeChatInfo().getInt(LOGIN_STATUS, 1);
    }

    public void setLoginToken(String loginToken) {
        getWeChatInfo().edit().putString(LOGIN_TOKEN, loginToken).commit();
    }

    public String getLoginToken() {
        return getWeChatInfo().getString(LOGIN_TOKEN, "");
    }

}
