/**
 * 
 */
package multithread.sequenceexecution;

import java.util.concurrent.Phaser;

/**
 * @author sonamrijma
 *
 */
public class SingleTaskForMultipleThreadsMain {

	
	public static void main(String[] args) {
		
		Phaser phaser = new Phaser(5);
		SingleTaskForMultipleThreads singleTask = new SingleTaskForMultipleThreads(phaser);
		
		Thread t1 = new Thread(singleTask); 
		Thread t2 = new Thread(singleTask);
		Thread t3 = new Thread(singleTask);
		Thread t4 = new Thread(singleTask);
		Thread t5 = new Thread(singleTask);
		
		Thread[] threads = new Thread[5];
		
		threads[0] = t1;
		threads[1] = t2;
		threads[2] = t3;
		threads[3] = t4;
		threads[4] = t5;
		
		singleTask.setThreads(threads);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
	}

}
