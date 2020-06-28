package multithread.sequenceexecution;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedTaskObject {

	Lock l1 = new ReentrantLock();
	Condition cl1 = l1.newCondition();
	Condition cl2 = l1.newCondition();
	Condition cl3 = l1.newCondition();
	Condition cl4 = l1.newCondition();

	volatile boolean flag1, flag2, flag3, flag4;

	public void task1() {
		l1.lock();
		System.out.println("Inside task1");
		flag1 = true;
		cl1.signalAll();
		l1.unlock();
	}

	public void task2() {

		try {
			l1.lock();
			System.out.println("Inside task2");
			while (!flag1) {
				cl1.await();
			}
			flag2 = true;
			flag1 = false;
			cl2.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			l1.unlock();
		}

		
	}
	
	public void task3() {

		try {
			l1.lock();
			while (!flag2) {
				cl2.await();
			}
			System.out.println("Inside task3");
			flag3 = true;
			flag2 = false;
			cl3.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			l1.unlock();
		}

		
	}
	
	public void task4() {

		try {
			l1.lock();
			while (!flag3) {
				cl3.await();
			}
			System.out.println("Inside task4");
			flag4 = true;
			flag3 = false;
			cl4.signalAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			l1.unlock();
		}
	}
	
	public void task5() {

		try {
			l1.lock();
			while (!flag4) {
				cl4.await();
			}
			System.out.println("Inside task5");
			flag4 = false;
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			l1.unlock();
		}

	}

}
