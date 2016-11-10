package com.youyu.gang.community.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.youyu.gang.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityRecommendFra extends Fragment {


    private Context context;
     CommunityFra targetFragment;
    float y = 0;

    public CommunityRecommendFra() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         Fragment targetFragment = getTargetFragment();
        if (targetFragment!=null){
            this.targetFragment = ((CommunityFra) targetFragment);
        }

        View view = inflater.inflate(R.layout.fragment_community_recommend, container, false);
        ListView viewById = (ListView) view.findViewById(R.id.listView);
        viewById.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        y = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        if (y-motionEvent.getY()<-200){
                            if (CommunityRecommendFra.this.targetFragment!=null){
                                CommunityRecommendFra.this.targetFragment.visibleHeader();
                            }
                        }
                        if (y-motionEvent.getY()>200){
                            if (CommunityRecommendFra.this.targetFragment!=null){
                                CommunityRecommendFra.this.targetFragment.invisibleHeader();
                            }
                        }
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;

                }
                return false;
            }
        });

        viewById.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 30;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                TextView textView = new TextView(context);
                textView.setText("xxxxxxxxxxxx");
                textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,300));
                return textView;
            }
        });
        return view;
    }



}
