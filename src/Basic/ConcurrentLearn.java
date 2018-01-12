package Basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ConcurrentLearn {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		Vector<Integer> vector = new Vector<Integer>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++)
			array.add(i);
		long end = System.currentTimeMillis();
		System.out.println("ArrayList����10000000����ʱ��Ϊ:" + (end - start));

		start = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++)
			vector.add(i);
		end = System.currentTimeMillis();
		System.out.println("Vector����10000000����ʱ��Ϊ:" + (end - start));
	}
}
