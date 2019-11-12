package com.gaoyang.service.pay.fundauth.controller;

import com.gaoyang.service.constant.ResponseEnum;
import com.gaoyang.service.model.ResponseModel;
import com.gaoyang.service.pay.fundauth.model.*;
import com.gaoyang.service.pay.fundauth.service.FundAuthService;
import com.gaoyang.service.util.LogExceptionWapper;
import com.gaoyang.service.util.RouteUtil;
import com.gaoyang.service.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 资金授权场景通用接口
 */
@RestController
@RequestMapping("/fundAuth")
public class FundAuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FundAuthController.class);
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 资金授权冻结
     * @return
     */
    @PostMapping("/freeze")
    public ResponseModel<FundAuthFreezeRespModel> freeze(@RequestBody FundAuthFreezeReqModel fundAuthFreezeReqModel){
        LOGGER.info("[FundAuthController-freeze]资金授权冻结入参,fundAuthFreezeReqModel={}", fundAuthFreezeReqModel);

        //1.参数校验

        //2.根据规则枚举匹配到具体的service
       try {
           String payPlatform = fundAuthFreezeReqModel.getPayPlatform();
           String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
           FundAuthService fundAuthService = applicationContext.getBean(serviceName, FundAuthService.class);
           FundAuthFreezeRespModel fundAuthFreezeRespModel = fundAuthService.freeze(fundAuthFreezeReqModel);

           LOGGER.info("[FundAuthController-freeze]资金授权冻结成功,fundAuthFreezeRespModel={}", fundAuthFreezeRespModel);
           return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, fundAuthFreezeRespModel);
       }catch (Exception e){
           LOGGER.error("[FundAuthController-freeze]资金授权冻结【异常】,e={}", LogExceptionWapper.getStackTrace(e));
           return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
       }
    }

    /**
     * 资金授权解冻
     * @param fundAuthUnFreezeReqModel
     * @return
     */
    @PostMapping("/unfreeze")
    public ResponseModel<FundAuthUnFreezeRespModel> unFreeze(@RequestBody FundAuthUnFreezeReqModel fundAuthUnFreezeReqModel){
        LOGGER.info("[FundAuthController-unFreeze]资金授权解冻入参,fundAuthUnFreezeReqModel={}", fundAuthUnFreezeReqModel);

        try {
            String payPlatform = fundAuthUnFreezeReqModel.getPayPlatform();
            String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
            FundAuthService fundAuthService = applicationContext.getBean(serviceName,FundAuthService.class);
            FundAuthUnFreezeRespModel fundAuthUnFreezeRespModel = fundAuthService.unFreeze(fundAuthUnFreezeReqModel);

            LOGGER.info("[FundAuthController-unFreeze]资金授权解冻成功,fundAuthUnFreezeRespModel={}", fundAuthUnFreezeRespModel);
            return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, fundAuthUnFreezeRespModel);
        }catch (Exception e){
            LOGGER.error("[FundAuthController-unFreeze]资金授权解冻【异常】,e={}", LogExceptionWapper.getStackTrace(e));
            return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
        }
    }

    /**
     * 资金授权操作统一查询
     * @param fundAuthQueryReqModel
     * @return
     */
    @PostMapping("/fundAuthQuery")
    public ResponseModel<FundAuthQueryRespModel> fundAuthQuery(@RequestBody FundAuthQueryReqModel fundAuthQueryReqModel){
        LOGGER.info("[FundAuthController-fundAuthQuery]资金授权操作统一查询入参,fundAuthQueryReqModel={}", fundAuthQueryReqModel);

        try {
            String payPlatform = fundAuthQueryReqModel.getPayPlatform();
            String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
            FundAuthService fundAuthService = applicationContext.getBean(serviceName,FundAuthService.class);
            FundAuthQueryRespModel fundAuthQueryRespModel = fundAuthService.fundAuthQuery(fundAuthQueryReqModel);

            LOGGER.info("[FundAuthController-fundAuthQueryRespModel]资金授权操作统一查询成功,fundAuthQueryReqModel={}", fundAuthQueryRespModel);
            return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, fundAuthQueryRespModel);
        }catch (Exception e){
            LOGGER.error("[FundAuthController-fundAuthQueryRespModel]资金授权操作统一查询【异常】,e={}", LogExceptionWapper.getStackTrace(e));
            return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
        }
    }

}
