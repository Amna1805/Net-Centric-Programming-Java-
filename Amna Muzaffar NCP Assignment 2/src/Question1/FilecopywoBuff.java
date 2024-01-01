package Question1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilecopywoBuff {
	public static void main(String[] args) {
	      String inFileStr = "src\\Question1\\qau.jpg";
	      String outFileStr = "src\\Question1\\qauNoBuff-out.jpg";
	      long startTime, elapsedTime;  // for speed benchmarking
	      // Check file length
	      File fileIn = new File(inFileStr);
	      System.out.println("File size is " + fileIn.length() + " bytes");
	     try (BufferedInputStream in = new BufferedInputStream(new 	FileInputStream(inFileStr)); BufferedOutputStream out = new 	BufferedOutputStream(new FileOutputStream(outFileStr))) {
	         startTime = System.nanoTime();
	         int byteRead;
	         while ((byteRead = in.read()) != -1) {
	            out.write(byteRead);
	         }
	         elapsedTime = System.nanoTime() - startTime;
	         System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
	      } catch (IOException ex) {
	         ex.printStackTrace();
	      }
	   }

}
