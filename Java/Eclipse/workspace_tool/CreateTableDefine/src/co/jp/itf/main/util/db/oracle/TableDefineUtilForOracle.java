package co.jp.itf.main.util.db.oracle;

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

public class TableDefineUtilForOracle {

	private static ConnectionManagerUtil connectionManagerUtil = null;

	public static void createTableData(List<TableDto> tableList) {

		try{

			connectionManagerUtil = ConnectionController.getConnectionManager(ConnectionController.DB_TYPE_ORACLE);
			connectionManagerUtil.beginConnection();

			System.out.println("createTableData start");

			// テーブルリストの取得
			getTableList(tableList);

			for (TableDto tableDto : tableList) {
				getColumnList(tableDto);
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
					"	select						" + "\n" +
					"		table_name	,			" + "\n" +
					"		COMMENTS				" + "\n" +
					"	from 						" + "\n" +
					"		user_tab_comments 		" + "\n" +
					"	where 						" + "\n" +
//					"		table_name in ('TGOODSDTL','TGOODSDTLDEPL','TGOODSLINK','TGOODSLINKDEPL','TGOODSMBIMG','TGOODSMBIMGDEPL','TGOODSOPT','TGOODSOPTDEPL','TGOODSOPTITM','TGOODSORT','TGOODSSEARCH')" + "\n" +
					"		table_name in ('TZIPCODE')" + "\n" +
					"	order by 					" + "\n" +
					"		table_name";

			System.out.println(sql);

			rs = stmt.executeQuery(sql);



			/* 取得したデータを表示します。 */
			TableDto dtoTmp = null;
			String	strTmp = null;
			while (rs.next()) {
				dtoTmp = new TableDto();
				dtoTmp.setTableName(rs.getString("TABLE_NAME"));

				String comments = rs.getString("COMMENTS");
				dtoTmp.setComments("");

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
			"	select							"	+ "\n" +
			"		column_name,				"	+ "\n" +
			"		data_type,data_length,		"	+ "\n" +
			"		data_precision,				"	+ "\n" +
			"		data_scale,nullable 		"	+ "\n" +
			"	from							"	+ "\n" +
			"		user_tab_columns 			"	+ "\n" +
			"	where 							"	+ "\n" +
			"		table_name=?"				;
			preStm = connectionManagerUtil.getConnection().prepareStatement(sql);
			preStm.setString(1, tableDto.getTableName());
			rs = preStm.executeQuery();

			/* 取得したデータを表示します。 */
			String	strTmp = null;
			ColumnDto dtoTmp = null;
			int tablePosition = 1;
			while (rs.next()) {

				dtoTmp = new ColumnDto();

				dtoTmp.setTablePosition(tablePosition);

				dtoTmp.setColumnName(rs.getString("column_name"));
				dtoTmp.setDataType(rs.getString("data_type"));

				if("NUMBER".equals(dtoTmp.getDataType())){
					dtoTmp.setDataLength(rs.getInt("data_precision"));
				}
				else{
					dtoTmp.setDataLength(rs.getInt("data_length"));
				}

				if("N".equals(rs.getString("nullable"))){
					dtoTmp.setNullAble(false);
				}
				else{
					dtoTmp.setNullAble(true);
				}

				getColumnAttributes(dtoTmp, tableDto.getTableName(), dtoTmp.getColumnName());
				tableDto.getColumnList().add(dtoTmp);

				tablePosition++;
			}

			// データベースのクローズ
			rs.close();
			preStm.close();

		} catch (Exception e) {
			e.printStackTrace ();
		}
	}

	private static void getColumnAttributes(ColumnDto columnDto,String tableName,String columnName){

		Connection conn = null;
		PreparedStatement preStm = null;
		ResultSet rs = null;

		try {

			/* Statementの作成 */
			String sql =
					"select "+
					"	const.constraint_type	constraint_type,			" + "\n" +
					"	const_col.position 		position,					" + "\n" +
					"	comme.comments		comments					" + "\n" +
					"from													" + "\n" +
					"	user_constraints	const,							" + "\n" +
					"	user_cons_columns	const_col,						" + "\n" +
					"	user_col_comments	comme							" + "\n" +
					"where 													" + "\n" +
					"		const.table_name = const_col.table_name 		" + "\n" +
					"	and const.constraint_type <> 'C'					" + "\n" +
					"	and const_col.position is not null					" + "\n" +
					"	and	const.table_name		= comme.table_name 		" + "\n" +
					"	and	const_col.column_name	= comme.column_name 	" + "\n" +
					"	and	const.table_name = ? 							" + "\n" +
					"	and	const_col.column_name = ? ";

			//System.out.println(sql);
			preStm = connectionManagerUtil.getConnection().prepareStatement(sql	);

			preStm.setString(1, tableName);
			preStm.setString(2, columnName);

			rs = preStm.executeQuery();

			/* 取得したデータを表示します。 */
			if (rs.next()) {

				columnDto.setConstraintType(rs.getString("constraint_type"));
				columnDto.setConstraintPosition(rs.getInt("position"));
				columnDto.setComments("");

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

			/* Statementの作成 */
			preStm = connectionManagerUtil.getConnection().prepareStatement(
					"	select	"+
					"		index_name,table_name"+
					"	from "+
					"		user_indexes"+
					"	where "+
					"		table_name=?");
			preStm.setString(1, tableDto.getTableName());
			rs = preStm.executeQuery();


			/* 取得したデータを表示します。 */
			IndexDto 	indexDtoTmp		= null;
			while (rs.next()) {
				indexDtoTmp = new IndexDto();

				indexDtoTmp.setIndexName(rs.getString("index_name"));
				indexDtoTmp.setTableName(rs.getString("table_name"));
				tableDto.getIndexList().add(indexDtoTmp);
			}

			// データベースのクローズ
			rs.close();
			preStm.close();

			for(IndexDto dtoTmp:tableDto.getIndexList()){
				/* Statementの作成 */
				preStm = connectionManagerUtil.getConnection().prepareStatement(
						"	select	"+
						"		index_name,table_name,column_name,column_position"+
						"	from "+
						"		user_ind_columns"+
						"	where "+
						"		table_name=? and index_name=?");
				preStm.setString(1, dtoTmp.getTableName());
				preStm.setString(2, dtoTmp.getIndexName());

				rs = preStm.executeQuery();

				/* 取得したデータを表示します。 */
				ColumnDto	columnDtoTmp 	= null;
				while (rs.next()) {
					columnDtoTmp = new ColumnDto();

					columnDtoTmp.setColumnName(rs.getString("column_name"));
					columnDtoTmp.setIndexPosition(rs.getInt("column_position"));
					dtoTmp.getColumnList().add(columnDtoTmp);
				}
				// データベースのクローズ
				rs.close();
				preStm.close();
			}


		} catch (Exception e) {
			e.printStackTrace ();
		}
	}
}
