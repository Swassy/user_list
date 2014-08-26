package com.training.crud.common;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.crud.database.*;
import com.training.crud.model.*;

import java.util.Scanner;

 
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = 
    		new ClassPathXmlApplicationContext("Spring-Module.xml");
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter name:");
    	String name=sc.nextLine();
    	System.out.print("Enter age:");
    	String age=sc.nextLine();
        DatabaseClass customerDAO = (DatabaseClass) context.getBean("customerDAO");
        UserBeanManager customer = new UserBeanManager(name,age);
        customerDAO.insert(customer);
 
        //Customer customer1 = customerDAO.findByCustomerId(1);
        
        
        //System.out.println(customer);
        sc.close();
        
 
    }
}