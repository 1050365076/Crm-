package com.xy.study;

public class ThreadClass extends Thread {

    @Override
    public void run(){
        System.out.println("挺好");
    }

    public static void main (String [] args){
        ThreadClass threadClass = new ThreadClass();

        System.out.println("你好");
        try {
            ThreadClass.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadClass.start();
    }

}
