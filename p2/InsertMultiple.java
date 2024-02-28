package org.btm.My_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class InsertMultiple {

	public static void main(String[] args) {
	    Connection con=null;
	    java.sql.PreparedStatement pstmt=null;
	    String inqry="insert into emp.empdata values(?,?,?,?)";
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123456");
			System.out.println("Connection Established");
			pstmt= con.prepareStatement(inqry);
			System.out.println("Platform created");
			//Set the value place holder before execution
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Ram");
			pstmt.setString(3, "Ranchi");
			pstmt.setInt(4, 797994);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 2);
			pstmt.setString(2, "Priya");
			pstmt.setString(3, "Pune");
			pstmt.setInt(4, 797994);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 3);
			pstmt.setString(2, "Ashish");
			pstmt.setString(3, "Noida");
			pstmt.setInt(4, 59797);
			pstmt.executeUpdate();
			
		
			
		
			System.out.println("Data Inserted Sucessfully");
		} catch (ClassNotFoundException | SQLException e) {
		

	}
	    finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("All Clostly Resources Closed");
		}

}
}