package com.huang.work.desinmodel.xiangyuan;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.work.desinmodel.xiangyuan
 * @Description:
 * @date 2016/11/1 16:01
 * @Company: creditease.cn
 */
public class FinancialReportManager implements IReportManager { //财务报表

    protected String tenantId = null; //租户Id

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "create FinancialReport ....";
    }

}
