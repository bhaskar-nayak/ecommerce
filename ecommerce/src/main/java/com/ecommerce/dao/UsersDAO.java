package com.ecommerce.dao;

import java.util.List;

import com.ecommerce.model.User;
import com.ecommerce.utils.Response;

  public interface UsersDAO { 
	
	  public Response registerUser(User user);
		 public Response loginUser(User user);
		 public List<User> getUsers(); 
		 public Response forgotPassword(User user);	 
		 public Response changePassword(User user);
  
  }
 