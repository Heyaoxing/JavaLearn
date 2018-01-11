import Utils.StringUtil;
import Basic.DateLearn;
import Basic.ThreadLearn;
import Basic.throwLearn;
public class MainLearn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLearn runnable=new ThreadLearn();
		Thread thread1=new Thread(runnable);
		thread1.start();
		System.out.println("¿ªÊ¼");
		try {
			Thread.sleep(200);
			thread1.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("±¨´í:"+e.getStackTrace());
		}
		
		
	}
}
