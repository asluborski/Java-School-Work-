import java.util.Scanner;
public class traveltcalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

double time;
String answer; 
System.out.println("Welcome to the time travel calculator");

Scanner sc = new Scanner(System.in);
do {
System.out.println("Enter miles: ");
double miles = sc.nextDouble();
System.out.println("Enter MPH: ");
double mph = sc.nextDouble();
time = miles/mph;
System.out.println("Time in hours is " + time + "\n" + "Time in minutes is " + " " + time*60 + "\n");
System.out.println("Continue? (Yes/No)");
answer = sc.next();
}
while (answer.equalsIgnoreCase("Yes"));
	}

}
