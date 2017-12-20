using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Calc.cal.pro
{

    public class ExcpressCalculation
    {
        public string express {get;set;}    // 計算する数式

        private int position = 0;   // 数式の処理位置

        
        public ExcpressCalculation(string express)
        {
            this.express = express;
            this.position = 0;
        }

        /*
         * 
         * 式の解析
         *      <expr>   ::= <term> [ ('+'|'-') <term> ]*
         *      式は、項,項+項,項-項 (+項,-項は0回以上複数来る) 
         * 
         */
        public double expr()
        {
            // 項①を作成する
            double val = term();

            // 0回以上の+項または-項が続く場合
            while (express.Length > position && (express[position] == '+' || express[position] == '-'))
            {
                // オペランドを保存する（ここでは原則＋とマイナスのみがくる）
                char op = express[position];

                // 次の項②を解析する。
                position++;
                double val2 = term();

                // 項①と項②の結果を返す
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

        /*
         * 
         * 項の解析
         *      <term>   ::= <factor> [ ('*'|'/') <factor> ]*
         *      項は、要素,要素*要素,要素/要素 (*要素,/要素は0回以上複数来る) 
         * 
         */
        private double term()
        {
            // 要素①を解析する。
            double val = factor();

            while (express.Length > position && (express[position] == '*' || express[position] == '/'))
            {
                // オペランドを取得する。
                char op = express[position];

                // 要素②を解析する。
                position++;
                double val2 = factor();

                // 要素①と要素②を*/計算する。
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

        /*
         * 
         * 項の解析
         *      <factor> ::= -<number> | -<number> | <number> | '(' <expr> ')'
         *      要素は、+数値,-数値,数値,(式) の形式になる。 
         * 
         */
        private double factor()
        {
            double ret = 0;

            // 数値の場合は数値解析をする。
            if (express.Length > position && isdigit(express[position]))
            {
                ret= number();
            }
            // 数値のマイナス記号を解析する。
            else if (express.Length > position && express[position].Equals('-'))
            {
                position++; // '-'を読み飛ばす
                ret= - 1 * number();
            }
            // 数値のプラス記号を解析する。
            else if (express.Length > position && express[position].Equals('+'))
            {
                position++; // '+'を読み飛ばす
                ret = number();
            }
            else if (express.Length > position && express[position].Equals('('))
            {
                position++; // '('を読み飛ばす
                ret = expr();
                position++; // ')'を読み飛ばす
            }

            return ret;
        }

        /*
         * 
         * 数の解析
         *      <number> ::= 1つ以上の数字 | 1つ以上の数字.1つ以上の数字
         * 
         */
        private double number()
        {

            double n = express[position++] - '0';

            int syousuuCount = 0;
            while (express.Length > position)
            {
                if (isdigit(express[position]))
                {
                    if (syousuuCount==0)
                    {
                        n = n * 10 + (express[position++] - '0');
                    }
                    else
                    {
                        double syousuu = (double)(express[position] - '0');
                        for (int i = 0; i < syousuuCount; i++)
                        {
                            syousuu = syousuu / 10;
                        }
                        n = n + syousuu;

                        position++;
                        syousuuCount++;
                    }
                }
                else if (express[position].Equals('.'))
                {
                    if (syousuuCount == 0)
                    {
                        syousuuCount=1;
                    }
                    position++;
                }
                else
                {
                    break;
                }
            }

            return n;
        }

        private bool isdigit(char c)
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
