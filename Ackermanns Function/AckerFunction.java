/***********************************************************
* Lab #3 (CIS 181) *
* Submitted By: Alex Sluborski *
* SID: 00656119 *
* Date: 2/22/18 *
***********************************************************/
public class AckerFunction {
	 private int spaces = 0;
	    private int numberOfInvocations = 0;

	    // getter for data field "numberOfInvocations"
	    public int countOfInvocations() {
	        return numberOfInvocations;
	    }
//creates two values for input
	    public int acker(int m, int n) {
// adds invocations and spaces
	        ++numberOfInvocations;
	        ++spaces;
//calling from Print Spaces Enter method
	        printSpaces();
	        // prints out Enter values from Enter method 
	        System.out.print("Enter Method Acker: m = " + m + " n = " + n + "\n");

	        int result = 0;

// Acker Function/Equation
	        if(m == 0)
	            result = n+=1;
	        else if(n == 0) {
	            result = acker(m-1, 1);
	        } else {
	            result = acker(m-1, acker(m,n-1));
	        }
// calling from Print Spaces leave method
	        printSpaces();
	        // prints out Leave values from leave method
	        System.out.print("Leave Method Acker: m = " + m + " n = " + n + "\n");

	        this.spaces -= 1;
//returns result
	        return result;
	    }
//printSpaces method, makes array of adding i++
	    private void printSpaces() {
	        for(int i = 0; i < spaces; i++)
	            System.out.print("   ");
	    }
	}