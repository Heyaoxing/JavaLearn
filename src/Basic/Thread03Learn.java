package Basic;

public class Thread03Learn {
	public static void main(String[] args) {
		final service1 service = new service1();
		final service2 service2 = new service2();
		new Thread() {
			public void run() {
				service.method2();
			}
		}.start();

		new Thread() {
			public void run() {
				service.method1();
			}
		}.start();
		
		new Thread() {
			public void run() {
				service2.method();
			}
		}.start();
	}

}

class service1 {
	public synchronized void method1() {
		try {
			Thread.sleep(2000);
			notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void method2() {
		try {
			System.out.println("service1�ȴ�");
			wait();
			System.out.println("service1����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


class  service2{
	public synchronized void method() {
		try {
			System.out.println("service2�ȴ�");
			wait();
			System.out.println("service2����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}