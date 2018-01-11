package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	// �ṩ��ʽ������ö��
	public enum formatEnum {
		DEFAULT, DATE, TIME, YEAR, MOUTH, DAY, HOUR, MINUTE, SECOND
	}

	private static final String defaultPattern = "yyyy-MM-dd HH:mm:ss";
	private static final String datePattern = "yyyy-MM-dd";
	private static final String timePattern = "HH:mm:ss";
	private static final String yearPattern = "yyyy";
	private static final String mouthPattern = "MM";
	private static final String dayPattern = "dd";
	private static final String hourPattern = "HH";
	private static final String minutePattern = "mm";
	private static final String secondPattern = "ss";

	/**
	 * ���ص�ǰϵͳʱ�� @Title: Now @Description: TODO(������һ�仰�����������������) @param @return
	 * Date @throws
	 */
	public static Date Now() {
		return new Date();
	}

	/**
	 * ���ص�ǰϵͳʱ���Ĭ�ϸ�ʽ���ַ� @Title: nowDefaultFormat @Description:
	 * TODO(������һ�仰�����������������) @param @return String @throws
	 */
	public static String nowDefaultFormat() {
		return defaultFormat(Now());
	}

	/**
	 * �Զ����ʽ����ǰϵͳʱ�� @Title: nowFormat @Description:
	 * TODO(������һ�仰�����������������) @param @return String @throws
	 */
	public static String nowFormat(String pattern) {
		return format(Now(), pattern);
	}

	/**
	 * �ṩö�ٸ�ʽ������ @Title: nowFormat @Description: TODO(�ṩö�ٸ�ʽ������) @param @return
	 * String @throws
	 */
	public static String nowFormat(formatEnum type) {
		return format(Now(), getFormatString(type));
	}

	/**
	 * ����ö�ٵ����ڸ�ʽ @Title: getFormatString @Description:
	 * TODO(������һ�仰�����������������) @param @return String @throws
	 */
	private static String getFormatString(formatEnum type) {
		String pattern;
		switch (type) {
		case DEFAULT:
			pattern = defaultPattern;
			break;
		case DATE:
			pattern = datePattern;
			break;
		case TIME:
			pattern = timePattern;
			break;
		case YEAR:
			pattern = yearPattern;
			break;
		case MOUTH:
			pattern = mouthPattern;
			break;
		case DAY:
			pattern = dayPattern;
			break;
		case HOUR:
			pattern = hourPattern;
			break;
		case MINUTE:
			pattern = minutePattern;
			break;
		case SECOND:
			pattern = secondPattern;
			break;
		default:
			pattern = defaultPattern;
			break;
		}
		return pattern;
	}

	/**
	 * ���ص�ǰʱ��ı�׼�ַ�����ʽ fomat:yyyy-MM-dd HH:mm:ss @Title:
	 * defaultFormat @Description: TODO(������һ�仰�����������������) @param @return
	 * String @throws
	 */
	public static String defaultFormat(Date date) {
		return format(date, defaultPattern);
	}

	/**
	 * ��ʽ������
	 * 
	 * @Title: format @Description: TODO(������һ�仰�����������������) @param @return
	 *         String @throws
	 */
	public static String format(Date date, String pattern) {
		if (date == null)
			return "";
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		return simple.format(date);
	}

	/**
	 * ��ʽ������ @Title: format @Description: TODO(������һ�仰�����������������) @param @return
	 * String @throws
	 */
	public static String format(Date date, formatEnum type) {
		if (date == null)
			return "";
		return format(date, getFormatString(type));
	}

	/**
	 * �Զ���ʱ�� @Title: Define @Description: TODO(������һ�仰�����������������) @param @return
	 * Date @throws
	 */
	public static Date Define(int year, int mouth, int day, int houch, int minute, int second) {
		Calendar calendar = new GregorianCalendar(year, mouth-1, day, houch, minute, second);
		return calendar.getTime();
	}
	
	/**
	 * ��ָ����������ӵ���ʵ����ֵ��
	* @Title: addYears 
	* @Description: TODO(��ָ����������ӵ���ʵ����ֵ��) 
	* @param  
	* @return Date    
	* @throws
	 */
	public static Date addYears(Date date,int year)
	{
		Calendar cal = Calendar.getInstance();  
		cal.set(Calendar.YEAR,cal.get(Calendar.YEAR)+year);
		return cal.getTime();
	}
	
	/**
	 * ��ָ�����·����ӵ���ʵ����ֵ��
	* @Title: addMonth 
	* @Description: TODO(��ָ�����·����ӵ���ʵ����ֵ��) 
	* @param  
	* @return Date    
	* @throws
	 */
	public static Date addMonth(Date date,int month){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+month);
		return cal.getTime();
	}
	
	/**
	 * ��ָ���������ӵ���ʵ����ֵ��
	* @Title: addDays 
	* @Description: TODO(��ָ���������ӵ���ʵ����ֵ��) 
	* @param  
	* @return Date    
	* @throws
	 */
	public static Date addDays(Date date,int day){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)+day);
		return cal.getTime();
	}
	
	/**
	 * ��ָ����Сʱ���ӵ���ʵ����ֵ��
	* @Title: addHours 
	* @Description: TODO(��ָ���������ӵ���ʵ����ֵ��) 
	* @param  
	* @return Date    
	* @throws
	 */
	public static Date addHours(Date date,int hour){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+hour);
		return cal.getTime();
	}
	
	/**
	 * ��ָ���ķ������ӵ���ʵ����ֵ��
	* @Title: addMinutes 
	* @Description: TODO(��ָ���������ӵ���ʵ����ֵ��) 
	* @param  
	* @return Date    
	* @throws
	 */
	public static Date addMinutes(Date date,int minute){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)+minute);
		return cal.getTime();
	}
	
	/**
	 * ��ָ���������ӵ���ʵ����ֵ��
	* @Title: addMinutes 
	* @Description: TODO(��ָ���������ӵ���ʵ����ֵ��) 
	* @param  
	* @return Date    
	* @throws
	 */
	public static Date addSeconds(Date date,int second){
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.SECOND, cal.get(Calendar.SECOND)+second);
		return cal.getTime();
	}
}
