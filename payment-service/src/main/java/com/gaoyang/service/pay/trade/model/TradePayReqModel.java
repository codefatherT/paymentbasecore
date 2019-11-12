package com.gaoyang.service.pay.trade.model;

/**
 * 支付请求模型
 */
public class TradePayReqModel {
    private String outAuthNo;        //支付平台资金授权订单号
    private String tradeNo;         //支付订单号
    private String subject;         //支付标题
    private String totalAmount;     //支付金额
    private String sellerId;        //商家支付账户id
    private String buyerId;         //买家支付账户id
    private String body;            //订单描述
    private String authConfirmMode;//预授权确认模式，授权转交易请求中传入，适用于预授权转交易业务使用
    private String payPlatform;     //支付平台

    public String getOutAuthNo() {
        return outAuthNo;
    }

    public void setOutAuthNo(String outAuthNo) {
        this.outAuthNo = outAuthNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthConfirmMode() {
        return authConfirmMode;
    }

    public void setAuthConfirmMode(String authConfirmMode) {
        this.authConfirmMode = authConfirmMode;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    @Override
    public String toString() {
        return "TradePayReqModel{" +
                "outAuthNo='" + outAuthNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", subject='" + subject + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", body='" + body + '\'' +
                ", authConfirmMode='" + authConfirmMode + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                '}';
    }
}
