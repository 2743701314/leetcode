package haha;

public class Test4 {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepRunner(),"sleep");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyRunner(),"busy");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("SleepThread" + sleepThread.isInterrupted());
        System.out.println("BusyThread" + busyThread.isInterrupted());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
