package com.karen.pay.service.impl;

import com.karen.pay.PayApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PayServiceTest extends PayApplicationTests {

    @Autowired
    private PayService payService;

    @Test
    public void create() {
        payService.create("karen_20220410_001", BigDecimal.valueOf(0.01));
    }
}