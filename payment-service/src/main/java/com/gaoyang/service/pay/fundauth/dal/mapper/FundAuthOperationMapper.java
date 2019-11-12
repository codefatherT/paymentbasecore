package com.gaoyang.service.pay.fundauth.dal.mapper;

import com.gaoyang.service.pay.fundauth.dal.dobj.FundAuthOperationDO;

/**
 * 资金授权操作数据访问接口
 */
public interface FundAuthOperationMapper {
    /**
     *资金授权操作流水入库操作
     * @param fundAuthOperationDO
     * @return
     */
    int insertFundAuthOperationInfo(FundAuthOperationDO fundAuthOperationDO);

    /**
     * 资金授权操作流水更新操作
     * @param fundAuthOperationDO
     * @return
     */
    int updateFundAuthOperationInfo(FundAuthOperationDO fundAuthOperationDO);
}
