package com.training.crud.database;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.training.crud.database.DatabaseInterface;
import com.training.crud.model.*;
 
public class DatabaseClass implements DatabaseInterface
{
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(UserBeanManager customer){
 
		String sql = "INSERT INTO USER " +
				"(email, passord) VALUES (?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getUserEmail());
			ps.setString(2, customer.getUserPassword());
			
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public String searchByEmailId(){
 
		String sql = "SELECT * FROM USER ";
 
		Connection conn = null;
		String a="";
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			UserBeanManager customer = null;
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				customer = new UserBeanManager(
					rs.getString("EMAIL"),
					rs.getString("PASSORD")

				);
				a+=rs.getString("email")+"::"+rs.getString("passord")+"<br></br>";
				System.out.println("inside"+a);
			}
			rs.close();
			ps.close();
			System.out.println("outside"+a);
			return a;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				
				} catch (SQLException e) {}
			}
		}
	}
}