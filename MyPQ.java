//CSE 373 A
//Homework 3
//Fangzheng Sun
//04/21/2015

//The class BinaryHeap implements the PriorityQueue Interface and 
//several method to insert/delete items and arrage the priority of
//the items using a list. 

import java.util.*;

public class MyPQ implements PriorityQueue{
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private List<Double> list;
    
    //This constructor constructs the empty priority queue with default
    //capacity.
    public MyPQ(){
        makeEmpty();
    }
    
    //This constructor, given the array of the heap, constructs the
    //priority queue in order.
    public MyPQ(double[] array){
        List<Double> temp = new ArrayList<Double>();
        for(int i = 0; i < array.length; i++){
            temp.add(array[i]);
        }
        list = new ArrayList<Double>();
        double min = array[0];
        int index = 0;
        while(!temp.isEmpty()){
            for(int i = 0; i < temp.size(); i++){
                if(list.get(i) < min){
                    min = list.get(i);
                    index = i;
                }
            }
            temp.remove(index);
            list.add(min);
        }
        size = list.size();
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
        return list.get(0);
    }
    
    //This method is used to insert a new double x in to the PQ and 
    //rearrange the priority of the items.
    public void insert(double x){
        int index = 0;
        while(index < size && x > list.get(index)){
            index++;
        }
        list.add(index, x);
        size++;
    }
    
    
    //This method delete and returns the minimum item in the PQ. It 
    //throws EmptyPQException if the PQ is empty.
    public double deleteMin(){
        if(isEmpty()){
		      throw new EmptyPQException("The binaryheap is empty");
		  }
        double min = list.get(0);
        list.remove(0);
        size--;
        return min;
    }
    
    //This method clears all items in the PQ.
    public void makeEmpty(){
        list = new ArrayList<Double>(); 
        size = 0;
    }
}