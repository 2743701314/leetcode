package haha;


import java.text.SimpleDateFormat;
import java.util.Date;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) {
        Thread thread = new Thread(new Wait());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1 = new Thread(new Notify());
        thread1.start();

    }
    static class Wait implements Runnable{

        @Override
        public void run() {
            synchronized(lock){
                while (flag){
                    try {
                        System.out.println(Thread.currentThread()+"flag is true"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread()+"flag id false"+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable{
        @Override
        public void run() {
            synchronized(lock){
                System.out.println(Thread.currentThread()+"flag lock notify"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized(lock){
                System.out.println(Thread.currentThread()+"flag lock again"+new SimpleDateFormat("HH:mm:ss").format(new Date()));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
