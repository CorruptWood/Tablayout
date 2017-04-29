package com.zdm.tablayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhy.autolayout.utils.AutoUtils;

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

public class TabRecylerAdapter extends RecyclerView.Adapter<TabRecylerAdapter.ViewHolder> {
    private Context mContext;
    private int resId;
//    private int tabCount;
    private List<TabEntity> list;
    private int selectPosition = -1;
    private TabInterface.OnItemClickListener listener;
    private TabInterface.OnItemBindViewDataListener bindlistener;

    public void setOnItemBindViewDataListener(TabInterface.OnItemBindViewDataListener bindlistener) {
        this.bindlistener = bindlistener;
    }

    public void setOnItemClickListener(TabInterface.OnItemClickListener listener) {
        this.listener = listener;
    }

    public TabRecylerAdapter(Context context,int tabResId) {
        this.mContext =context;
        this.resId = tabResId;
//        this.tabCount = tabCount;
    }

    public void setList(List<TabEntity> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void selectPosition(int position) {
        this.selectPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(resId, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindViewHolderData(position);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView title;
        protected TextView subtitle;
        protected ImageView image;
        protected View line;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.tablayout_title);
            subtitle = (TextView) itemView.findViewById(R.id.tablayout_subtitle);
            image = (ImageView) itemView.findViewById(R.id.tablayout_image);
            line = itemView.findViewById(R.id.tablayout_line);
        }

        public void bindViewHolderData(int position) {
            TabEntity tabEntity = list.get(position);
            if(bindlistener!=null){
                bindlistener.OnItemBindViewDataListener(this,tabEntity,selectPosition,position);
            }
//            if(title!=null) AutoUtils.auto(title);
//            if(subtitle!=null) AutoUtils.auto(subtitle);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.OnItemClickListener(v, getAdapterPosition());
            }
        }
    }
}
