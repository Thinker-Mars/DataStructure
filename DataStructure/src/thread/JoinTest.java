package thread;

public class JoinTest {

	public static void main(String[] args) {
		
		class ThreadA extends Thread {      //在主线程main中新建线程t1
			                                //通过t1.start()启动线程t1,使其进入就绪状态
			public ThreadA(String name) {   //执行t1.join()后,主线程会进入“阻塞状态”等待t1运行结束
				super(name);                //t1结束之后，会唤醒主线程main，主线程重新获取CPU执行权，继续运行
			}
			
			@Override
			public void run() {
				System.out.println("start "+this.getName());
				for(int i=0;i<1000000000;i++)
					;
				
				System.out.println("finish "+ this.getName());
			}
		}
		
		Thread t1 = new ThreadA("t1");
		t1.start();
		try {
			t1.join();
			System.out.println("finish "+Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
