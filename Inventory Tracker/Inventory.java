import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Inventory {
	private int totalItems=0;
	   private Item[] itemArray = new Item[100];

	   /**
	   * @return the totalItems
	   */
	   public int getTotalNumberOfItems() {
	       return totalItems;
	   }

	   public Item getItem(int index)
	   {
	       Item i= null;
	       if(index >= 0 && index < totalItems)
	       {
	           i= itemArray[index];
	       }
	       else {
	           System.out.println("Item NOT FOUND");
	       }
	       return i;
	   }

	   public void addItem(Item newItem)
	   {
	       if(totalItems == 100)
	       {System.out.println("Stock FULL");}
	       else {
	           itemArray[totalItems]= newItem ;
	           totalItems++ ;
	       }
	   }

	   public void saveInventoryToFile(String fileName)
	   {
	       PrintWriter output=null;
	       BufferedWriter bufferedWriter=null;
	       File file=null;
	       Item item=null;
	       try {
	           file = new File(fileName);
	           output = new PrintWriter(file);
	           bufferedWriter =
	                   new BufferedWriter(output);
	           for(int i=0;i< totalItems;i++)
	           {      
	               item= itemArray[i];
	               // writing to file
	               bufferedWriter.write(item.getName());
	               bufferedWriter.newLine();
	               bufferedWriter.write(String.valueOf(item.getPrice()));
	               bufferedWriter.newLine();
	               bufferedWriter.write(String.valueOf(item.getQuantity()));
	               bufferedWriter.newLine();
	               bufferedWriter.write(item.getUPC());
	               bufferedWriter.newLine();
	           }
	           // close file
	           bufferedWriter.close();
	       }
	       catch(IOException ex) {
	           System.out.println("Error reading file '"
	                   + fileName + "'");             
	       }catch(Exception e)
	       { e.getMessage();}


	   }

	   public void loadInventoryToFile(String fileName)
	   {
	       String line = null;
	       BufferedReader bufferedReader=null;
	       FileReader fileReader=null;
	       Item item;
	       String name=null;
	       int quantity=0;
	       double price=0.0;
	       String upc=null;
	       int itemTrack=0;
	       try {
	           // FileReader reads text files.
	           fileReader =
	                   new FileReader(fileName);
	           // wrapping FileReader in BufferedReader for performance.
	           bufferedReader =
	                   new BufferedReader(fileReader);
	           while((line = bufferedReader.readLine()) != null) {
	               if(itemTrack==0)
	               {
	                   name=line;
	                   itemTrack++;
	                   continue;
	               }
	               if(itemTrack==1)
	               {
	                   price=Double.parseDouble(line);
	                   itemTrack++;
	                   continue;
	               }
	               if(itemTrack==2)
	               {
	                   quantity=Integer.parseInt(line);
	                   itemTrack++;
	                   continue;
	               }
	               if(itemTrack==3)
	               {
	                   upc=line;
	                   item = new Item(name,quantity,price,upc);
	                   addItem(item);
	                   itemTrack=0;
	                   continue;
	               }

	           }

	           // close file.
	           bufferedReader.close();          
	       }
	       catch(FileNotFoundException ex) {
	           System.out.println(
	                   "Unable to open file '" + fileName + "'");              
	       }
	       catch(IOException ex) {
	           System.out.println("Error reading file '"
	                   + fileName + "'");             
	       }
	       catch(Exception e)
	       { e.getMessage();}


  } 
} 
	   
	             
	 
	
