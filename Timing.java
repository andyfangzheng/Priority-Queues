//CSE 373 A
//Homework 3
//Fangzheng Sun
//04/21/2015

//This is a test file for the three implementations to test
//the time each implementation spend.
public class Timing{
	 public static final int NUM_TIMINGS = 5;

	 public static void main(String[] args) {
        for(int timing = 0; timing < NUM_TIMINGS; ++timing) {
            for(int n = 1000; n <= 16000; n = n * 2){
                System.out.print("for n = " + n + ", ");
               
                //This part is to time the insert.
                long startTime = System.nanoTime();
                //Uncomment the part to switch timing different implementations.
                PriorityQueue pq = InsertTiming(new BinaryHeap(), n);
                //PriorityQueue pq = InsertTiming(new ThreeHeap(), n);
                //PriorityQueue pq = InsertTiming(new MyPQ(), n);
                long endTime = System.nanoTime();
                long elapsedTime = endTime - startTime;
                System.out.print("time of insert is " + elapsedTime + ", ");
            	
                //This part is to time the deleteMin.
                startTime = System.nanoTime();
                DeleteMinTiming(pq);
	             endTime = System.nanoTime();
	             elapsedTime = endTime - startTime;
	             System.out.println("time of deleteMin is " + elapsedTime);
            }
        }
	 }

	 // Test insert by inserting n random doubles
	 public static PriorityQueue InsertTiming(PriorityQueue pq, int n){
		  for (int i = 0; i < n; i++){
			  pq.insert(Math.random());
		  }
		  return pq;
	 }
	
	 // Test deleteMin by removing and summing contents
	 public static void DeleteMinTiming(PriorityQueue pq){
       Double temp = 0.0;
		 while (!pq.isEmpty()) {
			  temp = pq.deleteMin();
		 }
	 }
}