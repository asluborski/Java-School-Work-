/***********************************************************
 * Project #2 (CIS 181, Fall 2008)                         *
 * Submitted By: Alex Sluborski                            *
 * SID: 01656119                                           *
 * Date: 4/12/18                                           *
 ***********************************************************/

/**
 * CIS 181 Array Based Implementation of Conway's Game Of Life
 * The game of life class: GameOfLife.java
 *
 * @author Haiping Xu
 * Created on October 25, 2008
 **/

//This program implements the gameoflife with certain test cases by determining wether a cell is alive or dead in its respective
//rows and columns

public class GameOfLife implements GameInterface {
    private boolean[][] originalMap,    // The initial cell configuration
                                map,    // The current cell configuration
                             newMap;    // The next generation configuration
    private GameGUI gui;
    private int generation = 0;
    private FileIO fileIO;

    // GameOfLife constructor
    public GameOfLife() {
        originalMap = new boolean[MAX_ROWS][MAX_COLS];
        map = new boolean[MAX_ROWS][MAX_COLS];
        newMap = new boolean[MAX_ROWS][MAX_COLS];
        gui = new GameGUI(this, map);
        gui.setTitle("CIS 181 Array Based Game Of Life");
        fileIO = new FileIO("life", "Game of Life Text Files");
        readExample(2);
    }

    //  ====>>>>> Complete the methods below this line! <<<<<====

    // copyMap:
    // Precondtions: None.
    // Postcondtion: 'map' is a deep copy of 'sourceMap'.
    //
    private void copyMap(boolean sourceMap[][]) {

        // ==> 1. Add your code here!
    	for (int rows = 0; rows < MAX_ROWS; rows++) { // adds rows
    		for (int columns = 0; columns < MAX_COLS; columns++) { // adds colums
    			map[rows][columns] = sourceMap [rows] [columns]; // map object instantiates from source map
    		}
    	}
    	

    }

    // clearMap:
    // Precondtions: None.
    // Postcondtion: Sets all cells of the 'targetMap' to DEAD.
    //
    private void clearMap(boolean targetMap[][]) {

        // ==> 2. Add your code here!
    	for (int rows = 0; rows < MAX_ROWS; rows++) { // for loop for rows
    		for (int columns = 0; columns < MAX_COLS; columns++) { // for loop for columns
    			targetMap [rows] [columns] = DEAD; //cells of target map = dead (rows + columns)
    			
    		}
    	}

    }

    //  getFlatNeighborCount:
    //  Precondtions:  0 <= row < MAX_ROWS and 0 <= col < MAX_COLS.
    //  Postcondtion:  A count of all LIVE neighbors of the cell at [row, col] is
    //                 returned where its neighbors are all the ADJACENT cells
    //                 including those
    //                 a) In the rows BELOW and ABOVE the cell (if any exist).
    //                 b) In the columns LEFT and RIGHT of the cell (if any exist).
    //                 Thus, a cell adjacent to a board edge (or corner) has
    //                 fewer neighbors than other cells.
    //
    private int getFlatNeighborCount(int row, int col){
        int count = 0;

        // ==> 3. Add your code here!
        // gets for rows below and columns  below
        if(row - 1 >= 0) {
        	if(map[row-1][col]) {  
        	count++;
        }  
        	if(col - 1 >= 0 && map[row - 1][col - 1]) {
        		count++;
        	}
        } // gets for rows above and columns above
        if (row + 1 < MAX_ROWS) {
        	if(map[row + 1][col]) {
        		count++;
        	}
        	if(col + 1 < MAX_COLS && map[row + 1][col + 1]) {
        		count++;
        	}
        }// gets for rows and colums left
        if(col - 1 >=0) {
        	if (col - 1 >= 0 && map[row][col - 1]) {
        		count++;
        	}
        	if(row + 1 < MAX_ROWS && map [row +1][col - 1]) {
        		count++;
        	}
        }
        // gets for rows and columns right
        if(col + 1 < MAX_COLS) {
        	if(map[row][col + 1]) {
        		count++;
        	}
        	if(row -1 >= 0 && map[row - 1][col + 1]) {
        		count++;
        	}
        }
        return count; // returns count of cells 
    }


