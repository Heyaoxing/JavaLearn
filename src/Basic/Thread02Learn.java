package Basic;

public class Thread02Learn {
	public static void main(String[] args) {

		try {
			RunThread thread = new RunThread();
			thread.start();
			Thread.sleep(1000);
			thread.setRunning(false);
			System.out.println("�Ѿ���ֵΪfalse");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class RunThread extends Thread {

	private volatile boolean isRunning = true;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		System.out.println("����run��");
		while (isRunning == true) {
		}
		System.out.println("�̱߳�ֹͣ�ˣ�");
	}

}