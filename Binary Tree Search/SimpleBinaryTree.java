//Alex Sluborski
// CIS 181-02 
// 4/27/18
// Lab 10 

/**
 * @author Clint Rogers
 *
 */
public class SimpleBinaryTree {
	private BTNode root;
	
	public SimpleBinaryTree()
	{
		root = null;
	}
	
	public void addObject(Object obj)
	{
		/*This method builds the tree for us*/
		//If the root is null, simply set root to obj
		if(root == null)
		{
			root = new BTNode(obj);
		}else
		{
			//assume value is an integer
			int value1 = Integer.parseInt((String)obj);
			//Create a traverse pointer
			BTNode trav = root;
			while(true)
			{
				//get the value of the object pointed to by trav
				int value2 = Integer.parseInt((String)trav.getObject());
				
				//if the value of the current node has a value greater than the obj go left
				if(value1<value2)
					if(trav.getLeft() == null)
					{
						//if left is null, create the new node and set it there
						trav.setLeft(new BTNode(obj));
						return;
					}else
					{
						//else have trav go left;
						trav = trav.getLeft();
					}
				else
					if(trav.getRight() == null)
					{
						//if right is null, create the new node and set it there
						trav.setRight(new BTNode(obj));
						return;
					}else
					{
						//else have trav go right;
						trav = trav.getRight();
					}
			}			
		}
	}
	
	public int countLeafNodes()
	{
		/* A leaf node is defined as having no children (.getRight and .getLeft are null)
		 */
		//Use a recursive function countLN that traverses all nodes and counts them
		return countLN(root);
	}
	
	private int countLN(BTNode trav)
	{
		/**************This function must be recursive********************/
		
		
		//Terminating cases
		if(trav==null)
			return 0;
		if((trav.getLeft()==null)&&(trav.getRight()==null))
		{
			//child node!
			return 1;
		}
		int count;
		

		return countLN(trav.getLeft())+ countLN(trav.getRight());
		
		//returns count of tree nodes traversed
	}
	
	public boolean containsObject(Object obj)
	{
		BTNode trav = root;
		int value1 = Integer.parseInt((String)obj);
	
		while (trav != null)
		{
			int value2 = Integer.parseInt((String) trav.getObject());
			
			// pass right subtree as new tree
			
			if (value1 > value2)
				trav = trav.getRight();
			
			// pass left subtree as new tree
			
			else if (value1 < value2)
				
				trav = trav.getLeft();
			else 
				return true; // if the value is found return true
		}

		return false;
	}
}
