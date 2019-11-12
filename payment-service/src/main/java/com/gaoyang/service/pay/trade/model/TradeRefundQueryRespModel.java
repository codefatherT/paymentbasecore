package com.gaoyang.service.pay.trade.model;

import java.util.Date;

/**
 * 统一交易退款查询响应模型
 */
public class TradeRefundQueryRespModel {
    private String outTradeNo;            //支付平台支付订单号
    private String tradeNo;               //支付订单号
    private String operationId;           //退款请求号
    private String refundReason;         //退款原因
    private String totalAmount;         //该笔退款所对应的交易的订单金额
    private String refundAmount;        //本次退款请求，对应的退款金额
    private Date gmtRefundPay;        //退款时间

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Date getGmtRefundPay() {
        return gmtRefundPay;
    }

    public void setGmtRefundPay(Date gmtRefundPay) {
        this.gmtRefundPay = gmtRefundPay;
    }

    @Override
    public String toString() {
        return "TradeRefundQueryRespModel{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", operationId='" + operationId + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", gmtRefundPay=" + gmtRefundPay +
                '}';
    }
}
