/***********************************************************
* Lab #2 (CIS 181) *
* Submitted By: Alex Sluborski *
* SID: 00656119 *
* Date: 2/21/18 *
***********************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class DateApp {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String nextLine = "";
			
			int month = 1, day =1, year =2006;
			
			Date appointment = new Date();
			BufferedReader stdin = new BufferedReader(
					new InputStreamReader(System.in));
			while(true) {
				// asks user to input date
				System.out.println("Input the date in the format of MM/DD/YYYY (enter q to quit): ");
				try {
					nextLine = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// used to quit 
				if (nextLine.length() > 0 &&
						(nextLine.charAt(0) == 'q' || nextLine.charAt(0) == 'Q')) {
					System.out.println("Done!");
					System.exit(0);
				}
				// fail-proof code if user inputs invalid characters
				StringTokenizer input = new StringTokenizer(nextLine,"/");
				try {
					month = Integer.parseInt(input.nextToken());
					day = Integer.parseInt(input.nextToken());
					year = Integer.parseInt(input.nextToken());
				} catch (Exception e) {
					System.out.println("Invalid date! Please try again!");
					continue;
				//inlegitimate dates 			
				}
				if (!Date.isLegitimate(month, day, year)) {
					
					System.out.println("Invalid date! Please try again!");
					// program tells user the input date and the new date
				} else {
					appointment = new Date(month,day,year);
					appointment.display("The input date is: ");
					
					Date.advanceDate(appointment);
					appointment.display("The new date is: ");
				}
				
			}
		}
		

	}


