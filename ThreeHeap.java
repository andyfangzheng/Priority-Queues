//CSE 373 A
//Homework 3
//Fangzheng Sun
//04/21/2015

//The class BinaryHeap implements the PriorityQueue Interface and 
//several method to insert/delete items and arrage the priority of
//the items using three heap (one parent has three children) method. 

public class ThreeHeap implements PriorityQueue{
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private double[] heap;
    
    //This constructor constructs the empty three heap with default
    //capacity.
    public ThreeHeap(){
        makeEmpty();
    }
    
    //This constructor, given the array of the heap, constructs the
    //three heap in order.
    public ThreeHeap(double[] array){
        heap = new double[array.length + 1];
        for(int i = 1; i < array.length + 1; i++){
            heap[i] = array[i - 1];
        }
        size = array.length;
        for(int i = size / 3; i > 0; i--){
            percolateDown(i);
        }
    }
    
    //This helper method is used to arrange the priority of the items
    //using the percolate down method, that is, given a hole, compare
    //the priority of parent and childrens, then rearrange the items.
	 private void percolateDown(int hole){
		  boolean done = false;
		  while(!done) {		
			   int i = (hole * 3) - 1;
			   int min = hole;
			   while(i <= size && i <= (hole * 3) + 1){
				    if(heap[i] < heap[min]){
					     min = i;
				    }
				    i++;
			   }
			   if(heap[hole] > heap[min]){
				    double temp = heap[min];
				    heap[min] = heap[hole];
				    heap[hole] = temp;
				    hole = min;
			   }else{
				    done = true;
			   }
		  }
	 }  
    
    //This method returns true if the PQ is empty.
    public boolean isEmpty(){
        return size == 0;
    }
    
    //This method returns the current size of the PQ.
    public int size(){
        return size;
    }
    
    //This method returns the minimum items. It throws EmptyPQException
    //if the PQ is empty.
    public double findMin(){
        if(isEmpty()){
            throw new EmptyPQException("The binaryheap is empty");
        }
        return heap[1];
    }
    
    //This method is used to insert a new double x in to the PQ and 
    //rearrange the priority of the items.
    public void insert(double x){
        if(size == heap.length - 1){
            double[] temp = heap;
            heap = new double[heap.length * 2 + 1];
            for(int i = 0; i < temp.length; i++){
                heap[i] = temp[i];
            }
        }
        size++;
		  heap[size] = x;
		  percolateUp(size);
    }
    
    //This private method is used when inserting a new item and it will
    //give the item a right position related to its priority.
	 private void percolateUp(int hole) {
        if(hole > 1){
            int parent = (hole + 1) / 3;
		      while(heap[hole] < heap[parent] && hole > 1){
			       parent = (hole + 1) / 3;
				    double temp = heap[hole];
				    heap[hole] = heap[parent];
				    heap[parent] = temp;
				    hole = parent;
			   }
		  }
	 }
    
    //This method delete and returns the minimum item in the PQ. It 
    //throws EmptyPQException if the PQ is empty.
    public double deleteMin(){
        if(isEmpty()){
		      throw new EmptyPQException("The binaryheap is empty");
		  }
        double min = heap[1];
        heap[1] = heap[size--];
        percolateDown(1);
        return min;
    }
    
    //This method clears all items in the PQ.
    public void makeEmpty(){
        heap = new double[DEFAULT_CAPACITY];
        size = 0;
    }
}
    