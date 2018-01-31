/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myexample.MainActivity;
import com.example.myexample.R;
import com.example.myexample.base.BaseActivity;
import com.example.myexample.callback.EmptyCallback;
import com.example.myexample.callback.LoadingCallback;
import com.example.myexample.utils.PostUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class EmptyActivity extends BaseActivity {

    @Override
    protected void loadData() {
        OkGo.<String>post("http://192.168.0.162:8080/cts-web/login")
                .tag(this)
                .params("username", "15628767100")
                .params("password", "abc123")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        empty(true);
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }
                });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_empty;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("Empty页面");
        hideBack(true);
        hideMenu(false);

    }

    @Override
    protected void initNet() {
        PostUtil.postCallbackDelayed(loadService, EmptyCallback.class);
    }

    @Override
    protected void onNetReload(View v) {
        loadService.showCallback(LoadingCallback.class);
        PostUtil.postSuccessDelayed(loadService);
    }
}
