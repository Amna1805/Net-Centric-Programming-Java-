package Question1;

import java.io.*; 
class FileDemo { 
	public static void main(String args[]) throws Exception {
		InputStream f = new FileInputStream("src\\Question1\\a.txt"); 
		int size= f.available(); 
		System.out.println("Bytes available: " + size); byte[] buff = new byte[size]; 
		f.read(buff,0,size); 
		String s = new String(buff); 
		System.out.print(s); 
		f.close();
		
		f = new FileInputStream("src\\Question1\\a.txt");
	    System.out.println("\nContents read character by character:");
		while (f.available() > 0) {
			char ch = (char) f.read();
			System.out.print(ch); 
		}


	}
} 



