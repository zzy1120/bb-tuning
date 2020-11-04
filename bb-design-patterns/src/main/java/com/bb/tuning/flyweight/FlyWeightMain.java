package com.bb.tuning.flyweight;

/**
 * @ClassName FlyWeightMain
 * @Description: 享元模式测试类
 * @Author zzy
 * @Date 2020/11/3
 **/
public class FlyWeightMain {

    public static void main(String[] args) {
        ReportManagerFactory reportManagerFactory = new ReportManagerFactory();
        IReportManager rm = reportManagerFactory.getFinancialReportManager("A");
        System.out.println(rm.createReport());
    }
}
