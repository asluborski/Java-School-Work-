package set;
/* Alex Sluborski
 * CIS 181-02
 * Lab 4 
 * 2/28/18
 */
public class TestIntSet {
	 /**
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] s = {2, 5, 11, 19};
         IntSet is = new IntSet(s);

         // Test cases
         System.out.println("Before insertion: " + is.toString());
         is.insert(34);
         System.out.println("After insertion: " + is.toString());
// precondition not satisfied ( element -88)
         System.out.println("\nBefore insertion: " + is.toString());
         is.insert(-88);
         // prints out after insertion
         System.out.println("After insertion: " + is.toString());
         // prints out before remove to string
         System.out.println("\nBefore Remove: " + is.toString());
         // removes 34 from set 
         is.remove(34);
         // prints after remove 
         System.out.println("After Remove: " + is.toString());
         // prints before remove element 12
         System.out.println("\nBefore Remove: " + is.toString());
         is.remove(12);
         // prints out after remove
         System.out.println("After Remove: " + is.toString());
         int[] s1 = { 19, 22, 33, 35 };
         IntSet is1 = new IntSet(s1); // region s1
         // prints out old set 
         System.out.println("\nOld Set: " + is.toString());
         // prints out new set
         System.out.println("New Set: " + is1.toString());
         // prints out union set 
         IntSet union = is.union(is1);
         System.out.println("After Union: " + union.toString());
         int[] s2 = {5, 19, 22, 33, 35 }; // region s2
         IntSet is2 = new IntSet(s2);
         // prints out old and new sets
         System.out.println("\nOld Set: " + is.toString());
         System.out.println("New Set: " + is2.toString());
         // prints out intersection ( calls intersection from IntSet)
         IntSet intersection = is.intersection(is2);
         System.out.println("After Intersection: " + intersection.toString());
         IntSet complement = is.complement();
         // prints out complement 
         System.out.println("\nAfter Complement: " + complement.toString());
         IntSet blankSet = new IntSet();
         // prints out blankset ( new intset)
         System.out.println("\nBlank Set: " + blankSet.toString());

 
	}

}
