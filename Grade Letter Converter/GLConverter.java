import java.util.Scanner;
public class GLConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Letter Grade Converter");


Scanner sc = new Scanner(System.in);
int grade;
String answer;
do {

System.out.println("Enter Numerical Grade: ");
 grade = sc.nextInt();
if (grade >= 90) { 
System.out.println("A");

} else if  (grade >= 80) {
System.out.println("B");

} else if (grade >= 70) {
	System.out.println("C");
 
} else if (grade >= 60) {
	System.out.println("D");

} else 
	System.out.println("F");
System.out.println("Continue? Yes/No");
 answer = sc.next();
}
while (answer.equalsIgnoreCase("Yes"));
}

}