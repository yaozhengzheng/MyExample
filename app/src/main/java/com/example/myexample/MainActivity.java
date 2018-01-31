package com.example.myexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myexample.base.BaseActivity;
import com.example.myexample.bean.User;
import com.example.myexample.callback.LoadingCallback;
import com.example.myexample.event.C;
import com.example.myexample.event.Event;
import com.example.myexample.ui.activity.EmptyActivity;
import com.example.myexample.ui.activity.SecondActivity;
import com.example.myexample.utils.PostUtil;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("这是主页");
        hideBack(false);
        hideMenu(true);
        empty(false);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected void onNetReload(View v) {
    }

    /**
     * 重写此方法动态切换menu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.login).setVisible(false);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.publish) {
                    Toast.makeText(MainActivity.this, "fabutupian ", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void loadData() {

    }


    @Override
    protected boolean isRegisterEventBus() {
        return true;
    }

    @Override
    protected void receiveEvent(Event event) {
        //接收到event后的处理逻辑
        switch (event.getCode()) {
            case C.EventCode.C:
                Log.d("EventBus", "接收到B类型的Event，携带User");
                User user = (User) event.getData();
                Log.e("EventBus", user.getName());
                break;
            case C.EventCode.A:
                Log.d("EventBus", "接收到A类型的Event");
                break;
        }
    }

    @OnClick({R.id.tv, R.id.tv_frag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            case R.id.tv_frag:
                startActivity(new Intent(MainActivity.this, EmptyActivity.class));
                break;
        }
    }
}
