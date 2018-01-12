package Basic;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread04Learn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final service service=new service();
		new Thread() {
            public void run(){
            	service.method1();
            }
		}.start();
		
		new Thread() {
            public void run(){
            	service.method2();
            }
		}.start();;
	}

}

class service {
	private Lock lock = new ReentrantLock(true);//��ƽ���� ��ƽ��ָ�����̻߳�ȡ����˳���ǰ��ռ���˳������
    private Condition condition=lock.newCondition();
	public void method1() {
		lock.lock();
		try {
			Thread.sleep(2000);
			condition.await();
			System.out.println("����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void method2() {
		lock.lock();
		try {
			System.out.println("�ȴ�");
			condition.signal();
			System.out.println("����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
