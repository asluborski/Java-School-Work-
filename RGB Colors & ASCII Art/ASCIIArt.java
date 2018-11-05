// Student Name: Alex Sluborski
// Class: CIS 180-02
// Assignment: Lab 4 
// Due Date: 10/19/17

import java.io.IOException;
import java.util.Scanner;
public class ASCIIArt {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		while (true)
		{
			// get scanner class to input from keyboard
		Scanner keyboard = new Scanner(System.in);
		// ask what to print out into ASCII Art
		System.out.println("What letter would you like to turn into ASCII? : E, T, I, F, Z.");
		//create string
		String letterString = keyboard.next();
		// create switch statement with ASCII art of letters with corresponding letters
		switch (letterString.charAt(0)) {
		
		case 'E': {
			System.out.println("*****");
			System.out.println("*    ");
			System.out.println("*****");
			System.out.println("*    ");
			System.out.println("*****");
		    break;
		} 
		case 'T': {
			System.out.println("*****");
			System.out.println("  *  ");
			System.out.println("  *  ");
			System.out.println("  *  ");
			System.out.println("  *  ");
			break;		
		}
		case 'I': {
			System.out.println("*****");
			System.out.println("  *  ");
			System.out.println("  *  ");
			System.out.println("  *  ");
			System.out.println("*****");
			break;
		}
		case 'F': {
			System.out.println("*****");
			System.out.println("*    ");
			System.out.println("*****");
			System.out.println("*    ");
			System.out.println("*    ");
			break;
		}
		case 'Z': {
			System.out.println("*****");
			System.out.println("   * ");
			System.out.println("  *  ");
			System.out.println(" *   ");
			System.out.println("*****");
			break;
		}
		//set default for invalid characters, loops back to original question
	    default:
	    {
	    	  System.out.println("Invalid character, please enter any key.");
	    	  System.in.read(); }}}
	    }
	    
	    
	public static void functionDumpText() throws IOException
	{
}}
