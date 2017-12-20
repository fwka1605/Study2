package co.jp.itf.main.util.db;

import java.util.List;

import co.jp.itf.main.dto.ColumnDto;
import co.jp.itf.main.dto.TableDto;

public abstract class TableDefineUtil {

	protected abstract void createTableData(List<TableDto> tableList);

	protected abstract void getTableList(List<TableDto> tableList);

	protected abstract void getColumnList(TableDto tableDto);

	protected abstract void getConstraints(ColumnDto columnDto,String tableName,String columnName);

	protected abstract void getIndexList(TableDto tableDto);

}
