import java.util.Scanner;
public class TestScore {
public static void main(String[] args) {
	char choice;
	int totalScore, scoreCount, testScores, minimum, maximum;
	
	//create scanner object
	Scanner sc = new Scanner(System.in);
	
	//do..while loop
	do
	{
		
		//initialize variables
		totalScore = 0;
		testScores = 0;
		minimum = 999;
		maximum = 0;
		System.out.print(" enter the number of test scores to be enterd: ");
		scoreCount = sc.nextInt();
		System.out.println();
		
		// get a series of test scores from the user
		for (int i = 0; i < scoreCount; i++)
		{
			//get input from user
			System.out.print("Enter score: " + (i + 1) + " : ");
			testScores = sc.nextInt();
			
			// accumulate score count and score total
			if ((testScores >= 0) && (testScores <= 100))
			{
				//calculation of total
				totalScore = totalScore + testScores;
				
				// to find the maximum value
				if (testScores > maximum)
					maximum = testScores;
				
				// to find the minimum value
				if (testScores < minimum)
					minimum = testScores;
			}
			// if invalid input, display error message
			// and defrement the iterative value
			else 
			{
				System.out.println("Invalid entry, not counted");
				i--;
			}
		}
		// display the score count, score total, minimum, maximum, and average score
		double averageScore = totalScore / scoreCount;
		String message = "\n" + "Score Count: " + scoreCount + "\n" + "Score Total : "
		+  totalScore + "\n" + "Average score: " + averageScore + "\n"
		+ "Minimum score: " + minimum + "\n" + "Maximumn score: " + maximum + "\n";
		System.out.println(message);
		
		//prompt the user whether he or she wants to continue
		System.out.print("Enter more test scores? (y/n) : ");
		choice = sc.next().charAt(0);
		System.out.println();
		
		//test the condition
		} while (choice == 'y' || choice == 'Y');
	
		

}
}


