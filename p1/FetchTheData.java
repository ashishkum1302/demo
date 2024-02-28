package org.btm.My_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class FetchTheData {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from emp.empdata";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123456");
			System.out.println("Connection Establised");
			pstmt=(PreparedStatement) con.prepareStatement(qry);
			System.out.println("Platform Created");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("Id");
				String name=rs.getString(2);
				String city=rs.getString(3);
				int phone=rs.getInt("Phone");
				System.out.println(id+" "+name+" "+city+" "+phone);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("All Costly Resource close");
		}

	}

}
