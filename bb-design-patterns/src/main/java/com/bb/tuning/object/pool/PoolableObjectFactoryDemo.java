package com.bb.tuning.object.pool;

import org.apache.commons.pool.PoolableObjectFactory;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName PoolableObjectFactoryDeml
 * @Description: 对象池工厂
 * @Author zzy
 * @Date 2020/11/5
 **/
public class PoolableObjectFactoryDemo implements PoolableObjectFactory {

    private static AtomicInteger counter = new AtomicInteger(0);

    /**
     * 定义如何创建一个新的对象
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object makeObject() throws Exception {
        //创建对象
        String obj = String.valueOf(counter.getAndIncrement());
        System.out.println("Create Object " + obj);
        return obj;
    }

    /**
     * 对象从对象池中被销毁时，会执行这个方法
     *
     * @param obj
     * @throws Exception
     */
    @Override
    public void destroyObject(Object obj) throws Exception {
        System.out.println("Destroy Object " + obj);
    }

    /**
     * 判断对象是否可用
     *
     * @param obj
     * @return
     */
    @Override
    public boolean validateObject(Object obj) {
        return true;
    }

    /**
     * 在对象从对象池取出前，会激活对象
     *
     * @param obj
     * @throws Exception
     */
    @Override
    public void activateObject(Object obj) throws Exception {
        System.out.println("Before borrow " + obj);
    }

    /**
     * 在对象返回对象池时被调用
     *
     * @param obj
     * @throws Exception
     */
    @Override
    public void passivateObject(Object obj) throws Exception {
        System.out.println("return " + obj);
    }
}
