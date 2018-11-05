//Student Name: Alex Sluborski
//Class: CIS 180-02
// Assignment: Lab 7 
// Due Date: 11/9/17


import java.util.Scanner;

public class MainClass {
// variables
public int menuOption;

public boolean loopStatus = true;

private Scanner scanner;

private RandomGame randomGame;

public MainClass() {


// create scanner
scanner = new Scanner(System.in);
menuOption = 0;

{
randomGame = new RandomGame(scanner);
}

}

public static void main(String[] args) {
// creates a return method 
MainClass obj = new MainClass();

do {

// show menu

// prints out menu with do while loop to make menu loop
System.out.println("1. Random Game Version 1");

System.out.println("2. Random Game Version 2");

System.out.println("3. While vs Do…While vs For");

System.out.println("4. Quit");

System.out.println("Enter option number: ");

// take input

obj.menuOption = obj.scanner.nextInt();

// process input

switch (obj.menuOption) {

case 1:

obj.randomGame.checkWhile();

break;

case 2:

obj.randomGame.checkFor();

break;
// question 
case 3: System.out.println("'While' loop first checks the loop condition and then executes the loop body, whereas 'Do.. While' loop\n"

+" executes the loop body at least once and then checks the loop condition. 'For' loop works similar to 'While' loop but is usually\n"

+" used when number of iterations are already known.");

break;

case 4:

obj.loopStatus = false;

break;

default:

System.out.println("Wrong option!");

break;

}

} while (obj.loopStatus);

// print exit message

System.out.println("Thanks for playing!");

// close the scanner

obj.scanner.close();

}

}