package com.karen.pay.config;

import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BestPayConfig {

    @Autowired
    private WxAccountConfig wxAccountConfig;

    @Autowired
    private AlipayAccountConfig alipayAccountConfig;

    @Bean
    public BestPayService bestPayService(WxPayConfig wxPayConfig) {
        AliPayConfig alipayConfig = new AliPayConfig();
        alipayConfig.setAppId(alipayAccountConfig.getAppid());
        alipayConfig.setPrivateKey(alipayAccountConfig.getPrivateKey());
        alipayConfig.setAliPayPublicKey(alipayAccountConfig.getPublicKey());
        alipayConfig.setNotifyUrl(alipayAccountConfig.getNotifyUrl());
        alipayConfig.setReturnUrl(alipayAccountConfig.getReturnUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        bestPayService.setAliPayConfig(alipayConfig);
        return bestPayService;
    }

    @Bean
    public WxPayConfig wxPayConfig() {
        // 微信支付配置
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(wxAccountConfig.getAppid());           // 公众号Id
        wxPayConfig.setMchId(wxAccountConfig.getMchid());           // 商戶id
        wxPayConfig.setMchKey(wxAccountConfig.getMchkey());         // 商戶密鑰
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());   // 接受支付平台異步通知地址
        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());
        return wxPayConfig;
    }
}
