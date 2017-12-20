using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.EntityClient;
using System.Data;
using System.Data.Objects;
using System.Data.Common;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            DeleateAll();
            CreateData();

            QueryByLinq();
            ;
        }

        private static void DeleateAll()
        {
            using (var container = new AddressBookContainer()) //1. オブジェクトコンテキストの生成
            {
                container.ExecuteStoreCommand("DELETE from EntryCategory;"); //2. ネイティブSQLによるデータの削除
                container.ExecuteStoreCommand("DELETE from Entries;");
                container.ExecuteStoreCommand("DELETE from Categories;");
            }
        }

        private static void QueryByLinq()
        {
            using (var container = new AddressBookContainer()) //1. オブジェクトコンテキストの生成
            {
                string name = "Doi";
                var entries = from entry in container.Entries where entry.Name == name select entry ; //2. LINQ to Entitiesでクエリを実行
                PrintEntries(entries); //3. クエリ結果を表示する
            }
        }

        private static void PrintEntries(IQueryable<Entry> entries)
        {
            foreach (var entry in entries)
            {
                Console.WriteLine(string.Format("{0} {1}歳 電話番号:{2}", entry.Name, entry.Age, entry.Address.TelNo));
                foreach (var cat in entry.Categories)
                {
                    Console.WriteLine(string.Format(" カテゴリ名:{0}", cat.CategoryName));
                }
            }
        }
        
        private static void CreateData()
        {
            using (var container = new AddressBookContainer())
            {
                var entry1 = new Entry()
                {
                    Name = "Doi",
                    Age = 30,
                    Address = new AddressType() { TelNo = "03-0000-0000", MailAddress = "doi@hogehoge.com" }
                };
                var entry2 = new Entry()
                {
                    Name = "Tanaka",
                    Age = 20,
                    Address = new AddressType() { TelNo = "043-000-0000", MailAddress = "tanaka@hoge.com" }
                };

                var category1 = new Category()
                {
                    CategoryName = "友達"
                };
                var category2 = new Category()
                {
                    CategoryName = "仕事"
                };
                var category3 = new Category()
                {
                    CategoryName = "頻繁に連絡"
                };

                entry1.Categories.Add(category1);
                entry1.Categories.Add(category3);
                entry2.Categories.Add(category2);
                entry2.Categories.Add(category3);

                container.AddObject("Entries", entry1);
                container.AddObject("Entries", entry2);
                container.SaveChanges();
            }
        }
    }
}
