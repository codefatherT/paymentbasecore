package com.gaoyang.service.pay.trade.model;

/**
 * 统一交易查询响应模型
 */
public class TradeQueryRespModel {
    private String outTradeNo;  //支付平台支付订单号
    private String tradeNo;     //支付订单号
    private String buyerLogonId;//买家支付平台账号
    private String tradeStatus; //交易状态
    private String totalAmount; //交易的订单金额
    private String buyerUserId; //买家在支付平台的用户id

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

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    @Override
    public String toString() {
        return "TradeQueryRespModel{" +
                "outTradeNo='" + outTradeNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", buyerLogonId='" + buyerLogonId + '\'' +
                ", tradeStatus='" + tradeStatus + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", buyerUserId='" + buyerUserId + '\'' +
                '}';
    }
}
