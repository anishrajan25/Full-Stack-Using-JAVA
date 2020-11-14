package com.wipro.sales.dao;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
public class SalesDao {
	public int insertSales(Sales sales) {
		Connection con = DButil.getDBConnection();
		PreparedStatement ps;
		int res = -1;
		try {
			ps = con.prepareStatement("INSERT into TBL_SALES values(?,?,?,?,?)");
			ps.setString(1, sales.getSalesID());
			ps.setDate(2, new java.sql.Date(sales.getSalesDate().getTime()));
			ps.setString(3, sales.getProductID());
			ps.setInt(4, sales.getQuantitySold());
			ps.setDouble(5, sales.getSalesPricePerUnit());
			res = ps.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println("Unable to Insert into the Database");
		} 
		return res;
	}
	public String generateSalesID(java.util.Date salesDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(salesDate);
		int year = c.get(Calendar.YEAR);
		
		Connection con = DButil.getDBConnection();
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = con.prepareStatement("select SEQ_SALES_ID.nextval from dual");
			rs = ps.executeQuery();
			if(rs.next()) {
				return String.valueOf(year % 100) + rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";		
	}
	public List<SalesReport> getSalesReport() {
		List<SalesReport> report = new LinkedList();
		Connection con = DButil.getDBConnection();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from V_SALES_REPORT");
			while(rs.next()) {
				SalesReport sr = new SalesReport();
				sr.setSalesID(rs.getString("SALES_ID"));
				sr.setSalesDate(new java.util.Date(rs.getDate("SALES_DATE").getTime()));
				sr.setProductID(rs.getString("PRODUCT_ID"));
				sr.setProductName(rs.getString("PRODUCT_NAME"));
				sr.setQuantitySold(rs.getInt("QUANTITY_SOLD"));
				sr.setProductUnitPrice(rs.getDouble("PRODUCT_UNIT_PRICE"));
				sr.setProfitAmount(rs.getDouble("PROFIT_AMOUNT"));
				report.add(sr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return report;
	}
}
