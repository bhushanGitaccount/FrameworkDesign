package com.qa.Pages;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.TestBase.TestBase;

public class DateFormat 
{

	public static void main(String[] args) 
	{
		/*
		 * DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		 * LocalDateTime now = LocalDateTime.now(); System.out.println(dtf.format(now));
		 * 
		 * 
		 * Date date=java.util.Calendar.getInstance().getTime();
		 * System.out.println(date);
		 */
		   
		   
		/*
		 * String strDate = dateFormat.format(date); // LocalDate localDate =
		 * LocalDate.of(2017, Month.JANUARY, 25);
		 */		   
		/*
		 * Date date = Calendar.getInstance().getTime(); SimpleDateFormat dateFormat =
		 * new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); String strDate =
		 * dateFormat.format(date); System.out.println("Converted String: " + strDate);
		 */ 
		   
		
		/*
		 * Calendar c=Calendar.getInstance();
		 * c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY); c.set(Calendar.HOUR_OF_DAY,0);
		 * c.set(Calendar.MINUTE,0); c.set(Calendar.SECOND,0); DateFormat df=new
		 * SimpleDateFormat("EEE yyyy/MM/dd HH:mm:ss");
		 * System.out.println(df.format(c.getTime())); // This past Sunday [ May include
		 * today ] c.add(Calendar.DATE,7); System.out.println(df.format(c.getTime()));
		 * // Next Sunday c.add(Calendar.DATE,7);
		 * System.out.println(df.format(c.getTime()));
		 */
		   
		/*
		 * Calendar cal=Calendar.getInstance(); int day = cal.getFirstDayOfWeek();
		 * 
		 * System.out.println(day); cal.setFirstDayOfWeek(Calendar.SATURDAY);
		 * 
		 * day = cal.getFirstDayOfWeek(); System.out.println(day);
		 */
		
		System.setProperty("webdriver.chrome.driver", ".\\Resources\\WinDriver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		
		
		LocalDate dt = LocalDate.now();    
	    System.out.println("\nNext Saturday: "+dt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));
	    System.out.println("Previous Sunday: "+dt.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY))+"\n");
	    
	    LocalDate date = dt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
	    
	  System.out.println(date.getDayOfWeek());
	  
	  System.out.println(date.getDayOfMonth());
	  
	    driver.get("https://www.goibibo.com");
	    
	    driver.manage().window().maximize();
	    
	    driver.findElement(By.xpath("//span[contains(text(),'Depart:')]/parent::div//input")).click();
	    
	    
	}
	

}
