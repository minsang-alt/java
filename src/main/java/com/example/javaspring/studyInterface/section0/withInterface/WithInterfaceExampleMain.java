package com.example.javaspring.studyInterface.section0.withInterface;

public class WithInterfaceExampleMain {
    public static void main(String[] args) {
        MessageSender messageSender = new FakeMessageSender();
        Client client = new Client(messageSender);
        client.someMethod();
    }
}
