package com.bb.tuning.proxy.dynamic.cglib;

import com.bb.tuning.proxy.state.DBQuery;
import com.bb.tuning.proxy.state.IDBQuery;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibDbQueryInterceptor
 * @Description: cglib的动态代理
 * @Author zzy
 * @Date 2020/11/3
 **/
public class CglibDbQueryInterceptor implements MethodInterceptor {
    IDBQuery real = null;

    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createCglibProxy() {
        Enhancer enhancer = new Enhancer();
        //指定切入器，定义代理类逻辑
        enhancer.setCallback(new CglibDbQueryInterceptor());
        //指定实现的接口
        enhancer.setInterfaces(new Class[]{IDBQuery.class});
        //生成代理类的实例
        IDBQuery cglibProxy = (IDBQuery) enhancer.create();
        return cglibProxy;
    }
}
