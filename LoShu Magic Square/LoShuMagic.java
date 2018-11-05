// Alex Sluborski 
// CIS 180-02
// Homework 3 
// 12/10/17
 class LoShuMagic 
 {
	 public boolean test(int[][]matrix) {
		 int i,j; //to iterate
		 
		 // check if 1<=matrix[i][j] <= 9 or not
		 for (i=0;i<3;i++)
		 {
			 for(j=0;j<3;j++)
				 if(matrix[i][j]<1||matrix[i][j]>9)
					 return false;
					
		 }
		 // get diagonal sum 
		 int d1sum = matrix[0][0] + matrix[1][1] + matrix[2][2]; //left to right diagonal sum
		 int d2sum = matrix[0][2] + matrix[1][1] + matrix[2][0]; //right to left diagonal sum
		 // if diagonals sum is not same return false
		 
		 if(d1sum != d2sum)
	 return false;
		// check for rows and columns
		 int rowSum, colSum; // to hold row sum and column sum
		 for(i=0;i<3;i++)
			 
		 {
			 rowSum = 0; //initialize to 0
			 colSum = 0; //initialize to 0
			 for (j=0;j<3;j++)
			 {
				 rowSum = rowSum + matrix[i][j]; //add each row value to rowSum
				 colSum = colSum + matrix[j][i]; //add each col value to colSum
			 }
			 
			 // if any of rowSum or colSum is not same as diagonal sum return false
			 if(d1sum !=rowSum || d1sum !=colSum)
				 return false;
		 }
		 
		//finally return true if all rules satisfied
		 return true;
	 }
	 
 }

		