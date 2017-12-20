using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestConsoleApplication.EM
{
    public class SearchArrayByLinqSample
    {
        public void searchByQuery()
        {
            // クエリ検索対象の配列
            string[] names = { "Doi", "Tanaka", "Nakamura", "Saitou", "Yamada" };

            // 配列から文字列長が6文字の長さのデータを検索し、辞書順に並べ替え、大文字に変換するLINQ
            IEnumerable<string> query = from s in names where s.Length ==6 orderby s select s.ToUpper();

            // 結果の出力
            Console.WriteLine(string.Join(",", query));
            Console.WriteLine("");
        }

        public void searchByMethod()
        {
            // クエリ検索対象の配列
            string[] names = { "Doi", "Tanaka", "Nakamura", "Saitou", "Yamada" };

            // 配列から文字列長が6文字の長さのデータを検索し、辞書順に並べ替え、大文字に変換するLINQ
            //IEnumerable<string> query = from s in names where s.Length == 6 orderby s select s.ToUpper();
            IEnumerable<string> query = names.Where(x => x.Length==6).OrderBy(x =>x).Select(x => x.ToUpper());

            // 結果の出力
            Console.WriteLine(string.Join(",", query));
            Console.WriteLine("");
        }
    }
}
