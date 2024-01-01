package Question1;

public class part2 {
	 public static void main(String[] args) {
         int myNumber = 5;
         long factorial = 1;

         while (myNumber > 0) {
             factorial *= myNumber;
             myNumber--;
         }

         System.out.println("Factorial: " + factorial);
     }
}
