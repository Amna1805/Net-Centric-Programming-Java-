package Question2;
import java.io.*;
import java.util.Arrays;



class MinimumNumber extends Thread{
	private int[] numbers;
    private int startIndex;
    private int endIndex;
    private int min;

    public MinimumNumber(int[] numbers, int startIndex, int endIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.min = Integer.MAX_VALUE;
    }

    public int getMin() {
        return min;
    }
    @Override
    public void run() {
        for (int i = startIndex; i <= endIndex; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
    }

}
public class Question2 {

    public static void main(String[] args) {
        int num[] = new int[1000];

        // Writing random numbers to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/Question2/random_numbers.txt"))) {
            for (int i = 0; i < 1000; i++) {
                num[i] = (int) (Math.random() * ((1000 - 1) + 1) + 1);
                writer.println(num[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading the numbers from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Question2/random_numbers.txt"))) {
            for (int i = 0; i < 1000; i++) {
                // Read the line and convert it to an integer
                num[i] = Integer.parseInt(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     // Without threads
        long startTimeWithoutThreads = System.currentTimeMillis();
        int minWithoutThreads = findMinWithoutThreads(num);
        long endTimeWithoutThreads = System.currentTimeMillis();
        long elapsedTimeWithoutThreads = endTimeWithoutThreads - startTimeWithoutThreads;
     // Compare results and time taken
        System.out.println("Minimum value without threads: " + minWithoutThreads);
        System.out.println("Time taken without threads: " + elapsedTimeWithoutThreads + " milliseconds");
    
        
      //With threads
        long startTimeWithThreads = System.currentTimeMillis();
        int minWithThreads = findMinWithThreads(num,5);
        long endTimeWithThreads = System.currentTimeMillis();
        long elapsedTimeWithThreads = endTimeWithThreads - startTimeWithThreads;
     // Compare results and time taken
        System.out.println("Minimum value with threads: " + minWithThreads);
        System.out.println("Time taken with threads(5): " + elapsedTimeWithThreads + " milliseconds");
    
    }
 // Function to find the minimum without using threads
    private static int findMinWithoutThreads(int[] numbers) {
        return Arrays.stream(numbers).min().orElseThrow();
    }
    private static int findMinWithThreads(int [] numbers,int threadcount)
    {
    	int chunk=1000/threadcount;
    	MinimumNumber[] threads=new MinimumNumber[threadcount];
    	for (int i = 0; i < threadcount; i++) {
            int start = i * chunk;
            int end = (i == 4) ? 999 : start + chunk - 1;
            threads[i] = new MinimumNumber(numbers, start, end);
            threads[i].start();
        }
    	try {
            for (int i = 0; i < threadcount; i++) {
                threads[i].join();
            }

            int minFromThreads = Integer.MAX_VALUE;
            for (int i = 0; i < threadcount; i++) {
                int threadMin = threads[i].getMin();
                if (threadMin < minFromThreads) {
                    minFromThreads = threadMin;
                }
            }

            return minFromThreads;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1; // Handle error case
        }
    }
}

