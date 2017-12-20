package co.jp.itf.main.util.db.posgre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import co.jp.itf.main.dto.ColumnDto;
import co.jp.itf.main.dto.IndexDto;
import co.jp.itf.main.dto.TableDto;
import co.jp.itf.main.util.db.ConnectionController;
import co.jp.itf.main.util.db.ConnectionManagerUtil;

public class TableDefineUtilForPostgre {

	private static ConnectionManagerUtil connectionManagerUtil = null;


	public static void createTableData(List<TableDto> tableList) {

		try{

			connectionManagerUtil = ConnectionController.getConnectionManager(ConnectionController.DB_TYPE_POSGRE);
			connectionManagerUtil.beginConnection();

			System.out.println("createTableData start");

			// テーブルリストの取得
			getTableList(tableList);

			// テーブルリスト分ループして、列、列コメント、制約、索引情報を取得する。
			for (TableDto tableDto : tableList) {
				getColumnList(tableDto);
				getColumnCommentList(tableDto);
				getConstraints(tableDto);
				getIndexList(tableDto);

			}

			connectionManagerUtil.releaseConnection();

			System.out.println("createTableData end");

		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	private static void getTableList(List<TableDto> tableList){
		Statement stmt = null;
		ResultSet rs = null;
		try {

			/* Statementの作成 */
			stmt = connectionManagerUtil.getConnection().createStatement();

			/* Resultsetの作成 */
			String sql =

					"	select										" + "\n" +
					"		tablename								" + "\n" +
					"		,COALESCE(description,'')	description	" + "\n" +
					"		,COALESCE(objsubid,0)		objsubid	" + "\n" +
					"	from										" + "\n" +
					"		pg_tables	tables						" + "\n" +
					"		,pg_class	classes 					" + "\n" +
					"			left outer join (					" + "\n" +
					"					select						" + "\n" +
					"						*						" + "\n" +
					"					from						" + "\n" +
					"						pg_description			" + "\n" +
					"					where						" + "\n" +
					"						objsubid=0				" + "\n" +
					"			)	descriptions					" + "\n" +
					"			on	classes.oid=descriptions.objoid	" + "\n" +
					"	where										" + "\n" +
					"			tables.tablename=classes.relname	" + "\n" +
//					"		and ( tablename like 'rakuten_products%')      " + "\n" + // or tablename like 'dtb_information%')			" + "\n" +
					"	order by									" + "\n" +
					"		tablename								" + "\n" +
					"	limit 										" + "\n" +
					"		1										" + "\n";


			System.out.println(sql);
			System.out.println("-----------------------");

			rs = stmt.executeQuery(sql);

			/* 取得したデータを表示します。 */
			TableDto dtoTmp = null;
			String	strTmp = null;
			while (rs.next()) {
				dtoTmp = new TableDto();
				dtoTmp.setTableName(rs.getString("TABLENAME"));
				dtoTmp.setComments(rs.getString("description"));
				tableList.add(dtoTmp);
			}

			// データベースのクローズ
			rs.close();
			stmt.close();


		} catch (Exception e) {
			tableList = null;
			e.printStackTrace ();
		}

	}

	private static void getColumnList(TableDto tableDto){

		PreparedStatement preStm = null;
		ResultSet rs = null;


		try {

			/* Statementの作成 */

			String sql =
					"	select				" + "\n" +
							"		at.attname		attname,	" + "\n" +
							"		at.attnum		attnum,	" + "\n" +
							"		ty.typname		typname,	" + "\n" +
							"		at.attlen		attlen,		" + "\n" +
							"		at.atttypmod	atttypmod,	" + "\n" +
							"		at.attnotnull	attnotnull	" + "\n" +
							"	from							" + "\n" +
							"		pg_attribute	at,			" + "\n" +
							"		pg_type			ty			" + "\n" +
							"	where							" + "\n" +
							"			at.atttypid = ty.oid	" + "\n" +
							"		and	at.attnum > 0			" + "\n" +
							"		and	at.attrelid = (			" + "\n" +
							"					select 			" + "\n" +
							"						oid	" + "\n" +
							"					from			" + "\n" +
							"						pg_class	" + "\n" +
							"					where			" + "\n" +
							"						relname = ?	" + "\n" +
							"				)					" + "\n" +
							"	order by						" + "\n" +
							"		at.attnum					";

			preStm = connectionManagerUtil.getConnection().prepareStatement(sql);

			preStm.setString(1, tableDto.getTableName());

			System.out.println(sql);
			System.out.println("-----------------------");

			rs = preStm.executeQuery();

			/* 取得したデータを表示します。 */
			String	strTmp = null;
			ColumnDto dtoTmp = null;
			while (rs.next()) {
				dtoTmp = new ColumnDto();

				dtoTmp.setColumnName(rs.getString("attname"));
				dtoTmp.setTablePosition(rs.getInt("attnum"));

				dtoTmp.setDataType(rs.getString("typname"));

				dtoTmp.setDataLength(rs.getInt("attlen"));
				if(dtoTmp.getDataLength()<0){
					if(dtoTmp.getDataType().equals("text")){
						dtoTmp.setDataLength(0);
					}
					else{
						dtoTmp.setDataLength(rs.getInt("atttypmod"));
					}
				}

				dtoTmp.setNullAble(!rs.getBoolean("attnotnull"));

				tableDto.getColumnList().add(dtoTmp);
			}

			// データベースのクローズ
			rs.close();
			preStm.close();

		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
	private static void getColumnCommentList(TableDto tableDto){

		PreparedStatement preStm = null;
		ResultSet rs = null;


		try {

			/* Statementの作成 */

			String sql =
					"	select 										" + "\n" +
					"		description.objsubid	objsubid,		" + "\n" +
					"		description.description	description		" + "\n" +
					"	from										" + "\n" +
					"		pg_description description,				" + "\n" +
					"		pg_class class							" + "\n" +
					"	where										" + "\n" +
					"	    	description.objoid=class.oid		" + "\n" +
					"		and description.objsubid > 0			" + "\n" +
					"		and class.relname = ?					" + "\n" +
					"	order by									" + "\n" +
					"		objsubid								";

			preStm = connectionManagerUtil.getConnection().prepareStatement(sql);

			preStm.setString(1, tableDto.getTableName());

			System.out.println(sql);
			System.out.println("-----------------------");

			rs = preStm.executeQuery();

			/* 取得したデータを表示します。 */
			int		tablePosition = 0;
			ColumnDto dtoTmp = null;
			while (rs.next()) {
				tablePosition = rs.getInt("objsubid");
				dtoTmp = tableDto.getColumnDtoByPosition(tablePosition);

				dtoTmp.setComments(rs.getString("description"));
			}

			// データベースのクローズ
			rs.close();
			preStm.close();

		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	private static void getConstraints(TableDto tableDto){

		Connection conn = null;
		PreparedStatement preStm = null;
		ResultSet rs = null;

		try {

			String sql =
					"	select						" + "\n" +
					"		conname,				" + "\n" +
					"		upper(contype)	contype," + "\n" +
					"		conkey[1]	conkey1,	" + "\n" +
					"		conkey[2]	conkey2,	" + "\n" +
					"		conkey[3]	conkey3,	" + "\n" +
					"		conkey[4]	conkey4,	" + "\n" +
					"		conkey[5]	conkey5,	" + "\n" +
					"		conkey[6]	conkey6,	" + "\n" +
					"		conkey[7]	conkey7,	" + "\n" +
					"		conkey[8]	conkey8,	" + "\n" +
					"		conkey[9]	conkey9,	" + "\n" +
					"		conkey[10]	conkey10	" + "\n" +
					"	from						" + "\n" +
					"		pg_constraint			" + "\n" +
					"	where						" + "\n" +
					"			conrelid in (			" + "\n" +
					"				select				" + "\n" +
					"					oid				" + "\n" +
					"				from				" + "\n" +
					"					pg_class		" + "\n" +
					"				where				" + "\n" +
					"					relname = ?		" + "\n" +
					"			)						" + "\n" +
					"		and contype='p'				";

			/* Statementの作成 */
			preStm = connectionManagerUtil.getConnection().prepareStatement(sql);

			preStm.setString(1, tableDto.getTableName());

			System.out.println(sql);
			System.out.println("-----------------------");

			rs = preStm.executeQuery();

			/* 取得したデータを表示します。 */

			if (rs.next()) {

				String tmpKye	= "";
				String tmpConname = rs.getString("conname");
				int		tmpConstraintPosition = 0;

				for(int i=1;i<=10;i++){
					tmpKye = "conkey" + i;
					tmpConstraintPosition = rs.getInt(tmpKye);
					if(tmpConstraintPosition==0){
						break;
					}
					String tmp = rs.getString("contype");
					tableDto.getColumnDtoByPosition(tmpConstraintPosition).setConstraintPosition(tmpConstraintPosition);
					tableDto.getColumnDtoByPosition(tmpConstraintPosition).setConstraintType(rs.getString("contype"));
				}

			}

			// データベースのクローズ
			rs.close();
			preStm.close();


		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	private static void getIndexList(TableDto tableDto){

		PreparedStatement preStm = null;
		ResultSet rs = null;


		try {

			String sql =
					"select						" + "\n" +
					"	cla.relname	relname,	" + "\n" +
					"	indnatts	indnatts	" + "\n" +
					"from						" + "\n" +
					"	pg_index ind,			" + "\n" +
					"	pg_class cla			" + "\n" +
					"where						" + "\n" +
					"		indrelid in (		" + "\n" +
					"			select			" + "\n" +
					"				oid			" + "\n" +
					"			from			" + "\n" +
					"				pg_class	" + "\n" +
					"			where			" + "\n" +
					"				relname = ?	" + "\n" +
					"		)					" + "\n" +
					"	and ind.indexrelid=cla.oid	";

			/* Statementの作成 */
			preStm = connectionManagerUtil.getConnection().prepareStatement(sql);
			preStm.setString(1, tableDto.getTableName());

			System.out.println(sql);
			System.out.println("-----------------------");

			rs = preStm.executeQuery();


			/* 取得したデータを表示します。 */
			IndexDto 	indexDtoTmp		= null;
			ColumnDto	columnDtoTmp	= null;
			int counter = 1;

			String preIndexName = "";
			String currentIndexName = "";
			while (rs.next()) {

				currentIndexName = rs.getString("relname");

				if(!currentIndexName.equals(preIndexName)){
					indexDtoTmp = new IndexDto();
					indexDtoTmp.setIndexName(rs.getString("relname"));
					indexDtoTmp.setTableName(tableDto.getTableName());

					tableDto.getIndexList().add(indexDtoTmp);
				}

				columnDtoTmp = tableDto.getColumnDtoByPosition(rs.getInt("indnatts"));

				columnDtoTmp = columnDtoTmp.deepCopy();

				columnDtoTmp.setIndexPosition(counter);
				indexDtoTmp.getColumnList().add(columnDtoTmp);
				counter++;

				preIndexName = currentIndexName;
			}




		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
}
