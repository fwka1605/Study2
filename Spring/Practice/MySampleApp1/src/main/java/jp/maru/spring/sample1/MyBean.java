package jp.maru.spring.sample1;

import java.util.Calendar;
import java.util.Date;

public class MyBean implements MyBeanInterface {
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

	/* (非 Javadoc)
	 * @see jp.maru.spring.sample1.MyBeanInterface#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (非 Javadoc)
	 * @see jp.maru.spring.sample1.MyBeanInterface#setMessage(java.lang.String)
	 */
	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	/* (非 Javadoc)
	 * @see jp.maru.spring.sample1.MyBeanInterface#getDate()
	 */
	@Override
	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "MyBean [message="+message + ", date="+date+"]";
		
	}
}
