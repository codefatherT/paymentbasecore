package com.gaoyang.service.pay.trade.model;

/**
 * 统一交易查询请求模型
 */
public class TradeQueryReqModel {
    private String tradeNo;     //支付订单号
    private String outTradeNo;  //支付平台支付订单号
    private String payPlatform; //支付平台

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

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    @Override
    public String toString() {
        return "TradeQueryReqModel{" +
                "tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                '}';
    }
}
