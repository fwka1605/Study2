    using System;
    using System.Data.Entity;
    using System.Linq;
using System.Collections.Generic;

namespace CodeZineEFLinqSample
{

    public class CodeZineSampleContext : DbContext
    {
        // コンテキストは、アプリケーションの構成ファイル (App.config または Web.config) から 'CodeZineSampleModel' 
        // 接続文字列を使用するように構成されています。既定では、この接続文字列は LocalDb インスタンス上
        // の 'CodeZineEFLinqSample.CodeZineSampleModel' データベースを対象としています。 
        // 
        // 別のデータベースとデータベース プロバイダーまたはそのいずれかを対象とする場合は、
        // アプリケーション構成ファイルで 'CodeZineSampleModel' 接続文字列を変更してください。
        public CodeZineSampleContext()
            : base("name=CodeZineSampleContext")
        {
        }

        // モデルに含めるエンティティ型ごとに DbSet を追加します。Code First モデルの構成および使用の
        // 詳細については、http://go.microsoft.com/fwlink/?LinkId=390109 を参照してください。

        //コンテキストクラスのプロパティで各エンティティのDbSetを持っておく
        public virtual DbSet<Employee> Employees { get; set; }
        public virtual DbSet<Department> Departments { get; set; }
        public virtual DbSet<Product> Products { get; set; }
        public virtual DbSet<Maker> Makers { get; set; }
    }

    public class Employee //担当者
    {
        public int Id { get; set; }//プライマリキー
        public string Name { get; set; }//担当者名
        public DateTime Birthday { get; set; }//誕生日
        public virtual Department Department { get; set; }//所属部署
        public ICollection<Product> Products { get; set; }//担当する商品一覧
    }

    public class Department //部署
    {
        public int Id { get; set; }
        public string Name { get; set; } //部署名
        public ICollection<Employee> Employees { get; set; } //部署内担当者一覧
    }

    public class Product //商品
    {
        public int Id { get; set; }
        public string Name { get; set; } //商品名
        public int Price { get; set; } //金額
        public virtual Maker Maker { get; set; } //出荷元
        public virtual Employee Employee { get; set; } //商品担当者
    }

    public class Maker //出荷元
    {
        public int Id { get; set; }
        public string Name { get; set; } //会社名
        public virtual ICollection<Product> Products { get; set; } //出荷商品一覧
    }



}