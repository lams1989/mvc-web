package com.lesson.mvc.mvcweb.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class FilterDate {
	@DateTimeFormat(iso=ISO.DATE)
	private Date initDate;
	@DateTimeFormat(iso=ISO.DATE)
	private Date endDate;
	
	public FilterDate() {
		initDate = new Date();
		endDate = new Date();
	}
	
	public FilterDate(Date initDate, Date endDate) {
		super();
		this.initDate = initDate;
		this.endDate = endDate;
	}
	
	public Date getInitDate() {
		return initDate;
	}
	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
