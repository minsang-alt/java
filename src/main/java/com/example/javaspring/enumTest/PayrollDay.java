package com.example.javaspring.enumTest;

import static com.example.javaspring.enumTest.PayrollDay.PayType.WEEKDAY;

import static com.example.javaspring.enumTest.PayrollDay.PayType.WEEKEND;

public enum PayrollDay {
        MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY), THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
        SATURDAY(WEEKEND), SUNDAY(WEEKEND);

        private final PayType payType;

        PayrollDay(PayType payType){this.payType = payType;}
        int pay(int price,int payRate){
            return payType.pay(price,payRate);
        }


        enum PayType{
            WEEKDAY{
                int payPattern(int basePay){
                    return basePay/2;
                }
            },
            WEEKEND{
                int payPattern(int basePay){
                    return basePay*2;
                }
            };

            abstract int payPattern(int basePay);

            int pay(int price,int payRate){
                int basePay = price * payRate;
                return payPattern(basePay);
            }

        }

}
