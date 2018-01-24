/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.event;

import org.greenrobot.eventbus.EventBus;

/**
 * description:.将EventBus封装一层，方便管理，不多比比
 * author https://github.com/yaozhengzheng.
 */
public class EventBusUtil {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

    // 其他
}
