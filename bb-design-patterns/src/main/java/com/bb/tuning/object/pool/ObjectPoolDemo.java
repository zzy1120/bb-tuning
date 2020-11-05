package com.bb.tuning.object.pool;

import org.apache.commons.pool.ObjectPool;
import org.apache.commons.pool.PoolableObjectFactory;
import org.apache.commons.pool.impl.GenericObjectPool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ObjectPoolDemo
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/5
 **/
public class ObjectPoolDemo {
    static PoolableObjectFactory factory = new PoolableObjectFactoryDemo();
    static ObjectPool pool = new GenericObjectPool(factory);
    static AtomicInteger endCount = new AtomicInteger(0);

    public static class PoolThread extends Thread {
        @Override
        public void run() {
            Object obj = null;

            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println("== " + i + " ==");
                    //从对象池得到对象
                    pool.borrowObject();
                    //模拟使用对象
                    System.out.println(obj + " is get");
                    //使用完成后，将对象返回池中
                    pool.returnObject(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                endCount.getAndIncrement();
            }

        }
    }

    public static void main(String[] args) {
        new PoolThread().start();
        new PoolThread().start();
        new PoolThread().start();
        try {
            while (true) {
                //等待3个线程全部结束
                if (endCount.get() == 3) {
                    pool.close();
                    break;
                }
            }
        } catch (Exception e) {

        }
    }
}
