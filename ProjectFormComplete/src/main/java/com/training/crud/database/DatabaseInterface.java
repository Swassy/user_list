package com.training.crud.database;
 

import com.training.crud.model.UserBeanManager;
 
public interface DatabaseInterface 
{
	public void insert(UserBeanManager customer);
	public String searchByEmailId();
}