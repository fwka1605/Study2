package co.jp.itf.main.util.db;

import java.sql.Connection;

public abstract class ConnectionManagerUtil {

	protected static Connection conn = null;
	protected static ConnectionManagerUtil connectionManager = null;

	public abstract void beginConnection();

	public Connection getConnection(){
		if(null==conn){
			beginConnection();
		}
		return conn;
	}

	public void releaseConnection(){
	       try {
	        	if(conn!=null){
	        		conn.close();
	        		conn=null;
	        	}
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        }
	}
}
