package com.drafire.service;

import com.drafire.DoOrderRequest;
import com.drafire.DoOrderResponse;
import com.drafire.IOrderServices;
import org.springframework.stereotype.Service;

@Service("orderService1")
public class OrderServiceImpl implements IOrderServices {


    public DoOrderResponse doOrder(DoOrderRequest request) {
        System.out.println("曾经来过："+request);
        DoOrderResponse response=new DoOrderResponse();
        response.setCode("1141");
        response.setMemo("drafire的首个dubbo啊");
        return response;
    }
}
