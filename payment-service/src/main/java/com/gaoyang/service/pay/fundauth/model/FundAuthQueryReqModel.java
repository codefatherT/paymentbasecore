package com.gaoyang.service.pay.fundauth.model;

/**
 * 资金授权查询请求模型
 */
public class FundAuthQueryReqModel {
    private String outFundAuthNo;       //支付平台资金授权订单号
    private String fundAuthNo;          //资金授权订单号
    private String outOperationId;     //支付平台资金授权操作流水号
    private String operationId;        //资金授权操作流水号
    private String payPlatform;        //支付平台

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

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    @Override
    public String toString() {
        return "FundAuthQueryReqModel{" +
                "outFundAuthNo='" + outFundAuthNo + '\'' +
                ", fundAuthNo='" + fundAuthNo + '\'' +
                ", outOperationId='" + outOperationId + '\'' +
                ", operationId='" + operationId + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                '}';
    }
}
