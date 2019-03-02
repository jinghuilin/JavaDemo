package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/**
	 * ���ַ�����Ĭ�ϸ�ʽ(yyyy-MM-dd)����ΪDate����
	 * @param strDate
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse("yyyy-MM-dd", strDate);
	}
	/**
	 * ���ַ�����ָ����ʽ����ΪDate����
	 * @param formatter ָ���ĸ�ʽ
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
	 * ��Date�����ʽ��ΪĬ�ϸ�ʽ(yyyy-MM-dd)���ַ�������
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format("yyyy-MM-dd", date);
	}
	/**
	 * ��Date�����ʽ��Ϊָ����ʽ���ַ�������
	 * @param formatter ָ���ĸ�ʽ
	 * @param date
	 * @return
	 */
	public static String format(String formatter, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(date);
	}
}
