using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Data.Entity;

namespace Mvc4TestApplication1.Models
{
    public class MyMvcContext : DbContext
    {
        public DbSet<Book> Books { get; set; } // Booksテーブル
        public DbSet<Review> Reviews { get; set; } // Reviewsテーブル
    }
}