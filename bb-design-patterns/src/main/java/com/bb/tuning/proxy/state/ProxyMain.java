package com.bb.tuning.proxy.state;

import static com.bb.tuning.proxy.dynamic.cglib.CglibDbQueryInterceptor.createCglibProxy;
import static com.bb.tuning.proxy.dynamic.javassist.JavassistDynDbQueryHandler.createJavassistBytecodeDynamicProxy;
import static com.bb.tuning.proxy.dynamic.javassist.JavassistDynDbQueryHandler.createJavassistDynProxy;
import static com.bb.tuning.proxy.dynamic.jdk.JdkDbQueryHandler.createJdkProxy;

/**
 * @ClassName Main
 * @Description: 将代理模式用于实现延迟加载，可以有效的提升系统的启动速度，对改善用户体验有很大帮助
 * @Author zzy
 * @Date 2020/11/3
 **/
public class ProxyMain {

    public static final int CIRCLE = 30000000;

    public static void main(String[] args) throws Exception {
        IDBQuery d = null;
        long start = System.currentTimeMillis();
        d = createJdkProxy();
        System.out.println("createJdkProxy:" + (System.currentTimeMillis() - start));
        System.out.println("JdkProxy class:" + d.getClass().getName());
        start = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("classJdkProxy:" + (System.currentTimeMillis() - start));

        //测试CGLIB动态代理
        start = System.currentTimeMillis();
        d = createCglibProxy();
        System.out.println("createCglibProxy:" + (System.currentTimeMillis() - start));
        System.out.println("CglibProxy class:" + d.getClass().getName());
        start = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("classCglibProxy:" + (System.currentTimeMillis() - start));

        //测试Javaassist动态代理
        start = System.currentTimeMillis();
        d = createJavassistDynProxy();
        System.out.println("createJavassistDynProxy:" + (System.currentTimeMillis() - start));
        System.out.println("JavassistDynProxy class:" + d.getClass().getName());
        start = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("callJavassistDynProxy:" + (System.currentTimeMillis() - start));

        //测试Javaassist动态代理
        start = System.currentTimeMillis();
        d = createJavassistBytecodeDynamicProxy();
        System.out.println("createJavassistBytecodeDynamicProxy:" + (System.currentTimeMillis() - start));
        System.out.println("JavassistBytecodeDynamicProxy class:" + d.getClass().getName());
        start = System.currentTimeMillis();
        for (int i = 0; i < CIRCLE; i++) {
            d.request();
        }
        System.out.println("callJavassistBytecodeDynamicProxy:" + (System.currentTimeMillis() - start));

    }

}
