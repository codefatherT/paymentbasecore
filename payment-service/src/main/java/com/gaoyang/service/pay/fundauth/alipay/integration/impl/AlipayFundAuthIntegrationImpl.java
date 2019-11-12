package com.gaoyang.service.pay.fundauth.alipay.integration.impl;


import com.alipay.api.AlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.gaoyang.service.exception.CallThirdException;
import com.gaoyang.service.pay.fundauth.alipay.integration.AlipayFundAuthIntegration;
import com.gaoyang.service.pay.fundauth.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 调用支付宝资金授权操作防腐层实现
 */
@Component
public class AlipayFundAuthIntegrationImpl implements AlipayFundAuthIntegration {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlipayFundAuthIntegrationImpl.class);
    @Autowired
    private AlipayClient alipayClient;
    @Value("${fund_auth_freeze_notify_url}")
    private String notifyUrl;
    @Override
    public FundAuthFreezeRespModel freeze(FundAuthFreezeReqModel fundAuthFreezeReqModel) throws Exception {
        LOGGER.info("[AlipayFundAuthIntegrationImpl-freeze]资金授权冻结入参，fundAuthFreezeReqModel={}");
        //1.组装请求参数
        AlipayFundAuthOrderAppFreezeRequest freezeRequest = new AlipayFundAuthOrderAppFreezeRequest();
        AlipayFundAuthOrderAppFreezeModel freezeModel = convertModel(fundAuthFreezeReqModel);
        freezeRequest.setBizModel(freezeModel);
        freezeRequest.setNotifyUrl(notifyUrl);

        //2.调用支付宝sdk给订单请求参数加签
        AlipayFundAuthOrderAppFreezeResponse freezeResp = alipayClient.sdkExecute(freezeRequest);
        LOGGER.info("[AlipayFundAuthIntegrationImpl-freeze]调用支付宝sdk加签出参,freezeResp={}",freezeResp);
        //3.判断调用结果
        if (freezeResp.isSuccess()){//3.1成功
            LOGGER.info("[AlipayFundAuthIntegrationImpl-freeze]调用sdk加签成功");
            //3.1.组装响应参数
            FundAuthFreezeRespModel fundAuthFreezeRespModel = new FundAuthFreezeRespModel();
            fundAuthFreezeRespModel.setSignResult(freezeResp.getBody());
            LOGGER.info("[AlipayFundAuthIntegrationImpl-freeze]资金授权冻结出参，fundAuthFreezeRespModel={}",fundAuthFreezeRespModel);
            return fundAuthFreezeRespModel;
        }

        //3.2失败
        LOGGER.info("[AlipayFundAuthIntegrationImpl-freeze]调用sdk加签失败");
        throw new CallThirdException("调用sdk加签失败");
    }

    @Override
    public FundAuthUnFreezeRespModel unFreeze(FundAuthUnFreezeReqModel fundAuthUnFreezeReqModel) throws Exception {
        LOGGER.info("[AlipayFundAuthIntegrationImpl-freeze]资金授权解冻入参，fundAuthUnFreezeReqModel={}",fundAuthUnFreezeReqModel);
        //1.组装请求参数
        AlipayFundAuthOrderUnfreezeRequest unfreezeRequest = new AlipayFundAuthOrderUnfreezeRequest();
        AlipayFundAuthOrderUnfreezeModel unfreezeModel = convertModel(fundAuthUnFreezeReqModel);
        unfreezeRequest.setBizModel(unfreezeModel);
        unfreezeRequest.setNotifyUrl(notifyUrl);

        //2.调用支付宝资金授权解冻接口
        LOGGER.info("[AlipayFundAuthIntegrationImpl-unFreeze]调用支付宝sdk解冻入参,unfreezeRequest={}",unfreezeRequest);
        AlipayFundAuthOrderUnfreezeResponse unFreezeResp =  alipayClient.execute(unfreezeRequest);
        LOGGER.info("[AlipayFundAuthIntegrationImpl-unFreeze]调用支付宝sdk解冻出参,unFreezeResp={}",unFreezeResp);
        //3.判断调用结果
        if (unFreezeResp.isSuccess()){//3.1得到成功响应
            LOGGER.info("[AlipayFundAuthIntegrationImpl-unFreeze]调用支付宝sdk解冻接口成功");
            FundAuthUnFreezeRespModel fundAuthUnFreezeRespModel = convertModel(unFreezeResp);
            return fundAuthUnFreezeRespModel;
        }

        //3.2调用支付宝解冻接口失败
        LOGGER.info("[AlipayFundAuthIntegrationImpl-unFreeze]调用支付宝sdk解冻接口失败");
        throw new CallThirdException("支付宝sdk解冻接口失败");
    }

    @Override
    public FundAuthQueryRespModel fundAuthQuery(FundAuthQueryReqModel fundAuthQueryReqModel) throws Exception {
        LOGGER.info("[AlipayFundAuthIntegrationImpl-detailQuery]资金授权统一操作查询入参，fundAuthQueryReqModel={}",fundAuthQueryReqModel);
        //1.组装请求参数
        AlipayFundAuthOperationDetailQueryRequest queryRequest = new AlipayFundAuthOperationDetailQueryRequest();
        AlipayFundAuthOperationDetailQueryModel queryModel = convertModel(fundAuthQueryReqModel);
        queryRequest.setBizModel(queryModel);

        //2.调用支付宝资金授权统一查询接口
        LOGGER.info("[AlipayFundAuthIntegrationImpl-detailQuery]调用支付宝sdk资金授权统一操作查询入参，queryRequest={}",queryRequest);
        AlipayFundAuthOperationDetailQueryResponse queryResp = alipayClient.execute(queryRequest);
        LOGGER.info("[AlipayFundAuthIntegrationImpl-detailQuery]调用支付宝sdk资金授权统一操作查询出参，queryResp={}",queryResp);

        //3.判断调用结果
        if (queryResp.isSuccess()){//得到成功响应
            LOGGER.info("[AlipayFundAuthIntegrationImpl-detailQuery]调用支付宝sdk预授权操作查询调用成功");
            //3.1 组装响应参数
            FundAuthQueryRespModel fundAuthQueryRespModel = convertModel(queryResp);
            return fundAuthQueryRespModel;
        }

        //3.2 失败响应
        LOGGER.info("[AlipayFundAuthIntegrationImpl-detailQuery]调用支付宝sdk预授权操作查询调用失败");
        throw new CallThirdException("支付宝sdk统一资金操作查询失败");
    }

    /**
     * 冻结请求模型转换
     * @param fundAuthFreezeReqModel
     * @return
     */
    private AlipayFundAuthOrderAppFreezeModel convertModel(FundAuthFreezeReqModel fundAuthFreezeReqModel){
        AlipayFundAuthOrderAppFreezeModel alipayFundAuthOrderAppFreezeModel = new AlipayFundAuthOrderAppFreezeModel();
        alipayFundAuthOrderAppFreezeModel.setOrderTitle(fundAuthFreezeReqModel.getOrderTitle());
        alipayFundAuthOrderAppFreezeModel.setOutOrderNo(fundAuthFreezeReqModel.getFundAuthNo());    //todo
        alipayFundAuthOrderAppFreezeModel.setOutRequestNo(fundAuthFreezeReqModel.getOperationId());
        alipayFundAuthOrderAppFreezeModel.setPayeeLogonId(fundAuthFreezeReqModel.getPayeeLogonId());
        alipayFundAuthOrderAppFreezeModel.setProductCode(fundAuthFreezeReqModel.getProductCode());
        alipayFundAuthOrderAppFreezeModel.setAmount(fundAuthFreezeReqModel.getAmount());
        alipayFundAuthOrderAppFreezeModel.setPayeeUserId(fundAuthFreezeReqModel.getPayeeUserId());
        alipayFundAuthOrderAppFreezeModel.setPayTimeout(fundAuthFreezeReqModel.getPayTimeOut());
        alipayFundAuthOrderAppFreezeModel.setEnablePayChannels(fundAuthFreezeReqModel.getEnablePayChannels());
        alipayFundAuthOrderAppFreezeModel.setExtraParam(fundAuthFreezeReqModel.getExtraParam());
        return alipayFundAuthOrderAppFreezeModel;
    }

    /**
     * 解冻请求模型转换
     * @param tradeRefundReqModel
     * @return
     */
    private AlipayFundAuthOrderUnfreezeModel convertModel(FundAuthUnFreezeReqModel tradeRefundReqModel){
        AlipayFundAuthOrderUnfreezeModel alipayFundAuthOrderUnfreezeModel = new AlipayFundAuthOrderUnfreezeModel();
        alipayFundAuthOrderUnfreezeModel.setAuthNo(tradeRefundReqModel.getOutFundAuthNo());
        alipayFundAuthOrderUnfreezeModel.setOutRequestNo(tradeRefundReqModel.getOperationId());
        alipayFundAuthOrderUnfreezeModel.setAmount(tradeRefundReqModel.getAmount());
        alipayFundAuthOrderUnfreezeModel.setRemark(tradeRefundReqModel.getRemark());
        alipayFundAuthOrderUnfreezeModel.setExtraParam(tradeRefundReqModel.getExtraParam());
        return alipayFundAuthOrderUnfreezeModel;
    }

    /**
     * 解冻响应模型转换
     * @param alipayFundAuthOrderUnfreezeResponse
     * @return
     */
    private FundAuthUnFreezeRespModel convertModel(AlipayFundAuthOrderUnfreezeResponse alipayFundAuthOrderUnfreezeResponse){
        FundAuthUnFreezeRespModel fundAuthUnFreezeRespModel = new FundAuthUnFreezeRespModel();
        fundAuthUnFreezeRespModel.setOutFundAuthNo(alipayFundAuthOrderUnfreezeResponse.getAuthNo());
        fundAuthUnFreezeRespModel.setFundAuthNo(alipayFundAuthOrderUnfreezeResponse.getOutOrderNo());
        fundAuthUnFreezeRespModel.setOutOperationId(alipayFundAuthOrderUnfreezeResponse.getOperationId());
        fundAuthUnFreezeRespModel.setOperationId(alipayFundAuthOrderUnfreezeResponse.getOutRequestNo());
        fundAuthUnFreezeRespModel.setAmount(alipayFundAuthOrderUnfreezeResponse.getAmount());
        fundAuthUnFreezeRespModel.setStatus(alipayFundAuthOrderUnfreezeResponse.getStatus());
       return fundAuthUnFreezeRespModel;
    }

    /**
     *  资金授权操作查询请求模型转换
     * @param fundAuthQueryReqModel
     * @return
     */
    private AlipayFundAuthOperationDetailQueryModel convertModel(FundAuthQueryReqModel fundAuthQueryReqModel){
        AlipayFundAuthOperationDetailQueryModel alipayFundAuthOperationDetailQueryModel = new AlipayFundAuthOperationDetailQueryModel();
        alipayFundAuthOperationDetailQueryModel.setAuthNo(fundAuthQueryReqModel.getOutFundAuthNo());
        alipayFundAuthOperationDetailQueryModel.setOutOrderNo(fundAuthQueryReqModel.getFundAuthNo());
        alipayFundAuthOperationDetailQueryModel.setOperationId(fundAuthQueryReqModel.getOutOperationId());
        alipayFundAuthOperationDetailQueryModel.setOutRequestNo(fundAuthQueryReqModel.getOperationId());
        return alipayFundAuthOperationDetailQueryModel;
    }

    /**
     * 资金授权操作查询响应模型转换
     * @param alipayFundAuthOperationDetailQueryResponse
     * @return
     */
    private FundAuthQueryRespModel convertModel(AlipayFundAuthOperationDetailQueryResponse alipayFundAuthOperationDetailQueryResponse){
        FundAuthQueryRespModel fundAuthQueryRespModel = new FundAuthQueryRespModel();
        fundAuthQueryRespModel.setOutFundAuthNo(alipayFundAuthOperationDetailQueryResponse.getAuthNo());
        fundAuthQueryRespModel.setFundAuthNo(alipayFundAuthOperationDetailQueryResponse.getOutOrderNo());
        fundAuthQueryRespModel.setOperationId(alipayFundAuthOperationDetailQueryResponse.getOutRequestNo());
        fundAuthQueryRespModel.setOutOperationId(alipayFundAuthOperationDetailQueryResponse.getOperationId());
        fundAuthQueryRespModel.setTotalFreezeAmount(alipayFundAuthOperationDetailQueryResponse.getTotalFreezeAmount());
        fundAuthQueryRespModel.setRestAmount(alipayFundAuthOperationDetailQueryResponse.getRestAmount());
        fundAuthQueryRespModel.setTotalPayAmount(alipayFundAuthOperationDetailQueryResponse.getTotalPayAmount());
        fundAuthQueryRespModel.setOrderTitle(alipayFundAuthOperationDetailQueryResponse.getOrderTitle());
        fundAuthQueryRespModel.setPayerLogonId(alipayFundAuthOperationDetailQueryResponse.getPayerLogonId());
        fundAuthQueryRespModel.setPayerUserId(alipayFundAuthOperationDetailQueryResponse.getPayerUserId());
        fundAuthQueryRespModel.setAmount(alipayFundAuthOperationDetailQueryResponse.getAmount());
        fundAuthQueryRespModel.setOperationType(alipayFundAuthOperationDetailQueryResponse.getOperationType());
        fundAuthQueryRespModel.setStatus(alipayFundAuthOperationDetailQueryResponse.getStatus());
        fundAuthQueryRespModel.setRemark(alipayFundAuthOperationDetailQueryResponse.getRemark());
        fundAuthQueryRespModel.setGmtCreate(alipayFundAuthOperationDetailQueryResponse.getGmtCreate());
        fundAuthQueryRespModel.setGmtTrans(alipayFundAuthOperationDetailQueryResponse.getGmtTrans());
        return fundAuthQueryRespModel;
    }
}
