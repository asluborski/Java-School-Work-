// Alex Sluborski
// CIS 180-02
//12/10/17
// Homework 3 

import java.io.File;
import java.util.Scanner;

public class MainClass {
	public static Winner [] listOfWinners;
	public static void loadFromFile()
	{
		try{
			//Create instance of Scanner and provide instance of File pointing to the txt file
			Scanner input = new Scanner(new File("WorldSeriesWinners.txt"));
			
			
			//Get the number of teams
			int years = input.nextInt();
			input.nextLine();//move to the next line
			
			//Create the array
			listOfWinners = new Winner[years];
			
			//for every year in the textfile
			for(int index = 0; index<years; index++)
			{
				//Get the year
				int year = input.nextInt();
				input.skip("	");
				//Get the team
				String team = input.nextLine();
				
				//Create an instance of Winner and add it to the next spot in the array
				listOfWinners[index] = new Winner(team,year);
			
				
			}
		}catch(Exception e)
		
		{
			System.out.println("Hey Meatbag, I'm Bender, and something wrong in the loadFromFile method happened!");
			System.out.println(e.toString());
			System.exit(0);
		}
	}
	
	
	
	public static void sortByTeamName()
	{
		{

			// store current i

			Winner temp;

			// store the lowest value

			Winner min;

			//Print the array

			for(int i=0; i < listOfWinners.length; i++)

			{

			// select the first array value

			min = listOfWinners[i];

			for(int j=i+1; j < listOfWinners.length; j++)

			{

			// if value of the j is lower than the min make j the new min

			if(listOfWinners[j].getTeam().compareTo(min.getTeam()) > 0)

			{

			// store new minmum

			min= listOfWinners[j];

			// hold i

			temp = listOfWinners[i];

			// make i the new min

			listOfWinners[i] = min;

			// j is the last value

			listOfWinners[j] = temp;

			}// end of if

			} // end of for loop

			} // end of for loop

			}
	}
	
	public static void sortByYear()
	{
		{

			Winner temp;

			Winner min;

			for(int i=0; i < listOfWinners.length-1; i++)

			{

			min = listOfWinners[i];

			for(int j=i+1; j < listOfWinners.length; j++)

			{

			if(listOfWinners[j].getYear() < min.getYear())

			{

			min = listOfWinners[j];

			temp = listOfWinners[i];

			listOfWinners[i] = min;

			listOfWinners[j] = temp;

			} // end of if

			} // end of for loop

			} // end of for loop

			}
	}
	
	public static void printArray()
	{
		//Print the array
		for(int index=0; index<listOfWinners.length; index++)
		{
			System.out.println(listOfWinners[index].getYear()+" Winners " + listOfWinners[index].getTeam());
		}
	}
	
	public static void searchForWinnerByYear(int year)
	{
		{

			boolean match = false;

			int check = 0;

			while(match != true)

			{

			for(int i=0; i < listOfWinners.length; i++)

			{

			// check to see if the numbers match

			if(listOfWinners[i].getYear() == year)

			{

			match = true;

			System.out.println("Year:" + listOfWinners[i].getYear() + " Winner:" + listOfWinners[i].getTeam());

			}

			}// end of for loop

			// if number does not exit

			if(check == 0)

			{

			System.out.println("Invalid year");

			match = true;

			}

			}// end of while loop

			}


	}
	
	public static void searchForYearsATeamWon(String team)
	{
		{

			boolean match = false;

			int check = 0;

			while(match != true)

			{

			for(int i=0; i < listOfWinners.length; i++)

			{

			if(listOfWinners[i].getTeam().compareTo(team) == 0)

			{

			match = true;

			System.out.println("Year:" + listOfWinners[i].getYear() + " Winner:" + listOfWinners[i].getTeam());

			}

			}// end of loop

			if(check == 0)

			{

			System.out.println("Invalid Team");

			match = true;

			}

			}// end of loop

			}


	}
	
	public static void main(String[] args) {
		
		int choice;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("World Series Program");
		
		//Load textfile 
		loadFromFile();
		do{
			System.out.println("1.........Print out the Winner List sorted by team name");
			System.out.println("2.........Print out the Winner List sorted by years");
			System.out.println("3.........Print out the Winner of a particular year");
			System.out.println("4.........Print out the years a particular team won");
			System.out.println("5.........Exit the Program");
			System.out.println("Which Choice Would You Like?");
			choice = keyboard.nextInt();
			
			switch(choice)
			{
			case 1:
				//Option 1, sort array by name and print out.
				sortByTeamName();
				printArray();
				break;
			case 2:
				//Option 2, sort array by year and print out.
				sortByYear();
				printArray();
				break;
			case 3:
				//Option 3 Search for winner by year
				System.out.println("What year would you like to find the winner?");
				int year = keyboard.nextInt();
				searchForWinnerByYear(year);
				break;
			case 4:
				//Option 4 Search for years a team won
				System.out.println("What team would you like to check for years won?");
				keyboard.nextLine();
				String team = keyboard.nextLine();
				searchForYearsATeamWon(team);
				break;
			case 5://Exit
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}while(choice != 5);
		
		System.out.println("Goodbye!");
	}

}
