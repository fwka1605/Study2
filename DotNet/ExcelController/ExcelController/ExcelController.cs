using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

using Excel = Microsoft.Office.Interop.Excel;
using System.Runtime.InteropServices;

namespace ExcelControl
{
    public class ExcelController
    {
        public int checkExcelFile(string excelFile)
        {
            return 0;
        }

        public void excel_OutPutEx(String excelFile)
        {
            //Excelオブジェクトの初期化
            Excel.Application ExcelApp = null;
            Excel.Workbooks wbs = null;
            Excel.Workbook wb = null;
            Excel.Sheets shs = null;
            Excel.Worksheet ws = null;

            try
            {
                //Excelシートのインスタンスを作る
                ExcelApp = new Excel.Application();
                wbs = ExcelApp.Workbooks;
                wb = wbs.Add();

                shs = wb.Sheets;
                ws = shs[1];
                ws.Select(Type.Missing);

                ExcelApp.Visible = false;

                // エクセルファイルにデータをセットする
                for ( int i = 1; i < 10; i++ )
                {
                    // Excelのcell指定
                    Excel.Range w_rgn = ws.Cells;
                    Excel.Range rgn = w_rgn[i, 1];

                    try
                    {
                        // Excelにデータをセット
                        rgn.Value2 = "hoge";
                    }
                    finally
                    {
                        // Excelのオブジェクトはループごとに開放する
                        Marshal.ReleaseComObject(w_rgn);
                        Marshal.ReleaseComObject(rgn);
                        w_rgn = null;
                        rgn = null;
                    }
                }

                //excelファイルの保存
                wb.SaveAs(excelFile);
                wb.Close(false);
                ExcelApp.Quit();
            }
            finally
            { 
                //Excelのオブジェクトを開放し忘れているとプロセスが落ちないため注意
                Marshal.ReleaseComObject(ws);
                Marshal.ReleaseComObject(shs);
                Marshal.ReleaseComObject(wb);
                Marshal.ReleaseComObject(wbs);
                Marshal.ReleaseComObject(ExcelApp);
                ws = null;
                shs = null;
                wb = null;
                wbs = null;
                ExcelApp = null;

                GC.Collect();
            }
        }
    }
}
