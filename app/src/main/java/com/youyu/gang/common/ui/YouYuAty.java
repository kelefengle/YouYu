package com.youyu.gang.common.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.youyu.gang.R;
import com.youyu.gang.common.adapter.HomeFragmentPageAdp;
import com.youyu.gang.community.ui.CommunityFra;
import com.youyu.gang.find.ui.FindFra;
import com.youyu.gang.message.ui.MessageFra;
import com.youyu.gang.user.ui.UserFra;

public class YouYuAty extends FragmentActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private TextView community;
    private TextView find;
    private TextView message;
    private TextView user;
    private ViewPager homeViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_yu_aty);
        findViews();
        init();
        setListener();
    }

    void findViews(){
        community = ((TextView) findViewById(R.id.community));
        find = ((TextView) findViewById(R.id.find));
        message = ((TextView) findViewById(R.id.message));
        user = ((TextView) findViewById(R.id.user));
        homeViewPager = ((ViewPager) findViewById(R.id.homeViewPager));
    }

    void init(){
        community.setTextColor(getResources().getColor(R.color.textColorSelected));
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        homeViewPager.setAdapter(new HomeFragmentPageAdp(supportFragmentManager));
    }

    void setListener(){
        homeViewPager.addOnPageChangeListener(this);
        community.setOnClickListener(this);
        find.setOnClickListener(this);
        message.setOnClickListener(this);
        user.setOnClickListener(this);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.community:
                homeViewPager.setCurrentItem(0);
                selectCommunity();
                break;
            case R.id.find:
                homeViewPager.setCurrentItem(1);
                selectFind();
                break;
            case R.id.message:
                homeViewPager.setCurrentItem(2);
               selectMessage();
                break;
            case R.id.user:
                homeViewPager.setCurrentItem(3);
               selectUser();
                break;
        }
    }

    void selectCommunity(){
        community.setTextColor(getResources().getColor(R.color.textColorSelected));
        find.setTextColor(getResources().getColor(R.color.textColorSelect));
        message.setTextColor(getResources().getColor(R.color.textColorSelect));
        user.setTextColor(getResources().getColor(R.color.textColorSelect));
    }
    void selectFind(){
        community.setTextColor(getResources().getColor(R.color.textColorSelect));
        find.setTextColor(getResources().getColor(R.color.textColorSelected));
        message.setTextColor(getResources().getColor(R.color.textColorSelect));
        user.setTextColor(getResources().getColor(R.color.textColorSelect));
    }
    void selectMessage(){
        community.setTextColor(getResources().getColor(R.color.textColorSelect));
        find.setTextColor(getResources().getColor(R.color.textColorSelect));
        message.setTextColor(getResources().getColor(R.color.textColorSelected));
        user.setTextColor(getResources().getColor(R.color.textColorSelect));
    }
    void selectUser(){
        community.setTextColor(getResources().getColor(R.color.textColorSelect));
        find.setTextColor(getResources().getColor(R.color.textColorSelect));
        message.setTextColor(getResources().getColor(R.color.textColorSelect));
        user.setTextColor(getResources().getColor(R.color.textColorSelected));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                selectCommunity();
                break;
            case 1:
                selectFind();
                break;
            case 2:
                selectMessage();
                break;
            case 3:
                selectUser();
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
