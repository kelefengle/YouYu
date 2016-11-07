package com.youyu.gang.common.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.youyu.gang.community.ui.CommunityFra;
import com.youyu.gang.find.ui.FindFra;
import com.youyu.gang.message.ui.MessageFra;
import com.youyu.gang.user.ui.UserFra;

/**
 * Created by fengle on 2016/11/7.
 */
public class HomeFragmentPageAdp extends FragmentPagerAdapter {

    public HomeFragmentPageAdp(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CommunityFra();
            case 1:
                return new FindFra();
            case 2:
               return new MessageFra();
            case 3:
                return new UserFra();
            default:
                return new CommunityFra();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
