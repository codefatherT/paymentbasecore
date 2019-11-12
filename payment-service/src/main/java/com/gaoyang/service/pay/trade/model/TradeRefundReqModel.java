package com.gaoyang.service.pay.trade.model;

/**
 * 统一退款请求模型
 */
public class TradeRefundReqModel {
    private String tradeNo;     //支付订单号
    private String outTradeNo;  //支付平台的支付订单号
    private String operationId;      //退款请求号
    private String amount;          //退款金额
    private String refundReason;   //退款原因
    private String payPlatform;     //支付平台

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
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

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    @Override
    public String toString() {
        return "TradeRefundReqModel{" +
                "tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", operationId='" + operationId + '\'' +
                ", amount='" + amount + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                '}';
    }
}
