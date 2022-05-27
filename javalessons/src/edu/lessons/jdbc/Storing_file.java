package edu.lessons.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Storing_file {
	public static void main(String[] args) {  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","system","Arunps2244#");  
		              
		PreparedStatement ps=con.prepareStatement(  
		"insert into filetable values(?,?)");  
		              
		File f=new File("d:\\temp\\jdbc.txt");  
		FileReader fr=new FileReader(f);  
		              
		ps.setInt(1,101);  
		ps.setCharacterStream(2,fr,(int)f.length());  
		int i=ps.executeUpdate();  
		System.out.println(i+" records affected");  
		con.close();  
		}catch (Exception e) {e.printStackTrace();}  
		}  
}
