using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EDMStudy1.jp.co.nouvelle.db
{
    public class SelectEDM
    {
        public static void QueryByLinq()
        {
            //  オブジェクト・コンテキストの生成
            using (var container = new AddressBookContainer())
            {
                string name = "Doi";

                //  LINQ to Entitiesでクエリを実行
                var entries = container.Entries.Where(entry=>entry.Name==name).Select(entry => entry);

                /*
                var entries = from entry in container.Entries
                              where entry.Name == name
                              select entry;
                */

                //  クエリ結果を表示する
                PrintEntries(entries);


            }
        }

        public static void PrintEntries(IQueryable<Entry> entries)
        {
            //  取得したエントリを順に表示する
            foreach (var entry in entries)
            {
                Console.WriteLine(string.Format(
                  "{0} {1}歳 電話番号:{2}",
                  entry.Name, entry.Age, entry.TelNo));


                //  エントリに関連付けられたカテゴリも表示する
                foreach (var cat in entry.Categories)
                {
                    Console.WriteLine(string.Format(
                      " カテゴリ名:{0}", cat.CategoryName));
                }
            }
        }
    }
}
