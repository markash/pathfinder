package za.co.yellowfire.threesixty.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	
	public static String format(final Date date) {
		return format(date, DEFAULT_DATE_FORMAT);
	}
	
	public static String format(final Date date, final String format) {
		if (date != null) {
			return new SimpleDateFormat(StringUtils.isNoneBlank(format) ? format : DEFAULT_DATE_FORMAT).format(date);
		}
		return "";
	}
}
