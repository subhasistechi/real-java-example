package multithread.sequenceexecution;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Task2 implements Runnable {

	
	private SharedTaskObject stobj;


	public Task2(SharedTaskObject stobj) {
		this.stobj = stobj;
	}

	public void run() {
		try {
			
			System.out.println(Thread.currentThread().getName()+" - START");
			Thread.sleep(1000);
			stobj.task2();
			System.out.println(Thread.currentThread().getName()+" - END");
		}catch(Exception e) {
			
		}finally {
			
		}
		
		
	}
	

}
