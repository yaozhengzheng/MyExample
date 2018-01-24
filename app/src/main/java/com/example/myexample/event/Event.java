/*
 * author：姚政诤
 * description：
 * GitHub：https://github.com/yaozhengzheng
 */

package com.example.myexample.event;

/**
 * description:.这是一个事件总线的类，类似于bean.事件，EventBus订阅发布,可以添加具体的bean类
 * author https://github.com/yaozhengzheng.
 */

public class Event<T> {
    private int code;
    private T data;

    public Event(int code) {
        this.code = code;
    }

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
