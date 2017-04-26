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
    private boolean isShowLine;
    private int lineSelectColor;
    private int lineUnSelectColor;

    public void setOnItemClickListener(TabInterface.OnItemClickListener listener) {
        this.listener = listener;
    }

    public TabRecylerAdapter(Context mContext, int resId, boolean isShowLine,int lineSelectColor,int lineUnSelectColor) {
        this.mContext = mContext;
        this.resId = resId;
        this.isShowLine = isShowLine;
        this.lineSelectColor=lineSelectColor;
        this.lineUnSelectColor=lineUnSelectColor;
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

        private TextView textView;
        private ImageView image;
        private View line;

        public ViewHolder(View itemView) {
            super(itemView);
            AutoUtils.auto(itemView);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.text);
            image = (ImageView) itemView.findViewById(R.id.image);
            line = itemView.findViewById(R.id.line1);
        }

        public void bindViewHolderData(int position) {
            TabEntity tabEntity = list.get(position);

            if (isShowLine) {
                if (line != null)
                    line.setVisibility(View.VISIBLE);
            } else {
                if (line != null)
                    line.setVisibility(View.GONE);
            }

            if (selectPosition == position) {
                if (textView != null)
                    textView.setTextColor(tabEntity.getSelectColor());
                if (image != null)
                    image.setImageResource(tabEntity.getSelectimgResId());
                if (line != null)
                    line.setBackgroundColor(lineSelectColor);
            } else {
                if (textView != null)
                    textView.setTextColor(tabEntity.getUnSelectColor());
                if (image != null)
                    image.setImageResource(tabEntity.getUnSelectimgResId());
                if (line != null)
                    line.setBackgroundColor(lineUnSelectColor);
            }
            if (textView != null)
                textView.setText(tabEntity.getTitle());
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.OnItemClickListener(v, getAdapterPosition());
            }
        }
    }
}
