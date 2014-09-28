package amp.thread;

class DemoThred implements Runnable{
	Thread t;
	volatile boolean running = true;
	int c = 0;
	
	public DemoThred() {
		// TODO Auto-generated constructor stub
		t = new Thread(this);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(running){
			c++;
			System.out.println(c);
		}
			
	}
	
	void start(){
		running = true;
		t.start();
	}
	
	void stop(){
		running = false;
	}
	
}

public class NewThread {
	public static void main(String args[]){
		DemoThred th = new DemoThred();
		th.start();
		System.out.println(th.t.isAlive());
		try {
			Thread.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		th.stop();
		try {
			th.t.join();
			System.out.println(th.t.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
