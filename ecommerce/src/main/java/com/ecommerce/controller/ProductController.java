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
import com.ecommerce.service.ProductService;
import com.ecommerce.utils.Response;

@RestController
public class ProductController {
@Autowired
ProductService productService;
ResponseEntity responseObject=null;
@PostMapping("/addproduct")
public ResponseEntity addProduct(@RequestBody Product product) {
try {
	Response response=productService.addProduct(product);
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
//list of products
@GetMapping("/list")
public ResponseEntity getProduct() {
	try {
	responseObject=new ResponseEntity<List<Product>>(productService.list(), HttpStatus.OK);	
	}catch(Exception exception) {
		Response response=new Response();
		response.setMessage(exception.getMessage());
		response.setOperation(false);
		response.setStatusCode(500);
		System.out.println(exception);
		responseObject=new ResponseEntity(response, HttpStatus.OK);
	}
	return responseObject;
}
//getting products based on id
@SuppressWarnings({ "rawtype, unchecked"})
@GetMapping("/product/{id}")
public ResponseEntity getProduct(@PathVariable int id) {
	try {
		Product product=productService.getProduct(id);
		responseObject=new ResponseEntity(product, HttpStatus.OK);
	}catch(Exception exception) {
		Response response=new Response();
		response.setMessage(exception.getMessage());
		response.setOperation(false);
		response.setStatusCode(500);
		System.out.println(exception);
		responseObject=new ResponseEntity(response,HttpStatus.OK);
	}
	return responseObject;
}
//deleting product items
@SuppressWarnings({ "rawtype, unchecked"})
@DeleteMapping("/product/{id}")
public ResponseEntity deleteProduct(int id) {
	try {
		System.out.println("id:"+id);
		Response response=productService.deleteProduct(id);
		responseObject=new ResponseEntity(response, response.getOperation()? HttpStatus.OK: HttpStatus.BAD_REQUEST);
	}catch(Exception exception) {
		Response response= new Response();
		response.setMessage(exception.getMessage());
		response.setOperation(false);
		response.setStatusCode(500);
		System.out.println(exception);
		responseObject=new ResponseEntity(response, HttpStatus.OK);
	}
	return responseObject;
}
//updating product items 
@SuppressWarnings({ "rawtype, unchecked"})
@PutMapping("/update")
public ResponseEntity updateProduct(@RequestBody Product product) {
	try {
		Response response=productService.updateProduct(product);
		responseObject=new ResponseEntity(response, response.getOperation()? HttpStatus.OK: HttpStatus.BAD_REQUEST);
	}catch(Exception exception) {
		System.out.println(exception);
		Response response= new Response();
		response.setMessage(exception.getMessage());
		response.setOperation(false);
		response.setStatusCode(500);
		System.out.println(exception);
		responseObject=new ResponseEntity(response, HttpStatus.OK);
	}
	return responseObject;
}
}
