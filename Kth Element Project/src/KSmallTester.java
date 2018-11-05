/***********************************************************
 * Project #1 (CIS 181, Fall 2008)                         *
 * Submitted By: Alex Sluborski                        *
 * SID: 01656119                  *
 * Date: Your submission date                              *
 ***********************************************************/

/*
 * File name: KSmallTester.java
 * @author Haiping Xu
 * Created on 2008-09-27
 */
// finds the kth smallest integer in an array
import java.util.*;

public class KSmallTester {public final static int SIZE_OF_ARRAY = 10;
    public final static String PROMPT = "Please  enter an integer k, 1<=k<=" +
        SIZE_OF_ARRAY + ", or 'R' to refill the array: ";

    public static void printArray(int[] array) {

        System.out.println("");
        System.out.print("array = [");
        for (int i=0; i < SIZE_OF_ARRAY-1; i++)
            System.out.print(""+ array[i]+" | ");
        System.out.println(""+ array[SIZE_OF_ARRAY-1]+"]");
        System.out.println("-------------------------------------------------"
                         + "-------------------");
    }

    public static void randFillArray(int[] array) {
        Random random = new Random();

        for (int i=0; i < SIZE_OF_ARRAY; i++)
            array[i] = random.nextInt(100);
    }

    public static void main(String argv[]) {
        int k = 1, kthSmallest = 0;
        int[] array = new int[SIZE_OF_ARRAY];
        int[] arrayTmp = new int[SIZE_OF_ARRAY];

        randFillArray(array);
        printArray(array);

        // ToDo: Read input k and print out the k-th smallest item of the array.

        // Note that your program should allow finding k-th smallest item from an array
        // continuously (i.e., more than once) , refilling the array, and exiting the
        // program when typing in "Q" or "q".
        String choice = null;
        Scanner sc = new Scanner(System.in);
        do
        {
        	System.out.println(PROMPT);
        	choice =sc.nextLine();
        	if (choice.equalsIgnoreCase("R")) { // refills array
        		randFillArray(array);
        		printArray(array);      		
        	} else if (choice.equalsIgnoreCase("q")) { // quits program
        		System.out.println("Thank you for using");
        		System.exit(0);
        	}else if (!choice.equalsIgnoreCase("R") || !(choice.equalsIgnoreCase("q")) ){
        		try {
        			if(Integer.parseInt(choice)<1 || Integer.parseInt(choice)>10) { // allows only input 1-10
        				throw new Exception();
        			}
        		
        	else {
        		int kth = Integer.parseInt(choice); // parses kth
        		//Create a deep copy of array
        		for (int i = 0; i < SIZE_OF_ARRAY;i++) {
        			arrayTmp[i] = array[i];
        		}
        		int kthSmall = KthSmallest.kSmall(kth, arrayTmp, 0, SIZE_OF_ARRAY -1);
        		System.out.println("Kth Smallest Elemnt : " + kthSmall); 
        		// prints out kth smallest element
        		// prints out quicksort 
        		System.out.print("Quicksort: ");
        		for (int i = 0; i < SIZE_OF_ARRAY;i++) {
        			System.out.print(arrayTmp[i]+ " ");
        		}
        		System.out.println(" ");
        	        	}
        }
        		// catches invalid format
        		catch(NumberFormatException e) {
        			System.out.println("Invalid input please try again\n");
        			continue;
        		}
        		catch(Exception e) {
        			System.out.println("Invalid input please try again \n");
        			continue;
        		}
        	}
        }
        while(choice!=null);

    }

}


