package com.karen.pay.service;

import com.karen.pay.pojo.PayInfo;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;

import java.math.BigDecimal;

public interface IPayService {
    /**
     * 發起支付
     */
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

    /**
     * 異步通知處理
     * @param notifyData
     */
    String asyncNotify(String notifyData);

    /**
     * 查詢支付紀錄(通過訂單號)
     * @param orderId
     * @return
     */
    PayInfo queryByOrderId(String orderId);
}
