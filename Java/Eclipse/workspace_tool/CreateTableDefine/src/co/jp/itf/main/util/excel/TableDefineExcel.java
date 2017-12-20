package co.jp.itf.main.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.jp.itf.main.dto.ColumnDto;
import co.jp.itf.main.dto.IndexDto;
import co.jp.itf.main.dto.TableDto;

public class TableDefineExcel extends ExcelBaseUtil {
	public static void createExcelFile(List<TableDto> tableList,String templatePath,String resultPath){

		XSSFWorkbook	resultExcel		= null;
		XSSFSheet		tableListSheet	= null;
		XSSFSheet		tableDefineSheet	= null;
		XSSFSheet		tableSheet	= null;

		Row currentRow = null;
		int currentRowNo = 1;

		Cell currentCell = null;
		int	currentSheetNo = 1;

		int tableLastSpace=2;
		int tableColumnSpace=3;

		try {

			System.out.println("createExcelFile start");

			// 結果ファイルの作成
			copyFile(new File(templatePath),new File(resultPath));

            resultExcel	= new XSSFWorkbook(new FileInputStream(resultPath));


			/*
			 *  TableListシートの作成
			 */
			tableListSheet = resultExcel.getSheet("TableList");
			currentRowNo = 1;
			for(TableDto tableDto:tableList){
				currentRow = tableListSheet.getRow(currentRowNo);
				if(null==currentRow){
					break;
				}

				currentCell = currentRow.getCell(0);
				if(null==currentCell){
					break;
				}
				currentCell.setCellValue(currentRowNo);

				currentCell = currentRow.getCell(2);
				if(null==currentCell){
					break;
				}
				currentCell.setCellValue(tableDto.getTableName());

				currentCell = currentRow.getCell(3);
				if(null==currentCell){
					break;
				}
				currentCell.setCellValue(tableDto.getComments());

				currentRowNo++;
			}

			/*
			 *  テーブル定義シートの作成
			 */
			tableDefineSheet= resultExcel.getSheet("TableDefine");
			currentSheetNo = 1;
			for(TableDto tableDto:tableList){

				tableSheet = resultExcel.cloneSheet(2);

				if(tableDto.getComments().equals("")){
					resultExcel.setSheetName(currentSheetNo+2,tableDto.getTableName());
				}
				else{
					System.out.println(tableDto.getTableName());
					try{
						resultExcel.setSheetName(currentSheetNo+2,tableDto.getTableName());
					}
					catch(Exception e){
						resultExcel.setSheetName(currentSheetNo+2,tableDto.getTableName());
					}
				}

				// ヘッダー部分の設定
				currentRow = tableSheet.getRow(0);
				currentCell = currentRow.getCell(14);
				currentCell.setCellValue(tableDto.getComments());

				currentRow = tableSheet.getRow(1);
				currentCell = currentRow.getCell(14);
				currentCell.setCellValue(tableDto.getTableName());


				// 明細行を作成するために、空の行をコピーして作成する。
				int srcRowNo=4;
				int createRowNo=-1;
				Row srcRow = tableSheet.getRow(srcRowNo);
				Row newRow = null;

				// カラムの件数＋2件（余白用）だけ空の行を作成する。
				for(int iColumnCount =1;iColumnCount<tableDto.getColumnList().size()+tableLastSpace;iColumnCount++)
				{
					createRowNo=srcRowNo+iColumnCount;

					tableSheet.shiftRows(createRowNo, createRowNo,2);
					newRow = tableSheet.createRow(createRowNo);

					// コピー元のセルがNULLになるまでコピーを続ける。
					for(int i=0;;i++){
						if(null!=srcRow.getCell(i)){
							newRow.createCell(i).setCellValue(srcRow.getCell(i).getStringCellValue());
							newRow.getCell(i).setCellStyle(srcRow.getCell(i).getCellStyle());
						}
						else{
							break;
						}
					}

					// コピー後に対象のセルを結合する。。
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,0,1));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,2,10));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,11,19));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,20,24));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,25,29));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,30,31));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,32,33));
					tableSheet.addMergedRegion(new CellRangeAddress (createRowNo,createRowNo,34,47));

				}


				// 実際のデータを設定していく
				currentRowNo=4;
				int columnNo=1;
				for(ColumnDto columnDto:tableDto.getColumnList()){

					currentRow = tableSheet.getRow(currentRowNo);
					if(null==currentRow){
						break;
					}

					currentCell = currentRow.getCell(0);
					if(null==currentCell){
						break;
					}
					currentCell.setCellValue(columnNo);

					currentCell = currentRow.getCell(2);
					if(null==currentCell){
						break;
					}
					currentCell.setCellValue(columnDto.getComments());

					currentCell = currentRow.getCell(11);
					if(null==currentCell){
						break;
					}
					currentCell.setCellValue(columnDto.getColumnName());

					currentCell = currentRow.getCell(20);
					if(null==currentCell){
						break;
					}
					currentCell.setCellValue(columnDto.getDataType());

					currentCell = currentRow.getCell(25);
					if(null==currentCell){
						break;
					}
					currentCell.setCellValue(columnDto.getDataLength());

					currentCell = currentRow.getCell(30);
					if(null==currentCell){
						break;
					}
					if("P".equals(columnDto.getConstraintType())){
						currentCell.setCellValue(columnDto.getConstraintPosition());
					}

					currentCell = currentRow.getCell(32);
					if(null==currentCell){
						break;
					}
					if(!columnDto.isNullAble()){
						currentCell.setCellValue("○");
					}

					columnNo++;
					currentRowNo++;
				}


				// 索引の確認
				String strIndexCell = "";



				// テーブルの空スペースだけ移動する。。
				currentRowNo+=tableLastSpace;
				currentRowNo+=tableColumnSpace;

				int indexNo=1;
				columnNo=1;
				String lastIndexName="";
				for(IndexDto indexDto:tableDto.getIndexList()){


					currentRow = tableSheet.createRow(currentRowNo);
					currentRow.createCell(0).setCellValue(indexNo);
					currentRow.createCell(11).setCellValue(indexDto.getIndexName());
					currentRow.createCell(20).setCellValue(indexDto.getColumnListCsv());
					currentRow.createCell(25).setCellValue(columnNo);

					tableSheet.addMergedRegion(new CellRangeAddress (currentRowNo,currentRowNo,0,1));
					tableSheet.addMergedRegion(new CellRangeAddress (currentRowNo,currentRowNo,2,10));
					tableSheet.addMergedRegion(new CellRangeAddress (currentRowNo,currentRowNo,11,19));
					tableSheet.addMergedRegion(new CellRangeAddress (currentRowNo,currentRowNo,20,24));
					tableSheet.addMergedRegion(new CellRangeAddress (currentRowNo,currentRowNo,25,29));
					tableSheet.addMergedRegion(new CellRangeAddress (currentRowNo,currentRowNo,30,47));

					if(lastIndexName.equals(indexDto.getIndexName()))
					{
						columnNo++;
					}
					else{
						lastIndexName = indexDto.getIndexName();
						columnNo=1;
					}

					indexNo++;
					currentRowNo++;



				}

				currentSheetNo++;
				System.out.println("シート　番号："+currentSheetNo);
			}

			resultExcel.write(new FileOutputStream(resultPath));


			resultExcel.close();

			System.out.println("createExcelFile end");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
