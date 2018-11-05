//Alex Sluborski
// CIS 181-02 
// Lab 06
// 3/28/2018

// Takes two integers in a GUI and does arithmetic operations with them 
//This program does multiplcation, subtraction, addition, and division 
// It takes in account for Integer.MAX_VALUE and Integer.MIN_VALUE, if input is not between
// those values then it will return 0, and if the input is invalid ( string chars) then 
// it will return -1. 


public class SmallInt {

    int k; //value of small int

    public SmallInt(int k) { //overloaded constructor with integer argument

        super();

        this.k = k;

    }

    public SmallInt(String s) { //overloaded constructor with String argument

        this.k = setValue(s); // sets k to string int value

    }

    //getters and setters
    public int getK() {

        return k; // returns k

    }

    public void setK(int k) {

        this.k = k; //sets k to k

    }

    //method to check number is numeric or not

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    int setValue(String s) {

        int k;

        try {

            k = Integer.parseInt(s); // try catch exception for invalid input

        } catch (Exception e) {
            if (isNumeric(s)) {
                k = 0;
            } else {
                k = -1;
            }
        }

        if (k < Integer.MIN_VALUE || k > Integer.MAX_VALUE) {
            k = 0; // if sum smaller than min value or max value of integer k than k returns 0
        }
        return k;

    }

    int getValue() {

        return getK(); // returns getk

    }

    //Arithmetical operations
    int add(SmallInt sInt) { // add integers

        int sum;

        sum = sInt.getK() + this.getK();

        if (sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) {
            sum = 0;
        }

        return sum; // returns sum

    }

    int subtract(SmallInt sInt) { //subtract integers

        int sub;

        sub = this.getK() - sInt.getK();

        if (sub < Integer.MIN_VALUE || sub > Integer.MAX_VALUE) {
            sub = 0;
        }

        return sub; // returns sub

    }

    int multiply(SmallInt sInt) { //multiply integers

        int prd;

        prd = sInt.getK() * this.getK();

        if (prd < Integer.MIN_VALUE || prd > Integer.MAX_VALUE) {
            prd = 0;
        }

        return prd; // returns product

    }

    int divide(SmallInt sInt) { // divide integers

        int div;

        div = this.getK() / sInt.getK();

        if (div < Integer.MIN_VALUE || div > Integer.MAX_VALUE) {
            div = 0;
        }

        return div; // returns division

    }

}

