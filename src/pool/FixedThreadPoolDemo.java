package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hqk
 * 定长线程池
 * 可控制线程最大并发数，超出的线程会在队列中等待
 */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {

        //设置最大并发数为3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                        //通过打印当前线程名称可以发现三个线程在抢占资源执行
                        System.out.println("当前线程名称："+Thread.currentThread().getName() + "--->当前索引位置" + index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
