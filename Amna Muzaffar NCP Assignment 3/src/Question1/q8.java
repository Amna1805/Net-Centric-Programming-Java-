package Question1;
import java.io.*;
import java.util.*;

public class q8 {

	public static void main(String[] args) {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Enter");
		String inputLine = keyboard.nextLine();
		StringTokenizer wordFinder =
		            new StringTokenizer(inputLine, " \n.,");//the second argument is a string of the 4 delimiters
		while(wordFinder.hasMoreTokens())
		{
		   System.out.println(wordFinder.nextToken());
		}

	}

}
