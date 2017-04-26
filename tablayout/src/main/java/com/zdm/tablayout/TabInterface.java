package com.zdm.tablayout;

import android.view.View;

/**
 * Created by zdm on 2017/4/25/0025.
 * 描述：
 */

public class TabInterface {

    /**
     * 会覆盖TabLayout的方法 需要自己实现切换效果
     */
    public interface OnItemClickListener {
        void OnItemClickListener(View v, int position);
    }

    /**
     * 实现ViewPager的OnPageChangeListener 会覆盖TabLayout的方法
     */
    public interface OnPageChangeListener{

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        public void onPageSelected(int position);

        public void onPageScrollStateChanged(int state);
    }

    /**
     * 实现ViewPager的OnPageChangeListener中的onPageSelected   不会覆盖TabLayout的方法
     */
    public interface OnPageSelectedListener{

        public void onPageSelected(int position);
    }
}

