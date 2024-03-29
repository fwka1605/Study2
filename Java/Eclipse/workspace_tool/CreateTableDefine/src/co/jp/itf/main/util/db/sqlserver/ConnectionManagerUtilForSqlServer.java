package co.jp.itf.main.util.db.sqlserver;

import java.sql.Driver;
import java.util.Properties;

import co.jp.itf.main.util.db.ConnectionManagerUtil;

public class ConnectionManagerUtilForSqlServer extends ConnectionManagerUtil{

    /* ユーザ名 */
    private static final String USER = "sa";
    /* パスワード */
    private static final String PASS = "nouvelle";
    /* サーバ名 */
    private static final String SERVER_IP = "192.168.0.66";
    /* SID */
    private static final String SID = "navio_app";

	@Override
	public void beginConnection(){

        try {

        	if(conn!=null){
        		releaseConnection();
        	}

        	Driver d = (Driver) Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

        	String connUrl = "jdbc:sqlserver://" + SERVER_IP + ";database=" + SID + ";" + "user=" + USER + ";" + "password=" + PASS + ";";
        	conn = d.connect(connUrl, new Properties());


        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}



}
