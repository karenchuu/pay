# pay

> 1. **快速體驗項目**：[DEMO](http://ec2-54-215-191-12.us-west-1.compute.amazonaws.com/) 。
> 2.  本項目為電商平台和通用性支付系统，電商平台請往[這邊](https://github.com/karenchuu/Ecommerce)。


## 項目簡介

本項目是一套電商平台+通用型支付系統的雙系統項目，基於SpringBoot+MyBatis实现。
使用MySQL作為存儲層，Redis存儲購物車的商品，使用 Nginx 服務器實現反向代理，部署於AWS，支付系統串接微信和支付寶，並使用RabbitMQ實現支付的異步通知。

本項目為電商平台和通用性支付系统，這是支付系統，電商平台請往[這邊](https://github.com/karenchuu/Ecommerce)。

## 支付系統功能

1. 使用 MQ 實現支付與電商平台訂單模塊之間消息的異步通知
2. 串接微信支付和支付寶，構建支付系統

