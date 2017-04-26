package com.zdm.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;

import com.zdm.tablayout.TabEntity;
import com.zdm.tablayout.TabInterface;
import com.zdm.tablayout.TabLayout;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AutoLayoutActivity {
    @InjectView(R.id.container)
    FrameLayout container;
    @InjectView(R.id.tabLayout1)
    TabLayout tabLayout1;
    @InjectView(R.id.tabLayout2)
    TabLayout tabLayout2;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);


        initTabLayout1();
        initTabLayout2();


    }

    private void initTabLayout1() {
        List<Fragment> fragmentList=new ArrayList<>();

        List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.title[x], Constants.selectIcons[x],
                    Constants.unSelectIcons[x], Color.parseColor("#1296db"),
                    Color.parseColor("#333333")));
            fragmentList.add(TabFragment.getTabFragment(x,1));
        }
        tabLayout1.bindViewData(list);
        tabLayout1.setOnItemClickListener(new TabInterface.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {

            }
        });
        tabLayout1.bindViewData(list,fragmentList,R.id.container);
        tabLayout1.defaultSelected(0);

    }
    private void initTabLayout2() {
        List<Fragment> fragmentList=new ArrayList<>();
        List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.viewPagerTitle.length; x++) {
            list.add(new TabEntity(Constants.viewPagerTitle[x], R.drawable.line,
                    R.drawable.line, Color.parseColor("#ff6633"),
                    Color.parseColor("#333333")));
            fragmentList.add(TabFragment.getTabFragment(x,2));
        }
        //        tabLayout1.bindViewData(list);
        tabLayout2.bindViewData(list,viewPager,fragmentList);
        tabLayout2.defaultSelected(0);

    }
}
