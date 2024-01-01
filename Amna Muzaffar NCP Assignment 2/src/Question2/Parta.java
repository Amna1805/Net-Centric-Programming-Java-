package Question2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class Parta {
	public static void main(String[] args) {
		String sourceFilePath = "src/Question2/source.txt";
        String destinationFilePath = "src/Question2/destination.txt";
        
        // Without Buffered Stream
        long startTime = System.nanoTime();
        WithoutBufferedStream(sourceFilePath, destinationFilePath);
        long endTime = System.nanoTime();
        long durationWithoutBufferedStream = endTime - startTime;
     
        // With Buffered Stream
        startTime = System.nanoTime();
        WithBufferedStream(sourceFilePath, destinationFilePath);
        endTime = System.nanoTime();
        long durationWithBufferedStream = endTime - startTime;
        
        System.out.println("Copy without Buffered Stream took: " + durationWithoutBufferedStream + " nanoseconds");
        
        System.out.println("Copy with Buffered Stream took: " + durationWithBufferedStream + " nanoseconds");
    }
    
    public static void WithoutBufferedStream(String sourceFilePath, String destinationFilePath) {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {
            int bytesRead;
            while ((bytesRead = fis.read()) != -1) {
                fos.write(bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void WithBufferedStream(String sourceFilePath, String destinationFilePath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {
            int bytesRead;
            byte[] buffer = new byte[4096];
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



