package com.gaoyang.service.pay.trade.service;

import com.gaoyang.service.pay.trade.model.*;


/**
 * 统一交易操作服务接口
 */
public interface TradeService {
    /**
     * 统一交易支付操作
     * @param tradePayReqModel
     * @return
     */
    TradePayRespModel pay(TradePayReqModel tradePayReqModel) throws Exception;

    /**
     * 统一交易退款操作
     * @param tradeRefundReqModel
     * @return
     */
    TradeRefundRespModel refund(TradeRefundReqModel tradeRefundReqModel);

    /**
     * 统一交易查询操作
     * @param tradeQueryReqModel
     * @return
     */
    TradeQueryRespModel tradeQuery(TradeQueryReqModel tradeQueryReqModel)throws Exception;

    /**
     * 统一交易退款查询操作
     * @param tradeRefundQueryReqModel
     * @return
     */
    TradeRefundQueryRespModel refundQuery(TradeRefundQueryReqModel tradeRefundQueryReqModel);

}
