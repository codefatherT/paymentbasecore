package com.gaoyang.service.pay.fundauth.dal.dobj;

import java.util.Date;

/**
 * 资金授权操作模型
 */
public class FundAuthOperationDO {
    private Date gmtModified;   //记录修改时间
    private Date gmtCreate;     //记录创建时间
    private String recordStatus; //数据记录逻辑删除标识 0 正常 1 已删除
    private String id;            //主键
    private String fundAuthNo;        //资金授权订单号
    private String outFundAuthNo;    //支付平台资金授权订单号
    private String operationId;    //资金授权操作流水号
    private String outOperationId; //支付平台资金授权流水号
    private String amount;            //操作金额
    private String totalFreezeAmount;//订单累计的冻结金额
    private String totalUnfreezeAmount;//累计解冻金额
    private String restAmount;          //剩余冻结金额
    private String totalPayAmount;      //订单累计用于支付的金额
    private String operationType;   //操作类型
    private String status;          //流水状态
    private String ex0;
    private String ex1;
    private String ex2;
    private String ex3;
    private String ex4;

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFundAuthNo() {
        return fundAuthNo;
    }

    public void setFundAuthNo(String fundAuthNo) {
        this.fundAuthNo = fundAuthNo;
    }

    public String getOutFundAuthNo() {
        return outFundAuthNo;
    }

    public void setOutFundAuthNo(String outFundAuthNo) {
        this.outFundAuthNo = outFundAuthNo;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOutOperationId() {
        return outOperationId;
    }

    public void setOutOperationId(String outOperationId) {
        this.outOperationId = outOperationId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getTotalFreezeAmount() {
        return totalFreezeAmount;
    }

    public void setTotalFreezeAmount(String totalFreezeAmount) {
        this.totalFreezeAmount = totalFreezeAmount;
    }

    public String getTotalUnfreezeAmount() {
        return totalUnfreezeAmount;
    }

    public void setTotalUnfreezeAmount(String totalUnfreezeAmount) {
        this.totalUnfreezeAmount = totalUnfreezeAmount;
    }

    public String getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(String restAmount) {
        this.restAmount = restAmount;
    }

    public String getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(String totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEx0() {
        return ex0;
    }

    public void setEx0(String ex0) {
        this.ex0 = ex0;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
    }

    public String getEx2() {
        return ex2;
    }

    public void setEx2(String ex2) {
        this.ex2 = ex2;
    }

    public String getEx3() {
        return ex3;
    }

    public void setEx3(String ex3) {
        this.ex3 = ex3;
    }

    public String getEx4() {
        return ex4;
    }

    public void setEx4(String ex4) {
        this.ex4 = ex4;
    }

    @Override
    public String toString() {
        return "FundAuthOperationDO{" +
                "gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                ", recordStatus='" + recordStatus + '\'' +
                ", id='" + id + '\'' +
                ", fundAuthNo='" + fundAuthNo + '\'' +
                ", outFundAuthNo='" + outFundAuthNo + '\'' +
                ", operationId='" + operationId + '\'' +
                ", outOperationId='" + outOperationId + '\'' +
                ", amount='" + amount + '\'' +
                ", totalFreezeAmount='" + totalFreezeAmount + '\'' +
                ", totalUnfreezeAmount='" + totalUnfreezeAmount + '\'' +
                ", restAmount='" + restAmount + '\'' +
                ", totalPayAmount='" + totalPayAmount + '\'' +
                ", operationType='" + operationType + '\'' +
                ", status='" + status + '\'' +
                ", ex0='" + ex0 + '\'' +
                ", ex1='" + ex1 + '\'' +
                ", ex2='" + ex2 + '\'' +
                ", ex3='" + ex3 + '\'' +
                ", ex4='" + ex4 + '\'' +
                '}';
    }
}
