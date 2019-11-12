package com.gaoyang.service.pay.trade.model;

import java.util.Date;

/**
 * 支付响应模型
 */
public class TradePayRespModel {
    private String outTradeNo;          //支付平台的支付订单号
    private String tradeNo;             //支付订单号
    private String buyerLogonId;        //买家支付登录账号
    private String buyerUserId;         //买家支付账号id
    private String totalAmount;         //交易金额
    private String receiptAmount;       //实收金额
    private Date gmtPayment;            //交易支付时间

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

    public String getBuyerLogonId() {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId) {
        this.buyerLogonId = buyerLogonId;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public Date getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(Date gmtPayment) {
        this.gmtPayment = gmtPayment;
    }

    @Override
    public String toString() {
        return "TradePayRespModel{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", buyerLogonId='" + buyerLogonId + '\'' +
                ", buyerUserId='" + buyerUserId + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", receiptAmount='" + receiptAmount + '\'' +
                ", gmtPayment=" + gmtPayment +
                '}';
    }
}
