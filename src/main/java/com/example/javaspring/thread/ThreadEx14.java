package com.example.javaspring.thread;

import javax.swing.*;

public class ThreadEx14 {
    public static void main(String[] args) {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 "+input+"입니다.");
        th1.interrupt(); // interrupted상태가 true가 된다. + interruptedException이 발생 하여 일시정지인 스레드를 깨운다 => false로 자동초기화
        System.out.println("th1.isInterrupted() = " + th1.isInterrupted());
    }

}
class ThreadEx14_1 extends Thread{
    public void run(){
        int i = 10;
        while(i!=0 && !isInterrupted()){
            System.out.println(i--);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
            //   interrupt(); 추가하지 않으면 카운트가 계속된다.
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}
