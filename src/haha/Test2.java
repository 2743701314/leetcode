package haha;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.*;

public class Test2 {
    public static void main(String[] args){
//        MyTest m = new MyTest();
//        m.start();
//        MyTest myTest = new MyTest();
//        Thread thread = new Thread(myTest,"郭子成");
//        thread.start();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyTest());
        Thread thread = new Thread(futureTask,"jj");
        thread.start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();

    }
}

//class MyTest extends Thread{
//   public void run(){
//       System.out.println(Thread.currentThread().getName()+"run方法正在运行");
//   }
//}
//
//class MyTest implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()+" hhhh");
//    }
//}

class MyTest implements Callable{

    public Integer call(){
        System.out.println(Thread.currentThread().getName());
        return 1;
    }
}