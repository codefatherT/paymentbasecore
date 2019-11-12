package com.gaoyang.service.pay.fundauth.constant;

/**
 * @author zhantc
 * @date 2019/10/18
 * 平台产品规则枚举类
 */
public enum PlatformEnum {
    FUNDAUTH_ALIPAY("0","alipayFundAuthService","ALIPAY");

    private String platform;    //平台
    private String alias;       //别名
    private String remark;      //备注

    private PlatformEnum(String platform, String alias, String remark) {
        this.platform = platform;
        this.alias = alias;
        this.remark = remark;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
