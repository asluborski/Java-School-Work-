/* Alex Sluborski
 * CIS 181-02 
 * Lab 5 
 * 3/23/18
 */
/* This program shows an example of multithreading by extending thread class and running two threads concurrently
 * 
 */
import java.util.concurrent.Semaphore;
public class MyThread extends Thread{  //extends thread class
	
	 private int numberOfPapers;
	   static Semaphore desk = new Semaphore(1,true); //step e // sends signal through threads (desk) sets true

	   // step b Constructor
	   public MyThread(String name, int numberOfPapers) // sets name as string, number of papers as int 
	   {
	       this.setName(name);  //sets name method
	       this.numberOfPapers=numberOfPapers; //sets number of papers
	   }

	   //run method
	   public void run()
	   {
	       //System.out.println("Office Threading");// step a print office threading
	       int count=1;
	       // step b  
	       while(count <= numberOfPapers) // counts number of papers
	       {
	           try {
	               desk.acquire(); // Step e // acquires thread
	               System.out.println( Thread.currentThread().getName() + " has filed paper #" + count); // get name method, counts # of papers and prints it
	               //Thread.yield(); //Step c i
	               count++; //counts papers up ++
	               desk.release(); // Step e //releases thread
	           } catch (InterruptedException e1) {
	               // TODO Auto-generated catch block
	               System.out.println("Thread interrupted"); // catch exception 
	           }
	           //Thread.sleep(500); // step d
	           // catch (InterruptedException e) {
	           // TODO Auto-generated catch block
	           //   e.printStackTrace();
	           //}

	       }
	       if(count > numberOfPapers) // once count reaches 5, prints out statement that its done for the day
	           System.out.println( Thread.currentThread().getName()+ " has finished their work for the day!"); // prints out when finished
	   }

	}