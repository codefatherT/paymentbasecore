package com.gaoyang.service.util;


import com.gaoyang.service.model.ResponseModel;
import com.gaoyang.service.constant.ResponseEnum;

/**
 * 返回信息处理工具类
 * @author zhangtc
 * @date 2019/10/20
 */
public class ResponseUtil {

    /**
     * 生成ResponseModel
     *
     * @param responseEnum
     * @return
     */
    public static <T> ResponseModel<T> generateResponseModel(ResponseEnum responseEnum) {
        return generateResponseModel(responseEnum, null);
    }

    /**
     * 生成ResponseModel
     *
     * @param responseEnum
     * @param t
     * @return
     */
    public static <T> ResponseModel<T> generateResponseModel(ResponseEnum responseEnum, T t) {
        return generateResponseModel(responseEnum.getCode(), responseEnum.getSubMessage(),
                t);
    }

    /**
     * 生成ResponseModel
     *
     * @param code code码
     * @param msg  信息描述
     * @return
     */
    public static <T> ResponseModel<T> generateResponseModel(String code, String msg) {
        return generateResponseModel(code, msg, null);
    }


    /**
     * 生成ResponseModel
     *
     * @param code code码
     * @param msg  信息描述
     * @param t
     * @return
     */
    public static <T> ResponseModel<T> generateResponseModel(String code, String msg, T t) {
        ResponseModel<T> response = new ResponseModel<T>(code,msg,t);
        return response;
    }

}
