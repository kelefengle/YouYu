package com.youyu.gang.wxapi;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.youyu.gang.R;
import com.youyu.gang.common.constants.Constant;
import com.youyu.gang.common.util.SharedPreferencesUtil;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

    Context context;
    SharedPreferencesUtil spfUtil;

    RequestQueue queue;

    IWXAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        queue = Volley.newRequestQueue(context);
        spfUtil = new SharedPreferencesUtil(context);
        api = WXAPIFactory.createWXAPI(this, Constant.APP_ID
                , false);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {
        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
            spfUtil.setPayStatus(resp.errCode);
        }
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        queue.stop();
    }
}