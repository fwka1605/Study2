using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calc2
{
    class Program
    {
        static int position = 0;
        static void Main(string[] args)
        {
            string str = "1+2*6/(10-7)";
            position = 0;
            int result = expr(str);
            int i = 0;
        }

        static int  expr(string s) {
            int val = term(s);
            while (s.Length > position && (s[position] == '+' || s[position] == '-'))
            {
                char op = s[position];
                position++;
                int val2 = term(s);
                if (op == '+')
                {
                    val += val2;
                }
                else
                {
                    val -= val2;
                }
            }
            return val;
        }

        static int term(string s) {

            int val = factor(s);

            while (s.Length>position &&( s[position] == '*' || s[position] == '/'))
            {
                char op = s[position];
                position++;
                int val2 = factor(s);

                if (op == '*')
                {
                    val *= val2;
                }
                else
                {
                    val /= val2;
                }
          }
          return val;
        }

        static int factor(string s)
        {
            if (isdigit(s[position]))
            {
                return number(s);
            }

            // ここで構文が正しければ s[i] == '(' となる
            position++; // '('を読み飛ばす
            int ret = expr(s);
            position++; // ')'を読み飛ばす
         
            return ret;
        }

        static int number(string s)
        {

            int n = s[position++] - '0';

            while (isdigit(s[position]))
            {
                n = n * 10 + s[position++] - '0';
            };

            return n;
        }

        static bool isdigit(char c)
        {
            if (c >= 48 && c <= 57)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
