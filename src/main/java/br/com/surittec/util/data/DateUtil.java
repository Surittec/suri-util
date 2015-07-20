/*
 * SURITTEC
 * Copyright 2015, TTUS TECNOLOGIA DA INFORMACAO LTDA, 
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
import java.util.Locale;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Minutes;
import org.joda.time.Months;
import org.joda.time.Seconds;
import org.joda.time.Years;

/**
 * Classe com métodos utilitários capazes de:
 * <ul>
 * 	<li>Personalizar datas (limpando determinados campos);
 * 	<li>Adicionar ou subtrair valores a campos da data;
 * 	<li>Recuperar campos específicos da data;
 * 	<li>Converter formatos de datas;
 * 	<li>Comparar instâncias de datas diferentes;
 * </ul>
 * 
 * @author Lucas Lins
 *
 */
public class DateUtil {

	/*
	 * Get Calendar by Locale
	 */
	
	public static Calendar getCalendar(Locale locale){
		return locale != null ? Calendar.getInstance(locale) : Calendar.getInstance();
	}
	
	/*
	 * First / Last
	 */

	public static Date firstTime(Locale locale) {
		return toFirstTime(new Date(), locale);
	}

	public static Date firstTime() {
		return firstTime(null);
	}

	public static Date toFirstTime(Date date) {
		return toFirstTime(date, null);
	}
	
