package Question3;

public class Question3 {
	public static void main(String[] args) {
		int[] myarray= {24,6,34,2,11,67,44,11,16,34};
		int max=myarray[0];
		int min=myarray[0];
		
		for(int number:myarray) {
			if(number>max) {
				max=number;
			}
			if(number<min) {
				min=number;
			}
		}
		System.out.println("Largest number in array is: "+max);
		System.out.println("Smallest number in array is: "+min);
	    System.out.println();
		
		
	     
		//Ascending Order
		int temp=0;
		for(int i=0;i<myarray.length;i++)
		{
			for(int j=i+1;j<myarray.length;j++) {
				if(myarray[i]>myarray[j]) {
					temp=myarray[i];
					myarray[i]=myarray[j];
					myarray[j]=temp;
				}
			}
		}
		 System.out.println("Array in Ascending order: ");    
	        for (int i = 0; i < myarray.length; i++) {     
	            System.out.print(myarray[i] + " ");    
	        }    
		
	     System.out.println();
	    
	     
	     //Descending Order
	     System.out.println();
	        int temp2=0;
			for(int i=0;i<myarray.length;i++)
			{
				for(int j=i+1;j<myarray.length;j++) {
					if(myarray[i]<myarray[j]) {
						temp2=myarray[i];
						myarray[i]=myarray[j];
						myarray[j]=temp2;
					}
				}
			}
			 System.out.println("Array in Descending order: ");    
		        for (int i = 0; i < myarray.length; i++) {     
		            System.out.print(myarray[i] + " ");    
		        }    
			

	     
	}
}
