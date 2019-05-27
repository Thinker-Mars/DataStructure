package thread;

public class WaitTest {

	public static void main(String[] args) {  //1、ThreadA t1 = new ThreadA("t1") 新建线程t1
                                              //2、主线程main通过synchronized (t1)获取t1线程对象的同步锁
		class ThreadA extends Thread {        //3、执行t1.start()使t1进入就绪状态
			                                  //4、t1.wait()让当前线程（main）处于等待（阻塞）状态
			public ThreadA(String name) {     //5、此时t1线程执行run()方法
				                              //6、t1通过synchronized (this)获取当前对象(t1)的锁
				super(name);                  //7、notify()方法唤醒“当前对象上的等待线程”，也就是唤醒主线程main
			}                                 //8、main continue
			                                  //注意:wait()的作用是让“当前线程”等待，而“当前线程”是指正在CPU上运行的线程
			@Override                   //虽然t1.wait()是通过t1调用wait()方法,但是调用t1.wait()的地方是在“主线程main”中
		                            //而主线程必须是“当前线程”，也就是运行状态，才可以执行t1.wait()。所以“当前线程”是“主线程mian”
			public void run() {     //因此，t1.wait()是让“主线程”等待，而不是“线程t1”
				synchronized (this) {
					System.out.println(Thread.currentThread().getName() + "正在执行");
					System.out.println(Thread.currentThread().getName() + " 现在唤醒线程");
					notify();
				}
			}
		}
		
		
		ThreadA t1 = new ThreadA("t1");
		
		synchronized (t1) {
			System.out.println(Thread.currentThread().getName() + " start t1");
			t1.start();
			try {
				System.out.println(Thread.currentThread().getName()+" wait()");
				t1.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" continue");
		}

	}

}

