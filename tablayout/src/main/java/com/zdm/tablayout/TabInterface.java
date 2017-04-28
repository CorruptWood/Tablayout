package com.zdm.tablayout;

import android.view.View;

/**
 * Created by zdm on 2017/4/25/0025.
 * 描述：
 */

public class TabInterface {

    public interface OnItemClickListener {
        void OnItemClickListener(View v, int position);
    }

    public interface OnItemBindViewDataListener {
        void OnItemBindViewDataListener(TabRecylerAdapter.ViewHolder holder,TabEntity tabEntity, int selectPosition, int position);
    }

    /**
     * 会覆盖TabLayout的方法 需要自己实现切换效果
     */
    public interface OnTablayoutItemClickListener {
        void OnItemClickListener(View v, int position, int count);
    }

    /**
     * 实现ViewPager的OnPageChangeListener 会覆盖TabLayout的方法
     */
    public interface OnPageChangeListener {

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        public void onPageSelected(int position);

        public void onPageScrollStateChanged(int state);
    }

    /**
     * 实现ViewPager的OnPageChangeListener中的onPageSelected   不会覆盖TabLayout的方法
     */
    public interface OnPageSelectedListener {

        public void onPageSelected(int position);
    }
}

