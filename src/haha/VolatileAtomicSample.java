package haha;

public class VolatileAtomicSample {

        private static volatile int counter = 0;

        public static void main(String[] args) {

            for (int i = 0; i < 1000; i++) {
                new Thread(() -> {
                    for (int j = 0; j < 10; j++) {
                        counter=counter+1;   //不是一个原子操作,第一轮循环结果是没有刷入主存，这一轮循环已经无效
                        counter++;
//                    //1 load counter 到工作内存
//                    //2 add counter 执行自加
//                    //其他的代码段？
                    }
                }).start();

            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(counter);
        }
    }


