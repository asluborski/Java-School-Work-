//Alex Sluborski
// CIS 181-02 
// Lab 06
// 3/28/2018




//calculator class that displays arithmetic on GUI
	public class Calculator implements Process {

           protected final String PROMPT = "In the Input line, please enter "; // system print

           protected final int SENTINEL = -1; // -1 if invalid input

           int count=1;//counting to input values

           protected GUI gui;

           SmallInt[] num=new SmallInt[2]; //storing input values into array

           //Constructor default initiating GUI

           public Calculator() {

               gui = new GUI(this); // initiates gui

               gui.print(PROMPT+"NUM-"+count+": ");

           }

           @Override

           public void processInput(String s) {

               gui.println(s);
            

               num[count-1]=new SmallInt(s); //storing into array

            

               if(count==2){ //checking whether two number are collected

                   // gui prints out the arithmetic

            	   //add
                   gui.println("\t"+num[0].getValue()+"\n + \n \t"+num[1].getValue()+" \n ------------------------\n "+ "\t" + num[0].add(num[1]));

                   //subtract
                   
                   gui.println("\t"+num[0].getValue()+"\n - \n \t"+num[1].getValue()+" \n ------------------------\n "+ "\t" +num[0].subtract(num[1]));

                   //multiply
                   
                   gui.println("\t"+num[0].getValue()+"\n X \n \t"+num[1].getValue()+" \n ------------------------\n "+ "\t" +num[0].multiply(num[1]));

                   //divie 
                   
                 gui.println("\t"+num[0].getValue()+"\n / \n \t"+num[1].getValue()+" \n --------------------------\n "+ "\t"+num[0].divide(num[1]));

                   gui.freeze( ); //freezing input textbox

                   gui.print("\n\n\nCompleted you can close the WINDOW"); // prints out completion message

               }

               else{

               count++; // else counts number

               gui.print(PROMPT+"NUM-"+count+": ");

               }

            

           }

      

           public static void main(String argv[]) { //main method creates new instance

               Calculator age = new Calculator(); 

               }

        }