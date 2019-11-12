package com.gaoyang.service.pay.fundauth.dal.dobj;

/**
 * 退款订单模型
 */
public class RefundOrderDO {
    private String gmtModified;
    private String gmtCreate;  //记录创建时间
    private String recordStatus;//数据记录逻辑删除标识 0 正常 1 已删除
    private String id;//主键
    private String tradeNo;//交易号
    private String outTradeNo;//支付平台交易号
    private String refundNo;//退款号
    private String refundReason;// 退款原因
    private String refundAmount;//退款金额
    private String ex0;
    private String ex1;
    private String ex2;
    private String ex3;
    private String ex4;

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getEx0() {
        return ex0;
    }

    public void setEx0(String ex0) {
        this.ex0 = ex0;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
    }

    public String getEx2() {
        return ex2;
    }

    public void setEx2(String ex2) {
        this.ex2 = ex2;
    }

    public String getEx3() {
        return ex3;
    }

    public void setEx3(String ex3) {
        this.ex3 = ex3;
    }

    public String getEx4() {
        return ex4;
    }

    public void setEx4(String ex4) {
        this.ex4 = ex4;
    }

    @Override
    public String toString() {
        return "RefundOrderDO{" +
                "gmtModified='" + gmtModified + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", recordStatus='" + recordStatus + '\'' +
                ", id='" + id + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", refundNo='" + refundNo + '\'' +
                ", refundReason='" + refundReason + '\'' +
                ", refundAmount='" + refundAmount + '\'' +
                ", ex0='" + ex0 + '\'' +
                ", ex1='" + ex1 + '\'' +
                ", ex2='" + ex2 + '\'' +
                ", ex3='" + ex3 + '\'' +
                ", ex4='" + ex4 + '\'' +
                '}';
    }
}
