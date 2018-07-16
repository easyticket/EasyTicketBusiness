package com.dise.tickets.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public final class DateSetup {
	
	public static String formatterDate(Timestamp timesTamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(timesTamp);
	}

}
