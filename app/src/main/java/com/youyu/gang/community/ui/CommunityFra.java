package com.youyu.gang.community.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.youyu.gang.R;
import com.youyu.gang.common.util.AppUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFra extends Fragment implements ViewPager.OnPageChangeListener {


    private ViewPager viewPager;
    private Context context;
    private int screenWidth;
    private View bar;
    int currentIndex=0;

    public CommunityFra() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        screenWidth = AppUtil.getWindowWidth(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_community, container, false);
        viewPager = ((ViewPager) view.findViewById(R.id.communityViewPager));
        bar = view.findViewById(R.id.bar);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager.addOnPageChangeListener(this);
        initTabLineWidth();
    }

    @Override
    public void onPageScrolled(int position, float offset, int positionOffsetPixels) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) bar
                .getLayoutParams();


        if (currentIndex == 0 && position == 0)// 0->1
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4));

        } else if (currentIndex == 1 && position == 0) // 1->0
        {
            lp.leftMargin = (int) (-(1 - offset)
                    * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4));

        } else if (currentIndex == 1 && position == 1) // 1->2
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4));
        } else if (currentIndex == 2 && position == 1) // 2->1
        {
            lp.leftMargin = (int) (-(1 - offset)
                    * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4));
        } else if (currentIndex==2&&position==3)
        {
            lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4));
        } else if (currentIndex==3&&position==2){
            lp.leftMargin = (int) (-(1 - offset)
                    * (screenWidth * 1.0 / 4) + currentIndex
                    * (screenWidth / 4));
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
        lp.width = screenWidth / 4;
        bar.setLayoutParams(lp);
    }
}
