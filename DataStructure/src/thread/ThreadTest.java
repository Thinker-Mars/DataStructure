package thread;

public class ThreadTest {

	public static void main(String[] args) {
		
		class Count {
			
			public void synMethod() {
				synchronized (this) {
					try {
						for (int i = 0; i < 5; i++) {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() + "synMethod loop " + i);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			public void noSynMethod() {
				synchronized (this) {
					try {
						for (int i = 0; i < 5; i++) {
							Thread.sleep(100);
							System.out.println(Thread.currentThread().getName() + "noSynMethod loop " + i);
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		}
		
		final Count count = new Count();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				count.synMethod();
			}
		}, "t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				count.noSynMethod();
			}
		}, "t2");
		
		t1.start();
		t2.start();
		

	}

}
