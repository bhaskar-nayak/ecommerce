package com.ecommerce.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;
import com.ecommerce.model.Seller;
import com.ecommerce.utils.Response;
@Repository
public class SellerDAOImpl implements SellerDAO{
	
	@Autowired
	SessionFactory sessionFactory;
		@Override
		public Response addSeller(Seller seller) {
			// TODO Auto-generated method stub
			Response response=new Response();
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			int i=(int)session.save(seller);
			if(i!=0) {
				response.setMessage("seller added successfullly");
				response.setOperation(true);
				response.setStatusCode(201);
			}else {
				response.setMessage("seller add failed");
				response.setOperation(false);
				response.setStatusCode(500);
			}
			tx.commit();
			return response;	
	}
		//listing all seller details
		@Override
		public List<Seller> list() {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			//creating query

			Query<Seller> query=session.createQuery("from Seller");
			return query.getResultList();
		}
	 //getting seller details by id
		@Override
		public Seller getSeller(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Seller seller=session.get(Seller.class, id);
			return seller;
		}
		@Override
		public Response updateSeller(Seller seller) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			Response response=new Response();
			try {
				session.update(seller);
				tx.commit();
				response.setMessage("update successfully");
				response.setOperation(true);
				response.setStatusCode(200);
			}catch(Exception error) {
				System.out.println("error"+error.getMessage());
				response.setMessage("update failed");
				response.setOperation(false);
				response.setStatusCode(200);
			}
			return response;
		}
		@Override
		public Response deleteSeller(int id) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			//based on id getting seller and deleting it
			Seller seller=session.get(Seller.class, id);
			Response response=new Response();
			try {
				session.remove(seller);
				tx.commit();
				response.setMessage("deleted successfully");
				response.setOperation(true);
				response.setStatusCode(200);
			}catch(Exception error) {
				System.out.println("error"+ error.getMessage());
				response.setMessage("deleting failed");
				response.setOperation(false);
				response.setStatusCode(200);
			}
			return response;
		}
		
}
