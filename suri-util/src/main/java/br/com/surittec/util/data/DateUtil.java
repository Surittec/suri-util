/*
 * SURITTEC
 * Copyright 2014, SURITTEC CONSULTORIA LTDA, 
 * and individual contributors as indicated by the @authors tag
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package br.com.surittec.util.data;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtil {
	
	private static final int MILLISECOND_TO_DAY = 1000 * 60 * 60 * 24;
	private static final int MILLISECOND_TO_MINUTE = 1000 * 60;
	
	/*
	 * First / Last
	 */
	
	public static Date toFirstTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static Date toLastTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	
	public static Date toFirstDateOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		return toFirstTime(cal.getTime());
	}
	
	public static Date toLastDateOfMonth(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		return toLastTime(cal.getTime());
	}
	
	public static Date toFirstDateOfYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		return toFirstTime(cal.getTime());
	}
	
	public static Date toLastDateOfYear(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		return toLastTime(cal.getTime());
	}
	
	/*
	 * Add / Sub
	 */
	
	public static Date addMillisecond(Date date, int amount){
		return addToField(date, Calendar.MILLISECOND, amount);
	}
	
	public static Date subMillisecond(Date date, int amount){
		return addToField(date, Calendar.MILLISECOND, amount * -1);
	}
	
	public static Date addSecond(Date date, int amount){
		return addToField(date, Calendar.SECOND, amount);
	}
	
	public static Date subSecond(Date date, int amount){
		return addToField(date, Calendar.SECOND, amount * -1);
	}
	
	public static Date addMinute(Date date, int amount){
		return addToField(date, Calendar.MINUTE, amount);
	}
	
	public static Date subMinute(Date date, int amount){
		return addToField(date, Calendar.MINUTE, amount * -1);
	}
	
	public static Date addHour(Date date, int amount){
		return addToField(date, Calendar.HOUR_OF_DAY, amount);
	}
	
	public static Date subHour(Date date, int amount){
		return addToField(date, Calendar.HOUR_OF_DAY, amount * -1);
	}
	
	public static Date addDay(Date date, int amount){
		return addToField(date, Calendar.DAY_OF_MONTH, amount);
	}
	
	public static Date subDay(Date date, int amount){
		return addToField(date, Calendar.DAY_OF_MONTH, amount * -1);
	}
	
	public static Date addMonth(Date date, int amount){
		return addToField(date, Calendar.MONTH, amount);
	}
	
	public static Date subMonth(Date date, int amount){
		return addToField(date, Calendar.MONTH, amount * -1);
	}
	
	public static Date addYear(Date date, int amount){
		return addToField(date, Calendar.YEAR, amount);
	}
	
	public static Date subYear(Date date, int amount){
		return addToField(date, Calendar.YEAR, amount * -1);
	}
	
	public static Date addToField(Date date, int field, int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
	
	/*
	 * Convert
	 */
	
	public static XMLGregorianCalendar toXmlGregorianDate(Date date) {
		return toXmlGregorianDate(date.getTime());
	}
	
	public static XMLGregorianCalendar toXmlGregorianDate(long date) {
		DatatypeFactory dataTypeFactory;
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(date);
		return dataTypeFactory.newXMLGregorianCalendar(gc);
	}
	
	/*
	 * Ranges
	 */

	public static long daysBetween(Date from, Date to){
		return (toFirstTime(to).getTime() - toFirstTime(from).getTime()) / MILLISECOND_TO_DAY;
	}
	
	public static long minutesBetween(Date from, Date to){
		return (to.getTime() - from.getTime()) / MILLISECOND_TO_MINUTE;
	}
	
	public static int yearsBetween(Date from, Date to){
		Calendar fromC = Calendar.getInstance();
        fromC.setTime(from);
        
        Calendar toC = Calendar.getInstance();
        toC.setTime(to);
        
        int years = toC.get(Calendar.YEAR) - fromC.get(Calendar.YEAR);
        fromC.add(Calendar.YEAR, years);
        if (toC.before(fromC)) years--;
        
        return years;
	}
	
	public static int getAge(Date dateOfBirth){
		return yearsBetween(dateOfBirth, new Date());
    }
	
}