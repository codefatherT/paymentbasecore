package com.gaoyang.service.pay.fundauth.model;

/**
 * @author zhantc
 * @date 2019/10/17
 * @desc 资金授权冻结请求模型
 */
public class FundAuthFreezeReqModel {
    private String bizOrderNo;       //业务订单号
    private String fundAuthNo;      //资金授权订单号
    private String operationId;     //资金操作流水号
    private String orderTitle;      //业务订单的简单描述
    private String amount;          //操作金额
    private String payeeLogonId;    //收款方支付账号
    private String payeeUserId;     //收款方唯一用户号
    private String payTimeOut;      //最晚付款时间
    private String enablePayChannels;//指定可使用的支付渠道
    private String productCode;     //销售产品码
    private String extraParam;      //扩展参数,json格式
    private String payPlatform;     //支付平台

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getFundAuthNo() {
        return fundAuthNo;
    }

    public void setFundAuthNo(String fundAuthNo) {
        this.fundAuthNo = fundAuthNo;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayeeLogonId() {
        return payeeLogonId;
    }

    public void setPayeeLogonId(String payeeLogonId) {
        this.payeeLogonId = payeeLogonId;
    }

    public String getPayeeUserId() {
        return payeeUserId;
    }

    public void setPayeeUserId(String payeeUserId) {
        this.payeeUserId = payeeUserId;
    }

    public String getPayTimeOut() {
        return payTimeOut;
    }

    public void setPayTimeOut(String payTimeOut) {
        this.payTimeOut = payTimeOut;
    }

    public String getEnablePayChannels() {
        return enablePayChannels;
    }

    public void setEnablePayChannels(String enablePayChannels) {
        this.enablePayChannels = enablePayChannels;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    @Override
    public String toString() {
        return "FundAuthFreezeReqModel{" +
                "bizOrderNo='" + bizOrderNo + '\'' +
                ", fundAuthNo='" + fundAuthNo + '\'' +
                ", operationId='" + operationId + '\'' +
                ", orderTitle='" + orderTitle + '\'' +
                ", amount='" + amount + '\'' +
                ", payeeLogonId='" + payeeLogonId + '\'' +
                ", payeeUserId='" + payeeUserId + '\'' +
                ", payTimeOut='" + payTimeOut + '\'' +
                ", enablePayChannels='" + enablePayChannels + '\'' +
                ", productCode='" + productCode + '\'' +
                ", extraParam='" + extraParam + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                '}';
    }
}
