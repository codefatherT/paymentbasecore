package com.gaoyang.service.pay.fundauth.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * 资金授权查询响应模型
 */
public class FundAuthQueryRespModel {
    @JSONField(name = "auth_no")
    private String outFundAuthNo;           //支付平台资金授权订单号
    @JSONField(name = "out_order_no")
    private String fundAuthNo;              //资金授权订单号
    @JSONField(name = "out_request_no")
    private String operationId;             //资金操作流水号
    @JSONField(name = "operation_id")
    private String outOperationId;          //支付平台资金操作流水号
    @JSONField(name = "total_freeze_amount")
    private String totalFreezeAmount;   //订单累计的冻结金额
    @JSONField(name = "rest_amount")
    private String restAmount;          //订单总共剩余的冻结金额
    @JSONField(name = "total_pay_amount")
    private String totalPayAmount;      //订单累计用于支付的金额
    @JSONField(name = "total_unfreeze_amount")
    private String totalUnfreezeAmount; //累计解冻金额
    private String orderTitle;          //业务订单的简单描述
    @JSONField(name = "payer_logon_id")
    private String payerLogonId;        //付款方支付宝账号
    @JSONField(name = "payer_user_id")
    private String payerUserId;         //付款方账号在支付平台对应的唯一用户号
    @JSONField(name = "payee_logon_id")
    private String payeeLogonId;//收款方支付平台账号登陆号
    @JSONField(name = "payee_user_id")
    private String payeeUserId; //收款方支付平台账号UID
    @JSONField(name = "amount")
    private String amount;              //此次的操作金额
    @JSONField(name = "operation_type")
    private String operationType;       //资金操作类型
    private String status;              //资金操作流水的状态
    private String remark;              //附言描述
    @JSONField(name = "gmt_create")
    private Date gmtCreate;             //单据操作流水创建时间
    @JSONField(name = "gmt_trans")
    private Date gmtTrans;              //账务处理成功时间

    public String getOutFundAuthNo() {
        return outFundAuthNo;
    }

    public void setOutFundAuthNo(String outFundAuthNo) {
        this.outFundAuthNo = outFundAuthNo;
    }

    public String getFundAuthNo() {
        return fundAuthNo;
    }

    public void setFundAuthNo(String fundAuthNo) {
        this.fundAuthNo = fundAuthNo;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOutOperationId() {
        return outOperationId;
    }

    public void setOutOperationId(String outOperationId) {
        this.outOperationId = outOperationId;
    }

    public String getTotalFreezeAmount() {
        return totalFreezeAmount;
    }

    public void setTotalFreezeAmount(String totalFreezeAmount) {
        this.totalFreezeAmount = totalFreezeAmount;
    }

    public String getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(String restAmount) {
        this.restAmount = restAmount;
    }

    public String getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(String totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtTrans() {
        return gmtTrans;
    }

    public void setGmtTrans(Date gmtTrans) {
        this.gmtTrans = gmtTrans;
    }

    public String getTotalUnfreezeAmount() {
        return totalUnfreezeAmount;
    }

    public void setTotalUnfreezeAmount(String totalUnfreezeAmount) {
        this.totalUnfreezeAmount = totalUnfreezeAmount;
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

    @Override
    public String toString() {
        return "FundAuthQueryRespModel{" +
                "outFundAuthNo='" + outFundAuthNo + '\'' +
                ", fundAuthNo='" + fundAuthNo + '\'' +
                ", operationId='" + operationId + '\'' +
                ", outOperationId='" + outOperationId + '\'' +
                ", totalFreezeAmount='" + totalFreezeAmount + '\'' +
                ", restAmount='" + restAmount + '\'' +
                ", totalPayAmount='" + totalPayAmount + '\'' +
                ", totalUnfreezeAmount='" + totalUnfreezeAmount + '\'' +
                ", orderTitle='" + orderTitle + '\'' +
                ", payerLogonId='" + payerLogonId + '\'' +
                ", payerUserId='" + payerUserId + '\'' +
                ", payeeLogonId='" + payeeLogonId + '\'' +
                ", payeeUserId='" + payeeUserId + '\'' +
                ", amount='" + amount + '\'' +
                ", operationType='" + operationType + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtTrans=" + gmtTrans +
                '}';
    }
}
