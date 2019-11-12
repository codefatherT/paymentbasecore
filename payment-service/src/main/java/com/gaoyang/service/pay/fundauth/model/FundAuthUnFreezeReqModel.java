package com.gaoyang.service.pay.fundauth.model;

/**
 * 资金授权解冻请求模型
 */
public class FundAuthUnFreezeReqModel {
    private String outFundAuthNo;   //支付平台资金授权订单号
    private String operationId;     //资金操作流水号
    private String amount;          //解冻金额
    private String remark;          //附言描述
    private String extraParam;      //扩展信息
    private String payPlatform;     //支付平台

    public String getOutFundAuthNo() {
        return outFundAuthNo;
    }

    public void setOutFundAuthNo(String outFundAuthNo) {
        this.outFundAuthNo = outFundAuthNo;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(String payPlatform) {
        this.payPlatform = payPlatform;
    }

    public String getExtraParam() {
        return extraParam;
    }

    public void setExtraParam(String extraParam) {
        this.extraParam = extraParam;
    }

    @Override
    public String toString() {
        return "FundAuthUnFreezeReqModel{" +
                "outFundAuthNo='" + outFundAuthNo + '\'' +
                ", operationId='" + operationId + '\'' +
                ", amount='" + amount + '\'' +
                ", remark='" + remark + '\'' +
                ", extraParam='" + extraParam + '\'' +
                ", payPlatform='" + payPlatform + '\'' +
                '}';
    }
}
