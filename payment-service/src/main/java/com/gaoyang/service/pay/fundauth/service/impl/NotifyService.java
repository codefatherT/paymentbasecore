package com.gaoyang.service.pay.fundauth.service.impl;

import com.gaoyang.service.pay.fundauth.model.FundAuthQueryRespModel;

public interface NotifyService {


    /**
     * 更新资金授权订单和资金授权操作流水
     * @param fundAuthQueryRespModel
     */
    void fundAuthNotify(FundAuthQueryRespModel fundAuthQueryRespModel);

    /**
     * 回调商户
     * @param fundAuthQueryRespModel
     */
    void notifyMerchant(FundAuthQueryRespModel fundAuthQueryRespModel);
}
