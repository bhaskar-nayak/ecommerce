package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.Seller;
import com.ecommerce.utils.Response;

public interface SellerDAO {
	 public Response addSeller(Seller seller); 
	 public List<Seller>list();
	 public Seller getSeller(int id);
	 public Response updateSeller(Seller seller);
	 public Response deleteSeller(int id);
	 
}
