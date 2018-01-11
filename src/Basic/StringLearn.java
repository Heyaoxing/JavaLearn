package Basic;

import Interface.ILearn;

/**
 * 
 * @ClassName: StringHelper
 * @Description: TODO(字符串帮助类)
 * @author heyaoxing
 * @date 2018年1月10日 下午4:54:34
 *
 */
public class StringLearn implements ILearn {

	/**
	 * String是引用类型
	 * 原理 JVM中的常量是存储在常量池中，常量池在内存中是以表的形式存在，对于String类型，
	 * 会有一张固定长度的CONSTANT_String_info表来存储字符值（不存储字符引用）. 程序在执行时，常量池会存储在Method
	 * Area中而不是堆中。 常量池中保存着很多String对象，并且可以被共享 String是final类型，因此它的值创建后就不能被修改
	 */

	public  void Example() {

		// 使用String=""直接赋值的string类型不一定创建了对象，此例中，由于a之前没有创建过值为 "abc"
		// 的实例，所以a会创建一个新实例放入到常量池中
		String a = "abc";
		// b在创建实例前会在常量池中搜索值为"abc" 的实例，此例中发现已有a创建了相同值的实例，因此b不创建新实例，而是共享a的实例
		String b = "abc";

		System.out.println("example 1:");
		System.out.println("\tString池中存放的string对象可以共享，因此赋值相同的string值对象相等，如:");
		System.out.println("\ta.equals(b):" + (a.equals(b)));
		System.out.println("\ta==b:" + (a == b));
		System.out.println("\n");

		// 这个创建了2个对象，一个在字符池中，一个在堆中，堆中对象值引用的是字符池中的对象
		String aa = new String("abc");
		// 由于aa已经在字符池中创建了abc的对象，因此bb只创建了一个堆中的对象，值引用的是aa字符池中的对象
		String bb = new String("abc");
		System.out.println("example 2:");
		System.out.println("\tnew String 一定创建对象，如:");
		System.out.println("\t值相等 aa.equals(bb):" + (aa.equals(bb)));
		System.out.println("\t由于aa和bb在堆中不同一个对象，因此堆地址不相等  aa==bb:" + (aa == bb));
		System.out.println("\n");

		// aaa的值在编译时就自动合并位abcd,因此在运行时可以确定aaa等于bbb
		String aaa = "ab" + "cd";
		String bbb = "abcd";
		System.out.println("example 3:");
		System.out.println("\t使用string直接赋值时，由于String值位final类型,因此在编译就可以确定对象值，如:");
		System.out.println("\taaa.equals(bbb):" + (aaa.equals(bbb)));
		System.out.println("\taaa==bbb:" + (aaa == bbb));
		System.out.println("\n");

		/**
		 * str1和str2各自在常量池中创建一个对象
		 * 赋值给str3时，JVM会先创建一个StringBuild对象并用Append合并str1和str2，
		 * 用Tostring创建一个新的string对象放入到常量池中 将新创建的对象堆地址指向给str3
		 */
		String str1 = "ab";
		String str2 = "cd";
		String str3 = str1 + str2;
		String str4 = "abcd";
		System.out.println("example 4:");
		System.out.println("\t拘留池地址指的就是常量池中存放string对象值的那张表CONSTANT_String_info，如:");
		System.out.println("\tstr3.equals(str4):" + (str3.equals(str4)));
		System.out.println("\tstr3==str4:" + (str3 == str4));
		System.out.println("\n");
		
		/**
		 * StringBuffer与StringBuilder都继承自AbstractStringBuilder，作用完全相同，区别在于StringBuffer是线程安全的，StringBuilder线程不安全
		 * StringBuffer 始于 JDK 1.0  ,  StringBuilder 始于 JDK 1.5 
		 * AbstractStringBuilder 无非采用的是在内部使用char[]数组进行存储，当字符串长度大于AbstractStringBuilder的默认值16个字符后会进行动态扩展char数组的大小，默认是2倍增长
		 * Tostring方法的实现是将char[]数组转化成String对象，如: new String(value, 0, count);
		 */
		
	}

     public  void Method(){
     }
     
     
}
