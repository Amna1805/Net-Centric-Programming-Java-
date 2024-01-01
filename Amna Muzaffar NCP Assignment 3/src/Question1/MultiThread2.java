package Question1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThread2 {
    public static void main(String[] args) {
        new App2(5);
    }
}

class App2 implements Runnable {
    private final int loopLimit;

    public App2(int loopLimit) {
        this.loopLimit = loopLimit;
        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(this);
        taskList.execute(this);
        taskList.execute(this);
        taskList.shutdown();
    }

    private void pause(double seconds) {
        try {
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException ie) {
        }
    }

    public void run() {
        for (int i = 0; i < loopLimit; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %s%n", threadName, i);
            pause(Math.random());
        }
    }
}
