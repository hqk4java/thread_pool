package pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author hqk
 * 创建一个定长线程池，支持定时及周期性任务执行。
 */
public class ScheduledThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            //延迟三秒后执行
            newScheduledThreadPool.schedule(new Runnable() {

                @Override
                public void run() {
                    Thread t = Thread.currentThread();
                    System.out.println(t.getName() + "当前索引位" + index);
                }
            }, 3, TimeUnit.SECONDS);
        }
    }
}
