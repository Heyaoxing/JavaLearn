package Utils;

import java.util.Date;
/**
 * String工具类
* @ClassName: StringUtil 
* @Description: TODO(String工具类) 
* @author heyaoxing
* @date 2018年1月10日 下午7:27:08 
*
 */
public class StringUtil {
   
	/** char的特殊点
	 * java中字符使用UTF16字符集，但utf16并不能完全表示所有的文字
	 * 一个完整的 Unicode 字符叫代码点CodePoint，而一个 Java char 叫 代码单元 code unit。String 对象以UTF-16保存 Unicode 字符，需要用2个字符表示一个超大字符集的汉字，这这种表示方式称之为 Surrogate，第一个字符叫 Surrogate High，第二个就是 Surrogate Low。具体需要注意的事宜如下：
	 * 
		1.判断一个char是否是Surrogate区的字符，用Character的 isHighSurrogate()/isLowSurrogate()方法即可判断。从两个Surrogate High/Low 字符，返回一个完整的 Unicode CodePoint 用 Character.toCodePoint()/codePointAt()方法。
		2.一个Code Point，可能需要一个也可能需要两个char表示，因此不能直接使用 CharSequence.length()方法直接返回一个字符串到底有多少个汉字，而需要用String.codePointCount()/Character.codePointCount()。
		3.要定位字符串中的第N个字符，不能直接将N作为偏移量，而需要从字符串头部依次遍历得到，需要用String/Character.offsetByCodePoints() 方法。
		4.从字符串的当前字符，找到上一个字符，也不能直接用offset-- 实现，而需要用 String.codePointBefore()/Character.codePointBefore()，或用 String/Character.offsetByCodePoints()
		5.从当前字符，找下一个字符，不能直接用 offset++实现，需要判断当前 CodePoint的长度后，再计算得到，或用String/Character.offsetByCodePoints()。
	 */
	
	
	
   /**
    * 半角转全角
   * @Title: toFull 
   * @Description: TODO(半角转全角) 
   * @param  str
   * @return 全角字符    
   * @throws
    */
   public static String toFull(String str){
	   String source = "1234567890!@#$%^&*()abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_=+\\|[];:'\",<.>/?";    
       String[] decode = { "１", "２", "３", "４", "５", "６", "７", "８", "９", "０",    
               "！", "＠", "＃", "＄", "％", "︿", "＆", "＊", "（", "）", "ａ", "ｂ",    
               "ｃ", "ｄ", "ｅ", "ｆ", "ｇ", "ｈ", "ｉ", "ｊ", "ｋ", "ｌ", "ｍ", "ｎ",    
               "ｏ", "ｐ", "ｑ", "ｒ", "ｓ", "ｔ", "ｕ", "ｖ", "ｗ", "ｘ", "ｙ", "ｚ",    
               "Ａ", "Ｂ", "Ｃ", "Ｄ", "Ｅ", "Ｆ", "Ｇ", "Ｈ", "Ｉ", "Ｊ", "Ｋ", "Ｌ",    
               "Ｍ", "Ｎ", "Ｏ", "Ｐ", "Ｑ", "Ｒ", "Ｓ", "Ｔ", "Ｕ", "Ｖ", "Ｗ", "Ｘ",    
               "Ｙ", "Ｚ", "－", "＿", "＝", "＋", "＼", "｜", "【", "】", "；", "：",    
               "'", "\"", "，", "〈", "。", "〉", "／", "？" };    
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
    * 搜索CharSequence中是否包含char
    * CharSequence是String类型的接口，此借口提供可读可写的char有序序列字符数组，继承该接口的还有StrignBuild和StringBuffer
   * @Title: containsChar 
   * @Description: TODO(这里用一句话描述这个方法的作用) 
   * @param  cs
   * @param  searchChar
   * @return 包含一个则返回true，否则返回false    
   * @throws
    */
   public static boolean containsChar(CharSequence cs,char... searchChar){
	   if(cs==null||searchChar==null)  return true;
	   
	   for(int i=0;i<cs.length();i++){
		   for(int j=0;j<searchChar.length;j++){
			   char ch=searchChar[j];
			 //当出现单字符相等时，需要判断改字符集是否是高位char并且低位char是否也相等，只有高低位char相等的情况下彼此才相等
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
    * 将对象转换成字符串
   * @Title: toString 
   * @Description: TODO(将对象转换成字符串) 
   * @param  
   * @return string    
   * @throws
    */
   public static String toString(Object object){
	   return object==null?"":object.toString();
   }
   
   /**
    * 移除开头匹配的字符
   * @Title: removeStartWith 
   * @Description: TODO(移除匹配的开始字符) 
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
    * 移除结尾处匹配的字符串
   * @Title: endStartWith 
   * @Description: TODO(这里用一句话描述这个方法的作用) 
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
    * 是否是空字符或者是null值
   * @Title: isNullOrWhiteSpace 
   * @Description: TODO(是否是空字符或者是null值) 
   * @param  
   * @return boolean    
   * @throws
    */
   public static boolean isNullOrWhiteSpace(String sourch){
	   if(sourch==null||sourch.trim().isEmpty()) return true;
	   return false;
   }
   
   /**
    * 字符重复多次并返回字符串
   * @Title: repeat 
   * @Description: TODO(这里用一句话描述这个方法的作用) 
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
    * 源字符串长度不足size时从左边补充指定字符
   * @Title: rightPad 
   * @Description: TODO(右边补充指定长度的字符) 
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
    * 源字符串长度不足size时从右边补充指定字符
   * @Title: leftPad 
   * @Description: TODO(这里用一句话描述这个方法的作用) 
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
