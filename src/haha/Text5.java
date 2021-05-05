package haha;


import org.omg.CORBA.INITIALIZE;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//
//public class Text5 {
//    public static void main(String[] args) {
//        PrintABCUsingSemaphore printABCUsingSemaphore = new PrintABCUsingSemaphore();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printABCUsingSemaphore.printA();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printABCUsingSemaphore.printB();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printABCUsingSemaphore.printC();
//            }
//        }).start();
//
//    }
//}
//class PrintABCUsingSemaphore{
//    private Semaphore semaphoreA = new Semaphore(1);
//    private Semaphore semaphoreB = new Semaphore(0);
//    private Semaphore semaphoreC = new Semaphore(0);
//    private final int times = 5;
//    public void printA(){
//        for (int i = 0; i < times; i++) {
//            print("A",semaphoreA,semaphoreB);
//        }
//
//    }
//    public void printB(){
//        for (int i = 0; i < times; i++) {
//            print("B",semaphoreB,semaphoreC);
//        }
//
//    }
//    public void printC(){
//        for (int i = 0; i < times; i++) {
//            print("C",semaphoreC,semaphoreA);
//        }
//
//    }
//    public void print(String s,Semaphore currentSemaphore,Semaphore nextSemophore){
//        try {
//            currentSemaphore.acquire(1);
//            System.out.print(s);
//            nextSemophore.release(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }


//
//public class Text5{
//    public static void main(String[] args) {
//        PrintABCUsingSemaphore printABCUsingSemaphore = new PrintABCUsingSemaphore();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printABCUsingSemaphore.printA();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printABCUsingSemaphore.printB();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printABCUsingSemaphore.printC();
//            }
//        }).start();
//    }
//}
//class PrintABCUsingSemaphore{
//    private Semaphore semaphoreA = new Semaphore(1);
//    private Semaphore semaphoreB = new Semaphore(0);
//    private Semaphore semaphoreC = new Semaphore(0);
//    private final int time = 5;
//    public void printA(){
//        for (int i = 0; i < time; i++) {
//            print("A",semaphoreA,semaphoreB);
//        }
//    }
//    public void printB(){
//        for (int i = 0; i < time; i++) {
//            print("B",semaphoreB,semaphoreC);
//        }
//    }
//    public void printC(){
//        for (int i = 0; i < time; i++) {
//            print("C",semaphoreC,semaphoreA);
//        }
//    }
//    public void print(String s,Semaphore currentSemaphore,Semaphore nextSemaphore){
//        try {
//            currentSemaphore.acquire(1);
//            System.out.print(s);
//            nextSemaphore.release(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}

//public class Text5 {
//    public static void main(String[] args) throws InterruptedException {
//        Object a = new Object();
//        Object b = new Object();
//        Object c = new Object();
//        PrintABC a1 = new PrintABC("A", c, a);
//        PrintABC b1 = new PrintABC("B", a, b);
//        PrintABC c1 = new PrintABC("C", b, c);
//        new Thread(a1).start();
//        Thread.sleep(2000);
//        new Thread(b1).start();
//        Thread.sleep(2000);
//        new Thread(c1).start();
//
//
//    }
//
//}
//
//class PrintABC implements Runnable {
//    private String name;
//    private Object prev;
//    private Object self;
//
//    public PrintABC(String name, Object prev, Object self) {
//        this.name = name;
//        this.prev = prev;
//        this.self = self;
//    }
//
//    @Override
//    public void run() {
//        int count = 10;
//        while (count > 0) {
//            synchronized (prev) {
//                synchronized (self) {
//                    System.out.println(name);
//                    count--;
//                    self.notifyAll();
//                }
//                try {
//                    if (count == 0) {
//                        prev.notifyAll();
//                    } else {
//                        prev.wait();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//}


//public class Text5{
//    private static Lock lock = new ReentrantLock();
//    private static int state = 0;
//    public static void main(String[] args) {
//        new ThreadA().start();
//        new ThreadB().start();
//        new ThreadC().start();
//    }
//    static class ThreadA extends Thread{
//        public void run(){
//            for (int i = 0; i < 10; ) {
//               try {
//                   lock.lock();
//                   while (state % 3 == 0){
//                       System.out.print("A");
//                       state++;
//                       i++;
//                   }
//               }finally {
//                   lock.unlock();
//               }
//            }
//        }
//    }
//    static class ThreadB extends Thread{
//        public void run(){
//            for (int i = 0; i < 10;) {
//                try{
//                    lock.lock();
//                    while (state % 3 == 1){
//                        System.out.print("B");
//                        state++;
//                        i++;
//                    }
//                }finally{
//                    lock.unlock();
//                }
//            }
//        }
//    }
//    static class ThreadC extends Thread{
//        public void run(){
//            for (int i = 0; i < 10;) {
//                try {
//                    lock.lock();
//                    while (state%3 == 2){
//                        System.out.print("C");
//                        state++;
//                        i++;
//                    }
//                }finally {
//                    lock.unlock();
//                }
//            }
//
//        }
//    }
//
//}


public class Text5 implements Serializable {
    private static   Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();
    private static int count = 0;
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 0){
                            conditionA.await();
                        }
                        System.out.print("A");
                        count++;
                        conditionB.signal();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 1){
                            conditionB.await();
                        }
                        count++;
                        System.out.print("B");
                        conditionC.signal();
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    for (int i = 0; i < 10; i++) {
                        while (count % 3 != 2){
                            conditionC.await();
                        }
                        count++;
                        System.out.print("C");
                        conditionA.signal();
                    }

                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

    }

}














