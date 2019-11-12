package com.gaoyang.service.pay.fundauth.model;

/**
 * 资金授权冻结响应模型
 */
public class FundAuthFreezeRespModel {
    private String signResult;

    public String getSignResult() {
        return signResult;
    }

    public void setSignResult(String signResult) {
        this.signResult = signResult;
    }

    @Override
    public String toString() {
        return "FundAuthFreezeRespModel{" +
                "signResult='" + signResult + '\'' +
                '}';
    }

    /*private String productOrderId;  //产品订单号,例：支付宝资金授权订单号
    private String orderId;         //该平台维护的订单号
    private String operationNo;     //支付平台的资金操作流水号
    private String requestNo;       //该平台请求流水号
    private Double amount;          //金额
    private String status;          //资金明细状态
    private String payerUserId;    //付款方用户号
    private String gmtTrans;      //成功时间
    private String preType;        //例:信用，资金
    private String creditAmount;  //信用金额
    private String fundAmount;    //资金金额
    private String transCurrency; //标价币种

    public String getProductOrderId() {
        return productOrderId;
    }

    public void setProductOrderId(String productOrderId) {
        this.productOrderId = productOrderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId;
    }

    public String getGmtTrans() {
        return gmtTrans;
    }

    public void setGmtTrans(String gmtTrans) {
        this.gmtTrans = gmtTrans;
    }

    public String getPreType() {
        return preType;
    }

    public void setPreType(String preType) {
        this.preType = preType;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(String fundAmount) {
        this.fundAmount = fundAmount;
    }

    public String getTransCurrency() {
        return transCurrency;
    }

    public void setTransCurrency(String transCurrency) {
        this.transCurrency = transCurrency;
    }

    @Override
    public String toString() {
        return "PrePayRespModel{" +
                "productOrderId='" + productOrderId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", operationNo='" + operationNo + '\'' +
                ", requestNo='" + requestNo + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", payerUserId='" + payerUserId + '\'' +
                ", gmtTrans='" + gmtTrans + '\'' +
                ", preType='" + preType + '\'' +
                ", creditAmount='" + creditAmount + '\'' +
                ", fundAmount='" + fundAmount + '\'' +
                ", transCurrency='" + transCurrency + '\'' +
                '}';
    }*/
}
