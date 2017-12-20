package co.jp.itf.main;

import java.util.LinkedList;
import java.util.List;

import co.jp.itf.main.dto.TableDto;
import co.jp.itf.main.util.db.oracle.TableDefineUtilForOracle;
import co.jp.itf.main.util.excel.TableDefineExcel;

public class MainForOracle {

	private static List<TableDto> tableList = new LinkedList<TableDto>();

	public static void main(String[] args) {
		System.out.println("main start");

		TableDefineUtilForOracle.createTableData(tableList);
		TableDefineExcel.createExcelFile(tableList,"E:\\table.xlsx","E:\\table_oracle.xlsx");

		System.out.println("main end");

	}














}
