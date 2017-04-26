package com.zdm.tablayout;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * ......................我佛慈悲....................
 * ......................_oo0oo_.....................
 * .....................o8888888o....................
 * .....................88" . "88....................
 * .....................(| -_- |)....................
 * .....................0\  =  /0....................
 * ...................___/`---'\___..................
 * ..................' \\|     |// '.................
 * ................./ \\|||  :  |||// \..............
 * .............../ _||||| -卍-|||||- \..............
 * ..............|   | \\\  -  /// |   |.............
 * ..............| \_|  ''\---/''  |_/ |.............
 * ..............\  .-\__  '-'  ___/-. /.............
 * ............___'. .'  /--.--\  `. .'___...........
 * .........."" '<  `.___\_<|>_/___.' >' ""..........
 * ........| | :  `- \`.;`\ _ /`;.`/ - ` : | |.......
 * ........\  \ `_.   \_ __\ /__ _/   .-` /  /.......
 * ....=====`-.____`.___ \_____/___.-`___.-'=====....
 * ......................`=---='.....................
 * <p>
 * ..................佛祖开光 ,永无BUG................
 * <p>
 * <p>
 * <p>
 * Created by zdm on 2017/4/25/0025.
 * <p>
 * 描述:
 */

public class TabLayout extends LinearLayout {

    private int tabResId;
    private int tabCount;
    private boolean isScroll;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private TabRecylerAdapter tabAdapter;
    private List<Fragment> fragmentList;
    private Fragment fragment;
    private
    @IdRes
    int containerViewId;
    private ViewPager viewPager;
    private TabViewPagerAdapter pagerAdapter;
    private int lineSelectColor;
    private int lineUnSelectColor;
    private boolean isShowLine;
    private int offset = 50;
    private TabInterface.OnItemClickListener itemClickListener;
    private TabInterface.OnPageChangeListener onPageChangeListener;
    private TabInterface.OnPageSelectedListener onPageSelectedListener;


    public void setOnItemClickListener(TabInterface.OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setOnPageChangeListener(TabInterface.OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }

    public void setOnPageSelectedListener(TabInterface.OnPageSelectedListener onPageSelectedListener) {
        this.onPageSelectedListener = onPageSelectedListener;
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TabLayout);

        tabResId = typedArray.getResourceId(R.styleable.TabLayout_tabResId, -1);

        tabCount = typedArray.getInt(R.styleable.TabLayout_tabCount, -1);

        isScroll = typedArray.getBoolean(R.styleable.TabLayout_isScroll, false);

        isShowLine = typedArray.getBoolean(R.styleable.TabLayout_isShowLine, false);

        lineSelectColor = typedArray.getColor(R.styleable.TabLayout_lineSelectColor, Color.parseColor("#ffffff"));

        lineUnSelectColor = typedArray.getColor(R.styleable.TabLayout_lineUnSelectColor, Color.parseColor("#ffffff"));

        typedArray.recycle();

        if (tabResId == -1) {
            throw (new NullPointerException("tabResId资源未发现"));
        }

        if (tabCount == -1) {
            throw (new IndexOutOfBoundsException("tabCount的数量不能小于0"));
        }

        mRecycler = new RecyclerView(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRecycler.setLayoutParams(params);
        addView(mRecycler);

        if (isScroll) {
            layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        } else {
            layoutManager = new GridLayoutManager(context, tabCount);
        }
        mRecycler.setLayoutManager(layoutManager);

        tabAdapter = new TabRecylerAdapter(context, tabResId, isShowLine, lineSelectColor, lineUnSelectColor);
        mRecycler.setAdapter(tabAdapter);
        //移除更新动画
        ((SimpleItemAnimator) mRecycler.getItemAnimator()).setSupportsChangeAnimations(false);

        tabAdapter.setOnItemClickListener(new TabInterface.OnItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {
                tabAdapter.selectPosition(position);
                //自定义fragment切换
                if (itemClickListener != null) {
                    itemClickListener.OnItemClickListener(v, position);
                } else if (viewPager == null) {
                    relationFragment(position);
                } else {
                    viewPager.setCurrentItem(position);
                }
            }
        });
    }

    //关联ViewPager
    private void relationViewPager() {
        if (viewPager == null)
            return;
        FragmentManager fm = ((AppCompatActivity) getContext())
                .getSupportFragmentManager();
        pagerAdapter = new TabViewPagerAdapter(fm, fragmentList);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(position);
                } else {
                    if (layoutManager instanceof LinearLayoutManager) {
                        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(position, offset);
//                    } else if (layoutManager instanceof GridLayoutManager) {
//                        ((GridLayoutManager) layoutManager).scrollToPositionWithOffset(position, offset);
                    }
                    tabAdapter.selectPosition(position);

                    if(onPageSelectedListener!=null){
                        onPageSelectedListener.onPageSelected(position);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(state);
                }
            }
        });
    }

    //关联fragment
    private void relationFragment(int position) {
        if (fragmentList == null || fragmentList.isEmpty())
            return;

        addShowHideFragment(fragmentList.get(position));
    }

    Fragment currentFragment;
    List<Fragment> hasAddedFragment = new ArrayList<>();

    private void addShowHideFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) getContext())
                .getSupportFragmentManager().beginTransaction();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }
        if (hasAddedFragment.contains(fragment)) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(containerViewId, fragment);
            hasAddedFragment.add(fragment);
        }
        fragmentTransaction.commit();
        currentFragment = fragment;
    }

    /**
     * 不绑定fragment viewpager
     *
     * @param list
     */
    public void bindViewData(List<TabEntity> list) {
        tabAdapter.setList(list);
    }

    /**
     * 绑定fragment
     *
     * @param list
     * @param fragmentList
     * @param containerViewId
     */
    public void bindViewData(List<TabEntity> list, List<Fragment> fragmentList, @IdRes int containerViewId) {
        bindViewData(list);
        this.fragmentList = fragmentList;
        this.containerViewId = containerViewId;
    }

    /**
     * 绑定viewPager
     *
     * @param list
     * @param viewPager
     * @param fragmentList
     */
    public void bindViewData(List<TabEntity> list, ViewPager viewPager, List<Fragment> fragmentList) {
        bindViewData(list);
        this.viewPager = viewPager;
        this.fragmentList = fragmentList;
    }

    /**
     * 设置默认选中
     *
     * @param position
     */
    public void defaultSelected(int position) {
        tabAdapter.selectPosition(position);
        if (viewPager == null)
            relationFragment(position);
        else
            relationViewPager();
    }

    /**
     * 设置默认选中，并且设置tabLayout滑动的偏移量
     *
     * @param position
     * @param offset
     */
    public void defaultSelected(int position, int offset) {
        defaultSelected(position);
        this.offset = offset;
    }


}
