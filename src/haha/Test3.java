package haha;

import java.sql.SQLOutput;

public class Test3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner());
        thread.setDaemon(true);
        thread.start();
    }

     static class DaemonRunner implements Runnable {
        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("哈哈哈");
            }
        }
    }
}
