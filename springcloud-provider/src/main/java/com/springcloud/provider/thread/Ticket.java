package com.springcloud.provider.thread;

public class Ticket implements Runnable {
    private int ticketNum = 20;
    private final Object lock = new Object();//私有锁

    @Override
    public void run() {
        //同步代码快 同步方法
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            //对象锁 类锁
            synchronized (this) {
                try {
                    ticketNum--;
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getId() + ":" + Thread.currentThread().getName() + "剩余" + ticketNum + "张票");
            }
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket, "线程A");
        Thread t2 = new Thread(ticket, "线程B");
        t1.start();
        t2.start();
    }
}
