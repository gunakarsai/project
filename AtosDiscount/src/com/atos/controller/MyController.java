package com.atos.controller;

import java.io.IOException;

import java.rmi.ServerException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;  

import com.atos.Dao.MyDao;
import com.atos.model.Discounts;

@Controller
public class MyController
{
	@RequestMapping("link")
	public String meth()
	{
		return "linker";
	}
	
	@RequestMapping(value="/saveProduct",method = RequestMethod.POST)
	public String addProduc(HttpServletRequest request) throws ServerException,IOException
	{
		int product_id = Integer.parseInt(request.getParameter("id"));
		int product_price = Integer.parseInt(request.getParameter("price"));
		int product_discount = Integer.parseInt(request.getParameter("discount"));
		String Discount_valid = request.getParameter("discount_valid_month");
		
		System.out.println(product_id+" "+product_price+" "+product_discount+" "+Discount_valid);
		
		Discounts d = new Discounts(product_id, product_price, product_discount, Discount_valid);
		
		
		
		MyDao dao = new MyDao();
		int status = dao.save(d);
		
		if(status == 1)
		{
			return "success";
		}
		else
		{
			return "error";
		}
		
	}
	
	@RequestMapping("addProduct")
	public String addPro()
	{
		return "addP";
	}
	
	@RequestMapping("viewData")
	public String show() throws ClassNotFoundException,SQLException
	{
		MyDao dao = new MyDao();
		Discounts ds = dao.getProductById(1);
		if(ds.getProduct_id()!=-1)
		{
			System.out.println(ds.getProduct_id()+" "+ds.getProduct_price()+" "+ds.getProduct_discount()+" "+ds.getDiscount_valid());
			return "products";
		}
		else
		{
			return "error";
		}
	}
	
	
}