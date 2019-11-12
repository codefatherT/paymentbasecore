package com.gaoyang.service.pay.fundauth.dal.dobj;

import java.util.Date;

/**
 * 资金授权订单模型
 */
public class FundAuthOrderDO {
    private Date gmtModified;    //记录修改时间
    private Date gmtCreate;      //记录创建时间
    private String recordStatus;   //数据记录逻辑删除标识 0 正常 1 已删除
    private String id;              //主键
    private String fundAuthNo; //资金授权订单号
    private String bizOrderNo; //商户业务订单号
    private String orderTitle;// 业务订单的简单描述
    private String payerLogonId; // 付款方支付平台账号
    private String payerUserId; // 付款方支付平台唯一用户号
    private String payeeLogonId;//收款方支付平台账号登陆号
    private String payeeUserId; //收款方支付平台账号UID
    private String state;       //订单状态
    private String preAuthType;  //预授权类型
    private String payPlatform; //支付平台
    private String ex0;
    private String ex1;
    private String ex2;
    private String ex3;


    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
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

    public String getFundAuthNo() {
        return fundAuthNo;
    }

    public void setFundAuthNo(String fundAuthNo) {
        this.fundAuthNo = fundAuthNo;
    }

    public String getBizOrderNo() {
        return bizOrderNo;
    }

    public void setBizOrderNo(String bizOrderNo) {
        this.bizOrderNo = bizOrderNo;
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    public String getPayerLogonId() {
        return payerLogonId;
    }

    public void setPayerLogonId(String payerLogonId) {
        this.payerLogonId = payerLogonId;
    }

    public String getPayerUserId() {
        return payerUserId;
    }

    public void setPayerUserId(String payerUserId) {
        this.payerUserId = payerUserId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPreAuthType() {
        return preAuthType;
    }

    public void setPreAuthType(String preAuthType) {
        this.preAuthType = preAuthType;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
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

    @Override
    public String toString() {
        return "FundAuthOrderDO{" +
                "gmtModified=" + gmtModified +
                ", gmtCreate=" + gmtCreate +
                ", recordStatus='" + recordStatus + '\'' +
                ", id='" + id + '\'' +
                ", fundAuthNo='" + fundAuthNo + '\'' +
                ", bizOrderNo='" + bizOrderNo + '\'' +
                ", orderTitle='" + orderTitle + '\'' +
                ", payerLogonId='" + payerLogonId + '\'' +
                ", payerUserId='" + payerUserId + '\'' +
                ", payeeLogonId='" + payeeLogonId + '\'' +
                ", payeeUserId='" + payeeUserId + '\'' +
                ", state='" + state + '\'' +
                ", preAuthType='" + preAuthType + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                ", ex0='" + ex0 + '\'' +
                ", ex1='" + ex1 + '\'' +
                ", ex2='" + ex2 + '\'' +
                ", ex3='" + ex3 + '\'' +
                '}';
    }
}
