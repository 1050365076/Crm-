package com.xy.study;

public class ThreadClassT implements Runnable {
    @Override
    public void run() {
        System.out.println("jinlai");
    }


   public static  void  main(String [] args){

           ThreadClassT threadClass = new ThreadClassT();
           threadClass.run();

   }
}
