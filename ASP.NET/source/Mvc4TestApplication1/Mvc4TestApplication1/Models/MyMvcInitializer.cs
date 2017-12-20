using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Data.Entity;

namespace Mvc4TestApplication1.Models
{
    public class MyMvcInitializer : DropCreateDatabaseAlways<MyMvcContext>  
  {
    protected override void Seed(MyMvcContext context)  
    {
      var books = new List<Book> {

        new Book { Isbn = "978-4-8399-3793-5",
                   Title = "HTML5基礎",
                   Price = 2980,
                   Publish="毎日コミュニケーションズ",
                   Published = DateTime.Parse("2011-03-25") },

        new Book { Isbn = "978-4-7741-4663-8",
                   Title = "Ruby on Rails 3プログラミング",
                   Price = 3675, Publish="技術評論社",
                   Published = DateTime.Parse("2011-05-12") },
      };
      books.ForEach(b => context.Books.Add(b));
      context.SaveChanges();
    }
  }
}