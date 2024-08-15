package com.example.javaspring.thread.sync;

import static com.example.javaspring.thread.AbstractLogger.log;

import com.example.javaspring.thread.ThreadUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountV1 implements BankAccount {

    private final Lock lock = new ReentrantLock();

    private int balance;

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래시작: " + getClass().getSimpleName());
        // 잔고가 출금액 보다 적으면, 진행하면 안된다.

        lock.lock();
        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            // 잔고가 출금액 보다 많으면, 진행
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            ThreadUtils.sleep(1000);
            balance = balance - amount;
        } finally {
            lock.unlock();
        }

        log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        log("거래 종료");

        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
