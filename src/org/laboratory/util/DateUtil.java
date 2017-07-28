package org.laboratory.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static Date getNow() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = null;
		try {
			now = sdf.parse(sdf.format(new Date()));
		} catch (ParseException e) {
			
		}
		return now;
	}
}
