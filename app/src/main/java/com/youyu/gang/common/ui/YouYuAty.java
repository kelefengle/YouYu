package com.youyu.gang.common.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.youyu.gang.R;
import com.youyu.gang.community.ui.CommunityFra;
import com.youyu.gang.find.ui.FindFra;
import com.youyu.gang.message.ui.MessageFra;
import com.youyu.gang.user.ui.UserFra;

public class YouYuAty extends FragmentActivity {

    private TextView community;
    private TextView find;
    private TextView message;
    private TextView user;
    private View frameLayout;
    private CommunityFra communityFra;
    private FindFra findFra;
    private MessageFra messageFra;
    private UserFra userFra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_yu_aty);
        findViews();
        init();
    }

    void findViews(){
        community = ((TextView) findViewById(R.id.community));
        find = ((TextView) findViewById(R.id.find));
        message = ((TextView) findViewById(R.id.message));
        user = ((TextView) findViewById(R.id.user));
        frameLayout = findViewById(R.id.frameLayout);
    }

    void init(){
        community.setTextColor(getResources().getColor(R.color.textColorSelected));
        initCommunityFra();

    }

    void initCommunityFra(){
        if (communityFra==null){
            communityFra = new CommunityFra();
        }
        updateFragment(communityFra);
    }

    void initFindFra(){
        if (findFra==null){
            findFra = new FindFra();
        }
        updateFragment(findFra);
    }

    void initMessageFra(){
        if (messageFra==null){
            messageFra = new MessageFra();
        }
        updateFragment(messageFra);
    }

    void initUserFra(){
        if (userFra==null){
            userFra = new UserFra();
        }
        updateFragment(userFra);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.community:
                initCommunityFra();
                break;
            case R.id.find:
                initFindFra();
                break;
            case R.id.message:
                initMessageFra();
                break;
            case R.id.user:
                initUserFra();
                break;
        }
    }

    public void updateFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout,fragment)
                .commit();
    }

}
