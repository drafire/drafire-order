package com.drafire.service;

import com.drafire.DoOrderRequest;
import com.drafire.DoOrderResponse;
import com.drafire.IOrderServices;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("orderService2")
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
