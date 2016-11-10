package com.youyu.gang.community.ui;


import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.youyu.gang.R;
import com.youyu.gang.common.util.AppUtil;
import com.youyu.gang.community.adapter.CommunityPageAdp;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFra extends Fragment implements ViewPager.OnPageChangeListener {


    private ViewPager viewPager;
    private Context context;
    private int screenWidth;
    private View bar;
    int currentIndex=0;
    private TextView news_flash;
    private TextView recommend;
    private TextView newest;
    private TextView follow;
    private int initMarging;
    private View headView;
    float initViewY=0;

    public CommunityFra() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        screenWidth = AppUtil.getWindowWidth(context)-AppUtil.dpToPx(context,10);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        viewPager = ((ViewPager) view.findViewById(R.id.communityViewPager));
        bar = view.findViewById(R.id.bar);
        recommend = ((TextView) view.findViewById(R.id.recommend));
        newest = ((TextView) view.findViewById(R.id.newest));
        follow = ((TextView) view.findViewById(R.id.follow));
        news_flash = ((TextView) view.findViewById(R.id.news_flash));
        headView = view.findViewById(R.id.headView);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.addOnPageChangeListener(this);
        viewPager.setAdapter(new CommunityPageAdp(getChildFragmentManager(),this));
        initTabLineWidth();
    }

    @Override
    public void onPageScrolled(int position, float offset, int positionOffsetPixels) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) bar
                .getLayoutParams();


        if (currentIndex == 0 && position == 0)// 0->1
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4)+initMarging);

        } else if (currentIndex == 1 && position == 0) // 1->0
        {
            lp.leftMargin = (int) (-(1 - offset)
                    * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4)+initMarging);

        } else if (currentIndex == 1 && position == 1) // 1->2
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4)+initMarging);
        } else if (currentIndex == 2 && position == 1) // 2->1
        {
            lp.leftMargin = (int) (-(1 - offset)
                    * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4)+initMarging);
        } else if (currentIndex==2&&position==2) //2->3
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4)+initMarging);
        } else if (currentIndex==3&&position==2){ //3->2
            lp.leftMargin = (int) (-(1 - offset)
                    * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4)+initMarging);
        }
        bar.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        currentIndex=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initTabLineWidth() {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) bar
                .getLayoutParams();
        lp.width = AppUtil.spTopx(context,32)+10;
        lp.height=AppUtil.dpToPx(context,2);
        initMarging = screenWidth/8-AppUtil.spTopx(context,16)-2;
        lp.leftMargin=initMarging;
        bar.setLayoutParams(lp);
    }

    public void visibleHeader(){
        if (headView.getY()>-headView.getMeasuredHeight()){
            return;
        }
        ObjectAnimator animator=ObjectAnimator.ofFloat(headView,"translationY",-headView.getMeasuredHeight()-initViewY,initViewY);
        animator.setDuration(1000);
        animator.start();

    }
    public void invisibleHeader(){
        if (headView.getY()<0){
            return;
        }
        initViewY=headView.getY();
        ObjectAnimator animator=ObjectAnimator.ofFloat(headView,"translationY",headView.getPivotY(),-headView.getMeasuredHeight()-initViewY);
        animator.setDuration(1000);
        animator.start();
    }

}
