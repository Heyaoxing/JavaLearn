package Basic;

public class ThreadLearn implements Runnable  {
	private Thread thread;
	public ThreadLearn(String name){
		thread=new Thread(this,name);
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void start(){
		thread.start();
	}
}
