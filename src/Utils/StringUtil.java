package Utils;

import java.util.Date;
/**
 * String������
* @ClassName: StringUtil 
* @Description: TODO(String������) 
* @author heyaoxing
* @date 2018��1��10�� ����7:27:08 
*
 */
public class StringUtil {
   
	/** char�������
	 * java���ַ�ʹ��UTF16�ַ�������utf16��������ȫ��ʾ���е�����
	 * һ�������� Unicode �ַ��д����CodePoint����һ�� Java char �� ���뵥Ԫ code unit��String ������UTF-16���� Unicode �ַ�����Ҫ��2���ַ���ʾһ�������ַ����ĺ��֣������ֱ�ʾ��ʽ��֮Ϊ Surrogate����һ���ַ��� Surrogate High���ڶ������� Surrogate Low��������Ҫע����������£�
	 * 
		1.�ж�һ��char�Ƿ���Surrogate�����ַ�����Character�� isHighSurrogate()/isLowSurrogate()���������жϡ�������Surrogate High/Low �ַ�������һ�������� Unicode CodePoint �� Character.toCodePoint()/codePointAt()������
		2.һ��Code Point��������Ҫһ��Ҳ������Ҫ����char��ʾ����˲���ֱ��ʹ�� CharSequence.length()����ֱ�ӷ���һ���ַ��������ж��ٸ����֣�����Ҫ��String.codePointCount()/Character.codePointCount()��
		3.Ҫ��λ�ַ����еĵ�N���ַ�������ֱ�ӽ�N��Ϊƫ����������Ҫ���ַ���ͷ�����α����õ�����Ҫ��String/Character.offsetByCodePoints() ������
		4.���ַ����ĵ�ǰ�ַ����ҵ���һ���ַ���Ҳ����ֱ����offset-- ʵ�֣�����Ҫ�� String.codePointBefore()/Character.codePointBefore()������ String/Character.offsetByCodePoints()
		5.�ӵ�ǰ�ַ�������һ���ַ�������ֱ���� offset++ʵ�֣���Ҫ�жϵ�ǰ CodePoint�ĳ��Ⱥ��ټ���õ�������String/Character.offsetByCodePoints()��
	 */
	
	
	
   /**
    * ���תȫ��
   * @Title: toFull 
   * @Description: TODO(���תȫ��) 
   * @param  str
   * @return ȫ���ַ�    
   * @throws
    */
   public static String toFull(String str){
	   String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";    
       String[] decode = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",    
               "'", "\"", "��", "��", "��", "��", "��", "��" };    
       if(str==null||str.trim().isEmpty()) return "";
       StringBuffer buffer=new StringBuffer(str.length());
       
       for(int i=0;i<str.length();i++){
    	  int index= source.indexOf(str.charAt(i));
    	  if(index!=-1){
    		  buffer.append(decode[i]);
    	  }else{
    		  buffer.append(str.charAt(i));
    	  }
       }
       return buffer.toString();
   }
   
   /**
    * ����CharSequence���Ƿ����char
    * CharSequence��String���͵Ľӿڣ��˽���ṩ�ɶ���д��char���������ַ����飬�̳иýӿڵĻ���StrignBuild��StringBuffer
   * @Title: containsChar 
   * @Description: TODO(������һ�仰�����������������) 
   * @param  cs
   * @param  searchChar
   * @return ����һ���򷵻�true�����򷵻�false    
   * @throws
    */
   public static boolean containsChar(CharSequence cs,char... searchChar){
	   if(cs==null||searchChar==null)  return true;
	   
	   for(int i=0;i<cs.length();i++){
		   for(int j=0;j<searchChar.length;j++){
			   char ch=searchChar[j];
			 //�����ֵ��ַ����ʱ����Ҫ�жϸ��ַ����Ƿ��Ǹ�λchar���ҵ�λchar�Ƿ�Ҳ��ȣ�ֻ�иߵ�λchar��ȵ�����±˴˲����
			   if(cs.charAt(i)==ch){
				   if(Character.isHighSurrogate(ch)){   
					   if(j==searchChar.length-1) return true;
					   if(i<cs.length()-1&&cs.charAt(i+1)==searchChar[j+1]) return true;
					   else return false; 
				   }
			   }
		   }
	   }
	   return true;
   }
   
   /**
    * ������ת�����ַ���
   * @Title: toString 
   * @Description: TODO(������ת�����ַ���) 
   * @param  
   * @return string    
   * @throws
    */
   public static String toString(Object object){
	   return object==null?"":object.toString();
   }
   
   /**
    * �Ƴ���ͷƥ����ַ�
   * @Title: removeStartWith 
   * @Description: TODO(�Ƴ�ƥ��Ŀ�ʼ�ַ�) 
   * @param  
   * @return String    
   * @throws
    */
   public static String removeStartWith(String sourch,String start){
	   if(sourch==null||start==null) return sourch;
	   
	   if(sourch.startsWith(start)){
		  return sourch.substring(start.length());
	   }
	   return sourch;
   }
   
   /**
    * �Ƴ���β��ƥ����ַ���
   * @Title: endStartWith 
   * @Description: TODO(������һ�仰�����������������) 
   * @param  
   * @return String    
   * @throws
    */
   public static String removeEndStartWith(String sourch,String end){
	   if(sourch==null||end==null) return sourch;
	   if(sourch.endsWith(end))
		   return sourch.substring(0, sourch.length()-end.length());
	   return sourch;
   }
   
   /**
    * �Ƿ��ǿ��ַ�������nullֵ
   * @Title: isNullOrWhiteSpace 
   * @Description: TODO(�Ƿ��ǿ��ַ�������nullֵ) 
   * @param  
   * @return boolean    
   * @throws
    */
   public static boolean isNullOrWhiteSpace(String sourch){
	   if(sourch==null||sourch.trim().isEmpty()) return true;
	   return false;
   }
   
   /**
    * �ַ��ظ���β������ַ���
   * @Title: repeat 
   * @Description: TODO(������һ�仰�����������������) 
   * @param  
   * @return String    
   * @throws
    */
   public static String repeat(char ch,int repeat){
	   char[] buffer=new char[repeat];
	   for(int i=0;i<repeat;i++){
		   buffer[i]=ch;
	   }
	   return new String(buffer);
   }
   
   /**
    * Դ�ַ������Ȳ���sizeʱ����߲���ָ���ַ�
   * @Title: rightPad 
   * @Description: TODO(�ұ߲���ָ�����ȵ��ַ�) 
   * @param  
   * @return String    
   * @throws
    */
   public static String leftPad(String sourch,char padchar,int size){
	   if(sourch==null) return sourch;
       int len=size-sourch.length();
       if(len<=0){
    	   return sourch;
       }
       
       return sourch.concat(repeat(padchar,len));
   }
   
   /**
    * Դ�ַ������Ȳ���sizeʱ���ұ߲���ָ���ַ�
   * @Title: leftPad 
   * @Description: TODO(������һ�仰�����������������) 
   * @param  
   * @return String    
   * @throws
    */
   public static String rightPad(String sourch,char padchar,int size){
	   if(sourch==null) return sourch;
	   int len=size-sourch.length();
	   if(len<=0) return sourch;
	   return repeat(padchar,len).concat(sourch);
   }
}
