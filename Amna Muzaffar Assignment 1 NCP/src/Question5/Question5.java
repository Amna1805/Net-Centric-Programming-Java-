package Question5;

public class Question5 {

		public static String reverseStringinRecurrsion(String mystring) {
			if (mystring.isEmpty()) {
	            return mystring;
	        }
	        return reverseStringinRecurrsion(mystring.substring(1)) + mystring.charAt(0);
	    }
		public static String reverseStringinLoop(String mystring) {
			 char[] charArray = mystring.toCharArray();
		        int len = charArray.length;
		        char[] reversedString = new char[len];
		        
		        for (int i = 0; i < len; i++) {
		            reversedString[i] = charArray[len - 1 - i];
		        }
		        
		        return new String(reversedString);
		    }
		
		public static void main(String[] args) {  
			    String mystring1="Net Centric Programming";
			    String mystring2="Java Basics";
		        String reversedString1 = reverseStringinLoop(mystring1);
		        String reversedString2 = reverseStringinLoop(mystring2);
		        String recursiveString1 = reverseStringinRecurrsion(mystring1);
		        String recursiveString2 = reverseStringinRecurrsion(mystring2);
		        System.out.println("My Strings");
		        System.out.println("My String1 : " + mystring1);
		        System.out.println("My String2 : " + mystring2);
		        System.out.println();
		        System.out.println("String is reversed using Loop Method");
		        System.out.println();
		        System.out.println("String1 Reversed Using Loop: " + reversedString1);
		        System.out.println("String1 Reversed Using Loop: " + reversedString2);
		        System.out.println();
		        System.out.println("String is reversed using Recursion Method");
		        System.out.println("String1 Reversed Using Recurrsion: " + recursiveString1);
		        System.out.println("2 Reversed Using Recurrsion: " + recursiveString2);
		}

	
}
