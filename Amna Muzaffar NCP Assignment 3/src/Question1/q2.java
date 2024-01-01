package Question1;
import java.io.*;
public class q2 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("aa.txt");
	    String strs[] = { "abc", "def", "ghi", "jkl" };
	    for (int i = 0; i < strs.length; i++) {
	      fw.write(strs[i] + "\n");
	    }
	    fw.close();

	}

}
