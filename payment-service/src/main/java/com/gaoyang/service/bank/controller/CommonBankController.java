package com.gaoyang.service.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用对接银行相关操作
 */
@RestController
@RequestMapping("/commonBank")
public class CommonBankController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonBankController.class);
    @Autowired
    private ApplicationContext applicationContext;


}
