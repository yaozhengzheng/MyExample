/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myexample.R;
import com.example.myexample.base.BaseFragment;

/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */

public class TestFragment extends BaseFragment {
    @Override
    protected void loadData() {

    }

    @Override
    protected int getContentView() {
        return R.layout.frag_layout;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("这是fragment");
        hideBack(true);
        hideMenu(true);
    }

    /**
     * 重写此方法动态切换menu
     *
     * @param menu
     * @return
     */
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//
//        menu.findItem(R.id.login).setVisible(false);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if (item.getItemId() == R.id.publish) {
//                    Toast.makeText(MainActivity.this, "fabutupian ", Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });
//        return super.onPrepareOptionsMenu(menu);
//    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.login).setVisible(false);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.publish) {
                    Toast.makeText(getActivity(), "fabutupian ", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}
