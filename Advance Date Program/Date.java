/***********************************************************
* Lab #2 (CIS 181) *
* Submitted By: Alex Sluborski *
* SID: 00656119 *
* Date: 2/21/18 *
***********************************************************/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 public class Date {
	 private int month;

	 private int day;

	 private int year;

	 public Date() {

	      month = 1;

	      day = 1;

	      year = 2006;

	 }

	 public Date (int m, int d, int y) {

	      month = m;

	      day = d;

	      year = y;

	 }

	 // -----------------------------------------------------

	 // checks if date is valid

	 // precondition: mon, day and year are integers

	 // postcondition: if the combination of mon, day and year represents a valid date, a true value is returned; otherwise,

	 //a false value is returned

	 public static boolean isLegitimate(int month, int day, int year){

	      if((month>=1&&month<=12)&&(day>0&&day<32)&&(year>0)) {

	          // check the month of february

	          if((month==2)&&day<=29){

	              //check for leap year, february month

	              if ((year % 4 == 0)&&((!(year % 100 == 0))&&(day<30) || (year % 400 == 0))&&(day<30)) {

	                  return true;

	              }

	             

	              //check for nonleap year

	             

	              else if ((month==2)&&day<29) {

	                  return true;

	              }

	             

	              else

	                  return false;

	         

	          }else if((month==2)&&day>29){
	          return false;
	          }

	          // check for months having 30 days only

	          else if((month==4||month==6||month==9||month==11)&&(day>30)) {

	              return false;

	          }

	          else

	              return true;

	      }

	      else {

	          return false;

	      }

	 }

	 //advance date by one day

	 // precondition aDate is a valid date

	 //postcondition: aDate is a new valid date advanced by one day

	 public static void advanceDate(Date aDate) {
	   
	   if(!isLegitimate(aDate.month, aDate.day, aDate.year)){
	    System.out.println("Incorrect date");
	    return;
	   }

	      //advance for months having 31 days

	      if((aDate.month==1||aDate.month==3||aDate.month==5||aDate.month==7||aDate.month==8||aDate.month==10||aDate.month==12)) {

	          // advances date

	          aDate.day=aDate.day+1;

	          if(aDate.day>31) {

	              aDate.day=1;

	              aDate.month=aDate.month+1;

	              if(aDate.month>12) {

	                  aDate.day=1;

	                  aDate.month=1;

	                  aDate.year=aDate.year+1;

	              }

	          }

	                 

	      }

	     

	      //advance for months having 30 days

	      else if ((aDate.month==4||aDate.month==6||aDate.month==9||aDate.month==11)) {

	          aDate.day=aDate.day+1;

	          if(aDate.day>30) {

	              aDate.day=1;

	              aDate.month=aDate.month+1;

	          }

	      }

	      //advance for february dates
	     

	      else if (aDate.month==2) {
	      if(aDate.day <28){
	        aDate.day=aDate.day+1;
	      }

	      else if (aDate.day==28){
	          if(aDate.year%4 == 0)
	           {
	               if( aDate.year%100 == 0)
	               {
	                   // year is divisible by 400, hence the year is a leap year
	                   if ( aDate.year%400 == 0)
	                   aDate.day=aDate.day+1;
	                   else{
	                   aDate.day=1;
	                    aDate.month=aDate.month+1;
	                   }
	                      
	               }
	               else
	               aDate.day=aDate.day+1;
	           }
	           else{
	           aDate.day=1;
	               aDate.month=aDate.month+1;
	           }
	             
	         
	         
	          }

	      else if(aDate.day > 28){
	        aDate.day=1;
	              aDate.month=aDate.month+1;
	      }

	          }
//prints
	      System.out.println(aDate.month + " " + aDate.day + " " + aDate.year );
	      }
	     

	 public void display (String s) {
//print format
	      System.out.println(s + month + "/" + day + "/" + year);

	 }

	 public static void main(String args[]){
	   Date date = new Date(2, 28, 2000);
	   //System.out.println(date.isLegitimate(2, 12, 2000));
	   date.advanceDate(date);
	 }

	 }