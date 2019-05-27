package thread;

public class NotifyAllTest {
	
	private static Object obj = new Object();
	
	static class ThreadA extends Thread {
		
		public ThreadA(String name) {
			super(name);
		}
		
		@Override
		public void run() {
			synchronized (obj) {
				try {
					System.out.println(Thread.currentThread().getName()+" wait");
					obj.wait();
					System.out.println(Thread.currentThread().getName() + " continue");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}       //notify()是依据什么唤醒等待线程的？或者wait()和notify()之间是通过什么关联起来的？答案是：依据“对象的同步锁”
            //负责唤醒等待线程的那个线程（我们称为“唤醒线程”），它只有在获取“该对象的同步锁”(这里的同步锁必须和等待线程的同步锁是同一个)
	        //并且调用notify()或notifyAll()方法之后，才能唤醒等待线程
	        //虽然，等待线程被唤醒，但是，它不能立即执行。因为唤醒线程还持有“该对象的同步锁”。
	        //必须等到唤醒线程释放“该对象的同步锁”之后，等待线程才能获取到“对象的同步锁”，然后继续运行。
	public static void main(String[] args) {
		
		ThreadA t1 = new ThreadA("t1");
		ThreadA t2 = new ThreadA("t2");
		ThreadA t3 = new ThreadA("t3");
		t1.start();
		t2.start();
		t3.start();
		try {
			System.out.println(Thread.currentThread().getName()+" sleep(3000)");
			//睡眠主线程3s
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (obj) {
			System.out.println(Thread.currentThread().getName()+ " notifyAll()");
			//唤醒在此对象监视器(obj)上等待的所有线程
			obj.notifyAll();
		}

	}

}
