package com.example.myexample;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myexample.base.BaseActivity;
import com.example.myexample.bean.User;
import com.example.myexample.event.C;
import com.example.myexample.event.Event;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @Bind(R.id.tv)
    TextView tv;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("这是主页");
        hideBack(true);
        hideMenu(true);


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
        OkGo.<String>post("http://192.168.0.162:8080/cts-web/login")
                .tag(this)
                .params("username", "15628767100")
                .params("password", "abc123")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Toast.makeText(MainActivity.this, "请求成功！", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
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
}
