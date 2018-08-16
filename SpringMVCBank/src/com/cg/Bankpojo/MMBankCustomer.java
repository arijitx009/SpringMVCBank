package com.cg.Bankpojo;

import java.time.LocalDate;

import com.moneymoney.framework.account.pojo.Address;
import com.moneymoney.framework.account.pojo.Customer;

public class MMBankCustomer extends Customer{
	public MMBankCustomer(String customerName, long contactNumber, LocalDate dateOfBirth,
			Address permanentAddress, String nationality, String gender) {
		super(customerName, contactNumber, dateOfBirth, permanentAddress, nationality, gender);
		// TODO Auto-generated constructor stub
	} 
}
