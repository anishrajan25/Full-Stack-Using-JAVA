package com.wipro.sales.dao;
import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DButil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StockDao {
	public int insertStock(Product product) {
		Connection con = DButil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into tbl_stock values(?,?,?,?,?)");
			ps.setString(1, product.getProductID());
		    ps.setString(2, product.getProductName());
		    ps.setInt(3, product.getQuantityOnHand());
		    ps.setDouble(4, product.getProductUnitPrice());
		    ps.setInt(5, product.getReorderLevel());

		    return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public String generateProductID(String productName) {
		Connection con = DButil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select SEQ_PRODUCT_ID.nextval from dual");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return productName.substring(0, 2) + String.valueOf(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public static int updateStock(String productID, int soldQty) {
		Connection con = DButil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update tbl_stock set QUANTITY_ON_HAND = QUANTITY_ON_HAND - ? where product_id = ?");
			ps.setInt(1, soldQty);
			ps.setString(2, productID);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public static Product getStock(String productID) {
		Product product = new Product();
		Connection con = DButil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from tbl_stock where product_id = ?");
			ps.setString(1, productID);
		    ResultSet rs = ps.executeQuery();
		    if (rs.next()) {
		        product.setProductID(rs.getString(1));
		        product.setProductName(rs.getString(2));
		        product.setQuantityOnHand(rs.getInt(3));
		        product.setProductUnitPrice(rs.getDouble(4));
		        product.setReorderLevel(rs.getInt(5));
		    }
		    return product;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static int deleteStock(String productID) {
		Connection con = DButil.getDBConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from tbl_stock where product_id = ?");
			ps.setString(1, productID);
		    return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}
}
