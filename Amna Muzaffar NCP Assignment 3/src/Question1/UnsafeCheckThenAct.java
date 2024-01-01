package Question1;

public class UnsafeCheckThenAct {
    private int number;

    public  void changeNumber() {
        if (number == 0) {
            System.out.println(Thread.currentThread().getId() + " | Changed");
            number = -1;
        } else {
            System.out.println(Thread.currentThread().getId() + " | Not changed");
        }
    }

    public static void main(String[] args) {
        final UnsafeCheckThenAct checkAct = new UnsafeCheckThenAct();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    checkAct.changeNumber();
                }
            }, "T" + i).start();
        }
    }
}
