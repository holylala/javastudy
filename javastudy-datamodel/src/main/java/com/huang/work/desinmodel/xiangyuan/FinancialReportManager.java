package com.huang.work.desinmodel.xiangyuan;

/**
 * @author zhenqionghuang@a
 * @version V1.0
 * @Package com.huang.work.desinmodel.xiangyuan
 * @Description:
 * @date 2016/11/1 16:01
 * @Company: a
 */
public class FinancialReportManager implements IReportManager { //���񱨱�

    protected String tenantId = null; //�⻧Id

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "create FinancialReport ....";
    }

}
