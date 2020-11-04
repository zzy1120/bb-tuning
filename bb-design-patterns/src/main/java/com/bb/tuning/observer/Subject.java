package com.bb.tuning.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ISubject
 * @Description: 主题接口
 * @Author zzy
 * @Date 2020/11/4
 **/
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
