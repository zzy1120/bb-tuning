package com.bb.tuning.proxy.dynamic.jdk;

import com.bb.tuning.proxy.state.DBQuery;
import com.bb.tuning.proxy.state.IDBQuery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkDbQueryHandler
 * @Description: JDK动态代理
 * @Author zzy
 * @Date 2020/11/3
 **/
public class JdkDbQueryHandler implements InvocationHandler {
    //主题接口
    IDBQuery real = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (real == null) {
            //如果是第一次调用，则生成真实对象
            real = (IDBQuery) new DBQuery();
        }
        //使用真实主题完成实际的操作
        return real.request();
    }

    public static IDBQuery createJdkProxy() {
        IDBQuery jdkProxy = (IDBQuery) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{IDBQuery.class}
                , new JdkDbQueryHandler());
        return jdkProxy;
    }
}
