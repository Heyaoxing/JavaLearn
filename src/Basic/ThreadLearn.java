package Basic;

public class ThreadLearn extends Thread {
	@Override
	public   void run() {
		Thread.currentThread().setPriority(6);
		for(int i=0;i<2000000;i++){
			if(Thread.interrupted()){  //����interrupt()�������״̬Ϊ�ж�
				System.out.println("�ж��߳�");
				break;
			}
			System.out.println(i);
		}
		System.out.println("���");
	}
}
