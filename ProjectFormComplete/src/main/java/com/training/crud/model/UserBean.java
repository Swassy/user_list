package com.training.crud.model;

public class UserBean implements UserBeanInterface {

	private String email;
	private String password;
	public void setEmail( String email ){
		this.email=email;System.out.println("email in bean");
	}
	public void setPassword( String password ){
		this.password=password;
	}
	public String getEmail(){
		return email;
	}
	public String getPassword(){
		return password;
	}
}
