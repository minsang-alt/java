package com.example.javaspring.exception.oopException.unchecked_exception;

public class UncheckedExceptionExampleMain {
    public static void main(String[] args) {
        Client client = new Client();

        try {
            client.throwsUncheckedExceptionMethod();
        } catch (UncheckedException e) {
            // 예외에 대한 적절한 처리
        }

        client.tryCatchUncheckedExceptionMethod();
    }
}
