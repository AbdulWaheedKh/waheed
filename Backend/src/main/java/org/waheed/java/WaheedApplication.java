package org.waheed.java;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.waheed.java.model.DaysOfTheWeek;


@SpringBootApplication
public class WaheedApplication {

	private static final Object va = null;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());	
	
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
	    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	    loggingFilter.setIncludeClientInfo(true);
	    loggingFilter.setIncludeQueryString(true);
	    loggingFilter.setIncludePayload(false);
	    loggingFilter.setIncludeHeaders(true);	    
	    loggingFilter.setMaxPayloadLength(10000);
	    
	    return loggingFilter;
	}

	public static void main(String[] args) {
		SpringApplication.run(WaheedApplication.class, args);
		System.out.println("APP STARTED");

		DaysOfTheWeek day = DaysOfTheWeek.FRIDAY;

		for (DaysOfTheWeek va : DaysOfTheWeek.values()) {
			System.out.println(va);
		//	System.out.println(Stream.of(va).distinct());
			
		}
	//	System.out.println(Stream.of(va).count());

		System.out.println("ENUM specific >> " + day);

		System.out.println("Hello World!");
		LocalDate date = LocalDate.now();
		ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
		long epoch = date.atStartOfDay(zoneId).toEpochSecond();
	//	long epocha = date.toEpochSecond(LocalTime.now(), ZoneOffset);
		 System.out.println("epoch ! "+epoch);
	//	 System.out.println("epocha ! "+epocha);
		 System.out.println("zoneId ! "+zoneId);
		  System.out.println("date ! "+date);
	}

}
