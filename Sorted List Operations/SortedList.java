/***********************************************************
 * Lab #8 (CIS 181, Fall 2008)                             *
 * Submitted By: Alex Sluborski                      *
 * SID: Your new SID starting with "00"                    *
 * Date: 4/4/18                            *
 ***********************************************************/

/**
 * @author Haiping Xu
 * Created on Nov. 1, 2008
 */

// This program sorts data into a sorted list by removing items from an array list, adding items, and locating
// their index 
public class SortedList implements SortedListInterface {
    private static final int MAX_LIST = 50;
    private Object items[];  // an array of list items
    private int numItems;    // number of items in list

    // default constructor
    public SortedList() {
        items = new Object[MAX_LIST];
        numItems = 0;
    }

    public boolean isEmpty() {
        return numItems == 0;  
        // returns items  if empty 0 
    }

    public int size() {
        return numItems;
        // returns num items 
    }

    public Object get(int index) throws ListException {

        if (index >= 1 && index <= size()) { 
        	// index greater than or equal to 1 && index smaller than or equal to size
            return items[index - 1];
        } else {  
        	// index out of range
            throw new ListException("get (index out of range): " + index); // gets index out of range
        }
    }

    public void removeAll() {
        items = new Object[MAX_LIST]; 
        // removes all items from list
        numItems = 0;
    }

    // new operations: sortedAdd
    public void sortedAdd(Comparable newItem) throws ListException { // adds item to sorted list
        if (size() == MAX_LIST)
            throw new ListException("add (array is full)");
        

        if (numItems == 0) {
            items[0] = newItem;
            numItems++; // adds items if number is 0 items
            return;
        }

        Object[] newList = new Object[MAX_LIST];
        for (int i = 0; i < numItems; i++) { 
        	// for loop adds items 
            if (newItem.compareTo(items[i]) < 0) { 
            	// new item added after items i 
                newList[i] = newItem;
                numItems++;
                for (int j = i + 1; j < numItems; j++) {  
                	// item is added in sorted order
                    newList[j] = items[i];
                    i++;
                }
                items = newList;
                return;
            } else { 
            	// new item added before item i
                newList[i] = items[i];
            }
        }
        newList[numItems]=newItem; //
        numItems++;
        items=newList;
        return; 
        // returns new list of items sorted
    }

    // new operation: sortedRemove
    public void sortedRemove(Comparable anItem) throws ListException { 
    	// removes item from sorted list
        Object[] newList = new Object[MAX_LIST];
        for (int i = 0; i < numItems; i++) {
            if (anItem.compareTo(items[i])== 0) {
                for (int j = i ; j < numItems; j++) { // for loop removes num items
                    i++;
                    newList[j] = items[i];
                }
                newList[numItems-1]=null; // declares new list null 
                numItems--; // removes items 
                items = newList;
                return;
            } else {
                newList[i] = items[i];
            }
        }



    }

    // new operation: locateIndex
    public int locateIndex(Comparable anItem) { // finds item (index) in sorted list 
        int index = 7;

// returns index position in sorted list if item is in sorted list
        for (int i = 0; i < numItems; i++) {
            if (anItem.compareTo(items[i]) == 0) {
                return i+1;
            }
        }
// returns index of where item belongs if not in sorted list
        return index;
    }
}
