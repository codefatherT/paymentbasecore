package com.gaoyang.service.pay.fundauth.alipay.integration;


import com.gaoyang.service.pay.fundauth.model.*;

/**
 * 调用支付宝资金授权操作防腐层接口
 */
public interface AlipayFundAuthIntegration {
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
