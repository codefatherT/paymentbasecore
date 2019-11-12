package com.gaoyang.service.constant;

public enum  ResponseEnum {
    SUCCESS_ENUM("10000", "Success", "Success", "成功"),
    ERROR_ENUM("40004", "Error", "SYSTEM_BUSY", "系统繁忙，请稍后再试");

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误名称
     */
    private String message;

    /**
     * 错误码
     */
    private String subCode;

    /**
     * 错误描述
     */
    private String subMessage;

    ResponseEnum(String code, String message, String subCode, String subMessage) {
        this.code = code;
        this.message = message;
        this.subCode = subCode;
        this.subMessage = subMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMessage() {
        return subMessage;
    }

    public void setSubMessage(String subMessage) {
        this.subMessage = subMessage;
    }
}
