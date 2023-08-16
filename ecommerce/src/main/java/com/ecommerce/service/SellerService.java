package com.ecommerce.service;

import java.util.List;

import com.ecommerce.model.Seller;
import com.ecommerce.utils.Response;

public interface SellerService {
	
	  public Response addSeller(Seller seller);
	  public List<Seller> list();
	  public Seller getSeller(int id);
	  public Response updateSeller(Seller seller);
	  public Response deleteSeller(int id);
	 }
