package com.bb.tuning.observer;

/**
 * @ClassName OctalObserver
 * @Description: 进制观察者
 * @Author zzy
 * @Date 2020/11/4
 **/
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
