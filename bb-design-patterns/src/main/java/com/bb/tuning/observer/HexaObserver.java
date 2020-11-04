package com.bb.tuning.observer;

/**
 * @ClassName HexaObserver
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/4
 **/
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
