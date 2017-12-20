using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EDMStudy1.jp.co.nouvelle.db
{
    public class InsertEDM
    {

        public static void addCategory(string categoryName, string detail)
        {
            // ① オブジェクト・コンテキストを作成する。
            var container = new AddressBookContainer();

            // ②Entryオブジェクト作成する
            var category = new Category()
            {
                CategoryName = categoryName,
                Detail = detail
            };

            // ③Entryエンティティの集合オブジェクトに作成したエンティティを追加する。
            container.Categories.Add(category);
            //            container.AddToEntries(entry);

            // ④作成したエンティティをDBに保存する。
            container.SaveChanges();

            // ⑤LINQ to Entitiesを使って、Entryエンティティを全て取得する。
            var categories = from e in container.Categories select e;

            // ⑥取得したエンティティを表示する。
            foreach (var e in categories)
            {
                Console.WriteLine(string.Format("{0} {1}", e.CategoryName, e.Detail));
            }
        }

        public static void addEntry(string name, string mailAddress, string telNo, short age)
        {
            // ① オブジェクト・コンテキストを作成する。
            var container = new AddressBookContainer();

            // ②Entryオブジェクト作成する
            var entry = new Entry()
            {
                Name = name,
                MailAddress = mailAddress,
                TelNo = telNo,
                Age = age
            };

            // ③Entryエンティティの集合オブジェクトに作成したエンティティを追加する。
            container.Entries.Add(entry);
            //            container.AddToEntries(entry);

            // ④作成したエンティティをDBに保存する。
            container.SaveChanges();

            // ⑤LINQ to Entitiesを使って、Entryエンティティを全て取得する。
            var entries = from e in container.Entries select e;

            // ⑥取得したエンティティを表示する。
            foreach (var e in entries)
            {
                Console.WriteLine(string.Format("{0} {1}歳 電話番号:{2}", e.Name, e.Age, e.TelNo));
            }
        }
    }
}