	public static Date toFirstTime(Date date, Locale locale) {
		Calendar cal = getCalendar(locale);
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date lastTime(Locale locale) {
		return toLastTime(new Date(), locale);
	}

	public static Date lastTime() {
		return lastTime(null);
	}
	
	public static Date toLastTime(Date date) {
		return toLastTime(date, null);
	}
	
	public static Date toLastTime(Date date, Locale locale) {
		Calendar cal = getCalendar(locale);
		cal.setTime(date);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 23, 59, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	public static Date firstDateOfMonth(Locale locale) {
		return toFirstDateOfMonth(new Date(), locale);
	}

	public static Date firstDateOfMonth() {
		return firstDateOfMonth(null);
	}
	
	public static Date toFirstDateOfMonth(Date date){
		return toFirstDateOfMonth(date, null);
	}
	
	public static Date toFirstDateOfMonth(Date date, Locale locale){
		Calendar cal = getCalendar(locale);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		return toFirstTime(cal.getTime());
	}

	public static Date lastDateOfMonth(Locale locale) {
		return toLastDateOfMonth(new Date(), locale);
	}

	public static Date lastDateOfMonth() {
		return lastDateOfMonth(null);
	}

	public static Date toLastDateOfMonth(Date date){
		return toLastDateOfMonth(date, null);
	}
	
	public static Date toLastDateOfMonth(Date date, Locale locale){
		Calendar cal = getCalendar(locale);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		return toLastTime(cal.getTime());
	}
	
	public static Date toFirstDateOfYear(Date date){
		return toFirstDateOfYear(date, null);
	}
	
	public static Date toFirstDateOfYear(Date date, Locale locale){
		Calendar cal = getCalendar(locale);
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		return toFirstTime(cal.getTime());
	}
	
	public static Date toLastDateOfYear(Date date){
		return toLastDateOfYear(date, null);
	}
	
	public static Date toLastDateOfYear(Date date, Locale locale){
		Calendar cal = getCalendar(locale);
		cal.setTime(date);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		return toLastTime(cal.getTime());
	}
	
	/*
	 * Add / Sub
	 */
	
	public static Date setMillisecond(Date date, int value){
		return setMillisecond(date, value, null);
	}
	
	public static Date setMillisecond(Date date, int value, Locale locale){
		return setField(date, Calendar.MILLISECOND, value, locale);
	}
	
	public static Date addMillisecond(Date date, int amount){
		return addMillisecond(date, amount, null);
	}
	
	public static Date addMillisecond(Date date, int amount, Locale locale){
		return addToField(date, Calendar.MILLISECOND, amount, locale);
	}
	
	public static Date subMillisecond(Date date, int amount){
		return subMillisecond(date, amount, null);
	}
	
	public static Date subMillisecond(Date date, int amount, Locale locale){
		return addToField(date, Calendar.MILLISECOND, amount * -1, locale);
	}
	
	public static Date setSecond(Date date, int value){
		return setSecond(date, value, null);
	}
	
	public static Date setSecond(Date date, int value, Locale locale){
		return setField(date, Calendar.SECOND, value, locale);
	}
	
	public static Date addSecond(Date date, int amount){
		return addSecond(date, amount, null);
	}
	
	public static Date addSecond(Date date, int amount, Locale locale){
		return addToField(date, Calendar.SECOND, amount, locale);
	}
	
	public static Date subSecond(Date date, int amount){
		return subSecond(date, amount, null);
	}
	
	public static Date subSecond(Date date, int amount, Locale locale){
		return addToField(date, Calendar.SECOND, amount * -1, locale);
	}
	
	public static Date setMinute(Date date, int value){
		return setMinute(date, value, null);
	}
	
	public static Date setMinute(Date date, int value, Locale locale){
		return setField(date, Calendar.MINUTE, value, locale);
	}
	
	public static Date addMinute(Date date, int amount){
		return addMinute(date, amount, null);
	}
	
	public static Date addMinute(Date date, int amount, Locale locale){
		return addToField(date, Calendar.MINUTE, amount, locale);
	}
	
	public static Date subMinute(Date date, int amount){
		return subMinute(date, amount, null);
	}
	
	public static Date subMinute(Date date, int amount, Locale locale){
		return addToField(date, Calendar.MINUTE, amount * -1, locale);
	}
	
	public static Date setHour(Date date, int value){
		return setHour(date, value, null);
	}
	
	public static Date setHour(Date date, int value, Locale locale){
		return setField(date, Calendar.HOUR_OF_DAY, value, locale);
	}
	
	public static Date addHour(Date date, int amount){
		return addHour(date, amount, null);
	}
	
	public static Date addHour(Date date, int amount, Locale locale){
		return addToField(date, Calendar.HOUR_OF_DAY, amount, locale);
	}
	
	public static Date subHour(Date date, int amount){
		return subHour(date, amount, null);
	}
	
	public static Date subHour(Date date, int amount, Locale locale){
		return addToField(date, Calendar.HOUR_OF_DAY, amount * -1, locale);
	}
	
	public static Date setDay(Date date, int value){
		return setDay(date, value, null);
	}
	
	public static Date setDay(Date date, int value, Locale locale){
		return setField(date, Calendar.DAY_OF_MONTH, value, locale);
	}
	
	public static Date addDay(Date date, int amount){
		return addDay(date, amount, null);
	}
	
	public static Date addDay(Date date, int amount, Locale locale){
		return addToField(date, Calendar.DAY_OF_MONTH, amount, locale);
	}
	
	public static Date subDay(Date date, int amount){
		return subDay(date, amount, null);
	}
	
	public static Date subDay(Date date, int amount, Locale locale){
		return addToField(date, Calendar.DAY_OF_MONTH, amount * -1, locale);
	}
	
	public static Date setMonth(Date date, int value){
		return setMonth(date, value, null);
	}
	
	public static Date setMonth(Date date, int value, Locale locale){
		return setField(date, Calendar.MONTH, value, locale);
	}
	
	public static Date addMonth(Date date, int amount){
		return addMonth(date, amount, null);
	}
	
	public static Date addMonth(Date date, int amount, Locale locale){
		return addToField(date, Calendar.MONTH, amount, locale);
	}
	
	public static Date subMonth(Date date, int amount){
		return subMonth(date, amount, null);
	}
	
	public static Date subMonth(Date date, int amount, Locale locale){
		return addToField(date, Calendar.MONTH, amount * -1, locale);
	}
	
	public static Date setYear(Date date, int value){
		return setYear(date, value, null);
	}
	
	public static Date setYear(Date date, int value, Locale locale){
		return setField(date, Calendar.YEAR, value, locale);
	}
	
	public static Date addYear(Date date, int amount){
		return addYear(date, amount, null);
	}
	
	public static Date addYear(Date date, int amount, Locale locale){
		return addToField(date, Calendar.YEAR, amount, locale);
	}
	
	public static Date subYear(Date date, int amount){
		return subYear(date, amount, null);
	}
	
	public static Date subYear(Date date, int amount, Locale locale){
		return addToField(date, Calendar.YEAR, amount * -1, locale);
	}
	
	public static Date addToField(Date date, int field, int amount){
		return addToField(date, field, amount, null);
	}
	
	public static Date addToField(Date date, int field, int amount, Locale locale){
		Calendar calendar = getCalendar(locale);
		calendar.setTime(date);
		calendar.add(field, amount);
		return calendar.getTime();
	}
	
	public static Date setField(Date date, int field, int value, Locale locale){
		Calendar calendar = getCalendar(locale);
		calendar.setTime(date);
		calendar.set(field, value);
		return calendar.getTime();
	}
	
	/*
	 * Convert
	 */
	
	public static XMLGregorianCalendar toXmlGregorianDate(Date date) {
		return toXmlGregorianDate(date.getTime());
	}
	
	public static XMLGregorianCalendar toXmlGregorianDate(long date) {
		return toXmlGregorianDate(date, null);
	}
	
	public static XMLGregorianCalendar toXmlGregorianDate(long date, Locale locale) {
		DatatypeFactory dataTypeFactory;
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (DatatypeConfigurationException e) {
			throw new RuntimeException(e);
		}
		GregorianCalendar gc = locale != null ? new GregorianCalendar(locale) : new GregorianCalendar();
		gc.setTimeInMillis(date);
		return dataTypeFactory.newXMLGregorianCalendar(gc);
	}
	
	/*
	 * Ranges
	 */
	
	public static long daysBetween(Date from, Date to) {
		DateTime start = new DateTime(toFirstTime(from).getTime());
		DateTime end = new DateTime(toFirstTime(to).getTime());
		return Days.daysBetween(start, end).getDays();
	}
	
	public static int yearsBetween(Date from, Date to) {
		DateTime start = new DateTime(toFirstTime(from).getTime());
		DateTime end = new DateTime(toFirstTime(to).getTime());
		return Years.yearsBetween(start, end).getYears();
	}
	
	public static long monthsBetween(Date from, Date to) {
		DateTime start = new DateTime(toFirstTime(from).getTime());
		DateTime end = new DateTime(toFirstTime(to).getTime());
		return Months.monthsBetween(
				start.withDayOfMonth(1),
				end.withDayOfMonth(1)).getMonths();
	}
	
	public static long minutesBetween(Date from, Date to) {
		DateTime start = new DateTime(toFirstTime(from).getTime());
		DateTime end = new DateTime(toFirstTime(to).getTime());
		return Minutes.minutesBetween(start, end).getMinutes();
	}
	
	public static long secondsBetween(Date from, Date to) {
		DateTime start = new DateTime(toFirstTime(from).getTime());
		DateTime end = new DateTime(toFirstTime(to).getTime());
		return Seconds.secondsBetween(start, end).getSeconds();
	}

	public static int getAge(Date dateOfBirth){
		return yearsBetween(dateOfBirth, new Date());
    }
	
}