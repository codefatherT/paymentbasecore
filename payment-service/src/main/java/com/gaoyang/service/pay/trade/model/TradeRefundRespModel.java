package com.gaoyang.service.pay.trade.model;

import java.util.Date;

/**
 * 统一退款响应模型
 */
public class TradeRefundRespModel {
    private String tradeNo;        //支付订单号
    private String outTradeNo;     //支付平台支付订单号
    private String refundFee;           //退款金额
    private String buyerLogonId;        //用户在支付平台的登录账号
    private String buyerUserId;         //用户在支付平台的唯一id
    private String fundChange;          //本次退款是否发生资金变化
    private Date gmtRefundPay;          //退款支付时间

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

    public String getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(String refundFee) {
        this.refundFee = refundFee;
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

    public String getFundChange() {
        return fundChange;
    }

    public void setFundChange(String fundChange) {
        this.fundChange = fundChange;
    }

    public Date getGmtRefundPay() {
        return gmtRefundPay;
    }

    public void setGmtRefundPay(Date gmtRefundPay) {
        this.gmtRefundPay = gmtRefundPay;
    }

    @Override
    public String toString() {
        return "TradeRefundRespModel{" +
                "tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", refundFee='" + refundFee + '\'' +
                ", buyerLogonId='" + buyerLogonId + '\'' +
                ", buyerUserId='" + buyerUserId + '\'' +
                ", fundChange='" + fundChange + '\'' +
                ", gmtRefundPay=" + gmtRefundPay +
                '}';
    }
}
