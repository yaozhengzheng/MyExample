/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample;

import android.app.Application;

import com.example.myexample.callback.CustomCallback;
import com.example.myexample.callback.EmptyCallback;
import com.example.myexample.callback.ErrorCallback;
import com.example.myexample.callback.LoadingCallback;
import com.example.myexample.callback.TimeoutCallback;
import com.kingja.loadsir.core.LoadSir;

/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
