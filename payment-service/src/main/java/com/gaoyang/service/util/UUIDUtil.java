package com.gaoyang.service.util;

import java.util.UUID;

/**
 * UUID工具类
 */
public class UUIDUtil {

    /**
     * 获取一个UUID值
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
