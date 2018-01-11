package Basic;

import Interface.ILearn;

/**
 * 
 * @ClassName: StringHelper
 * @Description: TODO(�ַ���������)
 * @author heyaoxing
 * @date 2018��1��10�� ����4:54:34
 *
 */
public class StringLearn implements ILearn {

	/**
	 * String����������
	 * ԭ�� JVM�еĳ����Ǵ洢�ڳ������У����������ڴ������Ա����ʽ���ڣ�����String���ͣ�
	 * ����һ�Ź̶����ȵ�CONSTANT_String_info�����洢�ַ�ֵ�����洢�ַ����ã�. ������ִ��ʱ�������ػ�洢��Method
	 * Area�ж����Ƕ��С� �������б����źܶ�String���󣬲��ҿ��Ա����� String��final���ͣ��������ֵ������Ͳ��ܱ��޸�
	 */

	public  void Example() {

		// ʹ��String=""ֱ�Ӹ�ֵ��string���Ͳ�һ�������˶��󣬴����У�����a֮ǰû�д�����ֵΪ "abc"
		// ��ʵ��������a�ᴴ��һ����ʵ�����뵽��������
		String a = "abc";
		// b�ڴ���ʵ��ǰ���ڳ�����������ֵΪ"abc" ��ʵ���������з�������a��������ֵͬ��ʵ�������b��������ʵ�������ǹ���a��ʵ��
		String b = "abc";

		System.out.println("example 1:");
		System.out.println("\tString���д�ŵ�string������Թ�����˸�ֵ��ͬ��stringֵ������ȣ���:");
		System.out.println("\ta.equals(b):" + (a.equals(b)));
		System.out.println("\ta==b:" + (a == b));
		System.out.println("\n");

		// ���������2������һ�����ַ����У�һ���ڶ��У����ж���ֵ���õ����ַ����еĶ���
		String aa = new String("abc");
		// ����aa�Ѿ����ַ����д�����abc�Ķ������bbֻ������һ�����еĶ���ֵ���õ���aa�ַ����еĶ���
		String bb = new String("abc");
		System.out.println("example 2:");
		System.out.println("\tnew String һ������������:");
		System.out.println("\tֵ��� aa.equals(bb):" + (aa.equals(bb)));
		System.out.println("\t����aa��bb�ڶ��в�ͬһ��������˶ѵ�ַ�����  aa==bb:" + (aa == bb));
		System.out.println("\n");

		// aaa��ֵ�ڱ���ʱ���Զ��ϲ�λabcd,���������ʱ����ȷ��aaa����bbb
		String aaa = "ab" + "cd";
		String bbb = "abcd";
		System.out.println("example 3:");
		System.out.println("\tʹ��stringֱ�Ӹ�ֵʱ������Stringֵλfinal����,����ڱ���Ϳ���ȷ������ֵ����:");
		System.out.println("\taaa.equals(bbb):" + (aaa.equals(bbb)));
		System.out.println("\taaa==bbb:" + (aaa == bbb));
		System.out.println("\n");

		/**
		 * str1��str2�����ڳ������д���һ������
		 * ��ֵ��str3ʱ��JVM���ȴ���һ��StringBuild������Append�ϲ�str1��str2��
		 * ��Tostring����һ���µ�string������뵽�������� ���´����Ķ���ѵ�ַָ���str3
		 */
		String str1 = "ab";
		String str2 = "cd";
		String str3 = str1 + str2;
		String str4 = "abcd";
		System.out.println("example 4:");
		System.out.println("\t�����ص�ַָ�ľ��ǳ������д��string����ֵ�����ű�CONSTANT_String_info����:");
		System.out.println("\tstr3.equals(str4):" + (str3.equals(str4)));
		System.out.println("\tstr3==str4:" + (str3 == str4));
		System.out.println("\n");
		
		/**
		 * StringBuffer��StringBuilder���̳���AbstractStringBuilder��������ȫ��ͬ����������StringBuffer���̰߳�ȫ�ģ�StringBuilder�̲߳���ȫ
		 * StringBuffer ʼ�� JDK 1.0  ,  StringBuilder ʼ�� JDK 1.5 
		 * AbstractStringBuilder �޷ǲ��õ������ڲ�ʹ��char[]������д洢�����ַ������ȴ���AbstractStringBuilder��Ĭ��ֵ16���ַ������ж�̬��չchar����Ĵ�С��Ĭ����2������
		 * Tostring������ʵ���ǽ�char[]����ת����String������: new String(value, 0, count);
		 */
		
	}

     public  void Method(){
     }
     
     
}
