/* Alex Sluborski
 * CIS 180-02 
 * Lab 03 DPS 
 * 9/28/17
 */

//This program calculates your DPS using your damage, crit chance, and attack speed. 

import java.util.*;


public class DPSCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Create a variable of type int for attack damage
	    int damage;
	    
	    //Create scanner class that facilitates getting information from user console or keyboard
	    Scanner input = new Scanner(System.in);
	    
	    //Get the attack damage and save it to a variable
	    System.out.println("What is the attack damage? : ");
	    damage = input.nextInt ();
	    
	    //A simple debug line to verify that we got the right number from the user
	    System.out.println("The entered damage is " + damage);
	    
	    //6.)If damage was used as a double instead of an integer, then the method would change by saying nextDouble or by changing the scanner system to next double.
	    
	    
	    //Create a variable of type double for critical hit chance
	    double critical;
	    
	    //Get the critical hit chance and save it to a variable
	    System.out.println("What is the critical hit chance? (less than or equal to 1) : ");
	    critical = input.nextDouble ();
	    
	    //Create a variable for type double for attack speed
	    double attackspeed;
	    
	    // Get the attack speed and save it to a variable
	    System.out.println("What is the attack speed? : ");
	    attackspeed = input.nextDouble ();
	    
	    //Create a variable for type double for DPS 
	    double DPS;
	    
	    //Input equation to calculate your DPS 
	    DPS = ((critical * damage * 2) + ((1-critical) * damage)) * attackspeed;
	    System.out.println("Your DPS = " + DPS);
	    input.close();
	    
	    // If you have a DPS above 400 then it will say you are doing a lot of damage.
	    // If you have a dps below 100 then it will say you need to increase your damage.
	    if (DPS >= 401) {
	    System.out.println("You are outputting a lot of damage!");
	    }else if (DPS <= 99) {
	    	System.out.println("You need to increase your damage!");
	    }
	    
	   
	    
	    
	}

}
