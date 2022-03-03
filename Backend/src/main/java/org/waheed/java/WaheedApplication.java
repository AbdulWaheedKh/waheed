package org.waheed.java;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.waheed.java.model.DaysOfTheWeek;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableAsync
@EnableScheduling
public class WaheedApplication extends SpringBootServletInitializer {

	private static final Object va = null;
//	private final static  Logger logger = LoggerFactory.getILoggerFactory().getLogger()
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
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

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("------------APPLICATION Started----------");				
        return application.sources(WaheedApplication.class);
    }
	

	public static void main(String[] args) {
		SpringApplication.run(WaheedApplication.class, args);
		LoggerFactory.getLogger("------------- APP STARTED ----------------");
	//	final Logger logger = LoggerFactory.class.

	//	logger.debug("app sted");
		// working on collection 
		// map , hashmap 
		HashMap<Integer,String> map=new HashMap<Integer,String>();//Creating HashMap    
		map.put(1,"Mango");  //Put elements in Map  
		map.put(2,"Apple");    
		map.put(3,"Banana");   
		map.put(4,"Grapes");   
	//	logger.info("------------APPLICATION Started----------");		
		System.out.println("Iterating Hashmap...");  
		for(Map.Entry m : map.entrySet()){    
		 System.out.println(m.getKey()+" "+m.getValue());   
//		 logger.debug("app sted"); 
		}  
		
		HashMap<Integer , Integer > intmap = new HashMap<>();
		intmap.put(1, 11);
		intmap.put(2, 22);
		intmap.put(3, 33);
		System.out.println("Iteating Hashmap");
		
		for (Map.Entry i : intmap.entrySet()) {
			System.out.println(i.getKey() + "  >>> value >>> "+ i.getValue());
		}

		 // lambda
		 intmap.forEach((k, v) -> System.out.println("Key : " + k + ", Value : " + v));
		 intmap.forEach(
			(k, v) -> {
				// yes, we can put logic here
				if (k.equals(2)){
					System.out.println( "values >>> "+v);
				}
			}
		);


		HashMap<Integer , List<Integer>> ListMap = new HashMap<>();
		List<Integer> aList = new ArrayList<>(); 
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(1);
		aList.add(2);

		ListMap.put(1, aList);
		ListMap.put(2, aList);
		ListMap.put(3, aList);
		LoggerFactory.getLogger("------------- APP STARTED ----------------");

		for (Map.Entry<Integer,List<Integer>> vaiable : ListMap.entrySet()) {
			System.out.println("key >> "+vaiable.getKey() + "Values >> "+ vaiable.getValue().toString());
			if(vaiable.getKey().equals(2)){
				System.out.println("--- kEY 2 EXECUTED ---");
			}
		}

		HashMap<List<Integer> , List<Integer>> mapps = new HashMap<>();
		List<Integer> ListOne = new ArrayList<>();
		List<Integer> listtwo = new ArrayList<>();
		
		ListOne.add(1); ListOne.add(11); ListOne.add(111); ListOne.add(1111); ListOne.add(11111); ListOne.add(11111);
		listtwo.add(2);listtwo.add(22);listtwo.add(222);listtwo.add(2222);listtwo.add(22222);listtwo.add(222222);

		mapps.put(ListOne, listtwo);
		int j = 0;
		for (Map.Entry<List<Integer> , List<Integer>> allInts : mapps.entrySet()) {
		
			for (Integer integer : allInts.getKey()) {
				System.out.println("integer  >>>"+ integer);
				System.out.println("key num >> " + integer+  "Values >>>" + allInts.getValue());
		//		List<Integer> i = allInts.getValue();
		//		Integer j = null;
				for (Integer integer2 : allInts.getValue()) {
					System.out.println("integer  >>>"+ integer2);
				
					j += integer2; 
					System.out.println("sum >>>"+ j);
				}
			//	System.out.println("sum >>>"+ j);
			}

		}
		


		DaysOfTheWeek day = DaysOfTheWeek.FRIDAY;

		for (DaysOfTheWeek va : DaysOfTheWeek.values()) {
			System.out.println(va);
		//	System.out.println(Stream.of(va).distinct());
			
		}
		System.out.println(Stream.of(va).count());

		System.out.println("ENUM specific >> " + day);

		System.out.println("Hello World!");
		LocalDate date = LocalDate.now();
		ZoneId zoneId = ZoneId.systemDefault(); 
		long epoch = date.atStartOfDay(zoneId).toEpochSecond();

		 System.out.println("epoch ! "+epoch);

		 System.out.println("zoneId ! "+zoneId);
		  System.out.println("date ! "+date);

		  Instant instant = Instant.ofEpochSecond( epoch );
		  System.out.println("date ! "+instant);

		  java.util.Date time=new java.util.Date((long)epoch*1000);
		  System.out.println("date ! "+time);

		  ZoneId z = ZoneId.systemDefault();
LocalDate today = LocalDate.now( z ) ;
System.out.println(today);



	}

}
