package com.youyu.gang.community.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.youyu.gang.community.ui.CommunityFollowFra;
import com.youyu.gang.community.ui.CommunityNewestFra;
import com.youyu.gang.community.ui.CommunityNewsFlashFra;
import com.youyu.gang.community.ui.CommunityRecommendFra;

/**
 * Created by Administrator on 2016/11/8.
 */
public class CommunityPageAdp extends FragmentPagerAdapter {

    public CommunityPageAdp(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CommunityRecommendFra();
            case 1:
                return new CommunityNewestFra();
            case 2:
                return new CommunityFollowFra();
            case 3:
                return new CommunityNewsFlashFra();
            default:
                return new CommunityRecommendFra();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
