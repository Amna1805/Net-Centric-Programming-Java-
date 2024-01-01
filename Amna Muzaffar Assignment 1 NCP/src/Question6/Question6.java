package Question6;

public class Question6 {
	public static void main(String[] args) {
        String mystring = "Java is basic tool for Net Centric Prgramming.";
        mystring = mystring.toLowerCase();

        int[] Count = new int[26];

        for (int i = 0; i < mystring.length(); i++) {
            char ch = mystring.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
            	Count[ch - 'a']++;
            }
        }

        System.out.println("String to analyze: " + mystring);
        System.out.println("Letter count in the string:");

        for (char letter = 'a'; letter <= 'z'; letter++) {
            int count = Count[letter - 'a'];
            if (count > 0) {
                System.out.println(letter + ": " + count + " times");
            }
        }
    }
}
