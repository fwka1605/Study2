package co.jp.itf.main;

import java.util.LinkedList;
import java.util.List;

import co.jp.itf.main.dto.TableDto;
import co.jp.itf.main.util.db.posgre.TableDefineUtilForPostgre;
import co.jp.itf.main.util.excel.TableDefineExcel;

public class MainForPostgre {

	private static List<TableDto> tableList = new LinkedList<TableDto>();

	public static void main(String[] args) {
		System.out.println("main start");

		TableDefineUtilForPostgre.createTableData(tableList);
		TableDefineExcel.createExcelFile(tableList,"C:\\table.xlsx","C:\\table_postgre.xlsx");

		System.out.println("main end");

	}














}
