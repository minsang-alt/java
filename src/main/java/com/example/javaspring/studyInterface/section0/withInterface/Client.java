package com.example.javaspring.studyInterface.section0.withInterface;

public class Client {
    private MessageSender messageSender;

    Client(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void someMethod() {
        // 메시지 보내기 전 실행되는 어떤 작업

        messageSender.send();
    }
}
