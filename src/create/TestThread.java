package create;

import java.util.concurrent.*;

/**
 * @author hqk
 * 测试线程调用
 * <p>
 * 四种创建线程的方式，最底层还是Thread 类
 */
public class TestThread {
    public static void main(String[] args) throws Exception{
        System.out.println("当前main方法线程1-->" + Thread.currentThread().getName());

        // testExtendThread();

        //testRunnable();

        //testCallable();

        threadPool();
        //异步先执行了下面的执行打印语句，说明创建线程成功
        System.out.println("当前main方法线程2-->" + Thread.currentThread().getName());
    }

    /**
     * 继承Thread
     */
    public static void testExtendThread() {
        ExtendThread ex = new ExtendThread();
        ex.start();
    }

    /**
     * 实现 Runnable
     */
    public static void testRunnable() {
        ImplRunnable impl = new ImplRunnable();
        Thread thread = new Thread(impl);
        thread.start();
    }

    /**
     * 实现 Callable方法
     * <p>
     * Callable和Future做两件事-Callable与Runnable类似，
     * 因为它封装了要在另一个线程上运行的任务，而Future用于存储从另一个线程获得的结果。
     * 实际上，future也可以与Runnable一起使用。
     */
    public static void testCallable() throws Exception{
        ImplCallable callable = new ImplCallable();
        FutureTask<String> future = new FutureTask<String>(callable);
        for (int i = 0; i < 10; i++) {
            new Thread(future,"Callable线程").start();
        }
        System.out.println("子线程的返回值"+future.get());
    }

    /**
     * 线程池方式
     * 线程池与线程的区别 就像 连接池 与单个数据据连接 的区别一样的
     *
     * 四种线程池，以CacheThreadPool为例子
     */
    public static void threadPool(){
        CacheThreadPoolTest cacheThread = new CacheThreadPoolTest();
        cacheThread.print();
    }
}
