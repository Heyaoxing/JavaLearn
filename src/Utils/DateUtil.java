package Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	// 提供格式化日期枚举
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
	 * 返回当前系统时间 @Title: Now @Description: TODO(这里用一句话描述这个方法的作用) @param @return
	 * Date @throws
	 */
	public static Date Now() {
		return new Date();
	}

	/**
	 * 返回当前系统时间的默认格式化字符 @Title: nowDefaultFormat @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @return String @throws
	 */
	public static String nowDefaultFormat() {
		return defaultFormat(Now());
	}

	/**
	 * 自定义格式化当前系统时间 @Title: nowFormat @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @return String @throws
	 */
	public static String nowFormat(String pattern) {
		return format(Now(), pattern);
	}

	/**
	 * 提供枚举格式化日期 @Title: nowFormat @Description: TODO(提供枚举格式化日期) @param @return
	 * String @throws
	 */
	public static String nowFormat(formatEnum type) {
		return format(Now(), getFormatString(type));
	}

	/**
	 * 返回枚举的日期格式 @Title: getFormatString @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @return String @throws
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
	 * 返回当前时间的标准字符串格式 fomat:yyyy-MM-dd HH:mm:ss @Title:
	 * defaultFormat @Description: TODO(这里用一句话描述这个方法的作用) @param @return
	 * String @throws
	 */
	public static String defaultFormat(Date date) {
		return format(date, defaultPattern);
	}

	/**
	 * 格式化日期
	 * 
	 * @Title: format @Description: TODO(这里用一句话描述这个方法的作用) @param @return
	 *         String @throws
	 */
	public static String format(Date date, String pattern) {
		if (date == null)
			return "";
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		return simple.format(date);
	}

	/**
	 * 格式化日期 @Title: format @Description: TODO(这里用一句话描述这个方法的作用) @param @return
	 * String @throws
	 */
	public static String format(Date date, formatEnum type) {
		if (date == null)
			return "";
		return format(date, getFormatString(type));
	}

	/**
	 * 自定义时间 @Title: Define @Description: TODO(这里用一句话描述这个方法的作用) @param @return
	 * Date @throws
	 */
	public static Date Define(int year, int mouth, int day, int houch, int minute, int second) {
		Calendar calendar = new GregorianCalendar(year, mouth-1, day, houch, minute, second);
		return calendar.getTime();
	}
	
	/**
	 * 将指定的年份数加到此实例的值上
	* @Title: addYears 
	* @Description: TODO(将指定的年份数加到此实例的值上) 
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
	 * 将指定的月份数加到此实例的值上
	* @Title: addMonth 
	* @Description: TODO(将指定的月份数加到此实例的值上) 
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
	 * 将指定的天数加到此实例的值上
	* @Title: addDays 
	* @Description: TODO(将指定的天数加到此实例的值上) 
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
	 * 将指定的小时数加到此实例的值上
	* @Title: addHours 
	* @Description: TODO(将指定的天数加到此实例的值上) 
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
	 * 将指定的分钟数加到此实例的值上
	* @Title: addMinutes 
	* @Description: TODO(将指定的天数加到此实例的值上) 
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
	 * 将指定的秒数加到此实例的值上
	* @Title: addMinutes 
	* @Description: TODO(将指定的天数加到此实例的值上) 
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
