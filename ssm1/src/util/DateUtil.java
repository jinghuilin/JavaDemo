package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * 将字符串按默认格式(yyyy-MM-dd)解析为Date对象
	 * @param strDate
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse("yyyy-MM-dd", strDate);
	}
	/**
	 * 将字符串按指定格式解析为Date对象
	 * @param formatter 指定的格式
	 * @param strDate
	 * @return
	 */
	public static Date parse(String formatter, String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		try {
			return sdf.parse(strDate);
		}catch(ParseException e) {
			
		}
		return null;
	}
	/**
	 * 将Date对象格式化为默认格式(yyyy-MM-dd)的字符串描述
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format("yyyy-MM-dd", date);
	}
	/**
	 * 将Date对象格式化为指定格式的字符串描述
	 * @param formatter 指定的格式
	 * @param date
	 * @return
	 */
	public static String format(String formatter, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(date);
	}
}
