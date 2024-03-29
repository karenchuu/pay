package com.karen.pay.enums;

import com.lly835.bestpay.enums.BestPayTypeEnum;

public enum PayPlatformEnum {

    // 1-支付寶, 2-微信
    ALIPAY(1),
    WX(2),
    ;

    Integer code;

    PayPlatformEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static PayPlatformEnum getByBestPayTypeEnum(BestPayTypeEnum bestPayTypeEnum) {
        for (PayPlatformEnum payPlatformEnum : PayPlatformEnum.values()) {
            if (bestPayTypeEnum.getPlatform().name().equals(payPlatformEnum.name())) {
                return payPlatformEnum;
            }
        }
        throw new RuntimeException("錯誤的支付平台: " + bestPayTypeEnum.name());
    }

}
