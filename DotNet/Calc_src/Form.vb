Public Class Form
    Inherits System.Windows.Forms.Form

#Region " Windows Form Designer generated code "

    Public Sub New()
        MyBase.New()

        'This call is required by the Windows Form Designer.
        InitializeComponent()

        'Add any initialization after the InitializeComponent() call

    End Sub

    'Form overrides dispose to clean up the component list.
    Protected Overloads Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing Then
            If Not (components Is Nothing) Then
                components.Dispose()
            End If
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    Friend WithEvents txtExpression As System.Windows.Forms.TextBox
    Friend WithEvents cmdEvaluate As System.Windows.Forms.Button
    Friend WithEvents Label1 As System.Windows.Forms.Label
    <System.Diagnostics.DebuggerStepThrough()> Private Sub InitializeComponent()
        Me.txtExpression = New System.Windows.Forms.TextBox()
        Me.cmdEvaluate = New System.Windows.Forms.Button()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.SuspendLayout()
        '
        'txtExpression
        '
        Me.txtExpression.Location = New System.Drawing.Point(28, 55)
        Me.txtExpression.Name = "txtExpression"
        Me.txtExpression.Size = New System.Drawing.Size(358, 22)
        Me.txtExpression.TabIndex = 0
        '
        'cmdEvaluate
        '
        Me.cmdEvaluate.Location = New System.Drawing.Point(280, 92)
        Me.cmdEvaluate.Name = "cmdEvaluate"
        Me.cmdEvaluate.Size = New System.Drawing.Size(106, 37)
        Me.cmdEvaluate.TabIndex = 1
        Me.cmdEvaluate.Text = "Evaluate"
        '
        'Label1
        '
        Me.Label1.Location = New System.Drawing.Point(28, 37)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(202, 18)
        Me.Label1.TabIndex = 2
        Me.Label1.Text = "Enter expression:"
        '
        'Form
        '
        Me.AutoScaleBaseSize = New System.Drawing.Size(7, 15)
        Me.ClientSize = New System.Drawing.Size(437, 131)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.cmdEvaluate)
        Me.Controls.Add(Me.txtExpression)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.MaximizeBox = False
        Me.Name = "Form"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Expression Evaluator Test"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

#End Region

    Private Sub cmdEvaluate_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles cmdEvaluate.Click

        Dim calc As New mcCalc()

        MsgBox("The answer is " & calc.evaluate(txtExpression.Text), , "Expression Evaluation Test")

    End Sub
End Class
