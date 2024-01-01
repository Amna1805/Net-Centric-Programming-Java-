package Question1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteDemo {
    public static void main(String[] args) {
        try {
            String str = "Testing Byte Array Input Stream.";
            byte[] b = str.getBytes();
            InputStream bais = new ByteArrayInputStream(b, 0, b.length);
            int ch;

            while ((ch = bais.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();

            // Reset the stream position
            bais.reset();

            while ((ch = bais.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
