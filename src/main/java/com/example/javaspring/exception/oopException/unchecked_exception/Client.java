package com.example.javaspring.exception.oopException.unchecked_exception;

public class Client {
    public void throwsUncheckedExceptionMethod() {
        throw new UncheckedException();
    }

    public void tryCatchUncheckedExceptionMethod() {
        try {
            throw new UncheckedException();
        } catch (UncheckedException e) {
            // 예외에 대한 적절한 처리
            e.printStackTrace();
        }
    }
}
