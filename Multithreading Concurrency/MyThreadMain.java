/* Alex Sluborski
 * CIS 181-02 
 * Lab 5 
 * 3/23/18
 */
public class MyThreadMain {

	public static void main(String[] args) {
/*	STEP A 	
Thread t1 = new MyThread(); // step a ii: creates instance of MyThread class


t1.start(); // step a ii: starts thread 

	}

}
*/   
		
		  /* Step B-D
		   Thread t1 = new MyThread("Dwight",1); //sets name to thread dwight, files one paper 
		  Thread t2 = new MyThread();
		 
		t1.start(); // starts thread
		t2.start(); //starts thread
}
}
*/
		Thread t1 = new MyThread("Jim", 5); // sets thread name to jim , 5 papers ( new thread object)
		Thread t2 = new MyThread("Pam", 5); // sets thread name to pam, 5 papers ( new thread object 2)
		t1.start(); //starts threads
		t2.start();
	}
	
}
