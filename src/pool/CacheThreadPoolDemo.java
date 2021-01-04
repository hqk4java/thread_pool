package pool;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hqk
 * 线程池 newFixedThreadPool
 *
 * 可缓存线程池，先查看池中有没有以前建立的线程，如果有，就直接使用。
 * 如果没有，就建一个新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
 * 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
 */
public class CacheThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                //可以适当设置当前等待时间，发现如果当前线程还没执行，就会创建一个新的线程去执行
                Thread.sleep(5 * 100);

                cachedThreadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        //通过打印当前线程名称可以发现一直使用同一个线程执行
                        System.out.println(this.toString()+ "--->当前索引位置" + index);
                        System.out.println("当前线程名称："+Thread.currentThread().getName());
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
