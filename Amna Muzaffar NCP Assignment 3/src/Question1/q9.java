package Question1;

public class q9 {

    public static void main(String[] args) {
        System.out.println("Main ThreadId: " + Thread.currentThread().getId());

        // Create and start three instances of Thread1
        for (int i = 0; i < 3; i++) {
            new Thread1().start();
        }

        // Call PrintNumbers in the main thread
        PrintNumbers.printNumbers();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1 ThreadId: " + Thread.currentThread().getId());
        // do our thing
        PrintNumbers.printNumbers();
    }
}

class PrintNumbers {
    static public void printNumbers() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getId() + ": " + i);
        }
    }
}
