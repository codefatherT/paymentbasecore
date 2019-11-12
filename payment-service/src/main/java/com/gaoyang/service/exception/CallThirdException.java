package com.gaoyang.service.exception;

/**
 * 调用第三方支付平台接口异常
 */
public class CallThirdException extends Exception{
    private String errCode;
    private String errMsg;

    public CallThirdException() {
    }

    public CallThirdException(String message, Throwable cause) {
        super(message, cause);
    }

    public CallThirdException(String message) {
        super(message);
    }

    public CallThirdException(Throwable cause) {
        super(cause);
    }

    public CallThirdException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}
