package com.gaoyang.service.pay.trade.alipay.integration.integrationImpl;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import com.gaoyang.service.pay.trade.alipay.integration.AlipayTradeIntegration;
import com.gaoyang.service.pay.trade.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付宝统一交易防腐层接口实现
 */
@Component
public class AlipayTradeIntegrationImpl implements AlipayTradeIntegration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayTradeIntegrationImpl.class);
    @Autowired
    private AlipayClient alipayClient;
    @Override
    public TradePayRespModel pay(TradePayReqModel tradePayReqModel)throws Exception{
        AlipayTradePayRequest payRequest = new AlipayTradePayRequest();
        AlipayTradePayModel payModel = convertModel(tradePayReqModel);
        payRequest.setNotifyUrl("http://zhangtc.free.idcfengye.com/notify/fundauth");//todo
        payRequest.setBizModel(payModel);

        AlipayTradePayResponse payResp = alipayClient.execute(payRequest);
        if (payResp.isSuccess()){
            LOGGER.info("[AlipayTradeIntegrationImpl-pay]调用sdk授权转支付调用成功");
        }else{
            LOGGER.info("[AlipayTradeIntegrationImpl-pay]调用sdk授权转支付调用失败");
        }

        TradePayRespModel tradePayRespModel = convertModel(payResp);
        return tradePayRespModel;
    }

    @Override
    public TradeRefundRespModel refund(TradeRefundReqModel tradeRefundReqModel) throws Exception{
        AlipayTradeRefundRequest refundRequest = new AlipayTradeRefundRequest();
        AlipayTradeRefundModel refundModel = convertModel(tradeRefundReqModel);
        refundRequest.setBizModel(refundModel);

        AlipayTradeRefundResponse refundResp = alipayClient.execute(refundRequest);
        if (refundResp.isSuccess()){
            LOGGER.info("[AlipayFundAuthIntegrationImpl-refund]调用sdk退款调用成功");
        }else{
            LOGGER.info("[AlipayFundAuthIntegrationImpl-refund]调用sdk退款调用失败");
        }
        TradeRefundRespModel tradeRefundRespModel = convertModel(refundResp);
        return tradeRefundRespModel;
    }

    @Override
    public TradeQueryRespModel tradeQuery(TradeQueryReqModel tradeQueryReqModel) throws Exception{
        AlipayTradeQueryRequest tradeQueryRequest = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel alipayTradeQueryModel = convertModel(tradeQueryReqModel);
        tradeQueryRequest.setBizModel(alipayTradeQueryModel);

        AlipayTradeQueryResponse tradeQueryResp = alipayClient.execute(tradeQueryRequest);
        LOGGER.info("[AlipayFundAuthIntegrationImpl-tradeQuery]调用sdk查询支付订单出参tradeQueryResp={}",tradeQueryResp);
        if (tradeQueryResp.isSuccess()){
            LOGGER.info("[AlipayFundAuthIntegrationImpl-tradeQuery]调用sdk查询支付订单调用成功");
        }else{
            LOGGER.info("[AlipayFundAuthIntegrationImpl-tradeQuery]调用sdk查询支付订单调用失败");
        }

        TradeQueryRespModel tradeQueryRespModel = convertModel(tradeQueryResp);
        return tradeQueryRespModel;
    }

    @Override
    public TradeRefundQueryRespModel refundQuery(TradeRefundQueryReqModel tradeRefundQueryReqModel)throws Exception {
        AlipayTradeFastpayRefundQueryRequest refundQueryRequest = new AlipayTradeFastpayRefundQueryRequest();
        AlipayTradeFastpayRefundQueryModel refundQueryModel = convertModel(tradeRefundQueryReqModel);
        refundQueryRequest.setBizModel(refundQueryModel);

        AlipayTradeFastpayRefundQueryResponse refundQueryResp = alipayClient.execute(refundQueryRequest);
        if (refundQueryResp.isSuccess()){
            LOGGER.info("[AlipayFundAuthIntegrationImpl-tradeQuery]调用sdk查询退款订单调用成功");
        }else{
            LOGGER.info("[AlipayFundAuthIntegrationImpl-tradeQuery]调用sdk查询退款订单调用失败");
        }
        TradeRefundQueryRespModel tradeRefundQueryRespModel = convertModel(refundQueryResp);
        return tradeRefundQueryRespModel;
    }


    /**
     * 统一交易支付请求模型转换
     * @param tradePayReqModel
     * @return
     */
    private AlipayTradePayModel convertModel(TradePayReqModel tradePayReqModel){
        AlipayTradePayModel alipayTradePayModel = new AlipayTradePayModel();
        alipayTradePayModel.setOutTradeNo(tradePayReqModel.getTradeNo());//todo
        alipayTradePayModel.setAuthNo(tradePayReqModel.getOutAuthNo());
        alipayTradePayModel.setSubject(tradePayReqModel.getSubject());
        alipayTradePayModel.setTotalAmount(tradePayReqModel.getTotalAmount());
        alipayTradePayModel.setSellerId(tradePayReqModel.getSellerId());
        alipayTradePayModel.setBuyerId(tradePayReqModel.getBuyerId());
        alipayTradePayModel.setBody(tradePayReqModel.getBody());
        alipayTradePayModel.setProductCode("PRE_AUTH_ONLINE");
        alipayTradePayModel.setAuthConfirmMode(tradePayReqModel.getAuthConfirmMode());
        return alipayTradePayModel;
    }

    /**
     * 统一交易支付响应模型转换
     * @param alipayTradePayResponse
     * @return
     */
    private TradePayRespModel convertModel(AlipayTradePayResponse alipayTradePayResponse){
        TradePayRespModel tradePayRespModel = new TradePayRespModel();
        tradePayRespModel.setOutTradeNo(alipayTradePayResponse.getTradeNo());
        tradePayRespModel.setTradeNo(alipayTradePayResponse.getOutTradeNo());
        tradePayRespModel.setBuyerLogonId(alipayTradePayResponse.getBuyerLogonId());
        tradePayRespModel.setBuyerUserId(alipayTradePayResponse.getBuyerUserId());
        tradePayRespModel.setTotalAmount(alipayTradePayResponse.getTotalAmount());
        tradePayRespModel.setReceiptAmount(alipayTradePayResponse.getReceiptAmount());
        tradePayRespModel.setGmtPayment(alipayTradePayResponse.getGmtPayment());
        return tradePayRespModel;
    }

    /**
     * 统一交易退款请求模型转换
     * @param tradeRefundReqModel
     * @return
     */
    private AlipayTradeRefundModel convertModel(TradeRefundReqModel tradeRefundReqModel){
        AlipayTradeRefundModel alipayTradeRefundModel = new AlipayTradeRefundModel();
        alipayTradeRefundModel.setOutTradeNo(tradeRefundReqModel.getTradeNo());
        alipayTradeRefundModel.setTradeNo(tradeRefundReqModel.getOutTradeNo());
        alipayTradeRefundModel.setOutRequestNo(tradeRefundReqModel.getOperationId());
        alipayTradeRefundModel.setRefundAmount(tradeRefundReqModel.getAmount());
        alipayTradeRefundModel.setRefundReason(tradeRefundReqModel.getRefundReason());
        return alipayTradeRefundModel;
    }

    /**
     * 统一交易退款响应模型转换
     * @param alipayTradeRefundResponse
     * @return
     */
    private TradeRefundRespModel convertModel(AlipayTradeRefundResponse alipayTradeRefundResponse){
        TradeRefundRespModel tradeRefundRespModel = new TradeRefundRespModel();
        tradeRefundRespModel.setTradeNo(alipayTradeRefundResponse.getOutTradeNo());
        tradeRefundRespModel.setOutTradeNo(alipayTradeRefundResponse.getTradeNo());
        tradeRefundRespModel.setRefundFee(alipayTradeRefundResponse.getRefundFee());
        tradeRefundRespModel.setBuyerLogonId(alipayTradeRefundResponse.getBuyerLogonId());
        tradeRefundRespModel.setBuyerUserId(alipayTradeRefundResponse.getBuyerUserId());
        tradeRefundRespModel.setFundChange(alipayTradeRefundResponse.getFundChange());
        tradeRefundRespModel.setGmtRefundPay(alipayTradeRefundResponse.getGmtRefundPay());
        return tradeRefundRespModel;
    }

    /**
     * 统一交易查询请求模型转换
     * @param tradeQueryReqModel
     * @return
     */
    private AlipayTradeQueryModel convertModel(TradeQueryReqModel tradeQueryReqModel){
        AlipayTradeQueryModel alipayTradeQueryModel = new AlipayTradeQueryModel();
        alipayTradeQueryModel.setOutTradeNo(tradeQueryReqModel.getTradeNo());
        alipayTradeQueryModel.setTradeNo(tradeQueryReqModel.getOutTradeNo());
        return alipayTradeQueryModel;
    }

    /**
     * 统一交易查询响应模型转换
     * @param alipayTradeQueryResponse
     * @return
     */
    private TradeQueryRespModel convertModel(AlipayTradeQueryResponse alipayTradeQueryResponse){
        TradeQueryRespModel tradeQueryRespModel = new TradeQueryRespModel();
        tradeQueryRespModel.setOutTradeNo(alipayTradeQueryResponse.getTradeNo());
        tradeQueryRespModel.setTradeNo(alipayTradeQueryResponse.getOutTradeNo());
        tradeQueryRespModel.setBuyerLogonId(alipayTradeQueryResponse.getBuyerLogonId());
        tradeQueryRespModel.setTradeStatus(alipayTradeQueryResponse.getTradeStatus());
        tradeQueryRespModel.setTotalAmount(alipayTradeQueryResponse.getTotalAmount());
        tradeQueryRespModel.setBuyerUserId(alipayTradeQueryResponse.getBuyerUserId());
        return tradeQueryRespModel;
    }

    /**
     * 统一交易退款查询请求模型转换
     * @param tradeRefundQueryReqModel
     * @return
     */
    private AlipayTradeFastpayRefundQueryModel convertModel(TradeRefundQueryReqModel tradeRefundQueryReqModel){
        AlipayTradeFastpayRefundQueryModel alipayTradeFastpayRefundQueryModel = new AlipayTradeFastpayRefundQueryModel();
        alipayTradeFastpayRefundQueryModel.setTradeNo(tradeRefundQueryReqModel.getOutTradeNo());
        alipayTradeFastpayRefundQueryModel.setOutTradeNo(tradeRefundQueryReqModel.getTradeNo());
        alipayTradeFastpayRefundQueryModel.setOutRequestNo(tradeRefundQueryReqModel.getOperationId());
        return alipayTradeFastpayRefundQueryModel;
    }

    /**
     * 统一交易退款查询响应模型转换
     * @param alipayTradeFastpayRefundQueryResponse
     * @return
     */
    private TradeRefundQueryRespModel convertModel(AlipayTradeFastpayRefundQueryResponse alipayTradeFastpayRefundQueryResponse){
        TradeRefundQueryRespModel tradeRefundQueryRespModel = new TradeRefundQueryRespModel();
        tradeRefundQueryRespModel.setOutTradeNo(alipayTradeFastpayRefundQueryResponse.getTradeNo());
        tradeRefundQueryRespModel.setTradeNo(alipayTradeFastpayRefundQueryResponse.getOutTradeNo());
        tradeRefundQueryRespModel.setOperationId(alipayTradeFastpayRefundQueryResponse.getOutRequestNo());
        tradeRefundQueryRespModel.setRefundReason(alipayTradeFastpayRefundQueryResponse.getRefundReason());
        tradeRefundQueryRespModel.setTotalAmount(alipayTradeFastpayRefundQueryResponse.getTotalAmount());
        tradeRefundQueryRespModel.setRefundAmount(alipayTradeFastpayRefundQueryResponse.getRefundAmount());
        tradeRefundQueryRespModel.setGmtRefundPay(alipayTradeFastpayRefundQueryResponse.getGmtRefundPay());
        return tradeRefundQueryRespModel;
    }
}
