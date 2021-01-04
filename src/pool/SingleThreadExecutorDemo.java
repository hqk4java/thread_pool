package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hqk
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i=0;i<4;i++)
        {
            final int index=i;
            newSingleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        //通过打印当前线程名称可以发现无论等待多久都只会创建一个单一的线程去执行
                        System.out.println("当前线程名称："+Thread.currentThread().getName() + "--->当前索引位置" + index);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
