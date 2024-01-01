package Question1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Multithread1 {
    public static void main(String[] args) {
        new App1();
    }
}

class Counter implements Runnable {
    private final App1 mainApp;
    private final int loopLimit;

    public Counter(App1 mainApp, int loopLimit) {
        this.mainApp = mainApp;
        this.loopLimit = loopLimit;
    }

    public void run() {
        for (int i = 0; i < loopLimit; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.printf("%s: %s%n", threadName, i);
            mainApp.pause(Math.random());
        }
    }
}

class App1 {
    public App1() {
        ExecutorService taskList = Executors.newFixedThreadPool(100);
        taskList.execute(new Counter(this, 6));
        taskList.execute(new Counter(this, 10));
        taskList.execute(new Counter(this, 2));
        taskList.shutdown();
    }

    public void pause(double seconds) {
        try {
            Thread.sleep(Math.round(1000.0 * seconds));
        } catch (InterruptedException e) {
        }
    }
}
