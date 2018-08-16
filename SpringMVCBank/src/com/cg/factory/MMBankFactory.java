package com.cg.factory;

import java.util.Map;
import java.time.LocalDate;

import com.cg.Bankpojo.MMBankCurrentAccount;
import com.cg.Bankpojo.MMBankCustomer;
import com.cg.Bankpojo.MMBankCustomerAddress;
import com.cg.Bankpojo.MMBankSavingsAccount;
import com.moneymoney.framework.account.pojo.CurrentAccount;
import com.moneymoney.framework.account.pojo.SavingsAccount;
import com.moneymoney.framework.factory.BankFactory;

public class MMBankFactory extends BankFactory {
	MMBankCurrentAccount mmBankCurrentAccount;
	MMBankSavingsAccount mmBankSavingAccount;
	MMBankCustomer mmBankCustomer;
	MMBankCustomerAddress mmBankCustomerAddress;
	@Override
	public CurrentAccount createNewCurrentAccount(Map<String, Object> map) {
		mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(), map.get("street").toString(),
				map.get("city").toString(), map.get("state").toString(), Integer.parseInt(map.get("pincode").toString()));
		mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(),Long.parseLong((map.get("contactNumber").toString())),
				 (LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress, map.get("nationality").toString(),
				map.get("gender").toString());
		mmBankCurrentAccount = new MMBankCurrentAccount(mmBankCustomer, Double.parseDouble((map.get("accountBalance").toString())),
				Double.parseDouble((map.get("odLimit").toString())), map.get("accountType").toString());
		System.out.println(mmBankCustomerAddress);
		System.out.println(mmBankCustomer);
		return mmBankCurrentAccount;
	}
	@Override
	public SavingsAccount createNewSavingsAccount(Map<String, Object> map) {
		mmBankCustomerAddress = new MMBankCustomerAddress(map.get("houseNo").toString(),
				map.get("street").toString(), map.get("city").toString(), map.get("state").toString(),
				Integer.parseInt(map.get("pincode").toString()));
		mmBankCustomer = new MMBankCustomer(map.get("accountHolderName").toString(),
				Long.parseLong((map.get("contactNumber").toString())), (LocalDate) map.get("dateOfBirth"), mmBankCustomerAddress,
				map.get("nationality").toString(), map.get("gender").toString());
		mmBankSavingAccount = new MMBankSavingsAccount(mmBankCustomer, Double.parseDouble((map.get("accountBalance").toString())),
				(boolean) map.get("salaried"), map.get("accountType").toString());
		System.out.println(mmBankCustomerAddress);
		System.out.println(mmBankCustomer);
		System.out.println(mmBankSavingAccount);
		return mmBankSavingAccount;
	}
}


