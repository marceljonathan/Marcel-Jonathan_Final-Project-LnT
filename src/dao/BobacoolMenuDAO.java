package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.DBConnect;

public class BobacoolMenuDAO {
	
	Connection connection;
	
	public BobacoolMenuDAO() {
		try {
			initDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initDB() throws SQLException {
		connection = DBConnect.connect();
		if(connection == null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from bobamenu";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				data.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void insertData(String kode, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "insert into bobamenu values ('"+ kode +"', '"+ nama +"', '"+ harga +"', '"+ stok +"')";
			stmt.executeUpdate(sql);
//			System.out.println("Success input new menu");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateMenu(String code, String price, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update bobamenu set price='" + price + "', stock='" + stock + "' where menuCode='" + code + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMenu(String code) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from bobamenu where menuCode='" + code + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


