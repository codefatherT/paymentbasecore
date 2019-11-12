package com.gaoyang.service.pay.fundauth.model;

/**
 * 资金授权解冻响应模型
 */
public class FundAuthUnFreezeRespModel {
    private String outFundAuthNo;   //支付平台资金授权订单号
    private String fundAuthNo;      //资金授权订单号
    private String outOperationId;  //支付平台资金操作流水号
    private String operationId;     //资金操作流水号
    private String amount;      //冻结金额
    private String status;      //资金操作状态

    public String getOutFundAuthNo() {
        return outFundAuthNo;
    }

    public void setOutFundAuthNo(String outFundAuthNo) {
        this.outFundAuthNo = outFundAuthNo;
    }

    public String getFundAuthNo() {
        return fundAuthNo;
    }

    public void setFundAuthNo(String fundAuthNo) {
        this.fundAuthNo = fundAuthNo;
    }

    public String getOutOperationId() {
        return outOperationId;
    }

    public void setOutOperationId(String outOperationId) {
        this.outOperationId = outOperationId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FundAuthUnFreezeRespModel{" +
                "outFundAuthNo='" + outFundAuthNo + '\'' +
                ", fundAuthNo='" + fundAuthNo + '\'' +
                ", outOperationId='" + outOperationId + '\'' +
                ", operationId='" + operationId + '\'' +
                ", amount='" + amount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
