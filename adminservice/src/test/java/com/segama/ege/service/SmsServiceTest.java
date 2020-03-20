package com.segama.ege.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmsServiceTest {

    @Test
    public void verify() {
        SmsService smsService = new SmsService();
        boolean verify = smsService.verify("998877", "13472867511");
        System.out.println(verify);
    }
}