package Question4;

public class Question4 {
	 public static int[][] transposeArray(int[][] myarray) {
	        int rows = myarray.length;
	        int columns = myarray[0].length;

	        int[][] transposedArray = new int[columns][rows];

	        for (int i = 0; i < rows; i++) {
	            for (int j = 0; j < columns; j++) {
	                transposedArray[j][i] = myarray[i][j];
	            }
	        }

	        return transposedArray;
	    }
		// printing array
		public static void printArray(int[][] myarray) {
			for(int[]row:myarray) {
				for(int element:row) {
					System.out.print(element+"\t");
				}
				System.out.println();
			}
		}
		
		public static void main(String[] args) {
			int[][] myarray= {
					{23,12,8,47},
					{51,30,61,22},
					{12,41,11,15},
					{13,15,12,20},
					{17,19,16,18}
			};
			System.out.println("My Array");
			printArray(myarray);
			System.out.println();
			
			int[][] transposeofArray=transposeArray(myarray);
			System.out.println("Array after Transpose");
			printArray(transposeofArray);

		}
}
