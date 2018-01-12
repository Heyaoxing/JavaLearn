public class MainLearn {

	public volatile static int i = 0;
	public  static void test() {
			i++;
	}

	public static void main(String[] args) {
		for (int b = 0; b < 10; b++) {
			new Thread() {
				public void run() {
					for (int a = 0; a < 1000; a++) {
						test();
					}
				}
			}.start();
		}
		while (Thread.activeCount() > 1){
			Thread.yield();
		}
			
		System.out.println("½áÊø:" + i);
	}
}
