package Question1;
import java.io.*;
public class q4 {
	public static void main(String[] args) throws IOException {
		  FileReader fr=new FileReader("src/Question1/a.txt"); 
		  FileWriter fw=new FileWriter(FileDescriptor.out); 
		  char[] b=new char[256]; 
		  int num; 
		  while((num=fr.read(b))>-1)   { 
		   String upper=new String(b,0,num).toUpperCase(); 
		   fw.write(upper);    
			fw.flush();   } 
		   }  

	}
