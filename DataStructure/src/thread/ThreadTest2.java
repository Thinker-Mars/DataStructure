package thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		
		class Demo {
			public synchronized void synMethod() {
				for (int i = 0; i < 10000000; i++) {
					;
				}
			}
			public void synBlock() {
				synchronized (this) {
					for (int i = 0; i < 10000000; i++) {
						;
					}
				}
			}
		}
		
		Demo demo = new Demo();
		long start;
		long diff;
		start = System.currentTimeMillis();
		demo.synMethod();
		diff = System.currentTimeMillis() - start;
		System.out.println("synMethod spend " + diff);
		
		start = System.currentTimeMillis();
		demo.synBlock();
		diff = System.currentTimeMillis() - start;
		System.out.println("synBlock spend " + diff);

	}

}
