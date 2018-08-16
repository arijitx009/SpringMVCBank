package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/home")
	public String home()
	{
		return "home";
		
	}
	
	@RequestMapping("addNewAccount")
	public String addNewAccount()
	{
		return "addNewAccount";
		
	}

	@RequestMapping("depositForm")
	public String depositForm()
	{
		return "depositForm";
		
	}
	
	@RequestMapping("fundTransfer")
	public String fundTransfer()
	{
		return "fundTransfer";
		
	}
	
	@RequestMapping("searchAccount")
	public String searchAccount()
	{
		return "searchAccount";
		
	}
	
	@RequestMapping("/updateCustomerForm")
	public String updateCustomerForm()
	{
		return "updateCustomerForm";
		
	}
	
	@RequestMapping("/viewAllCustomers")
	public String viewAllCustomers()
	{
		return "viewAllCustomers";
		
	}
	@RequestMapping("/withdrawForm")
	public String withdrawForm()
	{
		return "withdrawForm";
		
	}
	
}
