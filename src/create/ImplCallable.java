package create;

import java.util.concurrent.Callable;

/**
 * @author hqk
 * 开启线程的四种方式 -- 实现callable 接口
 * 主要还是为了线程执行完毕有返回值 ，Runnable接口是没有返回值
 * */
public class ImplCallable implements Callable {

    @Override
    public Object call() throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName() + "-->"+ i);
        }
        return "callabe线程执行完毕";
    }
}
