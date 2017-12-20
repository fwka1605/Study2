package co.jp.itf.main.util.db.oracle;

import oracle.jdbc.pool.OracleDataSource;
import co.jp.itf.main.util.db.ConnectionManagerUtil;

public class ConnectionManagerUtilForOracle extends ConnectionManagerUtil{

    /* ユーザ名 */
    private static final String USER = "tscuser";
    /* パスワード */
    private static final String PASS = "itf2013";
    /* サーバ名 */
    private static final String SERVER_IP = "192.168.11.91";
    /* SID */
    private static final String SID = "tscuser";

	@Override
	public void beginConnection(){

        try {

        	if(conn!=null){
        		releaseConnection();
        	}

//    		/* ドライバクラスのロード */
//    		Class.forName ("oracle.jdbc.driver.OracleDriver");
//
//    		/* Connectionの作成 */
//    		conn = DriverManager.getConnection
//    		("jdbc:oracle:thin:@" + SERVER_IP + ":1521:" + SID,USER,PASS);

    	    OracleDataSource ods = new OracleDataSource();

    	    String string = "jdbc:oracle:thin:"+ USER + "/" + PASS + "@" + SERVER_IP + ":1521:" + SID;
			ods.setURL(string);
    	    conn = ods.getConnection();

        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}



}
