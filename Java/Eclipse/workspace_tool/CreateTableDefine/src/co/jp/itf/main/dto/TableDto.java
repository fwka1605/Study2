package co.jp.itf.main.dto;

import java.util.LinkedList;
import java.util.List;

public class TableDto {
	private String tableName = "";
	private String comments	= "";

	private List<ColumnDto> columnList = null;

	private List<IndexDto> indexList = null;

	public TableDto(){
		columnList = new LinkedList<ColumnDto>();
		indexList = new LinkedList<IndexDto>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public List<ColumnDto> getColumnList() {
		return columnList;
	}

	public List<IndexDto> getIndexList() {
		return indexList;
	}

	public ColumnDto getColumnDtoByPosition(int tablePosition){
		ColumnDto rtn = null;
		for(ColumnDto columnDto:columnList){
			if(tablePosition==columnDto.getTablePosition()){
				rtn = columnDto;
				break;
			}
		}
		return rtn;
	}

	public String toString(){
		String strRtn="";

		for (ColumnDto columnDto : getColumnList()) {
			strRtn =	strRtn +getTableName()+"," +
						columnDto.getColumnName()+"," +
						columnDto.getTablePosition()+","+
						columnDto.getDataType()+"," +
						columnDto.getDataLength()+"," +
						columnDto.isNullAble()+"," +
						columnDto.getConstraintType()+"," +
						columnDto.getConstraintPosition()+"\n";
		}

		return strRtn;
	}

}
