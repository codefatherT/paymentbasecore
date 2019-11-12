package com.gaoyang.service.pay.fundauth.alipay.service.impl;


import com.gaoyang.service.pay.fundauth.alipay.integration.AlipayFundAuthIntegration;
import com.gaoyang.service.pay.fundauth.dal.dobj.FundAuthOperationDO;
import com.gaoyang.service.pay.fundauth.dal.dobj.FundAuthOrderDO;
import com.gaoyang.service.pay.fundauth.dal.mapper.FundAuthOrderMapper;
import com.gaoyang.service.pay.fundauth.dal.mapper.FundAuthOperationMapper;
import com.gaoyang.service.pay.fundauth.model.*;
import com.gaoyang.service.pay.fundauth.service.FundAuthService;
import com.gaoyang.service.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("alipayFundAuthService")
public class AlipayFundAuthServiceImpl implements FundAuthService {
    private static final Logger LOOGER = LoggerFactory.getLogger(AlipayFundAuthServiceImpl.class);
    @Autowired
    private AlipayFundAuthIntegration alipayFundAuthIntegration;
    @Autowired
    private FundAuthOrderMapper fundAuthOrderMapper;
    @Autowired
    private FundAuthOperationMapper fundAuthOperationMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public FundAuthFreezeRespModel freeze(FundAuthFreezeReqModel fundAuthFreezeReqModel) throws Exception {
        LOOGER.info("[AlipayFundAuthServiceImpl-freeze]资金授权冻结入参,fundAuthFreezeReqModel={}",fundAuthFreezeReqModel);
        //1.冻结加签
        String fundAuthNo = UUIDUtil.getUUID();//生成资金授权订单号
        String operationId = UUIDUtil.getUUID();//生成冻结流水号
        fundAuthFreezeReqModel.setFundAuthNo(fundAuthNo);
        fundAuthFreezeReqModel.setOperationId(operationId);
        fundAuthFreezeReqModel.setProductCode("PRE_AUTH_ONLINE");//支付宝销售产品码，固定值
        FundAuthFreezeRespModel fundAuthFreezeRespModel = alipayFundAuthIntegration.freeze(fundAuthFreezeReqModel);

        //2.创建资金授权订单
        FundAuthOrderDO fundAuthOrderDO = new FundAuthOrderDO();
        BeanUtils.copyProperties(fundAuthFreezeReqModel,fundAuthOrderDO);
        LOOGER.info("[AlipayFundAuthServiceImpl-freeze]创建资金授权订单,fundAuthOrderDO={}",fundAuthOrderDO);
        fundAuthOrderMapper.insertFundAuthOrderInfo(fundAuthOrderDO);

        //3.创建冻结操作流水
        FundAuthOperationDO fundAuthOperationDO = new FundAuthOperationDO();
        fundAuthOperationDO.setOperationId(operationId);
        fundAuthOperationDO.setFundAuthNo(fundAuthNo);
        fundAuthOperationDO.setAmount(fundAuthFreezeReqModel.getAmount());
        LOOGER.info("[AlipayFundAuthServiceImpl-freeze]创建资金授权冻结操作流水,fundAuthOperationDO={}",fundAuthOperationDO);
        fundAuthOperationMapper.insertFundAuthOperationInfo(fundAuthOperationDO);

        return fundAuthFreezeRespModel;
    }

    @Override
    public FundAuthUnFreezeRespModel unFreeze(FundAuthUnFreezeReqModel fundAuthUnFreezeReqModel) throws Exception {
        LOOGER.info("[AlipayFundAuthServiceImpl-unFreeze]资金授权解冻入参,fundAuthUnFreezeReqModel={}",fundAuthUnFreezeReqModel);
        //1.调用支付宝解冻接口解冻
        fundAuthUnFreezeReqModel.setOperationId(UUIDUtil.getUUID());
        FundAuthUnFreezeRespModel fundAuthUnFreezeRespModel = alipayFundAuthIntegration.unFreeze(fundAuthUnFreezeReqModel);
        //2.创建解冻操作流水
        FundAuthOperationDO fundAuthOperationDO = new FundAuthOperationDO();
        BeanUtils.copyProperties(fundAuthUnFreezeRespModel,fundAuthOperationDO);
        LOOGER.info("[AlipayFundAuthServiceImpl-unFreeze]创建资金授权解冻操作流水,fundAuthOperationDO={}",fundAuthOperationDO);
        fundAuthOperationMapper.insertFundAuthOperationInfo(fundAuthOperationDO);//todo

        return fundAuthUnFreezeRespModel;
    }

    @Override
    public FundAuthQueryRespModel fundAuthQuery(FundAuthQueryReqModel fundAuthQueryReqModel) throws Exception {
        FundAuthQueryRespModel fundAuthQueryRespModel = alipayFundAuthIntegration.fundAuthQuery(fundAuthQueryReqModel);
        return fundAuthQueryRespModel;
    }
}
