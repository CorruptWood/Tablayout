package com.zdm.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;

import com.zdm.tablayout.TabEntity;
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
    @InjectView(R.id.tabLayout3)
    TabLayout tabLayout3;
    @InjectView(R.id.tabLayout4)
    TabLayout tabLayout4;
    @InjectView(R.id.tabLayout5)
    TabLayout tabLayout5;
    @InjectView(R.id.tabLayout6)
    TabLayout tabLayout6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initTabLayout1();
        initTabLayout2();
        initTabLayout3();
        initTabLayout4();
        initTabLayout5();
        initTabLayout6();
    }

    /**
     * 关联Fragment
     */
    private void initTabLayout1() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.title[x], Constants.selectIcons[x],
                    Constants.unSelectIcons[x]));
            fragmentList.add(TabFragment.getTabFragment(x, 1));
        }

        tabLayout1.bindViewData(list, fragmentList, R.id.container);
        tabLayout1.defaultSelected(0);

    }

    /**
     * 关联viewPager ==>viewPager关联的fragment不能使用单例模式
     */
    private void initTabLayout2() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.viewPagerTitle.length; x++) {
            list.add(new TabEntity(Constants.viewPagerTitle[x]));
            fragmentList.add(TabFragment.getTabFragment(x, 2));
        }
        tabLayout2.bindViewData(list, viewPager, fragmentList);
        tabLayout2.defaultSelected(1);
    }

    /**
     * 两个标题样式
     */
    private void initTabLayout3() {
        List<TabEntity> list=new ArrayList<>();
        for (int i = 0; i < Constants.evaluateTitle.length; i++) {
            list.add(new TabEntity(Constants.evaluateTitle[i],Integer.toString(Constants.evaluateSubTitle[i])));
        }

        tabLayout3.bindViewData(list);
        tabLayout3.defaultSelected(2);
    }

    /**
     * 两个标题样式  切换字体大小
     */
    private void initTabLayout4() {

    }


    private void initTabLayout5() {

    }

    private void initTabLayout6() {

    }
}
