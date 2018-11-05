/* Alex Sluborski
 * CIS 180-02 
 * Homework 2 
 * 11/21/17
 */

import java.util.Scanner;

public class InventoryTrackerInterface extends Inventory{
	   // Main method
	   public static Inventory inv = new Inventory();
	   public static void main(String[] args)
	   {
	       Scanner scanner = new Scanner(System.in);
	       int operation,suboperation;
	       String name;
	       int quantity;
	       double price;
	       String upc;
	       Item item;

	       boolean keepDoing = true;
	       while (keepDoing)
	       {
	           System.out.println("\nChoose an operation below:");
	           System.out.println("1: Add an item to inventory");
	           System.out.println("2: Get an item info");
	           System.out.println("3: Save inventory to file");
	           System.out.println("4: Load inventory from file");
	           System.out.println("5: Exit");
	           if (scanner.hasNextInt())
	               operation = scanner.nextInt();
	           else
	           {
	               System.out.println("Error: you must enter an integer.");
	               scanner.close();
	               return;
	           }

	           switch (operation)
	           {
	           case 1: // Add an item to inventory
	               System.out.println("Enter the new item name");
	               name = scanner.next();
	               System.out.println("Enter the new item quantity");
	               quantity = scanner.nextInt();
	               System.out.println("Enter the new item price");
	               price = scanner.nextDouble();
	               System.out.println("Enter the new item upc");
	               upc = scanner.next();
	               item= new Item(name,quantity,price,upc);
	               inv.addItem(item);
	               break;

	           case 2:
	               if(inv.getTotalNumberOfItems()==0)
	               {
	                   System.out.println("No Items in Inventory");
	               }// Get an item info
	               else {
	                   int count= inv.getTotalNumberOfItems()-1;
	                   System.out.println("Which item would you like info for [0-" + count + "]" );
	                   suboperation = scanner.nextInt();
	                   item = inv.getItem(suboperation);
	                   System.out.println("Name : " + item.getName() );
	                   System.out.println("Quantity : " + item.getQuantity());
	                   System.out.println("Price : " + item.getPrice() );
	                   System.out.println("UPC : " + item.getUPC() );

	               }
	               break;

	           case 3: // Save inventory to file
	               inv.saveInventoryToFile("output.txt");
	               System.out.println("Inventory saved");
	               break;

	           case 4: // Load inventory from file
	               inv.loadInventoryToFile("output.txt");
	               System.out.println("Inventory loaded");
	               break;

	           case 5: // Exit
	               System.out.println("Goodbye!");
	               keepDoing=false;
	               scanner.close();
	               break;

	           }

	       }
	       scanner.close();
	       keepDoing=false;

	   }

	}
