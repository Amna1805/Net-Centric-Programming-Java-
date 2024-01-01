package Question2;

import java.util.Scanner;

public class Question2 {
	 public static void main(String[] args) {
	        Scanner myinput = new Scanner(System.in);
	        
	        System.out.print("Enter the number for the multiplication table: ");
	        int number = myinput.nextInt();
	        
	        System.out.println("Multiplication Table for " + number + ":");
	        for (int i = 1; i <= 10; i++) {
	            System.out.println(number + " x " + i + " = " + (number * i));
	        }
	        
	        myinput.close();
	    }
}
