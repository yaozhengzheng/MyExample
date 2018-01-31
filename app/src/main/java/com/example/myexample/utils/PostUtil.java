/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.utils;

import android.os.Handler;
import android.os.Looper;

import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;

/**
 * description:.
 * author https://github.com/yaozhengzheng.
 */
public class PostUtil {
    private static final int DELAY_TIME = 1000;

    public static void postCallbackDelayed(final LoadService loadService, final Class<? extends Callback> clazz) {
        postCallbackDelayed(loadService, clazz, DELAY_TIME);
    }

    public static void postCallbackDelayed(final LoadService loadService, final Class<? extends Callback> clazz, long
            delay) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                loadService.showCallback(clazz);
            }
        }, delay);
    }

    public static void postSuccessDelayed(final LoadService loadService) {
        postSuccessDelayed(loadService, DELAY_TIME);
    }

    public static void postSuccessDelayed(final LoadService loadService, long delay) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                loadService.showSuccess();
            }
        }, delay);
    }
}
