using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace EFCodeFrist.EM
{
    public class User
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public int Age { get; set; }

        public User()
        {
        }

        public User(string Name, int Age)
        {
            this.Name = Name;
            this.Age = Age;
        }
    }
}
