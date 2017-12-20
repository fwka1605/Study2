using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using System.Globalization;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            CultureInfo culture = new CultureInfo("ja-JP", true);
            culture.DateTimeFormat.Calendar = new JapaneseCalendar();

            string date = "平成28年02月28日";
            DateTime result  = DateTime.ParseExact(date, "ggyy年M月d日", culture);
            Console.WriteLine(result.ToShortDateString());
        }
    }
}
