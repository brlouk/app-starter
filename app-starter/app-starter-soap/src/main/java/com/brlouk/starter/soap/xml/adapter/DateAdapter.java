package com.brlouk.starter.soap.xml.adapter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {
	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public Date unmarshal(String v) throws Exception {
		if(null != v) {
			DatatypeConverter.parseDate(v).getTime();
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(Date v) throws Exception {
		if (null != v) {
			Calendar cal = new GregorianCalendar();
			cal.setTime(v);
			return DatatypeConverter.printDate(cal);
		}
		return null;
	}
}