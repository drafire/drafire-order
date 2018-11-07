package com.drafire;

public class OrderServiceImpl implements IOrderServices{


    public DoOrderResponse doOrder(DoOrderRequest request) {
        System.out.println("曾经来过："+request);
        DoOrderResponse response=new DoOrderResponse();
        response.setCode("1141");
        response.setMemo("drafire的首个dubbo啊");
        return response;
    }
}
