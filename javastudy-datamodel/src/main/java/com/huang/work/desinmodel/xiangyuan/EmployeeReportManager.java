package com.huang.work.desinmodel.xiangyuan;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.work.desinmodel.xiangyuan
 * @Description:
 * @date 2016/11/1 16:05
 * @Company: creditease.cn
 */
public class EmployeeReportManager implements IReportManager { //Ա������

    protected String tenantId = null; //�⻧Id

    public EmployeeReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "create EmployeeReport";
    }


}
