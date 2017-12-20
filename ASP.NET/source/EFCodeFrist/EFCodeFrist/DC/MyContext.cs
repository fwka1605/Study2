using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Data.Entity;

using EFCodeFrist.EM;

namespace EFCodeFrist.DC
{
    public class MyContext: DbContext
    {
        public DbSet<User> Users { get; set; }
    }
}
