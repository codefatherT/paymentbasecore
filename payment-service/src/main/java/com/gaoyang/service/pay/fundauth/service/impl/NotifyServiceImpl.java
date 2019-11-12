package com.gaoyang.service.pay.fundauth.service.impl;

import com.gaoyang.service.pay.fundauth.dal.dobj.FundAuthOperationDO;
import com.gaoyang.service.pay.fundauth.dal.dobj.FundAuthOrderDO;
import com.gaoyang.service.pay.fundauth.dal.mapper.FundAuthOrderMapper;
import com.gaoyang.service.pay.fundauth.dal.mapper.FundAuthOperationMapper;
import com.gaoyang.service.pay.fundauth.model.FundAuthQueryRespModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotifyServiceImpl implements NotifyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyServiceImpl.class);
    @Autowired
    FundAuthOrderMapper fundAuthOrderMapper;
    @Autowired
    FundAuthOperationMapper fundAuthOperationMapper;

    @Override
    public void fundAuthNotify(FundAuthQueryRespModel fundAuthQueryRespModel) {
        LOGGER.info("[NotifyServiceImpl-fundAuthNotify]资金授权回调入参，fundAuthQueryRespModel={}",fundAuthQueryRespModel);
        //1.更新资金授权订单
        FundAuthOrderDO fundAuthOrderDO = new FundAuthOrderDO();
        BeanUtils.copyProperties(fundAuthQueryRespModel,fundAuthOrderDO);
        LOGGER.info("[NotifyServiceImpl-fundAuthNotify]资金授权回调更新资金授权订单，fundAuthOrderDO={}",fundAuthOrderDO);
        int fundAuthOrderRow = fundAuthOrderMapper.updateFundAuthOrderInfo(fundAuthOrderDO);
        //2.更新资金授权操作流水订单
        FundAuthOperationDO fundAuthOperationDO = new FundAuthOperationDO();
        BeanUtils.copyProperties(fundAuthQueryRespModel,fundAuthOperationDO);
        LOGGER.info("[NotifyServiceImpl-fundAuthNotify]资金授权回调更新资金授权操作流水，fundAuthOperationDO={}",fundAuthOperationDO);
        int fundAuthOperationRow = fundAuthOperationMapper.updateFundAuthOperationInfo(fundAuthOperationDO);

        if (fundAuthOrderRow == 0 ||  fundAuthOperationRow ==0){
            throw new RuntimeException();
        }
    }

    @Override
    @Async
    public void notifyMerchant(FundAuthQueryRespModel fundAuthQueryRespModel) {
        /*RestTemplate restTemplate = new RestTemplate();
        fundAuthQueryRespModel.setStatus("1");
        restTemplate.postForObject("",fundAuthQueryRespModel,String.class);*/
    }
}
