package com.xiazihao.android.taobao.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiazihao.android.taobao.R;

/**
 * Created by xiazihao on 2017/1/7.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context mContext;
    private static final int viewType0 = 0;
    private static final int viewType1 = 1;
    private static final int viewType2 = 2;
    private static final int viewType3 = 3;
    private static final int viewType4 = 4;
    private static final int viewType5 = 5;
    private static final int viewType6 = 6;
    private static final int viewTypeNomal = 10;

    public RecyclerViewAdapter(Context context) {
        mContext = context;
    }

    private View mView0;
    private View mView1;
    private View mView2;
    private View mView3;
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        switch (viewType){
            case viewType0:
                if(mView0 == null){
                    mView0 = inflater.inflate(R.layout.top_fly_banner_recycler_view_item,parent,false);
                }
                return new FlyBannerHolder(mView0);
            case viewType1:
                if(mView1 == null){
                    mView1 = inflater.inflate(R.layout.grid_menu_recycler_view_item,parent,false);
                }
                return new GridMenuHolder(mView1);
            case viewType2:
                if(mView2 == null){
                    mView2 = inflater.inflate(R.layout.head_line_recycler_view_item,parent,false);
                }
                return new HeadLineHolder(mView2);
            case viewType3:
                if(mView3 == null){
                    mView3 = inflater.inflate(R.layout.snapup_recycler_view_item,parent,false);
                }
                return new SnapUpHolder(mView3);
        }
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
       int viewType = getItemViewType(position);
        switch (viewType){
            case viewType0:
                break;
            case viewType1:
                break;
            case viewType2:
                break;
            case viewType3:
                break;
            case viewType4:
                break;
            case viewType5:
                break;
            case viewType6:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position <= viewType6){
            return position;
        }
        return viewTypeNomal;
//        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return 6;
    }
}

class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
//        mTextView = (TextView) itemView;
    }
}
class GridMenuHolder extends RecyclerViewHolder{

    public GridMenuHolder(View itemView) {
        super(itemView);
    }
}
class HeadLineHolder extends RecyclerViewHolder{

    public HeadLineHolder(View itemView) {
        super(itemView);
    }
}
class SnapUpHolder extends RecyclerViewHolder{

    public SnapUpHolder(View itemView) {
        super(itemView);
    }
}
class FlyBannerHolder extends RecyclerViewHolder{

    public FlyBannerHolder(View itemView) {
        super(itemView);
    }
}
