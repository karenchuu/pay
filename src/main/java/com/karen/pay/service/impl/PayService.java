package com.karen.pay.service.impl;

import com.karen.pay.service.IPayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class PayService implements IPayService {
    @Override
    public PayResponse create(String orderId, BigDecimal amount) {

        //微信支付配置
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId("wx3e6b9f1c5a7ff034");     // 公众号Id
        wxPayConfig.setMchId("1614433647");     // 商戶id
        wxPayConfig.setMchKey("Aa111111111122222222223333333333");    // 商戶密鑰
        wxPayConfig.setNotifyUrl("http://127.0.0.1"); // 接受支付平台異步通知地址

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);

        PayRequest request = new PayRequest();
        request.setOrderId(orderId);
        request.setOrderName("微信Native支付測試訂單");
        request.setOrderAmount(amount.doubleValue());
        request.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);

        PayResponse response = bestPayService.pay(request);
        log.info("response={}", response);
        return response;
    }
}