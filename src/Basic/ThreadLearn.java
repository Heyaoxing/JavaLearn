package Basic;

public class ThreadLearn extends Thread {
	@Override
	public   void run() {
		Thread.currentThread().setPriority(6);
		for(int i=0;i<2000000;i++){
			if(Thread.interrupted()){  //调用interrupt()方法标记状态为中断
				System.out.println("中断线程");
				break;
			}
			System.out.println(i);
		}
		System.out.println("完成");
	}
}
