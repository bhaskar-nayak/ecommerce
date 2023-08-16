package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.SellerDAO;
import com.ecommerce.model.Seller;
import com.ecommerce.utils.Response;
@Service
public class SellerServiceImpl implements SellerService{
@Autowired
SellerDAO sellerDAO;
	@Override
	public Response addSeller(Seller seller) {
		// TODO Auto-generated method stub
		return sellerDAO.addSeller(seller);
	}
	@Override
	public List<Seller> list() {
		// TODO Auto-generated method stub
		return sellerDAO.list();
	}
	@Override
	public Seller getSeller(int id) {
		// TODO Auto-generated method stub
		return sellerDAO.getSeller(id);
	}
	@Override
	public Response updateSeller(Seller seller) {
		// TODO Auto-generated method stub
		
		return sellerDAO.updateSeller(seller);
	}
	@Override
	public Response deleteSeller(int id) {
		// TODO Auto-generated method stub
		return sellerDAO.deleteSeller(id);
	}
	
	 
}
