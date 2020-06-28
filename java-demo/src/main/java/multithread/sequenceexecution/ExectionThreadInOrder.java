/**
 * 
 */
package multithread.sequenceexecution;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sonamrijma
 *
 */
public class ExectionThreadInOrder {

	volatile static boolean flag1, flag2, flag3, flag4, flag5;

	public static void main(String[] args) {
		SharedTaskObject stobj = new SharedTaskObject();

		ExecutorService es = Executors.newFixedThreadPool(5);

		
		try {
			
			// using Threadpool executing the threads in sequence
			// i.e. the start order may very but finishes in sequence always
			es.submit(new Task1(stobj));
			es.submit(new Task2(stobj));
			es.submit(new Task3(stobj));
			es.submit(new Task4(stobj));
			es.submit(new Task5(stobj));
			
			Thread.sleep(6000);
			
			
			// using Simple Thread for executing the threads in sequence
			// i.e. the start order may very but finishes in sequence always
			Thread t1 = new Thread(new Task1(stobj));
			Thread t2 = new Thread(new Task2(stobj));
			Thread t3 = new Thread(new Task3(stobj));
			Thread t4 = new Thread(new Task4(stobj));
			Thread t5 = new Thread(new Task5(stobj));
			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
			
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			es.shutdown();
		}	

	}

}
