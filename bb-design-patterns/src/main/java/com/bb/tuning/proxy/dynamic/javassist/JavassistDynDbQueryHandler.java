package com.bb.tuning.proxy.dynamic.javassist;


import com.bb.tuning.proxy.state.DBQuery;
import com.bb.tuning.proxy.state.IDBQuery;
import javassist.*;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

import java.lang.reflect.Method;

/**
 * @ClassName JavassistDynDbQueryHandler
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/3
 **/
public class JavassistDynDbQueryHandler implements MethodHandler {
    IDBQuery real = null;

    @Override
    public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
        if (real == null) {
            real = new DBQuery();
        }
        return real.request();
    }

    public static IDBQuery createJavassistDynProxy() throws IllegalAccessException, InstantiationException {
        ProxyFactory proxyFactory = new ProxyFactory();
        //指定接口
        proxyFactory.setInterfaces(new Class[]{IDBQuery.class});
        Class proxyClass = proxyFactory.createClass();
        IDBQuery javassistProxy = (IDBQuery) proxyClass.newInstance();
        //设置handler处理器
        ((ProxyObject) javassistProxy).setHandler(new JavassistDynDbQueryHandler());
        return javassistProxy;
    }

    public static IDBQuery createJavassistBytecodeDynamicProxy() throws Exception {
        ClassPool classPool = new ClassPool(true);
        //定义类名
        CtClass ctClass = classPool.makeClass(IDBQuery.class.getName() + "Javaassist-BytecodeProxy");
        //需要实现的接口
        ctClass.addInterface(classPool.get(IDBQuery.class.getName()));
        //添加构造函数
        ctClass.addConstructor(CtNewConstructor.defaultConstructor(ctClass));
        //添加类的字段信息，使用动态java代码
        ctClass.addField(CtField.make("public " + IDBQuery.class.getName() + " real;", ctClass));
        String dbqueryname = DBQuery.class.getName();
        //添加方法，这里使用动态java代码指定内部逻辑
        ctClass.addMethod(CtNewMethod.make("public String request() { if(real==null){real=new " + dbqueryname + "();}return real.request();}", ctClass));
        //基于以上信息，生成动态类
        Class pc = ctClass.toClass();
        IDBQuery byteccodeProxy = (IDBQuery) pc.newInstance();
        return byteccodeProxy;
    }
//    public String request(){ if(real==null){ real=new DBQuery(); }return real.request();}
}
