package create;

/**
 * @author hqk
 * 开启线程的四种方式 -- 继承Thread
 */
public class ExtendThread extends Thread {
    /**
     * 覆盖run方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(500);
                printNumber();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printNumber() {
        System.out.println("当前线程-->" + Thread.currentThread().getName());
    }
}
