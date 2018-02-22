package jp.maru.spring.sample1;

import java.util.Calendar;
import java.util.Date;

public class MyBean {
	private Date date;
	private String message;
	
	public MyBean() {
		super();
		this.date = Calendar.getInstance().getTime();
	}
	
	public MyBean(String message) {
		this();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "MyBean [message="+message + ", date="+date+"]";
		
	}
}
