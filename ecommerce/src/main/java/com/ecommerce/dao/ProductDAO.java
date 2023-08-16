package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;

public interface ProductDAO {
public Response addProduct(Product product);
public List<Product> list();
public Product getProduct(int id);
public Response deleteProduct(int id);
public Response updateProduct(Product product);
}
