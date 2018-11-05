/***********************************************************
* Lab #1 (CIS 181) *
* Submitted By: Alex Sluborski *
* SID: 00656119 *
* Date: 2/21/18 *
***********************************************************/
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// Print out the return value of the caesarEncrypt method using the parameters ("Hello World",13)
						System.out.println(caesarEncrypt("Hello World",13));
						
						// Create your scanner
						Scanner sc = new Scanner(System.in);
						
						// Get the phrase to decipher from the user and store it in a temporary String variable
						// Assignment will use (dlsjvtl ihjr av jpz!)
						System.out.println("Input string you wish to decipher");
						String input = sc.nextLine();
						System.out.println("Input key");
						
						// Get the key from the user and store it in a temporary variable
						// Assignment will use (7)
						// *Tip: Don't forget to clear the newline character after getting an integer
						int key = sc.nextInt();
						
						// Print to file the return value of the caesarDecrypt method using the parameters gathered from the user
						print(caesarDecrypt(input,key));
					}

					// Method that takes in a String to be encrypted and the key to encrypt it with, then returns the encrypted String
					private static String caesarEncrypt(String phrase, int key) {
						
						// Make the entire String Upper Case
						String capitals = phrase.toUpperCase();
						
						// Convert the String into an array of characters (char[])
						char[] array = capitals.toCharArray();
						
						// Iterate through each character in the array
						for(int i=0;i<array.length;i++){
							
							// If the character is not a letter, skip it (letters are 65-90 and skip using continue)
							char c = array[i];
							if(c<65||c>90) continue;
							
							// Create a temporary integer variable give it the value of the current character
							int temp = c;
							
							// Convert the ASCII value to 0-25 by subtracting 65
							temp -=65;
							
							// Shift the integer value by adding the key
							temp+=key;
							
							// While the integer value is negative, add 26
							if(temp<0)temp+=26;
							
							// Wrap the integer value by modding it by 26
							temp = temp%26;
							
							// Convert the 0-25 value to ASCII by adding 65
							temp+=65;
							
							// Set the current character value to the character value of the temporary integer variable
							array[i] = (char)temp;
						}
						

						// Return the String value of the encrypted character array
						return new String(array);
						
						
					}
					
					// Method that takes in a String to be decrypted and the key to decrypt it with, then returns the decrypted String
					private static String caesarDecrypt(String phrase, int key) {
						//Make the entire String Upper Case
						String capitals = phrase.toUpperCase();
						
						//Convert the String into an array of characters 
						char[] array = capitals.toCharArray();
						
						// Iterate through each character in the array
						for(int i=0;i<array.length;i++) {
							
							//if the character is not a letter, skip it (letters are 65-90 and skip using continue)
							char c = array[i];
							if (c<65||c>90) continue;
							
							// create a temporary integer variable
							int temp = c;
							
							// convert the ASCII Value to 0-25 by subtracting 65
							temp -=65;
							
							//decrypt the integer value by subtracting the key
							temp-=key;
							
							// while the integer value is neg add 26
							if (temp<0)temp+=26;
							
							//wrap the integer value by modding it by 26
							temp = temp%26;
							
							//convert the 0-25 value to ascII by adding 65
							temp+=65;
							
							//Set the current char value to the char value of the temp integer
							array[i] = (char)temp;
							
						}
					return new String(array);
					}
					
					// Method that takes in a String and writes it to a text file
					private static void print(String text){
						// String variable containing the file path to write to
						String filePath = "lab1.txt";
						
						// Attempt to create a FileWriter and BufferedWriter, then write the String to the given file path
						try {
							FileWriter fw=new FileWriter(filePath);
							BufferedWriter buffer = new BufferedWriter(fw);
							buffer.write(text);
							buffer.close();
						}
						// If it is successful, print out a confirmation message
						// If it fails, print out the error message
						catch(Exception e) {
							System.out.println(e);
						}
						System.out.println("Success!");
						// *Tip: Make sure to close the BufferedWriter!
						
						
					}
					
				
			



	}


