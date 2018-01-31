/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.callback;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.myexample.R;
import com.kingja.loadsir.callback.Callback;


/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */

public class TimeoutCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_timeout;
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        Toast.makeText(context.getApplicationContext(),"Connecting to the network again!",Toast.LENGTH_SHORT).show();
        return false;
    }

}