    // nextGenerationForFlatGrid:
    // Precondtions: None
    // Postcondtion: The next generation of live and dead cells is calculated using
    //               a) the FLAT neighbor counts.
    //               b) the current birth, survival and death count rules.
    //               c) the rules are applied to the counts obtained from the current
    //                  generation's configuration of live and dead cells.
    //               The current 'map' is updated to the next generation's configuration
    //               of live and dead cells.
    //		     d) the global variable 'generation' is increased by 1
    //	
    public  void nextGenerationForFlatGrid() {

        // ==> 4. Add your code here!
    	
    	for(int row = 0; row < MAX_ROWS; row++){
         	for(int col = 0; col < MAX_COLS; col++){
         		int neighborCount = getFlatNeighborCount(row, col);
         		if(!map[row][col] && neighborCount == 3){ // if three live neighbors then cell stays alive
         			newMap[row][col] = ALIVE;
         		}
         		else if(map[row][col] && (neighborCount == 2 || neighborCount == 3)){ // if 2 neighbors or three neighbors cell stays alive
         			newMap[row][col] = ALIVE;
         		}
         		else if(map[row][col] && neighborCount <= 1){ // if only 1 neighbor then cell dies
         			newMap[row][col] = DEAD;
         		}
         		else if(map[row][col] && neighborCount >= 4){ // if 4 neighbors cell dies
         			newMap[row][col] = DEAD;
         		}
         	}
         }
    	copyMap(newMap); // copies map
    	clearMap(newMap); //clears map
    	generation++; // generation incremented by 1

    }


    // ==> 5. Implement the game of life for torus grid.
    
    //getTorusNeighborCount
     //  Preconditions:  0 <= row < MAX_ROWS and 0 <= col < MAX_COLS.
     //  Postconditions: The count is increased for each living adjacent neighbor.
     //   This counts only neighbors located on adjacent edges of the grid.
     //   The count is returned when finished.
     
    public int getTorusNeighborCount(int row, int col){
    	int count = 0;
    	if((row == MAX_ROWS - 1) && map[0][col]){
    		count++;
    	}
    	if((row == MAX_ROWS - 1 && col > 0) && map[0][col - 1]){
    		count++;
    	}
    	if((row == MAX_ROWS - 1 && col < MAX_COLS - 1) && map[0][col + 1]){
    		count++;
    	}
    	if(row == 0 && map[MAX_ROWS - 1][col]){
    		count++;
    	}
    	if((row == 0 && col > 0) && map[MAX_ROWS - 1][col - 1]){
    		count++;
    	}
    	if((row == 0 && col < MAX_COLS - 1) && map[MAX_ROWS - 1][col + 1]){
    		count++;
    	}
    	if((col == MAX_COLS - 1) && map[row][0]){
    		count++;
    	}
    	if((col == MAX_COLS - 1 && row > 0) && map[row - 1][0]){
    		count++;
    	}
    	if((col == MAX_COLS - 1 && row < MAX_ROWS - 1) && map[row + 1][0]){
    		count++;
    	}
    	if((col == 0) && map[row][MAX_COLS - 1]){
    		count++;
    	}
    	if((col == 0 && row > 0) && map[row - 1][MAX_COLS - 1]){
    		count++;
    	}
    	if((col == 0 && row < MAX_ROWS - 1) && map[row + 1][MAX_COLS - 1]){
    		count++;
    	}
    	if((row == 0 && col == 0) && map[MAX_ROWS - 1][MAX_COLS - 1]){
        	count++;
        }
    	if((row == MAX_ROWS - 1 && col == 0) && map[0][MAX_COLS - 1]){
    		count++;
    	}
    	if((row == 0 && col == MAX_COLS - 1) && map[MAX_ROWS - 1][0]){
    		count++;
    	}
    	if((row == MAX_ROWS - 1 && col == MAX_COLS - 1) && map[0][0]){
    		count++;
    	}
    	return count;
    }
    
    
   // nextGenerationForTorusGrid()
    // Precondition: None
    // Postcondition: The grid is updated utilizing the FLAT and TORUS neighbor counts.
    // The same birth, survival and death rules apply as with the FLAT generation.
    // The generation variable is increased by 1.

