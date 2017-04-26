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
    private @DrawableRes int selectimgResId;
    private @DrawableRes int unSelectimgResId;
    private int selectColor;
    private int unSelectColor;
    private int lineSelectColor;
    private int lineUnSelectColor;
//    private boolean isAdd;

    public TabEntity() {
    }

    public TabEntity(String title, @DrawableRes int selectimgResId,@DrawableRes int unSelectimgResId,
                     int selectColor, int unSelectColor) {
        this.title = title;
        this.selectimgResId = selectimgResId;
        this.unSelectimgResId = unSelectimgResId;
        this.selectColor = selectColor;
        this.unSelectColor = unSelectColor;
//        isAdd=true;
    }

//    public TabEntity(String title, int selectimgResId, int unSelectimgResId, int selectColor,
//                     int unSelectColor, int lineSelectColor, int lineUnSelectColor) {
//        this.title = title;
//        this.selectimgResId = selectimgResId;
//        this.unSelectimgResId = unSelectimgResId;
//        this.selectColor = selectColor;
//        this.unSelectColor = unSelectColor;
//        this.lineSelectColor = lineSelectColor;
//        this.lineUnSelectColor = lineUnSelectColor;
//        isAdd=false;
//    }

//    public boolean isAdd() {
//        return isAdd;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getSelectColor() {
        return selectColor;
    }

    public void setSelectColor(int selectColor) {
        this.selectColor = selectColor;
    }

    public int getUnSelectColor() {
        return unSelectColor;
    }

    public void setUnSelectColor(int unSelectColor) {
        this.unSelectColor = unSelectColor;
    }

    public int getLineSelectColor() {
        return lineSelectColor;
    }

    public void setLineSelectColor(int lineSelectColor) {
        this.lineSelectColor = lineSelectColor;
    }

    public int getLineUnSelectColor() {
        return lineUnSelectColor;
    }

    public void setLineUnSelectColor(int unlineSelectColor) {
        this.lineUnSelectColor = unlineSelectColor;
    }
}
