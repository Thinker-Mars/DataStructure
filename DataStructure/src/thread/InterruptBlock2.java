package thread;

public class InterruptBlock2 {

	public static void main(String[] args) {
		
		class MyThread extends Thread {
			
			private volatile boolean flag = true;
			
			public void stopTask() {
				this.flag = false;
			}
			
			public MyThread(String name){
				super(name);
			}
			
			@Override
			public void run() {
				synchronized (this) {
					try {
						int i = 0;
						while (flag) {
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
		}
		
		try {
			MyThread t1 = new MyThread("t1");
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is new.");
			t1.start();
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is started.");
			Thread.sleep(300);
			t1.stopTask();
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is interrupted.");
			Thread.sleep(3000);
			System.out.println(t1.getName()+" ("+t1.getState()+" ) is interrupted now .");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
