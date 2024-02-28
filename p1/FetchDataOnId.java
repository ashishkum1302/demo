package org.btm.My_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class FetchDataOnId {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		sc.close();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * form emp.empdata where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=123456");
			System.out.println("Connection Established");
			pstmt=(PreparedStatement) con.prepareStatement(qry);
			System.out.println("Platform created");
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String name=rs.getString(2);
				String city=rs.getString(3);
				int phone=rs.getInt("Phone");
				System.out.println(name+" "+city+" "+phone);
			}
			else {
				System.err.println("No Data found for Id"+id);
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
			System.out.println("Closed All Costly Resources");
		}

	}

}
