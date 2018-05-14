package com.example.kila.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context mContext = this;
    ImageButton mTabCenter;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    private String[] mTitles = {
            "首页",
            "消息",
            "",
            "联系人",
            "更多"
    };
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect,
            R.mipmap.tab_speech_unselect,
            R.mipmap.dot,
            R.mipmap.tab_contact_unselect,
            R.mipmap.tab_more_unselect
    };
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select,
            R.mipmap.tab_speech_select,
            R.mipmap.dot,
            R.mipmap.tab_contact_select,
            R.mipmap.tab_more_select
    };
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private CommonTabLayout mTabLayout_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragments.add(SimpleCardFragment.getInstance("Switch Fragment 0"));
        mFragments.add(SimpleCardFragment.getInstance("Switch Fragment 1"));
        mFragments.add(new Fragment());
        mFragments.add(SimpleCardFragment.getInstance("Switch Fragment 3"));
        mFragments.add(SimpleCardFragment.getInstance("Switch Fragment 4"));


        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }

        /** with Fragments */
        mTabLayout_3 = findViewById(R.id.tl_3);

        mTabLayout_3.setSpecialTab(2);

        mTabLayout_3.setTabData(mTabEntities, this, R.id.fl_change, mFragments);

        mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                // 这里是FlycoTabLayout的tab点击事件
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        mTabLayout_3.setCurrentTab(3);

        // 显示未读红点
        mTabLayout_3.showDot(1);


        // 中间凸起按钮部分
        mTabCenter = findViewById(R.id.tab_main_center);
        mTabCenter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, "中间凸起按钮点击了", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
