package multithread.sequenceexecution;

public class Task5 implements Runnable{


	private SharedTaskObject stobj;

	public Task5(SharedTaskObject stobj) {
		this.stobj = stobj;
	}

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()+" - START");
			Thread.sleep(5000);
			stobj.task5();
			System.out.println(Thread.currentThread().getName()+" - END");
		}catch(Exception e) {
			
		}finally {
			
		}
		
		
	}
	

}
