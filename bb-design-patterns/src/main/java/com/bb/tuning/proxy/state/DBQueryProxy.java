package com.bb.tuning.proxy.state;

/**
 * @ClassName DBQueryProxy
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/3
 **/
public class DBQueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        //真正需要的时候，才创建真实对象，创建过程可能很慢
        if (real == null) {
            real = new DBQuery();
        }
        //在多线程环境下，这里返回一个虚假类，类似于Future模式
        return real.request();
    }
}
