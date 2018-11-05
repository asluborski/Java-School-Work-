//Student Name: Alex Sluborski
// Class: CIS 180-02 
// Assignment: Lab 9 
// Due Date: 11/23/17


import java.util.Scanner;


public class MainMethod {
	

	public static void main(String[] args) {
		try {
// create scanner
			Scanner scanner = new Scanner(System.in);

			do {
// input number to convert
			System.out.print("Enter the Number:");

			int number = scanner.nextInt();
// print out menu with switch case 
			System.out.println("-----Menu-----");

			System.out

			.print(" 1. Number to Binary\n 2. Number to Hex\n 3. Number to Roman\n 4. Exit\n");

			System.out.print("Enter the choice:");

			int choice = scanner.nextInt();

			if (choice == 4)

			break;

			switch (choice) {
// return methods from IntegerConverter Class
			case 1:

			System.out.println("Number " + number + " to Binary is "

			+ IntegerConverter.toBinary(number));

			break;

			case 2:

			System.out.println("Number " + number + " to Hex is "

			+ IntegerConverter.toHex(number));

			break;

			case 3:

			System.out.println("Number " + number + " to Roman is "

			+ IntegerConverter.toRomanNumeral(number));

			break;

			case 4:

			break;

			default:

			System.out.println("Invalid Choice");

			break;

			}

			} while (true);
// catch exception 
			} catch (Exception e) {

			// TODO: handle exception

			}
		
	}
}




