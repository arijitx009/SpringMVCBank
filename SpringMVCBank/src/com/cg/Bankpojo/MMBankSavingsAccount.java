package com.cg.Bankpojo;

import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.Customer;
import com.moneymoney.framework.account.pojo.SavingsAccount;

public class MMBankSavingsAccount extends SavingsAccount implements Comparable<BankAccount> {
	public MMBankSavingsAccount(Customer accountHolder, double accountBalance, boolean salary, String accountType) {
		super(accountHolder, accountBalance, salary, accountType);
		// TODO Auto-generated constructor stub
	}
	public MMBankSavingsAccount(Customer accountHolder, double accountBalance, String accountType) {
		super(accountHolder, accountBalance, accountType);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(BankAccount BankAccount) {
		return this.getAccountNumber() - BankAccount.getAccountNumber();
	}
	public double withdraw(double amountToBeWithDrawn) {
		if (this.getAccountBalance()> amountToBeWithDrawn) {
			this.setAccountBalance(this.getAccountBalance() - amountToBeWithDrawn);
			return amountToBeWithDrawn;
		}else {
			return 0;
		}
	}


}
