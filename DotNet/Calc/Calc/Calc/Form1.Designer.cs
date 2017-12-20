namespace Calc
{
    partial class Form1
    {
        /// <summary>
        /// 必要なデザイナー変数です。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 使用中のリソースをすべてクリーンアップします。
        /// </summary>
        /// <param name="disposing">マネージ リソースが破棄される場合 true、破棄されない場合は false です。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows フォーム デザイナーで生成されたコード

        /// <summary>
        /// デザイナー サポートに必要なメソッドです。このメソッドの内容を
        /// コード エディターで変更しないでください。
        /// </summary>
        private void InitializeComponent()
        {
            this.txtExpression = new System.Windows.Forms.TextBox();
            this.btnCal = new System.Windows.Forms.Button();
            this.lblConvertedExpression = new System.Windows.Forms.Label();
            this.lblMessage = new System.Windows.Forms.Label();
            this.lblResultExpression = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // txtExpression
            // 
            this.txtExpression.Font = new System.Drawing.Font("MS UI Gothic", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(128)));
            this.txtExpression.Location = new System.Drawing.Point(55, 50);
            this.txtExpression.Name = "txtExpression";
            this.txtExpression.Size = new System.Drawing.Size(284, 27);
            this.txtExpression.TabIndex = 0;
            // 
            // btnCal
            // 
            this.btnCal.Font = new System.Drawing.Font("MS UI Gothic", 10F);
            this.btnCal.Location = new System.Drawing.Point(358, 50);
            this.btnCal.Name = "btnCal";
            this.btnCal.Size = new System.Drawing.Size(154, 27);
            this.btnCal.TabIndex = 1;
            this.btnCal.Text = "計算";
            this.btnCal.UseVisualStyleBackColor = true;
            this.btnCal.Click += new System.EventHandler(this.btnCal_Click);
            // 
            // lblConvertedExpression
            // 
            this.lblConvertedExpression.AutoSize = true;
            this.lblConvertedExpression.Font = new System.Drawing.Font("MS UI Gothic", 12F);
            this.lblConvertedExpression.Location = new System.Drawing.Point(201, 100);
            this.lblConvertedExpression.Name = "lblConvertedExpression";
            this.lblConvertedExpression.Size = new System.Drawing.Size(57, 20);
            this.lblConvertedExpression.TabIndex = 2;
            this.lblConvertedExpression.Text = "label1";
            // 
            // lblMessage
            // 
            this.lblMessage.AutoSize = true;
            this.lblMessage.Font = new System.Drawing.Font("MS UI Gothic", 12F);
            this.lblMessage.Location = new System.Drawing.Point(150, 9);
            this.lblMessage.Name = "lblMessage";
            this.lblMessage.Size = new System.Drawing.Size(57, 20);
            this.lblMessage.TabIndex = 3;
            this.lblMessage.Text = "label1";
            // 
            // lblResultExpression
            // 
            this.lblResultExpression.AutoSize = true;
            this.lblResultExpression.Font = new System.Drawing.Font("MS UI Gothic", 12F);
            this.lblResultExpression.Location = new System.Drawing.Point(201, 148);
            this.lblResultExpression.Name = "lblResultExpression";
            this.lblResultExpression.Size = new System.Drawing.Size(57, 20);
            this.lblResultExpression.TabIndex = 4;
            this.lblResultExpression.Text = "label1";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("MS UI Gothic", 12F);
            this.label1.Location = new System.Drawing.Point(51, 148);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(99, 20);
            this.label1.TabIndex = 7;
            this.label1.Text = "計算結果：";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("MS UI Gothic", 12F);
            this.label2.Location = new System.Drawing.Point(51, 9);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(94, 20);
            this.label2.TabIndex = 6;
            this.label2.Text = "メッセージ：";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("MS UI Gothic", 12F);
            this.label3.Location = new System.Drawing.Point(51, 100);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(119, 20);
            this.label3.TabIndex = 5;
            this.label3.Text = "変換後数式：";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(738, 255);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.lblResultExpression);
            this.Controls.Add(this.lblMessage);
            this.Controls.Add(this.lblConvertedExpression);
            this.Controls.Add(this.btnCal);
            this.Controls.Add(this.txtExpression);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtExpression;
        private System.Windows.Forms.Button btnCal;
        private System.Windows.Forms.Label lblConvertedExpression;
        private System.Windows.Forms.Label lblMessage;
        private System.Windows.Forms.Label lblResultExpression;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
    }
}

