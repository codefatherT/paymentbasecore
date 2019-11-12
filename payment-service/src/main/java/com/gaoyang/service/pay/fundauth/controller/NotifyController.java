package com.gaoyang.service.pay.fundauth.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.response.AlipayFundAuthOperationDetailQueryResponse;
import com.gaoyang.service.pay.fundauth.model.FundAuthQueryRespModel;
import com.gaoyang.service.pay.fundauth.service.impl.NotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * 支付平台回调接口
 */
@RestController()
@RequestMapping("/notify")
public class NotifyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotifyController.class);
    public static final String SUCCESS = "success";
    @Autowired
    private NotifyService notifyService;

    @PostMapping("/fundauth")
    public String fundAuthNotify(HttpServletRequest httpServletRequest){
        HashMap<String,String> map = new HashMap<>();
        Enumeration<String> paraNames =  httpServletRequest.getParameterNames();
        for(Enumeration e=paraNames;e.hasMoreElements();){
            String key = e.nextElement().toString();
            String value = httpServletRequest.getParameter(key);
            map.put(key,value);
        }
        System.out.println(JSON.toJSONString(map));
        FundAuthQueryRespModel fundAuthQueryRespModel = JSONObject.parseObject(JSON.toJSONString(map),FundAuthQueryRespModel.class);
        LOGGER.info("[NotifyController-fundAuthNotify]资金授权回调入参fundAuthQueryRespModel={}",fundAuthQueryRespModel);

        //验签处理
        try {
            //1.业务逻辑处理
            notifyService.fundAuthNotify(fundAuthQueryRespModel);
            //2.回调通知商户
            /*notifyService.notifyMerchant(fundAuthQueryRespModel)*/;

            return SUCCESS;
        }catch (Exception e){
            LOGGER.error("[NotifyController-fundAuthNotify]资金授权回调业务逻辑处理出错");
            return "";
        }
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
