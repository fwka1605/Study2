/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.jpademo;

import java.sql.Connection; 
import java.sql.Driver; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.util.Properties;

/**
 *
 * @author NVLCLT13
 */
public class TestMain {
    public static void main(String args[]){
        try 
        {
            Driver d = (Driver) Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance(); 
            String connUrl = "jdbc:sqlserver://NVLSVR16;database=Navio_App;" 
                        + "integratedSecurity=false;user=sa;password=nouvelle"; 

            Connection con = d.connect(connUrl, new Properties()); 
            String SQL = "SELECT * FROM pertot_mst ORDER BY per_start,sf1"; 

	Statement stmt = con.createStatement(); 
	ResultSet rs = stmt.executeQuery(SQL); 

	while (rs.next()) { 
		System.out.println( rs.getString("sf1") + ", " + rs.getString("amt")); 
	} 

	rs.close(); 
	stmt.close(); 
	con.close();
} 
catch (Exception e) 
{
	e.printStackTrace(); 
}
    }
}
