<!DOCTYPE html>
<script runat="server">

    Protected Sub btn_entry_Click(sender As Object, e As EventArgs)
        e.
    End Sub
</script>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        #form1 {
            height: 163px;
        }
    </style>
</head>
<body>



    <form id="form1" runat="server">
        <p>
            &nbsp;</p>
        <asp:Label ID="Label1" runat="server" Text="ID"></asp:Label>
        <asp:TextBox ID="txt_name" runat="server"></asp:TextBox>
        <br />
        名前<asp:TextBox ID="txt_name0" runat="server"></asp:TextBox>
        <br />
        <asp:Button ID="btn_entry" runat="server" OnClick="btn_entry_Click" Text="登録" />
    </form>



</body>
</html>
