package co.jp.itf.main.dto;

public class ColumnDto {
	private int	tablePosition;
	private String columnName = "";
	private String comments = "";
	private String dataType = "";
	private int dataLength;
	private Boolean nullAble = false;
	private String constraintType = "";
	private int constraintPosition;
	private int indexPosition;


	public ColumnDto deepCopy(){
		ColumnDto columnDto = new ColumnDto();
		columnDto.setTablePosition(this.tablePosition);
		columnDto.setColumnName(this.columnName);
		columnDto.setComments(this.comments);
		columnDto.setDataType(this.dataType);
		columnDto.setDataLength(this.dataLength);
		columnDto.setNullAble(this.nullAble);
		columnDto.setConstraintType(this.constraintType);
		columnDto.setConstraintPosition(this.constraintPosition);
		columnDto.setIndexPosition(this.indexPosition);

		return columnDto;
	}

	public int getTablePosition() {
		return tablePosition;
	}
	public void setTablePosition(int tablePosition) {
		this.tablePosition = tablePosition;
	}

	public String getConstraintType() {
		return constraintType;
	}
	public void setConstraintType(String constraintType) {
		this.constraintType = constraintType;
	}
	public int getConstraintPosition() {
		return constraintPosition;
	}
	public void setConstraintPosition(int constraintPosition) {
		this.constraintPosition = constraintPosition;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}

	public Boolean isNullAble() {
		return nullAble;
	}
	public void setNullAble(Boolean nullAble) {
		this.nullAble = nullAble;
	}

	public int getIndexPosition() {
		return indexPosition;
	}
	public void setIndexPosition(int indexPosition) {
		this.indexPosition = indexPosition;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
