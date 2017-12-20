package co.jp.itf.main.dto;

import java.util.LinkedList;
import java.util.List;

public class IndexDto {
	public	String	tableName	= "";
	public	String	indexName	= "";

	private List<ColumnDto> columnList = null;

	public IndexDto(){
		columnList = new LinkedList<ColumnDto>();
	}

	public List<ColumnDto> getColumnList() {
		return columnList;
	}

	public String getColumnListCsv(){
		String strRtn = "";

		for(ColumnDto columnDto:columnList){
			strRtn = strRtn + columnDto.getColumnName() + ",";
		}

		if(strRtn.length()>0){
			strRtn = strRtn.substring(0, strRtn.length()-1);
		}

		return strRtn;
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}



}
