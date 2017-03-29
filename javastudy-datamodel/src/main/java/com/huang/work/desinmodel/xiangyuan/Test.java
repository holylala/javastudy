package com.huang.work.desinmodel.xiangyuan;

/**
 * @author zhenqionghuang@creditease.cn
 * @version V1.0
 * @Package com.huang.work.desinmodel.xiangyuan
 * @Description:
 * @date 2016/11/1 16:52
 * @Company: creditease.cn
 */
public class Test {

    public static void main(String[] args) {
        ReportManagerFactory reportManagerFactory = new ReportManagerFactory();

        IReportManager rm = reportManagerFactory.getFinancialReportManager("A");

        System.out.println(rm.createReport());

    }

}
