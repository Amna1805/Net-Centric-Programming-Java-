package Question1;

import java.io.*;

public class CopyFileTV_ex { 
	 public static void main(String[] args) throws IOException {
		 FileInputStream fin = null; 
		 FileOutputStream fout = null; 
	 fin = new FileInputStream("src\\Question1\\a1.txt");  
	 fout = new FileOutputStream("src\\Question1\\xyz.txt"); 
	 byte[] buffer = new byte[1024]; 
	 int bytesRead; 
	 while ((bytesRead = fin.read(buffer)) > 0) {
		 fout.write(buffer, 0, bytesRead); 

	 } 
	int size = 0; 
	try { 
	size = fin.available();
	byte[] b = new byte[size];
	fin.read(b,0,size); 
	fout.write(b,0,size);
	} catch (IOException e) { 
		e.printStackTrace(); 

	}
	 fin.close();
	 fout.close(); 
	}
}
