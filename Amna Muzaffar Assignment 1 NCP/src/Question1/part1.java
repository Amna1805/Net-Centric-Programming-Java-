package Question1;

public class part1 {
    public static void main(String[] args) {
        int i;

        for (i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Broke out of loop");
                System.out.println("Broke out of loop at i = " + i);
                break;
            }
        }
    }
}
