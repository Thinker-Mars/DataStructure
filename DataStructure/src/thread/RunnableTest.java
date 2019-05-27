package thread;

public class RunnableTest {
	
	public static void main(String[] args) {
		
		class MyRunnable implements Runnable {
		
			@Override
			public void run() {
				synchronized (this) {
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() + "loop" + i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				
			}
			
		}
		
		class MyThread extends Thread {
			
			public void run() {
				
				synchronized (this) {
					for (int i = 0; i < 5; i++) {
						try {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() + "loop" + i);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					}
				}

			}
		}
//		MyRunnable myRunnable = new MyRunnable();
//		Thread thread1 = new Thread(myRunnable, "thread1");
//		Thread thread2 = new Thread(myRunnable, "thread2");
//		Thread thread3 = new Thread(myRunnable, "thread3");
//		thread1.start();
//		thread2.start();
//		thread3.start();
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		t1.start();
		t2.start();
		
				
		
	}

}
