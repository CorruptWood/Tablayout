package com.zdm.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.zdm.tablayout.TabEntity;
import com.zdm.tablayout.TabInterface;
import com.zdm.tablayout.TabLayout;
import com.zdm.tablayout.TabRecylerAdapter;
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
        List<TabEntity> list=new ArrayList<>();
        for (int i = 0; i < Constants.seckillTitle.length; i++) {
            TabEntity entity = new TabEntity(Constants.seckillTitle[i], Constants.seckillSubTitle[i]);
            entity.setTitleSelectColor(Color.parseColor(Constants.seckillColor[i]));
            entity.setTitleUnSelectColor(Color.parseColor(Constants.seckillColor[i]));
            entity.setSubtitleSelectColor(Color.parseColor(Constants.seckillColor[i]));
            entity.setSubtitleUnSelectColor(Color.parseColor(Constants.seckillColor[i]));
            list.add(entity);
        }

        tabLayout4.bindViewData(list);
        tabLayout4.defaultSelected(3);
    }


    private void initTabLayout5() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.title[x], Constants.selectIcons[x],
                    Constants.unSelectIcons[x]));
            fragmentList.add(TabFragment.getTabFragment(x, 1));
        }

        tabLayout5.bindViewData(list);
        tabLayout5.defaultSelected(0);

        //Tablayout的代码执行后会执行此回调的代码
        tabLayout5.addItemBindViewDataListener(new TabInterface.OnItemBindViewDataListener() {
            @Override
            public void OnItemBindViewDataListener(TabRecylerAdapter.ViewHolder holder, TabEntity tabEntity, int selectPosition, int position) {
                if(selectPosition==position)
                Toast.makeText(MainActivity.this,"当前点击的索引是"+selectPosition,Toast.LENGTH_SHORT).show();
            }
        });

        //会覆盖Tablayout的切换按钮代码
//        tabLayout5.setOnItemClickListener(new TabInterface.OnTablayoutItemClickListener() {
//            @Override
//            public void OnItemClickListener(View v, int position, int count) {
//
//            }
//        });
    }

    private void initTabLayout6() {
        final List<TabEntity> list = new ArrayList<>();
        for (int x = 0; x < Constants.title.length; x++) {
            list.add(new TabEntity(Constants.otherTitle[x],Integer.toString(5)));
        }

        tabLayout6.bindViewData(list);
        tabLayout6.defaultSelected(0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                list.clear();
                for (int x = 0; x < Constants.title.length; x++) {
                    list.add(new TabEntity(Constants.otherTitle[x],Integer.toString(2)));
                }

                tabLayout6.bindViewData(list);

            }
        },5000);
    }
}
