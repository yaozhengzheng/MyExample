/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.example.myexample.R;
import com.example.myexample.base.BaseActivity;
import com.example.myexample.bean.User;
import com.example.myexample.event.C;
import com.example.myexample.event.Event;
import com.example.myexample.event.EventBusUtil;

import butterknife.OnClick;

/**
 * EventBus测试activity
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void loadData() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_second;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("EventBus");
        hideBack(true);
        hideMenu(false);
    }

    @Override
    protected void initNet() {

    }

    @Override
    protected void onNetReload(View v) {

    }

    @OnClick({R.id.btn_send, R.id.btn_sendModel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_send:
                EventBusUtil.sendEvent(new Event(C.EventCode.A));
                break;
            case R.id.btn_sendModel:
                Event<User> event = new Event<>(C.EventCode.C, new User());
                User user = new User();
                user.setName("jimao");
                event.setData(user);
                EventBusUtil.sendEvent(event);
                break;
        }
    }
}
