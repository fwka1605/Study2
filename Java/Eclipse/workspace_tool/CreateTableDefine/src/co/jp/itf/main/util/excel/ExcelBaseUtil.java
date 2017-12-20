package co.jp.itf.main.util.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelBaseUtil {



    /**
     * ファイルをコピーします。
     * @param file コピー元ファイル
     * @param newFileName コピー先ファイル名
     */
	public static void copyFile(File file, File newFileName) {

        FileChannel ifc = null;
        FileChannel ofc = null;
        try {
            // 入力元ファイルのストリームからチャネルを取得
            FileInputStream fis = new FileInputStream(file);
            ifc = fis.getChannel();

            // 出力先ファイルのチャネルを取得
            FileOutputStream fos = new FileOutputStream(newFileName);
            ofc = fos.getChannel();

            // バイトを転送します。
            ifc.transferTo(0, ifc.size(), ofc);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ifc != null) {
                try {
                    // 入力チャネルを close します。
                    ifc.close();
                } catch (IOException e) {
                }
            }
            if (ofc != null) {
                try {
                    // 出力チャネルを close します。
                    ofc.close();
                } catch (IOException e) {
                }
            }
        }
    }

	public static String getCellValueToString(Cell cell){

		String rtn="";
		switch(cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			rtn = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				rtn = "" + cell.getDateCellValue();
			} else {
				rtn = "" + cell.getNumericCellValue();
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			rtn = "" + cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_FORMULA:
			rtn = "" + cell.getCellFormula();
			break;
		case Cell.CELL_TYPE_ERROR :
			rtn = "" + cell.getErrorCellValue();
			break;
		case Cell.CELL_TYPE_BLANK  :
			rtn="";
			break;
		}
		return rtn;
	}


}
