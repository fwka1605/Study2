using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExcelControl
{
    class Program
    {
        static void Main(string[] args)
        {

            string excelFile = "C:\\Users\\NVLCLT13\\Desktop\\OBICマスタリスト追加2\\SEIKYUSYO\\20160131FC請求書.xlsx";
            ExcelController excelController = new ExcelController();

            excelController.checkExcelFile(excelFile);

            excelController.excel_OutPutEx(excelFile);

        }
    }
}
