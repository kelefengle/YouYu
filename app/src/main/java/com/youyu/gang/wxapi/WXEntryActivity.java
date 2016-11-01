package com.youyu.gang.wxapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.youyu.gang.R;
import com.youyu.gang.common.constants.Constant;
import com.youyu.gang.common.constants.UrlManager;
import com.youyu.gang.common.util.SharedPreferencesUtil;
import com.youyu.gang.common.util.ToastUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    Context context;
    SharedPreferencesUtil spfUtil;
    String action;

    RequestQueue queue;

    IWXAPI api;

//    WeChatAuthorize weChatAuthorize;
//    WeChatUserInfo weChatUserInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        queue = Volley.newRequestQueue(context);
        spfUtil = new SharedPreferencesUtil(context);
        action = spfUtil.getAction();
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
    public void onReq(BaseReq baseReq) {
    }

    @Override
    public void onResp(BaseResp baseResp) {
        if (getString(R.string.action_we_chat_share).equals(action)) {
            int result;
            switch (baseResp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    result = R.string.share_err_ok;
                    break;
                case BaseResp.ErrCode.ERR_COMM:
                    result = R.string.share_err_comm;
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    result = R.string.share_err_user_cancel;
                    break;
                case BaseResp.ErrCode.ERR_SENT_FAILED:
                    result = R.string.share_err_sent_failed;
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    result = R.string.share_err_auth_denied;
                    break;
                case BaseResp.ErrCode.ERR_UNSUPPORT:
                    result = R.string.share_err_unsupport;
                    break;
                default:
                    result = R.string.share_err_unknow;
                    break;
            }
            ToastUtil.showShort(context, result);
            finish();
        } else if (getString(R.string.action_we_chat_login).equals(action)) {
            switch (baseResp.errCode) {
                case BaseResp.ErrCode.ERR_OK:
                    String code = ((SendAuth.Resp) baseResp).code;
                    getAccessToken(code);
                    //用户同意
                    break;

                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    //用户拒绝授权
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    //用户取消
                default:
                    spfUtil.setLoginStatus(-1);
                    finish();
                    break;
            }
        } else {
            finish();
        }
    }

    void getAccessToken(String code) {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        StringRequest request = new StringRequest(
//                "UrlManager.WXAccessTokenUrl"
//                        + "appid=" + Constant.APP_ID
//                        + "&secret=" + Constant.SECRET
//                        + "&code=" + code
//                        + "&grant_type=authorization_code",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        weChatAuthorize = LoginJsonAnaly.analyWeChatAuthorize(response);
//                        if (weChatAuthorize != null) {
//                            handler.obtainMessage(Constant.Init_OK).sendToTarget();
//                        } else {
//                            handler.obtainMessage(Constant.Init_Fail).sendToTarget();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        handler.obtainMessage(Constant.Init_Error).sendToTarget();
//                    }
//                });
//        queue.add(request);
    }

    void getWeChatUserInfo() {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        MyStringRequest request = new MyStringRequest(
//                UrlManager.WXUserInfoUrl + weChatAuthorize.getAccess_token()
//                        + "&openid=" + weChatAuthorize.getOpenid(),
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        String s=null;
//                        try {
//                             s=new String(response.getBytes(),"UTF-8");
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//                        weChatUserInfo = LoginJsonAnaly.analyWeChatUserInfo(s);
//                        if (weChatUserInfo != null) {
//                            handler.obtainMessage(Constant.Get_OK).sendToTarget();
//                        } else {
//                            handler.obtainMessage(Constant.Get_Fail).sendToTarget();
//                        }
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        handler.obtainMessage(Constant.Get_Error).sendToTarget();
//                    }
//                }
//        );
//        queue.add(request);
    }

    void weChatAuthorize() {
//        RequestQueue queue = Volley.newRequestQueue(context);
//        StringRequest request = null;
//        try {
//            request = new StringRequest(
//                    UrlManager.WXAuthorizeUrl
//                            + "?openid=" + weChatUserInfo.getOpenid()
//                            + "&unionid=" + weChatUserInfo.getUnionid()
//                            + "&headimgurl=" + weChatUserInfo.getHeadimgurl()
//                            + "&sex=" + weChatUserInfo.getSex()
//                            + "&property=" +getString(R.string.jinxiangzhistring)
//                            + "&nickname=" + URLEncoder.encode(weChatUserInfo.getNickname(), "UTF-8") ,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            String token = LoginJsonAnaly.analyToken(response);
//                            if (null != token) {
//                                handler.obtainMessage(Constant.Create_OK, token).sendToTarget();
//                            } else {
//                                handler.obtainMessage(Constant.Create_Fail).sendToTarget();
//                                handler.obtainMessage(Constant.Change);
//                            }
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            handler.obtainMessage(Constant.Create_Error).sendToTarget();
//                        }
//                    }
//            );
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        queue.add(request);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Constant.Init_OK:
                    getWeChatUserInfo();
                    break;
                case Constant.Get_OK:
                    weChatAuthorize();
                    break;
                case Constant.Create_OK:
                    String token = msg.obj.toString();
                    spfUtil.setLoginToken(token);
                    spfUtil.setLoginStatus(0);
                    finish();
                    break;
                case Constant.Init_Fail:
                case Constant.Init_Error:
                case Constant.Get_Fail:
                case Constant.Get_Error:
                case Constant.Refresh_Fail:
                case Constant.Refresh_Error:
                case Constant.Create_Fail:
                case Constant.Create_Error:
                    spfUtil.setLoginStatus(-1);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        queue.stop();
    }

}
