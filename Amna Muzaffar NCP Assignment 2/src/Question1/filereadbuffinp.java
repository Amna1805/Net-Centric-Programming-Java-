package Question1;
import java.io.BufferedInputStream;
import java.io.FileInputStream;


public class filereadbuffinp {
public static void main(String[] args) throws Exception {
    byte[] buffer = new byte[1024];
    BufferedInputStream bi = new BufferedInputStream(new FileInputStream("src\\Question1\\b.txt"));
    int bytesRead = 0;
    int i=1;
    while ((bytesRead = bi.read(buffer)) != -1)
{
    String chunk = new String(buffer, 0, bytesRead);
    System.out.println("Chunk No: "+i);    
    System.out.println(chunk);    
    i++;
}
    bi.close();
  }
}
