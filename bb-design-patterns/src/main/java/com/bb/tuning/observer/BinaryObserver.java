package com.bb.tuning.observer;

/**
 * @ClassName BinaryObserver
 * @Description: 实体观察者
 * @Author zzy
 * @Date 2020/11/4
 **/
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Binary String:" + Integer.toBinaryString(subject.getState()));
    }
}
