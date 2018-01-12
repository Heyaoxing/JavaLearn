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
	private Lock lock = new ReentrantLock(true);//公平锁： 公平锁指的是线程获取锁的顺序是按照加锁顺序来的
    private Condition condition=lock.newCondition();
	public void method1() {
		lock.lock();
		try {
			Thread.sleep(2000);
			condition.await();
			System.out.println("唤醒");
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
			System.out.println("等待");
			condition.signal();
			System.out.println("结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
