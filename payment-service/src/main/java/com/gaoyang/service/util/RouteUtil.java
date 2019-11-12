package com.gaoyang.service.util;

import com.gaoyang.service.pay.fundauth.constant.PlatformEnum;

import java.util.Arrays;

public class RouteUtil {

    /**
     * 根据规则匹配到具体类别名
     * @param paltform
     * @return
     */
    public static String findServiceNameByRule(String paltform) {
        return Arrays.stream(PlatformEnum.values()).filter(ruleEnum ->
                ruleEnum.getPlatform().equals(paltform)
        ).map(ruleEnum -> ruleEnum.getAlias()).findFirst().get();
    }
}
