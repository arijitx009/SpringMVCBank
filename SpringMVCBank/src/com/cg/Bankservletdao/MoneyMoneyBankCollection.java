package com.cg.Bankservletdao;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.moneymoney.framework.account.dao.BankAccountCollection;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

public class MoneyMoneyBankCollection extends BankAccountCollection {
	
	public void removeBankAccountByAccountNumber(int accountNumberToBeRemoved) {
		for (BankAccount bankAccount : BankAccountCollection.viewAll()) {
			if (bankAccount.getAccountNumber() == accountNumberToBeRemoved) {
				BankAccountCollection.viewAll().remove(bankAccount);
				break;
			}
		}
	}
	public BankAccount getAccountByAccountNumber(int accountToBeSearched) {
		System.out.println("Account number in bank Account : "+accountToBeSearched);
		System.out.println();
		System.out.println(BankAccountCollection.viewAll());
		for (BankAccount bankAccount : BankAccountCollection.viewAll()) {
		if (bankAccount.getAccountNumber() == accountToBeSearched) {
		return bankAccount;
		}
		}
		return null;
		}
	public Collection<Customer> getCustomers() {
		List<Customer> listOfCustomer = new ArrayList<Customer>();
		for (BankAccount s : viewAll()) {
		listOfCustomer.add(s.getAccountHolder());
		}
		return listOfCustomer;
		}
	public Double withdrawAmount(int accountToDeductedFrom, double amount) {
		for (BankAccount b : viewAll()) {
		if ((b.getAccountNumber() == accountToDeductedFrom)) {
		b.withdraw(amount);
		return amount;
		}
		}
		return 0.0;
		}
	public Double depositAmount(int accountToBeDepositedIn, double amount) {
		for (BankAccount b : viewAll()) {
		if ((b.getAccountNumber() == accountToBeDepositedIn)) {
		b.deposit(amount);
		return amount;
		}
		}
		return 0.0;
		}
	
public List<BankAccount> getBankAccounts() {
		
		List<BankAccount> listOfAccounts = new ArrayList<BankAccount>();
		for (BankAccount s : viewAll()) {
			listOfAccounts.add(s);
		}
		return listOfAccounts;
	}
	public Double performFundTransfer(int receipientAccountNumber, int donorAccountNumber, double amountToBeTransffered) {
		for(BankAccount receiver : viewAll() ) {
		if(receiver.getAccountNumber() == receipientAccountNumber) {
		for(BankAccount sender : viewAll() ) {
		if(sender.getAccountNumber() == donorAccountNumber) {
		receiver.deposit(sender.withdraw(amountToBeTransffered));
		}
		}
		}
		}
		return 0.0;
		}
}

