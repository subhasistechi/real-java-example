/**
 * 
 */
package multithread.sequenceexecution;

import java.util.concurrent.Phaser;

/**
 * @author sonamrijma
 *
 */
public class SingleTaskForMultipleThreads implements Runnable {

	private Thread[] threads;
	private Phaser phaser;

	public SingleTaskForMultipleThreads(Phaser phaser) {
		this.phaser = phaser;
	}

	public Thread[] getThreads() {
		return threads;
	}

	public void setThreads(Thread[] threads) {
		this.threads = threads;
	}

	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.println(Thread.currentThread().getName() + " - START");

		if (Thread.currentThread().getName().equals("Thread-1")) {
			try {
				threads[0].join();
				System.out.println(Thread.currentThread().getName() + " - END");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		else if (Thread.currentThread().getName().equals("Thread-2")) {
			try {
				threads[1].join();
				System.out.println(Thread.currentThread().getName() + " - END");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		else if (Thread.currentThread().getName().equals("Thread-3")) {
			try {
				threads[2].join();
				System.out.println(Thread.currentThread().getName() + " - END");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		else if (Thread.currentThread().getName().equals("Thread-4")) {
			try {
				threads[3].join();
				System.out.println(Thread.currentThread().getName() + " - END");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(Thread.currentThread().getName() + " - END");
		}

	}

}
