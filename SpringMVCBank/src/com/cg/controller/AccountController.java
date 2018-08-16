package com.cg.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.factory.MMBankFactory;
import com.cg.serviceLayer.MoneyMoneyBankService;

@Controller
public class AccountController{ 

	MMBankFactory mmBankFactory = new MMBankFactory();
	Map<String,Object> account=new HashMap<>();
	MoneyMoneyBankService serviceLayer = new MoneyMoneyBankService();


	@RequestMapping("createdAccount")
	public String addNewAccount(@RequestParam("customerName")String customerName,@RequestParam("gender")String gender,
			@RequestParam("dob")String dob,@RequestParam("email")String email,@RequestParam("contact_no")String contact_no,
			@RequestParam("houseNo")String houseNo,@RequestParam("street")String street,@RequestParam("city")String city,
			@RequestParam("state")String state,@RequestParam("pincode")String pincode,@RequestParam("nationality")String nationality,
			@RequestParam("accountType")String accountType,@RequestParam("salaried")String salaried,
			@RequestParam("savSbalance")String savSbalance,@RequestParam("savNbalance")String savNbalance,
			@RequestParam("overDraft")String overDraft,@RequestParam("currentBalance")String currentBalance,Model model)
	{
		account.put("accountHolderName",customerName);
		account.put("gender", gender);


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dob, formatter);
		account.put("dateOfBirth", date);

		account.put("contactNumber", contact_no);
		account.put("houseNo",houseNo);
		account.put("street",street);
		account.put("city", city);
		account.put("state",state);
		account.put("pincode",pincode);
		account.put("email",email);
		account.put("nationality",nationality);
		account.put("accountType",accountType);
		System.out.println("&************************&");

		if (accountType.equals("savingAccount")) {
			if (salaried.equals("salaried")) {
				account.put("salaried", true);
				account.put("accountBalance", savSbalance);
			} else {
				account.put("salaried", false);
				account.put("accountBalance", savNbalance);
			}
			System.out.println();
			System.out.println("Map : " +account);
			System.out.println();
			model.addAttribute("createdbankAccount",serviceLayer.addBankAccount(mmBankFactory.createNewSavingsAccount(account)));
		}
			
			else {
				account.put("odLimit", overDraft);
				account.put("accountBalance",currentBalance);
				System.out.println(mmBankFactory.createNewCurrentAccount(account));
				model.addAttribute("createdbankAccount",serviceLayer.addBankAccount(mmBankFactory.createNewCurrentAccount(account)));
			}

			return "addNewSuccess";
		}



	}	












