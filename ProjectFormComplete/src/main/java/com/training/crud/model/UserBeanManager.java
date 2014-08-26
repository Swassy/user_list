package com.training.crud.model;

import com.training.crud.database.DatabaseClass;
import com.training.crud.model.UserBeanInterface;

public class UserBeanManager {
	String email,password;
	UserBeanInterface ub=new UserBean();
	public UserBeanManager(String email,String password){
		this.email=email;
		this.password=password;
		setUserParameter();
		//System.out.println("done initialising");
		
		}
	public void setUserEmail(String email){
		this.email=email;
		}
	public void setUserPassword(String password){
		this.password=password;
		}
	public void setUserParameter(){
		ub.setEmail(email);
		ub.setPassword(password);
	}
	public String getUserEmail(){
		return ub.getEmail();
	}
	public String getUserPassword(){
		return ub.getPassword();
	}
	public void setIntoDatabase(String email,String password){
		CheckClass cc=new CheckClass(email,password);
		if(cc.validateEmail()==1){
			DatabaseClass dc=new DatabaseClass();
			dc.insert(new UserBeanManager(email,password));
		}
		else {
			System.out.println("Invalid email");
		}
		
	}
	
}
