package create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hqk
 * 开启线程的四种方式 -- 线程池
 * 四种线程池，以CacheThreadPool为例子
 */
public class CacheThreadPoolTest {
    public void print(){
        ExecutorService cachedThreadPool_test = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                //可以适当设置当前等待时间，发现如果当前线程还没执行，就会创建一个新的线程去执行
                Thread.sleep(5 * 100);

                cachedThreadPool_test.execute(new Runnable() {
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
