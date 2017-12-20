using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using TestConsoleApplication.EM;

namespace TestConsoleApplication
{
    class Program
    {
        static void Main(string[] args)
        {
            SearchArrayByLinqSample sa = new SearchArrayByLinqSample();
            sa.searchByQuery();

            sa.searchByMethod();

        }
    }
}
