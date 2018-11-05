/***********************************************************
* Lab #3 (CIS 181) *
* Submitted By: Alex Sluborski *
* SID: 00656119 *
* Date: 2/22/18 *
***********************************************************/
import java.util.Scanner;
import java.util.StringTokenizer;
public class AckerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;

		while (run) {

		  

		Scanner inputReader = new Scanner(System.in);

		int m = 0,n = 0;
		
		

		  

		// Prompt for input

		  
// quit program with q
		System.out.println("Input Two integers separated by a space character (enter \"q\" to quit)");

		String i = inputReader.nextLine();

		// Get m and n

		if (i.equalsIgnoreCase("q")) {

		System.out.println("program terminated");

		System.exit(0);

		}
		else {
// takes in integer values of m and n
			// try catch exception for invalid string 
		try {
// gets next token after m and then n
		StringTokenizer sb=new StringTokenizer(i);
		m = Integer.valueOf( sb.nextToken());

		n = Integer.valueOf( sb.nextToken());
		// invalid input if user uses negative values 
		if(m < 0 || n < 0) {
            System.out.println("Invalid input");
            continue;
        }
		// calls ackerfunction method AckerFunction class
		AckerFunction ak = new AckerFunction();
		// takes m and n
		int result = ak.acker(m, n);
		// prints out results 
		System.out.println("Total Number of invocations = " + ak.countOfInvocations() + " result = " + result);

// catch exception for invalid input ( not integer)
		} catch (Exception e) {
			System.out.println("Invalid input");

		}
		  

		}

		}

		}

		}


	
