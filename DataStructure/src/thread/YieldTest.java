package thread;

public class YieldTest {

	public static void main(String[] args) {
		
		class ThreadA extends Thread {
			
			public ThreadA(String name) { //yield并不能保证在当前线程调用yield()之后，其他具有相同优先级的线程就一定能获得执行权；
				super(name);              //也有可能是当前线程又进入到“运行状态”继续运行
			}
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(" " + this.getName() + " " +i);
					if (i % 2 == 0) {
						//若余数为0则将当前线程变为就绪状态
						Thread.yield();
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
