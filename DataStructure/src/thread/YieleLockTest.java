package thread;

public class YieleLockTest {
	
	public static void main(String[] args) {
		
		final Object obj = new Object();
		
		class ThreadA extends Thread {
			                              //线程t1和t2在run()后会通过synchronized (obj)引用同一个对象的同步锁
			public ThreadA(String name) { //在t1运行过程中，虽然它会调用Thread.yield()；但是，t2是没有获取到CPU执行权的
				super(name);              //因为，t1并没有释放“obj所持有的同步锁”
			}
			
			@Override
			public void run() {
				synchronized (obj) {
					for (int i = 0; i < 10; i++) {
						System.out.println(this.getName()+" "+i);
						if (i % 4 == 0) {
							Thread.yield();
						}
					}
				}
			}

		}
		ThreadA t1 = new ThreadA("t1");
		ThreadA t2 = new ThreadA("t2");
		t1.start();
		t2.start();
	}

}
