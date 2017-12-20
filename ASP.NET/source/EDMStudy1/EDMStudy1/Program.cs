using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Objects;

using EDMStudy1.jp.co.nouvelle.db;

namespace EDMStudy1
{
    class Program
    {
        static void Main(string[] args)
        {
            addData();
            SelectEDM.QueryByLinq();

            int i = 1;
        }

        public static void addData()
        {
            using (var container = new AddressBookContainer())
            {
                //  Entryエンティティを作成
                var entry1 = new Entry()
                {
                    Name = "Doi",
                    Age = 30,
                    TelNo = "03-0000-0000",
                    MailAddress = "doi@hogehoge.com"
                };

                //  Categoryエンティティを作成
                var category1 = new Category()
                {
                    CategoryName = "友達",
                    Detail="友達の詳細"
                };

                //  EntryエンティティにCategoryエンティティを追加
                entry1.Categories.Add(category1);

                //  Entryエンティティをデータベースに追加
                container.Entries.Add(entry1);

                //  変更内容を保存
                container.SaveChanges();
            }
        }


    }
}
