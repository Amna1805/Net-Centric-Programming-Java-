package Question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Partb {
    public static void main(String[] args) {
        String zipFilePath = "src/Question2/myfile.zip";
        String extractFileName = "myfile/hello.txt";
        String extractDestination = "src/Question2/extracted";

        File destinationDirectory = new File(extractDestination);
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdirs(); 
        }

        try (ZipFile zipFile = new ZipFile(zipFilePath)) {
            ZipEntry entry = zipFile.getEntry(extractFileName);

            if (entry != null) {
                try (InputStream inputStream = zipFile.getInputStream(entry);
                     FileOutputStream outputStream = new FileOutputStream(destinationDirectory + File.separator + entry.getName())) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }

                System.out.println("File saved in the extracted folder.");

                
                try (FileInputStream fis = new FileInputStream(destinationDirectory + File.separator + entry.getName());
                     BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
                    String line;
                    System.out.println("Contents of the extracted file:");
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File not found in the zip archive.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}