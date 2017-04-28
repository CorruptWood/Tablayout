package com.zdm.tablayout;

import android.support.annotation.ColorInt;
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
    private int selectimgResId;
    private int unSelectimgResId;
    @ColorInt
    private int lineSelectColor;
    @ColorInt
    private int lineUnSelectColor;
    @ColorInt
    private int titleSelectColor;
    @ColorInt
    private int titleUnSelectColor;
    @ColorInt
    private int subtitleSelectColor;
    @ColorInt
    private int subtitleUnSelectColor;

    public TabEntity() {
    }

    public TabEntity(String title) {
        this.title = title;
    }

    public TabEntity(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public TabEntity(String title, @DrawableRes int selectimgResId, @DrawableRes int unSelectimgResId) {
        this.title = title;
        this.selectimgResId = selectimgResId;
        this.unSelectimgResId = unSelectimgResId;
    }

    public TabEntity(String title, String subTitle, @DrawableRes int selectimgResId, @DrawableRes int unSelectimgResId) {
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

    public void setSelectimgResId(@DrawableRes int selectimgResId) {
        this.selectimgResId = selectimgResId;
    }

    public int getUnSelectimgResId() {
        return unSelectimgResId;
    }

    public void setUnSelectimgResId(@DrawableRes int unSelectimgResId) {
        this.unSelectimgResId = unSelectimgResId;
    }

    @ColorInt
    public int getLineSelectColor() {
        return lineSelectColor;
    }

    public void setLineSelectColor(@ColorInt int lineSelectColor) {
        this.lineSelectColor = lineSelectColor;
    }

    @ColorInt
    public int getLineUnSelectColor() {
        return lineUnSelectColor;
    }

    public void setLineUnSelectColor(@ColorInt int lineUnSelectColor) {
        this.lineUnSelectColor = lineUnSelectColor;
    }

    @ColorInt
    public int getTitleSelectColor() {
        return titleSelectColor;
    }

    public void setTitleSelectColor(@ColorInt int titleSelectColor) {
        this.titleSelectColor = titleSelectColor;
    }

    @ColorInt
    public int getTitleUnSelectColor() {
        return titleUnSelectColor;
    }

    public void setTitleUnSelectColor(@ColorInt int titleUnSelectColor) {
        this.titleUnSelectColor = titleUnSelectColor;
    }

    @ColorInt
    public int getSubtitleSelectColor() {
        return subtitleSelectColor;
    }

    public void setSubtitleSelectColor(@ColorInt int subtitleSelectColor) {
        this.subtitleSelectColor = subtitleSelectColor;
    }

    @ColorInt
    public int getSubtitleUnSelectColor() {
        return subtitleUnSelectColor;
    }

    public void setSubtitleUnSelectColor(@ColorInt int subtitleUnSelectColor) {
        this.subtitleUnSelectColor = subtitleUnSelectColor;
    }
}
