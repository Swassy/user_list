package com.training.crud.model;

import org.apache.commons.validator.EmailValidator;
import java.util.regex.*;

public class CheckClass {
	private String email;
	private String password;
	public CheckClass(){
		email="";
		password="";
	}
	public CheckClass(String email,String password){
		this.email=email;
		this.password=password;
	}
	public int validateEmail(){
		EmailValidator ev= EmailValidator.getInstance();
		if(ev.isValid(email)){
			return 1;
		}
		return 0;
	}
	public int validatePassword(){
		
		Pattern p = Pattern.compile("(((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[.@#$%])).{8,20})");
		Matcher m = p.matcher(password);
		if(m.matches())
			return 1;
		else 
			return 0;
		
	}
	
}