    public  void nextGenerationForTorusGrid() {
    	for(int row = 0; row < MAX_ROWS; row++){
         	for(int col = 0; col < MAX_COLS; col++){
         		int neighborCount = getFlatNeighborCount(row, col) + getTorusNeighborCount(row, col);
         		if(!map[row][col] && neighborCount == 3){  // if 3 neighbors then cell stays alive
         			newMap[row][col] = ALIVE;
         		}
         		else if(map[row][col] && (neighborCount == 2 || neighborCount == 3)){ // if 2 or 3 neighbors cell stays alive
         			newMap[row][col] = ALIVE;
         		} 
         		else if(map[row][col] && neighborCount <= 1){ // if 1 or less neighbor cell dies
         			newMap[row][col] = DEAD;
         		}
         		else if(map[row][col] && neighborCount >= 4){ // if 4  neighbors cell dies (overcrowded)
         			newMap[row][col] = DEAD;
         		}
         	}
         }
    	copyMap(newMap);  //copies map
    	clearMap(newMap); //clears map
    	generation++; //generation increments by 1
    }



    //  ====>>>>> Don't touch the code below this line! <<<<<====

    // Return the next generation
    public int getGeneration() {
        return generation;
    }

    // Reset the map to the original map
    public void reset() {
        copyMap(originalMap);
        generation = 0;
        gui.repaint();
    }

    // Game of life examples 1-4: Fish, Plus, Glider, FlyingMachine
    public void readExample(int n) {
        System.out.println("Initializing with example " + n + " ...");
        clearMap(originalMap);

        switch (n) {
           case 1: // Example 1: Fish
             for (int col = 23; col <= 26; col++)
                 originalMap[13][col] = ALIVE;
             originalMap[14][22] = ALIVE;
             originalMap[14][26] = ALIVE;
             originalMap[15][26] = ALIVE;
             originalMap[16][22] = ALIVE;
             originalMap[16][25] = ALIVE;
             break;
           case 2: // Example 2: Plus
               for (int col = 6; col < 43; col++)
                 originalMap[24][col] = ALIVE;
             for (int row = 6; row < 43; row++)
                 originalMap[row][24] = ALIVE;
             break;
           case 3: // Example 3: Glider
                originalMap[14][23] = ALIVE;
             originalMap[15][24] = ALIVE;
             for (int row = 13; row <= 15; row++)
                 originalMap[row][25] = ALIVE;
             break;
           case 4: // Example 4: FlyingMachine
                for (int col = 22; col <= 25; col++) {
                 originalMap[11][col] = ALIVE;
                 originalMap[19][col] = ALIVE;
             }
             for (int row = 14; row <= 16; row++)
                 for (int col = 17; col <= 18; col++)
                     originalMap[row][col] = ALIVE;
             originalMap[15][19] = ALIVE;
             for (int row = 12; row <= 18; row = row+2)
                 originalMap[row][21] = ALIVE;
             originalMap[14][24] = ALIVE;
             originalMap[16][24] = ALIVE;
             originalMap[12][25] = ALIVE;
             originalMap[13][25] = ALIVE;
             originalMap[17][25] = ALIVE;
             originalMap[18][25] = ALIVE;
             break;
           default: // Default Example: ClearSpace
             break;
        }

        copyMap(originalMap);
        generation = 0;
        gui.repaint();
    }

    //  Read map from file
    public void readInMap() {
        clearMap(originalMap);
        if (fileIO.read(originalMap)) {
            copyMap(originalMap);
            generation = 0;
        } else
            readExample(2);
        gui.repaint();
    }

    // Write map to file
    public void writeMap() {
       fileIO.write(map);
    }

    // Change the state of a cell
    public void updateMap(int row, int col) {
        map[row][col] = !map[row][col];

    }

    // Destroy the GUI window
    public void destroy() {
        gui.dispose();
    }

    // The main method of GameOfLife
    public static void  main(String[] args) {
        GameOfLife game = new GameOfLife();
    }
}
