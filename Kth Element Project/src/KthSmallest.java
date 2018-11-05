/***********************************************************
 * Project #1 (CIS 181, Fall 2008)                         *
 * Submitted By: Alex Sluborski                        *
 * SID: 01656119                  *
 * Date: Your submission date                              *
 ***********************************************************/
public class KthSmallest {

	private  static void swap(int[] theArray, int i, int j){
        int temp = theArray[i];
        theArray[i] = theArray[j];
        theArray[j] = temp;
    }
	
    private static int partition(int[] theArray, int first, int last){
    // Returns the index of the pivot element after partitioning
    // theArray[first..last]

        int pivot = theArray[last];    // use the first item of the array as the pivot (p)
        int i = (first-1);        // set S1 and S2 to empty
        for (int j=first; j<last;j++)
        {
        	//if current element is smaller than or equal to pivot
        	if (theArray[j] <= pivot)
        	{
        		i++;
        	
        	//swap arr[i] and arr[j]
        	int temp = theArray[i];
        	theArray[i] = theArray[j];
        	theArray[j] = temp;
        	}
        }
        
        //swap arr[i+1] and arr[high] (or pivot)
        int temp = theArray[i+1];
        theArray[i+1] = theArray[last];
        theArray[last] = temp;
        return i+1;
    }
    public static void quicksort(int anArray[], int first, int last)
    {
    	if (first < last)
    	{
    		// pi is partioning index
    		int pivotIndex = partition(anArray, first, last);
    		//recursively sort elements before and after partition
    		quicksort(anArray, first, pivotIndex-1);
    		quicksort(anArray, pivotIndex+1,last);
    	}
    }

     

       
      
    public static int kSmall(int k, int[] anArray, int first, int last){
        int pivotIndex = partition(anArray, first, last);
        int p = anArray[pivotIndex]; // p is the pivot

        // ToDo: Return the kth smallest value in anArray[first..last].
        // Refer to the recursive algorithm on page 151-152 of the textbook.
        // if (first < last)
        if (pivotIndex == k - 1)

            return anArray[pivotIndex]; //returns pivot 
        else if (p > anArray[k - 1])

        return kSmall(k, anArray, first, pivotIndex - 1); // returns ksmall

    return kSmall(k, anArray, pivotIndex + 1, last); //returns ksmall last
}
}
