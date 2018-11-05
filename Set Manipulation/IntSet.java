package set;
/* Alex Sluborski
 * CIS 181-02
 * Lab 4 
 * 2/28/18
 */
/**
 * Created on Sept. 24, 2006
 * Provides for creating and manipulating sets of non-negative integers.
 * The set can contain non-negative integers (0...) with values from min...max.
 *
 */

public class IntSet {
		// Attributes
		private final int min = 0, max = 100;
		private boolean[] contents = new boolean[101];
		private int cardinality = 0; // maintains the number of elements in the set
		// Constructors
		// Postcondition: Creates an empty set, cardinality()==0 and for all i, such that min<=i<=max, contents[i]==false
		public IntSet() {
		this.cardinality = 0;
		for (int i = min; i <= max; i++) {
		this.contents[i] = false;
		}
		}
		// Precondition: every element of values has the property min<=element<=max
		// Postcondition: For all x in values, such that min<=x<=max, contents[x]==true.
		public IntSet(int[] values) {
		for (int i = 0; i < values.length; i++) {
		if (values[i] <= max && values[i] >= min) {
		this.contents[values[i]] = true;
		this.cardinality++;
		}
		}
		}
		// Set Methods
		/**
		* Precondtion: null Postcondition: return this.cardinality==0
		*/
		public boolean isEmpty() {
		return this.cardinality == 0;
		}
		/**
		* Precondition: null Postcondition: return this.cardinality
		*/
		public int cardinality() {
		return this.cardinality;
		}
		/**
		* Precondition: min<=element<=max Postcondition: return
		* this.contents[element]
		*/
		public boolean isElement(int element) {
		if (element >= min && element <= max) {
		return this.contents[element];
		} else {
		return false;
		}
		}
		/**
		* Precondition: min<=element<=max and !isElement(element) Postcondition:
		* this.contents[element] = true. returns true if successful, false
		* otherwise
		*
		*/
		public boolean insert(int element) {
		if ((element <= max && element >= min) && !this.isElement(element)) {
		this.contents[element] = true;
		this.cardinality++;
		return true;
		} else {
		System.out.println("Precondition is NOT satisfied: element = "+ element);
		return false;
		}
		}
		/**
		* Precondition: min<=element<=max and isElement(element) Postcondition:
		* this.contents[element] = false. returns true if successful, false
		* otherwise
		*
		*/
		public boolean remove(int element) {
		if ((element <= max && element >= min) && this.isElement(element)) { // sets element if = max oe min
		this.contents[element] = false; // sets contents of element to false
		this.cardinality--; // subtract cardinality
		return true;// returns true 
		} else {
		System.out.println("Precondition is NOT satisfied: element = "+ element);
		return false; //  element not satisifed 12, return false
		}
		}
		// Operations
		/**
		* Precondition: s is an IntSet object. Postcondition: returns a new set
		* that is the union of this set and set s
		*/
		public IntSet union(IntSet s) { // everything that is in either of the sets
		boolean element2[] = s.contents; // sets element 2 for contents
		boolean union[] = new boolean[this.contents.length]; // gets length for union
		int set[] = new int[this.contents.length];// set new int 
		for (int i = 0; i < this.contents.length; i++) { // i ++, add up for array
		if (this.contents[i]) { //if = i, then union is true
		union[i] = true; // sets union true 
		}
		}
		for (int i = 0; i < element2.length; i++) {
		if (element2[i] && !contents[i]) {
		union[i] = true;
		}
		}
		for (int i = 0; i < union.length; i++) {
		if (union[i]) {
		set[i] = i; // set i = i if union = i 
		} else {
		set[i] = -1; // if not i then set is -1
		}
		}
		IntSet newSet = new IntSet(set);
		return newSet;// returns union set 
		}
		/**
		* Precondition: s is an IntSet object. Postcondition: returns a new set
		* that is the intersection of this set and set s
		*/
		public IntSet intersection(IntSet s) { // intersection, only numbers that are in both of the sets
		boolean contents2[] = s.contents; // takes in contents
		boolean intersection[] = new boolean[this.contents.length]; // makes new boolean for contents length
		int set[] = new int[this.contents.length]; // new set 
		for (int i = 0; i < this.contents.length; i++) {// array of going up while int = 0
		if (this.contents[i] && contents2[i]) {
		intersection[i] = true; // intersection true if contents = i 
		}
		}
		for (int i = 0; i < intersection.length; i++) {
		if (intersection[i]) { // if else for intersection to agree to set 
		set[i] = i;
		} else {
		set[i] = -1;
		}
		}
		IntSet newSet = new IntSet(set);
		return newSet; // returns intersected set
		}
		/**
		* Precondition: null Postcondition: produces a new set representing those
		* elements that are in the universal set but not in this set, this set is
		* unchanged.
		*/
		public IntSet complement() { // everything outside 
		boolean complement[] = new boolean[this.contents.length]; // sets boolean complement to array length
		int set[] = new int[this.contents.length];// sets new int
		for (int i = 0; i < this.contents.length; i++) {// i= 0 , takes array length, execeutes i++
		if (!this.contents[i]) {
		complement[i] = true;// sets complements as true if contents are i
		}
		}
		for (int i = 0; i < complement.length; i++) {
		if (complement[i]) {
		set[i] = i;
		} else {
		set[i] = -1;
		}
		}
		IntSet newSet = new IntSet(set);
		return newSet; // returns complemented set
		}
		/**
		* Postcondition: returns a String representation of the calling Set. The
		* representation is {int, int, int} beginning with the smallest value in
		* the set to the largest from left to right.
		*/
		public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("{");
		for (int i = 0; i <= max; i++) {
		if (this.contents[i]) {
		s.append(i + ", ");
		}
		}
		// remove the last "," and white space from the end of the stringbuffer
		if (s.length() > 1) {
		s.delete(s.length() - 2, s.length());
		}
		s.append("}");
		return s.toString();
		}
		}

	