package com.bb.tuning.flyweight;

/**
 * @ClassName FinancialReportManager
 * @Description: 财务报表
 * @Author zzy
 * @Date 2020/11/3
 **/
public class FinancialReportManager implements IReportManager {
    //租户ID
    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report ";
    }
}
