package com.gaoyang.service.pay.trade.controller;

import com.gaoyang.service.constant.ResponseEnum;
import com.gaoyang.service.model.ResponseModel;
import com.gaoyang.service.pay.trade.util.RouteUtil;
import com.gaoyang.service.util.LogExceptionWapper;
import com.gaoyang.service.pay.trade.model.*;
import com.gaoyang.service.pay.trade.service.TradeService;
import com.gaoyang.service.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 统一交易操作通用接口
 */
@RestController
@RequestMapping("/trade")
public class TradeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeController.class);
    @Autowired
    ApplicationContext applicationContext;

    /**
     * 统一交易支付操作
     * @param tradePayReqModel
     * @return
     */
    @PostMapping("/pay")
    public ResponseModel<TradePayRespModel> pay(@RequestBody TradePayReqModel tradePayReqModel){
        LOGGER.info("[TradeController-pay]统一交易支付入参,tradePayReqModel={}", tradePayReqModel);

        try {
            String payPlatform = tradePayReqModel.getPayPlatform();
            String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
            TradeService tradeService = applicationContext.getBean(serviceName,TradeService.class);
            TradePayRespModel tradePayRespModel = tradeService.pay(tradePayReqModel);

            LOGGER.info("[TradeController-pay]统一交易支付成功,tradePayRespModel={}", tradePayRespModel);
            return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, tradePayRespModel);
        }catch (Exception e){
            LOGGER.error("[TradeController-pay]统一交易支付【异常】,e={}", LogExceptionWapper.getStackTrace(e));
            return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
        }
    }

    /**
     * 统一交易退款操作
     * @param tradeRefundReqModel
     * @return
     */
    @PostMapping("/refund")
    public ResponseModel<TradeRefundRespModel> refund(@RequestBody TradeRefundReqModel tradeRefundReqModel){
        LOGGER.info("[TradeController-refund]统一交易退款入参,tradeRefundReqModel={}", tradeRefundReqModel);

        try {
            String payPlatform = tradeRefundReqModel.getPayPlatform();
            String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
            TradeService tradeService = applicationContext.getBean(serviceName,TradeService.class);
            TradeRefundRespModel tradeRefundRespModel = tradeService.refund(tradeRefundReqModel);

            LOGGER.info("[TradeController-refund]统一交易退款成功,tradePayRespModel={}", tradeRefundRespModel);
            return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, tradeRefundRespModel);
        }catch (Exception e){
            LOGGER.error("[TradeController-refund]统一交易退款成功【异常】,e={}", LogExceptionWapper.getStackTrace(e));
            return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
        }
    }

    /**
     * 统一交易查询操作
     * @param tradeQueryReqModel
     * @return
     */
    @PostMapping("/tradeQuery")
    public ResponseModel<TradeQueryRespModel> tradeQuery(@RequestBody TradeQueryReqModel tradeQueryReqModel){
        LOGGER.info("[TradeController-tradeQuery]统一交易查询入参,tradeQueryReqModel={}", tradeQueryReqModel);

        try {
            String payPlatform = tradeQueryReqModel.getPayPlatform();
            String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
            TradeService tradeService = applicationContext.getBean(serviceName,TradeService.class);
            TradeQueryRespModel tradeQueryRespModel = tradeService.tradeQuery(tradeQueryReqModel);

            LOGGER.info("[TradeController-tradeQuery]统一交易查询成功,tradeQueryReqModel={}", tradeQueryReqModel);
            return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, tradeQueryRespModel);
        }catch (Exception e){
            LOGGER.error("[TradeController-tradeQuery]统一交易查询成功【异常】,e={}", LogExceptionWapper.getStackTrace(e));
            return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
        }
    }

    /**
     * 统一交易退款查询操作
     * @param tradeRefundQueryReqModel
     * @return
     */
    @PostMapping("/refundQuery")
    public ResponseModel<TradeRefundQueryRespModel> refundQuery(@RequestBody TradeRefundQueryReqModel tradeRefundQueryReqModel){
        LOGGER.info("[TradeController-refundQuery]统一交易退款入参,tradeRefundQueryReqModel={}", tradeRefundQueryReqModel);

        try {
            String payPlatform = tradeRefundQueryReqModel.getPayPlatform();
            String serviceName = RouteUtil.findServiceNameByRule(payPlatform);
            TradeService tradeService = applicationContext.getBean(serviceName,TradeService.class);
            TradeRefundQueryRespModel tradeRefundQueryRespModel  = tradeService.refundQuery(tradeRefundQueryReqModel);

            LOGGER.info("[TradeController-refundQuery]统一交易退款成功,tradeRefundQueryReqModel={}", tradeRefundQueryRespModel);
            return ResponseUtil.generateResponseModel(ResponseEnum.SUCCESS_ENUM, tradeRefundQueryRespModel);
        }catch (Exception e){
            LOGGER.error("[TradeController-refundQuery]统一交易退款成功【异常】,e={}", LogExceptionWapper.getStackTrace(e));
            return ResponseUtil.generateResponseModel(ResponseEnum.ERROR_ENUM);
        }
    }


}
