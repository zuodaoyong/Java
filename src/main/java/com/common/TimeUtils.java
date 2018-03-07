package com.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeUtils {
	
	//时间格式
	public final static String SECONDSTR="yyyy-MM-dd HH:mm:ss";
	public final static String MINUTESTR="yyyy-MM-dd HH:mm";
	public final static String HOURSTR="yyyy-MM-dd HH";
	public final static String DAYSTR="yyyy-MM-dd";
	public final static String DEFAULTMINUTESTR="yyyy-MM-dd HH:mm:00";
	public final static String DEFAULTHOURSTR="yyyy-MM-dd HH:00:00";
	public final static String DEFAULTDAYSTR="yyyy-MM-dd 00:00:00";
	public final static String time="yyyyMMdd";
	private static ThreadLocal<DateFormat> threadLocal_day = new ThreadLocal<DateFormat>(); 
	private static ThreadLocal<DateFormat> threadLocal_defaultday = new ThreadLocal<DateFormat>(); 
	private static ThreadLocal<DateFormat> threadLocal_hour = new ThreadLocal<DateFormat>(); 
	private static ThreadLocal<DateFormat> threadLocal_defaulthour = new ThreadLocal<DateFormat>(); 
	private static ThreadLocal<DateFormat> threadLocal_minute = new ThreadLocal<DateFormat>(); 
	private static ThreadLocal<DateFormat> threadLocal_defaultminute = new ThreadLocal<DateFormat>();
	private static ThreadLocal<DateFormat> threadLocal_second = new ThreadLocal<DateFormat>();
	private static ThreadLocal<DateFormat> threadLocal_time = new ThreadLocal<DateFormat>();
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyyMMdd
	 * @return
	 */
	public static DateFormat getDateFormatByTime()   
    {  
        DateFormat df = threadLocal_time.get();
        if(df==null){ 
            df = new SimpleDateFormat(time);  
            threadLocal_time.set(df);
        }
        return df; 
    } 
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd
	 * @return
	 */
	public static DateFormat getDateFormatByDay()   
    {  
        DateFormat df = threadLocal_day.get();
        if(df==null){ 
            df = new SimpleDateFormat(DAYSTR);  
            threadLocal_day.set(df);
        }
        return df; 
    } 
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd 00:00:00
	 * @return
	 */
	public static DateFormat getDateFormatByDefaultDay()   
    {  
        DateFormat df = threadLocal_defaultday.get();
        if(df==null){ 
            df = new SimpleDateFormat(DEFAULTDAYSTR);  
            threadLocal_defaultday.set(df);  
        }
        return df; 
    } 
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd HH
	 * @return
	 */
	public static DateFormat getDateFormatByHour()   
    {  
        DateFormat df = threadLocal_hour.get();
        if(df==null){ 
            df = new SimpleDateFormat(HOURSTR);  
            threadLocal_hour.set(df);  
        }
        return df; 
    } 
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd HH:00:00
	 * @return
	 */
	public static DateFormat getDateFormatByDefaultHour()   
    {  
        DateFormat df = threadLocal_defaulthour.get();
        if(df==null){ 
            df = new SimpleDateFormat(DEFAULTHOURSTR);  
            threadLocal_defaulthour.set(df);  
        }
        return df; 
    } 
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd HH:mm
	 * @return
	 */
	public static DateFormat getDateFormatByMinute()   
    {  
        DateFormat df = threadLocal_minute.get();
        if(df==null){ 
            df = new SimpleDateFormat(MINUTESTR);  
            threadLocal_minute.set(df);  
        }
        return df; 
    }
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd HH:mm:00
	 * @return
	 */
	public static DateFormat getDateFormatByDefaultMinute()   
    {  
        DateFormat df = threadLocal_defaultminute.get();
        if(df==null){ 
            df = new SimpleDateFormat(DEFAULTMINUTESTR);  
            threadLocal_defaultminute.set(df);  
        }
        return df; 
    }
	
	/**
	 * 获取线程安全的DateFormat
	 * 时间格式:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static DateFormat getDateFormatBySecond()   
    {  
        DateFormat df = threadLocal_second.get();
        if(df==null){ 
            df = new SimpleDateFormat(SECONDSTR);  
            threadLocal_second.set(df);  
        }
        return df; 
    }
	
	public static DateFormat getDateFormat(String str){
		if(str.equals(DAYSTR)){
			return getDateFormatByDay();
		}else if(str.equals(DEFAULTDAYSTR)){
			return getDateFormatByDefaultDay();
		}else if(str.equals(HOURSTR)){
			return getDateFormatByHour();
		}else if(str.equals(DEFAULTHOURSTR)){
			return getDateFormatByDefaultHour();
		}else if(str.equals(MINUTESTR)){
			return getDateFormatByMinute();
		}else if(str.equals(DEFAULTMINUTESTR)){
			return getDateFormatByDefaultMinute();
		}else if(str.equals(SECONDSTR)){
			return getDateFormatBySecond();
		}else{
			return getDateFormatBySecond();
		}
	}
	
	public static Date getFormatTime(){
		Date ts = new Date(System.currentTimeMillis());
	    return ts;
	}

	public static Date getFormatTimeByStr(String time) throws ParseException{
		//sdf.parse(time);
		return getDateFormatBySecond().parse(time);
	}
	public static Date getFormatTimeByStr(String time,String sdf) throws ParseException{
		return getDateFormat(sdf).parse(time);
		//return sdf.parse(time);
	}
	public static String parseToFormatTime(Date date){
		SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateTimeInstance();
		return sdf.format(date);
	}
	public static String parseToFormatTime(Date date,String sdf){
		return getDateFormat(sdf).format(date);
		//return sdf.format(date);
	}

	public static Long parseTime(String time) throws Exception{
		Long result=null;
		try {
			result=getDateFormat(SECONDSTR).parse(time.toString()).getTime();
		} catch (Exception e) {
			try {
				result=getDateFormat(MINUTESTR).parse(time.toString()).getTime();
			} catch (ParseException e1) {
				result=getDateFormat(HOURSTR).parse(time.toString()).getTime();
			}
		}
		return result;
	}

	public static Date parseToDate(String time,String sdf) throws Exception{
		return getDateFormat(sdf).parse(time);
	}
	
	public static Long parseToLong(Date date) throws Exception{
		String timeStr=getDateFormat(TimeUtils.DEFAULTMINUTESTR).format(date);
	    Long time =parseToDate(timeStr, TimeUtils.DEFAULTMINUTESTR).getTime();
	    return time;
	}
}
