package com.huang.work.desinmodel.xiangyuan;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.work.desinmodel.xiangyuan
 * @Description:
 * @date 2016/11/1 16:05
 * @Company: a
 */
public class EmployeeReportManager implements IReportManager { //员工报表

    protected String tenantId = null; //租户Id

    public EmployeeReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "create EmployeeReport";
    }


}
