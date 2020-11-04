package com.bb.tuning.observer;

/**
 * @ClassName IObserver
 * @Description: 观察者接口
 * @Author zzy
 * @Date 2020/11/4
 **/
public abstract class Observer {
    protected Subject subject;

    protected abstract void update();
}
