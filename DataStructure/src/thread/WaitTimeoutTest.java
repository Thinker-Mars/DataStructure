package thread;

public class WaitTimeoutTest {

	public static void main(String[] args) {
	
		class ThreadA extends Thread {
			
			public ThreadA(String name) {
				super(name);
			}
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" run");
				while(true) {
					;//死循环
				}
			}
		}
		ThreadA t1 = new ThreadA("t1");
		synchronized (t1) {
			try {
				System.out.println(Thread.currentThread().getName() + " start t1");
				t1.start();
				System.out.println(Thread.currentThread().getName() + " call wait ");
				//主线程等待t1通过notify()或 notifyAll()唤醒，或超过2000ms延时后才被唤醒
				t1.wait(2000);
				//主线程main和线程t1会一直运行下去
				System.out.println(Thread.currentThread().getName() + " continue");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
