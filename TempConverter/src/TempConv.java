import java.util.Scanner;
public class TempConv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("Welcome to the temperature converter");
double celcius;
String answer;

Scanner sc = new Scanner (System.in);
do {

System.out.println("Enter degrees in Farenheit: ");
double farenheit = sc.nextDouble();
celcius = (farenheit -32) *5/9;
System.out.println("Degrees in Celcius:" +" " + celcius + " ");
System.out.println("Continue? (Yes/No)");
answer =sc.next();
}
while (answer.equalsIgnoreCase("Yes"));
	}

}



