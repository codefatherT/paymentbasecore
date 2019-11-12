package com.gaoyang.service.pay.fundauth.dal.mapper;

import com.gaoyang.service.pay.fundauth.dal.dobj.FundAuthOrderDO;

/**
 * 资金授权数据访问接口
 */
public interface FundAuthOrderMapper {
    /**
     *资金授权订单入库操作
     * @param fundAuthOrderDO
     * @return
     */
    int insertFundAuthOrderInfo(FundAuthOrderDO fundAuthOrderDO);

    /**
     * 资金授权订单更新操作
     * @param fundAuthOrderDO
     * @return
     */
    int updateFundAuthOrderInfo(FundAuthOrderDO fundAuthOrderDO);
}
