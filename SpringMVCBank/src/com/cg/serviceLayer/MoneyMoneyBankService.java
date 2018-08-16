package com.cg.serviceLayer;

import java.util.Collection;

import com.cg.Bankservletdao.MoneyMoneyBankCollection;
import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;

public class MoneyMoneyBankService {
	MoneyMoneyBankCollection bankCollection = new MoneyMoneyBankCollection();
	public BankAccount addBankAccount(BankAccount bankAccount) {
		bankCollection.addBankAccount(bankAccount);
		return bankAccount;
	}
	public void removeBankAccountByAccountNumber(int accountNumberToBeRemoved) {
		bankCollection.removeBankAccountByAccountNumber(accountNumberToBeRemoved);
	}
	public BankAccount getAccountByAccountNumber(int accountToBeSearched) {
		return bankCollection.getAccountByAccountNumber(accountToBeSearched);
		
	}
	
	
	public Collection<BankAccount> getBankAccounts() {
		return bankCollection.getBankAccounts();
	}
	public Collection<Customer> getCustomers() {
		return bankCollection.getCustomers();
	}
	public Double withdrawAmount(int accountToDeductedFrom, double amount) {
		return bankCollection.withdrawAmount(accountToDeductedFrom, amount);
	}
	public Double depositAmount(int accountToBeDepositedIn, double amount) {
		return bankCollection.depositAmount(accountToBeDepositedIn, amount);
	}
	public Double performFundTransfer(int receipientAccountNumber, int donerAccountNumber, double amountToBeTransffered) {
		return bankCollection.performFundTransfer(receipientAccountNumber, donerAccountNumber, amountToBeTransffered);
	}

}
