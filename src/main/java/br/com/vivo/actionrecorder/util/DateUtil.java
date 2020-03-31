package br.com.vivo.actionrecorder.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	public static Date fromLocalDateTimeToDate(LocalDateTime ldt) {
		return Date.from( ldt.atZone( ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDateTime fromDateToLocalDateTime(Date dt) {
		return Instant.ofEpochMilli( dt.getTime() )
                .atZone( ZoneId.systemDefault() )
                .toLocalDateTime();
	}
}
