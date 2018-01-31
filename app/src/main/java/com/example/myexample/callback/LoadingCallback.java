/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.callback;

import android.content.Context;
import android.view.View;

import com.example.myexample.R;
import com.kingja.loadsir.callback.Callback;

/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */

public class LoadingCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_loading;
    }

    @Override
    public boolean getSuccessVisible() {
        return super.getSuccessVisible();
    }

    @Override
    protected boolean onReloadEvent(Context context, View view) {
        return true;
    }
}
