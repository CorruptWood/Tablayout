package com.zdm.tablayout;

import android.support.annotation.DrawableRes;

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

public class TabEntity {
    private String title;
    private String subTitle;
    private @DrawableRes int selectimgResId;
    private @DrawableRes int unSelectimgResId;

    public TabEntity() {
    }

    public TabEntity(String title) {
        this.title = title;
    }

    public TabEntity(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public TabEntity(String title, int selectimgResId, int unSelectimgResId) {
        this.title = title;
        this.selectimgResId = selectimgResId;
        this.unSelectimgResId = unSelectimgResId;
    }

    public TabEntity(String title, String subTitle, int selectimgResId, int unSelectimgResId) {
        this.title = title;
        this.subTitle = subTitle;
        this.selectimgResId = selectimgResId;
        this.unSelectimgResId = unSelectimgResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getSelectimgResId() {
        return selectimgResId;
    }

    public void setSelectimgResId(int selectimgResId) {
        this.selectimgResId = selectimgResId;
    }

    public int getUnSelectimgResId() {
        return unSelectimgResId;
    }

    public void setUnSelectimgResId(int unSelectimgResId) {
        this.unSelectimgResId = unSelectimgResId;
    }
}
