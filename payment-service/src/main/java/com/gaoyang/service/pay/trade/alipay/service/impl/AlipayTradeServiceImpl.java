package com.gaoyang.service.pay.trade.alipay.service.impl;

import com.gaoyang.service.pay.trade.alipay.integration.AlipayTradeIntegration;
import com.gaoyang.service.pay.trade.model.*;
import com.gaoyang.service.pay.trade.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("alipayTradeService")
public class AlipayTradeServiceImpl implements TradeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayTradeServiceImpl.class);
    @Autowired
    AlipayTradeIntegration alipayTradeIntegration;
    @Override
    public TradePayRespModel pay(TradePayReqModel tradePayReqModel) throws Exception{
        LOGGER.info("[AlipayTradeServiceImpl-pay]支付入参,tradePayReqModel={}",tradePayReqModel);
        //1.调支付宝支付接口
        /*tradePayReqModel.setTradeNo(UUIDUtil.getUUID());*/
        TradePayRespModel tradePayRespModel = alipayTradeIntegration.pay(tradePayReqModel);
        //2.创建支付操作流水

        return tradePayRespModel;
    }

    @Override
    public TradeRefundRespModel refund(TradeRefundReqModel tradeRefundReqModel) {
        return null;
    }

    @Override
    public TradeQueryRespModel tradeQuery(TradeQueryReqModel tradeQueryReqModel) throws Exception{
        return alipayTradeIntegration.tradeQuery(tradeQueryReqModel);
    }

    @Override
    public TradeRefundQueryRespModel refundQuery(TradeRefundQueryReqModel tradeRefundQueryReqModel) {
        return null;
    }
}
