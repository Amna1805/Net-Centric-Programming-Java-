package Question1;

public class q10 {

    public static void main(String[] args) {
        System.out.println("Main ThreadId: " + Thread.currentThread().getId());
        for (int i = 0; i < 3; i++) {
            new Thread(new Thread2()).start();
            // again, don't call run!
            // (if you want a separate thread)
        }
        PrintNumbers.printNumbers();
    }
}

class Thread2 implements Runnable {
    public void run() {
        System.out.println("Thread2 ThreadId: " + Thread.currentThread().getId());
        // do our thing
        PrintNumbers.printNumbers();
    }
}
