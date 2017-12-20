package co.jp.itf.main.util.db.posgre;

import java.sql.DriverManager;

import co.jp.itf.main.util.db.ConnectionManagerUtil;

public class ConnectionManagerUtilForPostgre extends ConnectionManagerUtil{

	/*
	// ユーザ名 （ローカルaoe)
	private static final String USER = "eccube_db_user";
	//  パスワード
	private static final String PASS = "mam6mck3";
	// サーバ名
	private static final String SERVER_IP = "127.0.0.1";
	// SID
	private static final String SID = "store03_db";
	*/

	/*
	// 開発環境（ささげ）
	// ユーザ名
    private static final String USER = "sasage";
	//  パスワード
    private static final String PASS = "itf2013";
	//  サーバ名
    private static final String SERVER_IP = "192.168.11.91";
	//  SID
    private static final String SID = "sasage-aoyama";
	*/

	/*
	// ユーザ名 （ローカルaoe)
	private static final String USER = "eccube_db_user";
	//  パスワード
	private static final String PASS = "mam6mck3";
	// サーバ名
	private static final String SERVER_IP = "127.0.0.1";
	// SID
	private static final String SID = "store03_db";
	*/

	// ユーザ名 （P環境)
	private static final String USER = "adempiere";
	//  パスワード
	private static final String PASS = "nouvelle";
	// サーバ名
	private static final String SERVER_IP = "localhost";
	// SID
	private static final String SID = "idempiere";


    @Override
	public void beginConnection(){

        try {

        	if(conn!=null){
        		releaseConnection();
        	}

            // JDBCドライバの登録
            String driver = "org.postgresql.Driver";
            // データベースの指定
            String server   = SERVER_IP;   // PostgreSQL サーバ ( IP または ホスト名 )
            String dbname   = SID;         // データベース名
            String url = "jdbc:postgresql://" + server + "/" + dbname;
            String user     = USER;         //データベース作成ユーザ名
            String password = PASS;     //データベース作成ユーザパスワード
            Class.forName (driver);
            // データベースとの接続
            conn = DriverManager.getConnection(url, user, password);
            // テーブル照会実行



        }
        catch(Exception e){
        	e.printStackTrace();
        }
	}


}
