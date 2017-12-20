using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace Calc.cal.pro
{
    public class ExpressAnalyzer
    {
        public string initialExpress { set; get; }
        public string convertedExpress { set; get; }

        public LinkedList<string> itemList = new LinkedList<string>();

        public ExpressAnalyzer(string initialExpress)
        {
            this.initialExpress = initialExpress;
        }

        public bool accountConvert()
        {
            bool bRtn = false;

            convertedExpress = initialExpress;

            // 科目情報の取得
            MatchCollection mc = Regex.Matches(initialExpress, "@[A-Za-z1-9]+@");

            // マッチした科目情報の数だけループする。
            foreach (Match m in mc)
            {
                // 前後の@を取り除く
                string acountName = m.Value.Replace("@", "");

                // 科目名から金額を取得する。
                decimal accountValue = 123456789m;

                // 取得した金額で計算式を置き換える。
                convertedExpress = convertedExpress.Replace(m.Value, "" + accountValue);

            }

            bRtn = true;
            return bRtn;
        }


    }
}
