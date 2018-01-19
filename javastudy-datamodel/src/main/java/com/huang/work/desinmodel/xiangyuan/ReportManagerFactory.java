package com.huang.work.desinmodel.xiangyuan;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.work.desinmodel.xiangyuan
 * @Description:
 * @date 2016/11/1 16:44
 * @Company: a
 */
public class ReportManagerFactory {

    Map<String,IReportManager> finacialReportManagerMap = new HashMap<String,IReportManager>();
    Map<String,IReportManager> employeeReportManagerMap = new HashMap<String,IReportManager>();

    IReportManager getFinancialReportManager(String tenantId) {
        IReportManager r = finacialReportManagerMap.get(tenantId);
        if (r == null) {
            r = new FinancialReportManager(tenantId);
            finacialReportManagerMap.put(tenantId,r);
        }
        return r;
    }

    IReportManager getEmployeeReportManager(String tenantId) {
        IReportManager r = employeeReportManagerMap.get(tenantId);
        if (r == null) {
            r = new EmployeeReportManager(tenantId);
            employeeReportManagerMap.put(tenantId,r);
        }
        return r;
    }

}
