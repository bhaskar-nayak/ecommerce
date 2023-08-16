package com.ecommerce.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.model.Seller;
import com.ecommerce.service.SellerService;
import com.ecommerce.utils.Response;

@RestController
public class SellerController {
	@Autowired
	SellerService sellerService;
	ResponseEntity responseObject=null;
	@PostMapping("/addseller")
	public ResponseEntity addSeller(@RequestBody Seller seller) {
	try {
		Response response=sellerService.addSeller(seller);
		responseObject=new ResponseEntity(response, response.getOperation()? HttpStatus.CREATED: HttpStatus.BAD_REQUEST);
	}catch(Exception error) {
		System.out.println(error);
		Response response=new Response();
		response.setMessage(error.getMessage());
		response.setOperation(false);
		response.setStatusCode(500);
		responseObject=new ResponseEntity(response, response.getOperation()? HttpStatus.CREATED: HttpStatus.BAD_REQUEST);
	}
	return responseObject;
	}
	//list of all seller details
	@SuppressWarnings({ "rawtype, unchecked"})
	@GetMapping("/sellerlist")
	public ResponseEntity getSeller() {
		try {
			responseObject=new ResponseEntity<List<Seller>>(sellerService.list(), HttpStatus.OK);
		}catch(Exception exception) {
			Response response=new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject=new ResponseEntity(response, HttpStatus.OK);	
			System.out.println(exception);
		}
		return responseObject;
	}
	//getting list based on id
	@SuppressWarnings({ "rawtype, unchecked"})
	@GetMapping("/seller/{id}")
	public ResponseEntity getSeller(@PathVariable int id) {
		try {
			Seller seller=sellerService.getSeller(id);
			responseObject=new ResponseEntity(seller, HttpStatus.OK);
		}catch(Exception exception) {
			Response response=new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject=new ResponseEntity(response, HttpStatus.OK);
			System.out.println(exception);
			}
		return  responseObject;
	}
	@SuppressWarnings({ "rawtype, unchecked"})
	@PutMapping("/updatesller")
	public ResponseEntity updateSeller(@RequestBody Seller sellet) {
		try {
			Response response=sellerService.updateSeller(sellet);
			responseObject=new ResponseEntity(response, response.getOperation()? HttpStatus.OK: HttpStatus.BAD_REQUEST);
		}catch(Exception exception) {
			Response response=new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject=new ResponseEntity(response, HttpStatus.OK);
			System.out.println(exception);
		}
		return responseObject;
	}
	//deleting sellers based on id
	@SuppressWarnings({ "rawtype, unchecked"})
	@DeleteMapping("/deleteseller/{id}")
	
	public ResponseEntity deleteSeller(@PathVariable int id) {
		try {
			System.out.println("id:"+ id);
			Response response=sellerService.deleteSeller(id);
			responseObject=new ResponseEntity(response, response.getOperation()? HttpStatus.OK: HttpStatus.BAD_REQUEST);
		}catch(Exception exception) {
			Response response=new Response();
			response.setMessage(exception.getMessage());
			response.setOperation(false);
			response.setStatusCode(500);
			responseObject=new ResponseEntity(response, HttpStatus.OK);
			
		}
		
		return responseObject;
	}
}
