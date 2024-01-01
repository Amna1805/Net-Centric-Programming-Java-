package Question1;
import java.io.*;
import java.util.Scanner;
public class q7 {

	public static void main(String[] args) throws IOException {
		String fileName=null;
		try {
			Scanner keyboard=new Scanner(System.in);
			System.out.println("Enter file name");
			fileName=keyboard.next();
			BufferedReader inputStream=new BufferedReader(new FileReader(fileName));
			String line=null;
			line=inputStream.readLine();
			System.out.println("The first line in "+fileName+"is:");
			System.out.println(line);
			inputStream.close();
			}
		catch(FileNotFoundException e){
			System.out.println("File "+fileName+" Not Found.");
		}
		catch(IOException e)
		{
			System.out.println("Error reading from file "+fileName);
		}

	}

}
