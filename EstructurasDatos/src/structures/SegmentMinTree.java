package structures;

public class SegmentMinTree<T>  {

double tree[]; // The array that stores segment tree nodes
    
    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    public SegmentMinTree(double arr[], int size){
        // Allocate memory for segment tree
        //Height of segment tree
        int x = (int) (Math.ceil(Math.log(size) / Math.log(2)));
 
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
 
        tree = new double[max_size]; // Memory allocation
 
        constructSTUtil(arr, 0, size - 1, 0);
        //toStringArr();
    }
    
    // A recursive function that constructs Segment Tree for array[start...end].
    // currentIndex is index of current node in segment tree 'tree[]'
    private double constructSTUtil(double arr[], int start, int end, int currentIndex)
    {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (start == end) {
            tree[currentIndex] = arr[start];
            return arr[start];
        }
 
        // If there are more than one elements, then recur for left and
        // right subtrees and store the minimum of values in this node
        int mid = getMid(start, end);//To split the range by the middle, obtain the middle index
        tree[currentIndex] = minOf(constructSTUtil(arr, start, mid, currentIndex * 2 + 1),
                 constructSTUtil(arr, mid + 1, end, currentIndex * 2 + 2));
        return tree[currentIndex];
    }
    
    private double minOf(double a, double b) {
    	if(b==0.0) {
    		if(a==0.0) return 0.0;
    		else return a;
    	}
    	if(a==0.0) return b;
    	if (a<b) return a;
    	else return b;
    }
 
    // A utility function to get the middle index from corner indexes.
    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }
    
    // Return sum of elements in range from index qStart (query start) to
    // qEnd (query end).  It mainly uses getSumUtil()
    public double getMin(int size, int qStart, int qEnd){
        // Check for erroneous input values
        if (qStart < 0 || qEnd > size - 1 || qStart > qEnd) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getMinUtil(0, size - 1, qStart, qEnd, 0);
    }
    
    /*  A recursive function to get the sum of values in given range
    of the array.  The following are parameters for this function.

  	tree    		--> Pointer to segment tree
  	currentIndex  	--> Index of current node in the segment tree. Initially
            			0 is passed as root is always at index 0
  	start & end  	--> Starting and ending indexes of the segment represented
               			by current node, i.e., tree[currentIndex]
  	qStart & qStart	--> Starting and ending indexes of query range */
    private double getMinUtil(int start, int end, int qStart, int qEnd, int currentIndex){
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qStart <= start && qEnd >= end)
            return tree[currentIndex];
 
        // If segment of this node is outside the given range
        if (end < qStart || start > qEnd)
            return 0;
 
        // If a part of this segment overlaps with the given range
        int mid = getMid(start, end);
        return minOf(getMinUtil(start, mid, qStart, qEnd, 2 * currentIndex + 1),
                getMinUtil(mid + 1, end, qStart, qEnd, 2 * currentIndex + 2));
    }
 
    /* A recursive function to update the nodes which have the given 
    index in their range. The following are parameters
     tree, currentIndex, start and end are same as getSumUtil()
     i    --> index of the element to be updated. This index is in
              input array.
    diff --> Value to be added to all nodes which have i in range */
    private void updateValueUtil(int start, int end, int i, double newVal, int currentIndex)
    {
        // Base Case: If the input index lies outside the range of 
        // this segment
        if (i < start || i > end)
            return;
 
        // If the input index is in range of this node, then update the
        // value of the node and its children
        
        if (end != start) {
            int mid = getMid(start, end);
            updateValueUtil(start, mid, i, newVal, 2 * currentIndex + 1);
            updateValueUtil(mid + 1, end, i, newVal, 2 * currentIndex + 2);
            tree[currentIndex]=minOf(tree[2 * currentIndex + 1],tree[2 * currentIndex + 2]);
        } else {
        	//System.out.println("Inserta el nuevo dato en el segment tree");
        	tree[currentIndex] = newVal;
        }
    }
 
    // The function to update a value in input array and segment tree.
   // It uses updateValueUtil() to update the value in segment tree
    public void updateValue(double arr[], int size, int i, double newVal)
    {
    	// Check for erroneous input index
        if (i < 0 || i > size - 1) {
            System.out.println("Invalid Input");
            return;
        }
 
        // Get the difference between new value and old value
        /*double diff = newVal - arr[i];*/
 
        // Update the value in array
        arr[i] = newVal;
 
        // Update the values of nodes in segment tree
        updateValueUtil(0, size - 1, i, newVal, 0);
        //toStringArr();
    }
    public void toStringArr() {
		for(double d: tree) {
			System.out.print(d+" ");
		}
		System.out.println();
	}
}
//This code is contributed by Ankur Narain Verma, and adapted by Christian Cuestas
