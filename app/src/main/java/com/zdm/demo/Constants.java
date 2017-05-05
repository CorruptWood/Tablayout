package com.zdm.demo;

/**
 * Created by zdm on 2017/4/25/0025.
 * 描述：
 */

public interface Constants {

    String[] title={"首页","口碑","朋友","我的"};
    int[]selectIcons={R.mipmap.alipay_pressed,R.mipmap.word_mouth_pressed,
                R.mipmap.friend_pressed,R.mipmap.mine_pressed};
    int[]unSelectIcons={R.mipmap.alipay_narmal,R.mipmap.word_mouth_normal,
            R.mipmap.friend_normal,R.mipmap.mine_normal};

    String[] viewPagerTitle={"全部","待付款","待发货","待收货","退款中","退货中","交易成功","待评价",};

    String[] evaluateTitle={"全部","好评","中评","差评"};
    int[] evaluateSubTitle={90,20,30,40};

    String[] seckillTitle={"已结束","已结束","已结束","抢购中","即将开始"};
    String[] seckillSubTitle={"08:00","10:00","12:00","14:00","16:00"};
    String[] seckillColor={"#e5e5e5","#33f3f3","#33ff66","#ff6633","#667788"};

    String[] otherTitle={"待提交","待审核","已通过","未通过"};
}
