package com.gaoyang.service.model;

/**
 * 公共返回数据模型
 * @author zhangtc
 * @date 2019/10/16
 */
public class ResponseModel<T>{
    private String code;    //网关返回码
    private String msg;     //网关返回描述
    private String subCode; //业务返回码
    private String subMsg;  //业务返回码描述
    private T bizContent;   //业务参数

    public ResponseModel(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResponseModel(String code, String msg, T bizContent) {
        super();
        this.code = code;
        this.msg = msg;
        this.bizContent = bizContent;
    }

    public ResponseModel(String code, String msg, String subCode, T bizContent) {
        super();
        this.code = code;
        this.msg = msg;
        this.subCode = subCode;
        this.bizContent = bizContent;
    }

    public ResponseModel(String code, String msg, String subCode, String subMsg, T bizContent) {
        super();
        this.code = code;
        this.msg = msg;
        this.subCode = subCode;
        this.subMsg = subMsg;
        this.bizContent = bizContent;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public T getBizContent() {
        return bizContent;
    }

    public void setBizContent(T bizContent) {
        this.bizContent = bizContent;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", subCode='" + subCode + '\'' +
                ", subMsg='" + subMsg + '\'' +
                ", bizContent=" + bizContent +
                '}';
    }
}
