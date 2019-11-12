package com.gaoyang.service.pay.fundauth.service;

import com.gaoyang.service.pay.fundauth.model.*;

/**
 * 资金授权操作服务抽象接口
 */
public interface FundAuthService {

    /**
     * 资金授权冻结操作
     * @param fundAuthFreezeReqModel
     * @return
     * @throws Exception
     */
    FundAuthFreezeRespModel freeze(FundAuthFreezeReqModel fundAuthFreezeReqModel)throws Exception;

    /**
     * 资金授权解冻操作
     * @param fundAuthUnFreezeReqModel
     * @return
     * @throws Exception
     */
    FundAuthUnFreezeRespModel unFreeze(FundAuthUnFreezeReqModel fundAuthUnFreezeReqModel)throws Exception;

    /**
     * 资金授权查询操作
     * @param fundAuthQueryReqModel
     * @return
     * @throws Exception
     */
    FundAuthQueryRespModel fundAuthQuery(FundAuthQueryReqModel fundAuthQueryReqModel)throws Exception;
}
