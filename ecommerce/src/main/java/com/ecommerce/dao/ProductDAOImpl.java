package com.ecommerce.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Product;
import com.ecommerce.utils.Response;
@Repository
public class ProductDAOImpl implements ProductDAO{
@Autowired
SessionFactory sessionFactory;
	@Override
	public Response addProduct(Product product) {
		// TODO Auto-generated method stub
		Response response=new Response();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		int i=(int)session.save(product);
		if(i!=0) {
			response.setMessage("product added successfullly");
			response.setOperation(true);
			response.setStatusCode(201);
		}else {
			response.setMessage("product add failed");
			response.setOperation(false);
			response.setStatusCode(500);
		}
		tx.commit();
		return response;	
}
	//list all products
	@Override
	public List<Product> list() {
Session session=sessionFactory.openSession();
Transaction tx=session.beginTransaction();
Query<Product> query=session.createQuery("from Product");
return query.getResultList();
	}
	@Override
	public Product getProduct(int id) {
	Session session=sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	Product product=session.get(Product.class, id);
	return product;
	}
	//delete product based on id
	@Override
	public Response deleteProduct(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Product product=session.get(Product.class,id);
		Response response= new Response();
		try {
			session.remove(product);
			tx.commit();
			response.setMessage("delete successfully");
			response.setOperation(true);
			response.setStatusCode(200);	
		}catch(Exception error) {
			System.out.println("error:"+ error.getMessage());
			response.setMessage(error.getMessage());
			response.setOperation(false);
			response.setStatusCode(200);
			
		}
return response;
	}
	//updating product items
	@Override
	public Response updateProduct(Product product) {
	Session session= sessionFactory.openSession();
	Transaction tx= session.beginTransaction();
	Response response=new Response();
	try {
		session.update(product);
		tx.commit();
		response.setMessage("updation successfully");
		response.setOperation(false);
		response.setStatusCode(200);		
	}catch(Exception error) {
		System.out.println("error:"+ error.getMessage());
		response.setMessage("update failed");
		response.setStatusCode(200);
	}
		return response;
	}
	
}
