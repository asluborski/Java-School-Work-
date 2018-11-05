//Student Name: Alex Sluborski
//Class: CIS 180-02
// Assignment: Lab 7 
// Due Date: 11/9/17

// import scanner and create variables 
import java.util.Scanner;
public class RandomGame {
	public boolean guessed = false;

	public int randomNumber;

	public int userNumber;

	public int guesses;

	private Scanner scanner;

	public RandomGame(Scanner newInput) {

	scanner = newInput;

	guesses = 5;

	}
// method for first game
	public void checkWhile() {

	// reset guessed

	guessed = false;

	// generate a random number

	newRandom();

	// ask user

	while (!guessed) {

	System.out.println("Guess a number between 1 to 10: ");

	userNumber = scanner.nextInt();

	if (userNumber == randomNumber) { // if correct guess

	guessed = true;

	System.out.println("Congratulations, you have won!!");

	} else { // else show retry message

	System.out.println("Wrong guess, please try again!");

	}

	}

	}

	public void checkFor() {

	// reset guessed

	guessed = false;

	// generate a random number

	newRandom();

	// ask user

	for (int i = 0; i < guesses; i++) {

	System.out.println("Guess a number between 1 to 10: ");

	userNumber = scanner.nextInt();

	if (userNumber == randomNumber) { // if correct guess

	guessed = true;

	break;

	} else if ((i + 1) < guesses) { // if more chances are available

	System.out.println("Wrong guess, please try again!");
	System.out.println("You have " + (guesses-i-1)+"guesses remaining. ");

	}

	}

	if (guessed) {

	System.out.println("Congratulations, you have won!!");

	} else {

	System.out.println("Game Over!");

	}

	}

	public void newRandom() {

	// generate a random number

	randomNumber = (int) (Math.floor(Math.random() * 10) + 1);

	}

	}

