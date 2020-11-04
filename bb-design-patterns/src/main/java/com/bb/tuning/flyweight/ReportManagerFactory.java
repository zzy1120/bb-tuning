package com.bb.tuning.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FlyWeightFactory
 * @Description: 享元工厂
 * @Author zzy
 * @Date 2020/11/3
 **/
public class ReportManagerFactory {

    Map<String, IReportManager> financialReportManager = new HashMap<>();
    Map<String, IReportManager> employReportManager = new HashMap<>();

    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager reportManager = financialReportManager.get(tenantId);
        if (reportManager == null) {
            reportManager = new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId, reportManager);
        }
        return reportManager;
    }

    IReportManager getEmployReportManager(String tenantId) {
        //通过租户ID获取享元
        IReportManager reportManager = employReportManager.get(tenantId);
        if (reportManager == null) {
            reportManager = new EmployReportManager(tenantId);
            //维护已创建的享元对象
            employReportManager.put(tenantId, reportManager);
        }
        return reportManager;
    }

}
