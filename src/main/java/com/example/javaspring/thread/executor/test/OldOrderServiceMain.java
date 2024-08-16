package com.example.javaspring.thread.executor.test;

import java.util.concurrent.ExecutionException;

public class OldOrderServiceMain {
    public static void main(String[] args) {
        String orderNo = "Order#1234"; // 예시 주문 번호
        OldOrderService orderService = new OldOrderService();
        try {
            orderService.order(orderNo);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}