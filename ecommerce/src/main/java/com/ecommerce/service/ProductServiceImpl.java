package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;
@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductDAO productDAO;
	@Override
	public Response addProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.addProduct(product);
	}
	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		return productDAO.list();
	}
	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(id);
	}
	@Override
	public Response deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(id);
	}
	@Override
	public Response updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}

}
