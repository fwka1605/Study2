using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

using Calc.cal.pro;

namespace Calc
{
    public partial class Form1 : Form
    {
        public ExpressAnalyzer expressAnalyzer;

        public Form1()
        {
            InitializeComponent();
            init();
        }

        public void init()
        {
            txtExpression.Text = "";
            lblMessage.Text = "";
            lblConvertedExpression.Text = "";
            lblResultExpression.Text = "";

        }

        private void btnCal_Click(object sender, EventArgs e)
        {
            //txtExpression.Text = "((0-1)+2)+6/((10-7))";
            //txtExpression.Text = "@test1@";

            // 入力チェック
            if (txtExpression == null || txtExpression.Equals(""))
            {
                MessageBox.Show("式を入力してください");
                return;
            } 
            
            expressAnalyzer = new ExpressAnalyzer(txtExpression.Text);

            // 科目集計の数値への置き換え
            expressAnalyzer.accountConvert();

            lblConvertedExpression.Text = expressAnalyzer.convertedExpress;

            double d;
            if (double.TryParse(expressAnalyzer.convertedExpress, out d))
            {
                lblMessage.Text = "数値データのため変換は不要になります";

                lblResultExpression.Text = ""+d;
            }

            ExcpressCalculation expressCalculation = new ExcpressCalculation(expressAnalyzer.convertedExpress);

            double j = expressCalculation.expr();
            lblResultExpression.Text = "" + j;
            lblMessage.Text = "計算処理は正常終了しました";
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
