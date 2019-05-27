package thread;

public class InterruptBlock {

	public static void main(String[] args) {
		
		class MyThread extends Thread {
			public MyThread(String name){
				super(name);
			}
			
			@Override
			public void run() {
				try {
					int i = 0;
					while (!isInterrupted()) {
						Thread.sleep(100);
						i++;
						System.out.println(Thread.currentThread().getName()+ " ("+this.getState()+") loop "+i);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println(Thread.currentThread().getName()+ " ("+this.getState()+") catch InterruptedExecption");
				}
			}
		}
		try {
			Thread t1 = new MyThread("t1");
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is new.");
			System.out.println("luo1:"+t1.isInterrupted());
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is started.");
			t1.start();
			System.out.println("luo2:"+t1.isInterrupted());
			Thread.sleep(300);
			t1.interrupt();
			System.out.println("luo3:"+t1.isInterrupted());
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is interrupted.");
			Thread.sleep(300);
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is interrupted now .");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
