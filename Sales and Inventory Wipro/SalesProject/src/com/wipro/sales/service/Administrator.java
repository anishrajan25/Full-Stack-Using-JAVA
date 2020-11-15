package com.wipro.sales.service;

import java.util.List;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;

public class Administrator {

	public String insertStock(Product stockobj) {
		StockDao sdao = new StockDao();
		if(stockobj != null && stockobj.getProductName().length() >= 2) {
			String productId = sdao.generateProductID(stockobj.getProductName());
			stockobj.setProductID(productId);
			if(sdao.insertStock(stockobj) != -1) return "Inserted Successfully";
		}
		return "Data not valid for insertion";
	}
	
	public insertSales(Product product) {
		
	}

	public String deleteStock(String productID) {
		StockDao sdao = new StockDao();
		return sdao.deleteStock(productID) != -1 ? "Deleted SuccessFully" : "Failed to delete the Stock record";
	}

	public List<SalesReport> getSalesReport() {
		SalesDao ob = new SalesDao();
		return ob.getSalesReport();
	}
}
