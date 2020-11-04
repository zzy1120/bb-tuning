package com.bb.tuning.flyweight;

/**
 * @ClassName EmployReportManager
 * @Description: 员工报表
 * @Author zzy
 * @Date 2020/11/3
 **/
public class EmployReportManager implements IReportManager {
    //租户ID
    protected String tenantId = null;

    public EmployReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a employee report";
    }
}
