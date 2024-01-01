package Question1;

import java.io.*; 
class FileOutputDemo { 
	public static void main(String args[]) { 
		String s= "Testing file output stream"; 
		byte b[] = s.getBytes(); 
		try { 
			FileOutputStream fos = new FileOutputStream("src\\Question1\\aa.txt");
			fos.write(b,0,b.length); 
			System.out.println(b.length + " bytes are written!");
			fos.close();
		} catch(IOException e) { 
			System.out.println("Error creating file!");
		} 
	} 
}
