package com.example.javaspring.enumTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductsTest {

    @Test
    void 값_꺼내오기(){
        Products p = Products.SAMSUNG;
        System.out.println("p = " + p);
        Products p1 = Products.valueOf("GRAM");
        System.out.println("p1 = " + p1);
        Products[] products = Products.values();
        System.out.println("products.toString() = " + Arrays.toString(products));
        Products mac = Enum.valueOf(Products.class, "MAC");
        System.out.println("mac = " + mac);
    }

}