package org.btm.My_Project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo {
	public static void main(String[]args) {
		Connection con=null;
		Statement stmt=null;
		//String qry="insert into btm.Student values(5,'Pakhi',27)";
		//String qry = "update btm.Student set name = 'Raj' where id= 2";
		//String qry= "delete from btm.Student where id=5";
		
		//insert the multiple records
		String qry1="insert into btm.Student values(5,'Pakhi',27)";
		String qry2="insert into btm.Student values(6,'Nisha',35)";
		String qry3="insert into btm.Student values(7,'Virat',26)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123456");
			System.out.println("Connection Established");
			stmt=con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			System.out.println("Data inserted");
			//System.out.println("Data sucessfully update");
			//System.out.println("Data sucessfully deleted");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

