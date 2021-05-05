package haha;

import java.util.concurrent.Semaphore;

/**
 * synchronized实现ABC打印10次
 */
//public class Test6 {
//    static int count = 0;
//    static Object lock = new Object();
//    public static void main(String[] args) {
//
//       // static int count = 0;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (lock){
//                    for (int i = 0; i < 10; i++) {
//                        while (count % 3 != 0){
//                            try {
//                                lock.wait();
//                            }catch (InterruptedException e){
//                                e.printStackTrace();
//                            }
//                        }
//                        System.out.print("A");
//                        count++;
//                        lock.notifyAll();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (lock){
//                    for (int i = 0; i < 10; i++) {
//                        while (count % 3 != 1){
//                            try {
//                                lock.wait();
//                            }catch (InterruptedException e){
//                                e.printStackTrace();
//                            }
//                        }
//                        System.out.print("B");
//                        count++;
//                        lock.notifyAll();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (lock){
//                    for (int i = 0; i < 10; i++) {
//                        while (count % 3 != 2){
//                            try {
//                                lock.wait();
//                            }catch (InterruptedException e){
//                                e.printStackTrace();
//                            }
//                        }
//                        System.out.print("C");
//                        count++;
//                        lock.notifyAll();
//                    }
//                }
//            }
//        }).start();
//    }
//}
//
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * lock实现ABC打印10次
// */
//public class Test6{
//    static ReentrantLock lock = new ReentrantLock();
//    static int count = 0;
//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; ) {
//                    try {
//                        lock.lock();
//                        while (count % 3 == 0) {
//                            System.out.print("A");
//                            count++;
//                            i++;
//                        }
//                    }finally{
//                        lock.unlock();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                    for (int i = 0; i < 10; ) {
//                        try {
//                            lock.lock();
//                        while (count % 3 == 1){
//                            System.out.print("B");
//                            count++;
//                            i++;
//                        }
//                    }finally {
//                        lock.unlock();
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 10; ) {
//                    try {
//                        lock.lock();
//                        while (count % 3 == 2){
//                            System.out.print("C");
//                            count++;
//                            i++;
//                    }
//                    }finally {
//                        lock.unlock();
//                    }
//                }
//            }
//        }).start();
//    }
//
//}
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * reentrantLock+condition
// */
//public class Test6 {
//    static ReentrantLock lock = new ReentrantLock();
//    static Condition conditionA = lock.newCondition();
//    static Condition conditionB = lock.newCondition();
//    static Condition conditionC = lock.newCondition();
//    static int count = 0;
//
//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    for (int i = 0; i < 10; i++) {
//                        while (count % 3 != 0) {
//                            conditionA.await();
//                        }
//                        System.out.print("A");
//                        count++;
//                        conditionB.signal();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    for (int i = 0; i < 10; i++) {
//                        while (count % 3 != 1) {
//                            conditionB.await();
//                        }
//                        System.out.print("B");
//                        count++;
//                        conditionC.signal();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    for (int i = 0; i < 10; i++) {
//                        while (count % 3 != 2) {
//                            conditionC.await();
//                        }
//                        System.out.print("C");
//                        count++;
//                        conditionA.signal();
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//
//            }
//        }).start();
//
//    }
//}


public class Test6{
    static Semaphore semaphoreA = new Semaphore(1);
    static Semaphore semaphoreB = new Semaphore(0);
    static Semaphore semaphoreC = new Semaphore(0);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoreA.acquire(1);
                        System.out.print("A");
                        semaphoreB.release(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoreB.acquire(1);
                        System.out.print("B");
                        semaphoreC.release(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        semaphoreC.acquire(1);
                        System.out.print("C");
                        semaphoreA.release(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}









