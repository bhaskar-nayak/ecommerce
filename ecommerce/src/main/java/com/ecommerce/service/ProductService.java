package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;

public interface ProductService {
public Response addProduct(Product product);
public List<Product> list();
public Product getProduct(int id);
public Response deleteProduct(int id);
public Response updateProduct(Product product);
}
