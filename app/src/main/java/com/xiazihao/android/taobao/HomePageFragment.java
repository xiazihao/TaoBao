package com.xiazihao.android.taobao;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiazihao.android.taobao.MainActivity;
import com.xiazihao.android.taobao.R;
import com.xiazihao.android.taobao.view.CombineButton;
import com.xiazihao.android.taobao.view.RecyclerViewAdapter;

/**
 * Created by xiazihao on 2017/1/8.
 */

public class HomePageFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mRefreshLayout;
    private CombineButton mMessageCombineButton;
    private CombineButton mScanCombineButton;

    public static HomePageFragment newInstance(){
        return new HomePageFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else if (position == 1) {
                    return 2;
                } else if (position == 2) {
                    return 2;
                } else if (position == 3) {
                    return 2;
                } else if (position == 4) {
                    return 2;
                } else if (position == 5) {
                    return 2;
                } else if (position == 6) {
                    return 2;
                } else {
                    return 1;
                }
            }

        });
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(new RecyclerViewAdapter(getActivity()));

        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"Refreshing",Toast.LENGTH_SHORT).show();
                mRefreshLayout.setRefreshing(false);
            }
        });

        mMessageCombineButton = (CombineButton) view.findViewById(R.id.message_combine_button);

        mScanCombineButton = (CombineButton)view.findViewById(R.id.scan_combine_button);
        return view;
    }
}
