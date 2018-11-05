/* Alex Sluborski
 * CIS 180-02
 * HW1 Part 3 - Hot Dog Calculator
 * 10.5.17
 */

// This program calculates the amount of hot dog and bun packages needed for a cook out and estimates the leftovers.

import java.util.Scanner;


public class HotDogCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner created for input by user, variable of int for # of people created, asks how many people coming
		Scanner s = new Scanner(System.in);
		System.out.println("Enter # of people");
		int people = s.nextInt();
		
		// input int variable for hotdogs, asks user how many hot dogs per person
		System.out.println("Enter # of hot dogs per person");
		int hdogs = s.nextInt();
		s.close();
		
		// Equation used to calculate total # of hot dogs needed.
		int totalHotDogs = people*hdogs;
		System.out.println("# of hot dogs needed: "+ totalHotDogs);
		
		// input double variable, equation used to calculate mininum # of hot dog packages needed, math.ceil used to round up integer, calculates 
		double hDogsNeeded = Math.ceil((double)totalHotDogs/10);
		System.out.println("Minimum number of packages of hot dogs needed: "+ hDogsNeeded);
		
		// input double variable for bun packages needed, equation used to calculate buns needed
		double bunsNeeded = Math.ceil((double)totalHotDogs/8);
		System.out.println("Minimum number of packages of buns needed: "+ bunsNeeded);
		
		// double variables declared, equations to find out leftovers. 
		double hotDogsLeft = hDogsNeeded*10-totalHotDogs;
		double bunsLeft = bunsNeeded*8-totalHotDogs;
		
		// Displays the amount of hot dogs left over and the amount of vuns left over
		System.out.println("The amount of hot dogs that will be left over: " + hotDogsLeft);
		System.out.println("The amount of buns that will be left over: " + bunsLeft);
		
		
		
		
		
				
				
		

	}

}
