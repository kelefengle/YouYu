package com.youyu.gang.common.constants;

public class Constant {

    public static  final int Init_OK = 0x0001;
    public static  final int Init_Zero = 0x0002;
    public static  final int Init_Fail = 0x0003;
    public static  final int Init_Error = 0x0004;

    public static  final int Refresh_OK = 0x0011;
    public static  final int Refresh_Zero = 0x0012;
    public static  final int Refresh_Fail = 0x0013;
    public static  final int Refresh_Error = 0x0014;

    public static  final int Load_More_OK = 0x0021;
    public static  final int Load_More_Zero = 0x0022;
    public static  final int Load_More_Fail = 0x0023;
    public static  final int Load_More_Error = 0x0024;


    public static  final int All_Load = 0x0040;

    public static  final int Get_OK = 0x0041;
    public static  final int Get_Zero = 0x0042;
    public static  final int Get_Fail = 0x0043;
    public static  final int Get_Error = 0x0044;


    public static  final int Join_In_OK = 0x0051;
    public static  final int Join_In_Fail = 0x0052;
    public static  final int Join_In_Error = 0x0053;


    public static  final int Delete_OK = 0x0061;
    public static  final int Delete_Fail = 0x0062;
    public static  final int Delete_Error = 0x0063;


    public static  final int Create_OK = 0x0081;
    public static  final int Create_Fail = 0x0082;
    public static  final int Create_Error = 0x0083;

    public static  final int Pay_OK = 0x0091;
    public static  final int Pay_Fail = 0x0092;
    public static  final int Pay_Error = 0x0093;

    public static  final int Save_OK = 0x0101;
    public static  final int Save_Fail = 0x0102;

    public static  final int Comment_OK=0x112;
    public static  final int Comment_Fail=0x113;
    public static  final int Comment_Error=0x114;
    public static  final int Zhan_Ok=0x115;
    public static final int Change=0x0111;
    public static final int Search_OK=0x1001;
    public static final int Search_Error=0x1010;

    public static final String APP_ID = "wx82b2a93bb687f5c1";
    public static final String SECRET = "f4375ef9995ba58808773334a3fb3940";

//  public static final String SINA_APP_KEY = "3731403874";
    public static final String SINA_APP_KEY = "1569085031";
    public static final String REDIRECT_URL = "https://api.weibo.com/oauth2/default.html";
    public static final String SCOPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";
}
