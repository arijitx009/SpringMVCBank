package com.cg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.serviceLayer.MoneyMoneyBankService;
@Controller
public class DisplayController {

	
	MoneyMoneyBankService serviceLayer=new MoneyMoneyBankService();
	
	
	@RequestMapping("viewAccount")
	public String viewAccount(@RequestParam("typedAccount") int accountToBeSearched,Model model)
	{
		System.out.println("***********************1");
		
		model.addAttribute("createdbankAccount",serviceLayer.getAccountByAccountNumber(accountToBeSearched));
		
		return "viewAccount";
		
	}
	
	@RequestMapping("searchAccount")
	public String searchAccount()
	{
		return "searchAccount";
	}
@RequestMapping("viewAllCustomers")
public String viewAllCustomers(Model model)
{
	model.addAttribute("BankAccounts",serviceLayer.getBankAccounts());
	
	return "viewAllCustomer";
}
	
	
	
}
