//CSE 373 A
//Homework 3
//Fangzheng Sun
//04/21/2015

//This is a test file for the three implementations to test
//whether the methods work as expected. Once all of then pass
//the tests, the user will be informed of the success.

import java.util.Random;

public class test{

    public static void main(String[] args){
        MyPQ test = new MyPQ();
        //1st part
        Random rand = new Random();
        System.out.println("---test insert, size---");
        for(int i = 0; i < 10; i++){
            test.insert(rand.nextDouble());
        }
        if(test.size() == 10){
            System.out.println("current size is " + test.size());
            System.out.println("insert, size successful");
        }
        System.out.println();
        //2nd part
        System.out.println("---test findMin, isEmpty, deleteMin---");
        double a = test.findMin();
        test.insert(a); //This gives an example of a PQ having two same items.
        double b = test.deleteMin();
        double c = test.deleteMin();
        System.out.println("delete " + b);
        while(!test.isEmpty()){
            System.out.println("current size is " + test.size());
            System.out.println("delete " + test.deleteMin());
        }
        if(a == b && b == c){
            System.out.println("Min = " + a);
            System.out.println("findMin, isEmpty, deleteMin successful");
        }
        System.out.println();
        //3rd part
        System.out.println("---test makeEmpty---");
        for(int i = 0; i < 100; i++){
            test.insert(rand.nextDouble());
        }
        System.out.println("current size is " + test.size());
        System.out.println("excute makeEmpty");
        test.makeEmpty();
        if(test.isEmpty()){
            System.out.println("current size is " + test.size());
            System.out.println("makeEmpty successful");
        }
	 }
}