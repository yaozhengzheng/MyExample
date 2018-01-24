/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myexample.R;
import com.example.myexample.bean.User;
import com.example.myexample.event.C;
import com.example.myexample.event.Event;
import com.example.myexample.event.EventBusUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
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
