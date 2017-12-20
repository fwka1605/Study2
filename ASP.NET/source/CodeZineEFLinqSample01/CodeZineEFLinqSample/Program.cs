using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
//using System.Data.Objects.SqlClient;


namespace CodeZineEFLinqSample
{
    class Program
    {
        static void Main(string[] args)
        {
            //クエリ対象文字列配列配列
            string[] names = { "Doi", "Tanaka", "Nakamura", "Saitou", "Yamada" };
            //上記配列から、文字列長が6の文字列を検索し、辞書順にソートし、大文字に変換する
            IEnumerable<string> query =
              from s in names
              where s.Length == 6
              orderby s
              select s.ToUpper();
            //結果をカンマを挟んで出力
            Console.WriteLine(string.Join(",", query));
            //出力結果: SAITOU,TANAKA,YAMADA

            //上記クエリ式をメソッド式に置き換えたもの
            query = names.Where(x => x.Length == 6).OrderBy(x => x).Select(x => x.ToUpper());
            Console.WriteLine(string.Join(",", query));

            //ラムダ式理解のために、ちょっと書き下してみる
            foreach (var name in names)
            {
                if (IsLength6(name))
                {
                    Console.WriteLine(name);
                }
            }

            //DB初期化方法を指定。今回はデータ投入を同時に行う
            Database.SetInitializer(new CustomSeedInitializer());
            var program = new Program();
            program.Select();
        }

        static bool IsLength6(string x)
        {
            return x.Length == 6;
        }

        //データ投入用イニシャライザクラス
        public class CustomSeedInitializer : DropCreateDatabaseIfModelChanges<CodeZineSampleContext>
        {
            protected override void Seed(CodeZineSampleContext context)
            {
                base.Seed(context);
                //部署定義
                var department1 = new Department()
                {
                    Name = "営業部"
                };
                var department2 = new Department()
                {
                    Name = "販売部"
                };

                //社員定義
                var employee1 = new Employee()
                {
                    Name = "土井",
                    Birthday = DateTime.Parse("1978-10-25"),
                    Department = department1
                };
                var employee2 = new Employee()
                {
                    Name = "佐藤",
                    Birthday = DateTime.Parse("1970-1-2"),
                    Department = department2
                };
                var employee3 = new Employee()
                {
                    Name = "田中",
                    Birthday = DateTime.Parse("1950-12-20"),
                    Department = department2
                };

                //生産者定義
                var maker1 = new Maker()
                {
                    Name = "お菓子屋さんA"
                };
                var maker2 = new Maker()
                {
                    Name = "酪農家A"
                };

                //商品定義
                var product1 = new Product()
                {
                    Name = "ショートケーキ",
                    Price = 250,
                    Maker = maker1,
                    Employee = employee1,
                };


                var product2 = new Product()
                {
                    Name = "バームクーヘン",
                    Price = 500,
                    Maker = maker1,
                    Employee = employee1,
                };

                var product3 = new Product()
                {
                    Name = "おいしい牛乳",
                    Price = 250,
                    Maker = maker2,
                    Employee = employee2,
                };

                var product4 = new Product()
                {
                    Name = "季節のアイスクリーム",
                    Price = 220,
                    Maker = maker1,
                    Employee = employee1,
                };

                var product5 = new Product()
                {
                    Name = "流行のヨーグルト",
                    Price = 320,
                    Maker = maker2,
                    Employee = employee2,
                };


                //商品を登録（関連するエンティティも自動的に登録される）
                context.Products.Add(product1);
                context.Products.Add(product2);
                context.Products.Add(product3);
                context.Products.Add(product4);
                context.Products.Add(product5);

                //保存
                context.SaveChanges();
            }
        }

        public void Select()
        {
            Console.ReadKey();
        }

    }
}
