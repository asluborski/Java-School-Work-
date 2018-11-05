//Student Name: Alex Sluborski
// Class: CIS 180-02 
// Assignment: Lab 9 
// Due Date: 11/23/17
public class IntegerConverter {
	public static String toHex(int number)
	{
		String total = "";
		
		//If the number is negative, make it positive
		if(number<0)
		{
			number = number*-1;
		}
		
		do{
			int value = number % 16;
			//If the value of 'value' is greater than 9, assign the appropriate letter
			switch(value)
			{
			case 10:
				total+="A";
				break;
			case 11:
				total+="B";
				break;
			case 12:
				total+="C";
				break;
			case 13:
				total+="D";
				break;
			case 14:
				total+="E";
				break;
			case 15:
				total+="F";
				break;
			default:
				total+=value;
					
			}
			
			//divide out 16 and repeat
			number=number/16;
		}
		while(number!=0);
		
		//reverse the string
		total = (new StringBuilder(total)).reverse().toString();
		return total;
	}
	
	public static String toBinary(int number)
	{
	// convert from decimal to binary
		String total = "";
		int a;
		while (number > 0) {

			a = number % 2;

			total = total + "" + a;
// divide number by 2 
			number = number / 2;

			}

// return value 
		return (new StringBuilder(total)).reverse().toString();
		
	}
	
	public static String toRomanNumeral(int number)
	{
		/* 
		 * I = 1
		 * IV = 4
		 * V = 5
		 * IX = 9
		 * X = 10
		 * XL = 40
		 * L = 50
		 * XC = 90
		 * C = 100
		 * CD = 400
		 * D = 500
		 * CM = 900
		 * M = 1000
		 * 
		 * Rules
		 * the numeral I can be placed before V and X to make 4 units (IV) and 9 units (IX) respectively
		 * X can be placed before L and C to make 40 (XL) and 90 (XC) respectively
		 * C can be placed before D and M to make 400 (CD) and 900 (CM) according to the same pattern
		 * 
		 * 
		 */
		String total = "";
		int times = 0;
// take roman strings and integers 
		String[] romans = new String[] { "I", "IV", "V", "IX", "X", "XL", "L",

		"XC", "C", "CD", "D", "CM", "M" };

		int[] ints = new int[] { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500,

		900, 1000 };
// convert from decimal to roman numerals
		for (int i = ints.length - 1; i >= 0; i--) {

		times = number / ints[i];

		number %= ints[i];

		while (times > 0) {

		total += romans[i];

		times--;

		}

		}
		
		// return total 
		return total;
	}

}


