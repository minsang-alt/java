package com.example.javaspring.studyInterface.section0;

public class Client {
    public void someMethod() {
        // 메시지 보내기 전 실행되는 어떤 작업
        FakeMessageSender messageSender = new FakeMessageSender();
        messageSender.send();
    }
}
