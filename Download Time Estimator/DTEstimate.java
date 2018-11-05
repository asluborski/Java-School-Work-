import java.util.Scanner;
public class DTEstimate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

Scanner sc = new Scanner(System.in);
String answer;
do {

System.out.println("Welcome to the Download Time Estimator");
System.out.println();
System.out.println("Enter File Size (MB): ");
double fileSize = sc.nextDouble();
System.out.println("Enter Download Speed (MB/sec) : ");
double downloadSpeed = sc.nextDouble();
int total_seconds = (int) (fileSize/downloadSpeed);
int total_hours = total_seconds/3600;
int total_mins = (total_seconds%3600)/60;
int remaining_seconds = (total_seconds%60);

System.out.println("Time required: Hours = " + total_hours + "; Minutes = " + total_mins + "; Seconds = " + remaining_seconds);

System.out.println("Continue? (Y/N)");
answer = sc.next();
}
while(answer.equalsIgnoreCase("y"));
}
}

