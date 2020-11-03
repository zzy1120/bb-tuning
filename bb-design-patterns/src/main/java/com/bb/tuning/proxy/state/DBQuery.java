package com.bb.tuning.proxy.state;

/**
 * @ClassName DBQuery
 * @Description: TODO
 * @Author zzy
 * @Date 2020/11/3
 **/
public class DBQuery implements IDBQuery {

    public DBQuery(){
        try {
            //可能包含数据库连接等耗时操作
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String request() {
        return "request String";
    }
}
