/**
 * 
 */
package multithread;

/**
 * @author sonamrijma
 *
 */
public class ExecutionThreadInOrder implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		if(Thread.currentThread().getName().equals("E")) {
			
		System.out.println(Thread.currentThread().getName() +" - start");
		System.out.println(Thread.currentThread().getName() +" - end");
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutionThreadInOrder esio = new ExecutionThreadInOrder();
		Thread t1 = new Thread(esio);
		Thread t2 = new Thread(esio);
		Thread t3 = new Thread(esio);
		Thread t4 = new Thread(esio);
		Thread t5 = new Thread(esio);
		
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		t4.setName("D");
		t5.setName("E");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t5.start();
		
		

	}

}
