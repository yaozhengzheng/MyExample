/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myexample.R;

/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */

public abstract class BaseFragment extends Fragment {

    public View view;

    //导航栏
    public Toolbar toolbar;
    //放置activity的布局
    private FrameLayout viewContent;
    //标题
    private TextView toolBarTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_base, null);

        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        viewContent = (FrameLayout) view.findViewById(R.id.viewContent);
        toolBarTitle = (TextView) view.findViewById(R.id.toolbar_title);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        //隐藏toolbar自身的title
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //需要加上这句话，否则会显示label
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        //设置framelayout中的布局
        LayoutInflater.from(activity).inflate(getContentView(), viewContent);
        init(savedInstanceState);
        loadData();
        return view;
    }

    /**
     * 加载网络数据，初始化布局
     */
    protected abstract void loadData();

    protected abstract int getContentView();

    protected abstract void init(Bundle savedInstanceState);

    /**
     * 设置title
     *
     * @param title
     */
    protected void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            toolBarTitle.setText(title);
        }
    }

    /**
     * 是否显示返回按键
     *
     * @param a
     */
    protected void hideBack(Boolean a) {

        if (a) {
            toolbar.setNavigationIcon(R.mipmap.navigation_back_white);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "返回", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    /**
     * 是否显示menu
     *
     * @param b
     */
    protected void hideMenu(Boolean b) {
        if (b) {
//            toolbar.inflateMenu(R.menu.toolbar_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.publish) {

                    }
                    return false;
                }
            });
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
