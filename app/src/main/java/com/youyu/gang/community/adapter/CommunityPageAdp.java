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

    Fragment fragment;
    public CommunityPageAdp(FragmentManager fm,Fragment fragment) {
        super(fm);
        this.fragment=fragment;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CommunityRecommendFra communityRecommendFra = new CommunityRecommendFra();
                communityRecommendFra.setTargetFragment(fragment,1);
                return communityRecommendFra;
            case 1:
                CommunityNewestFra communityNewestFra = new CommunityNewestFra();
                communityNewestFra.setTargetFragment(fragment,1);
                return communityNewestFra;
            case 2:
                CommunityFollowFra communityFollowFra = new CommunityFollowFra();
                communityFollowFra.setTargetFragment(fragment,1);
                return communityFollowFra;
            case 3:
                CommunityNewsFlashFra communityNewsFlashFra = new CommunityNewsFlashFra();
                communityNewsFlashFra.setTargetFragment(fragment,1);
                return communityNewsFlashFra;
            default:
                return new CommunityRecommendFra();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
