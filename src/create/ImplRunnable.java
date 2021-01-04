package create;

/**
 * @author hqk
 * 开启线程的四种方式 -- 实现Runnable的方法
 *
 *  In most cases, the Runnable interface should be used
 *  if you are only planning to override the run() method and
 *  no other Thread methods. This is important because classes
 *  should not be subclassed unless the programmer intends on modifying or
 *  enhancing the fundamental behavior of the class.
 *
 *  在大多数情况下，如果只计划重写run（）方法而不打算重写其他线程方法，
 *  则应该使用Runnable接口。这一点很重要，因为类不应该被子类化，
 *  除非程序员打算修改或增强类的基本行为。
 *
 *  面向接口编程
 *
 *  Runnable是没有返回值，需要返回值，请查阅Callable接口
 */
public class ImplRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("当前线程："+Thread.currentThread().getName() + "-->" +i);
        }
    }
}
