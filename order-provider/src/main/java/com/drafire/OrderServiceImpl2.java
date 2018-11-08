package com.drafire;

import java.util.concurrent.TimeUnit;

public class OrderServiceImpl2 implements IOrderServices {
    @Override
    public DoOrderResponse doOrder(DoOrderRequest request) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("版本2的内容："+request);
        DoOrderResponse response=new DoOrderResponse();
        response.setCode("版本2");
        response.setMemo("版本2实现了多版本啊");
        return response;
    }
}
