package com.cg.Bankpojo;

import com.moneymoney.framework.account.pojo.BankAccount;
import com.moneymoney.framework.account.pojo.CurrentAccount;
import com.moneymoney.framework.account.pojo.Customer;

public class MMBankCurrentAccount extends CurrentAccount implements Comparable<BankAccount>{
public MMBankCurrentAccount(Customer accountHolder, double accountBalance, double odLimit, String accountType) {
super(accountHolder, accountBalance, odLimit,accountType);

// TODO Auto-generated constructor stub
}
@Override
public int compareTo(BankAccount currentAccount) {
return this.getAccountNumber()-currentAccount.getAccountNumber();
}
public double withdraw(double amountToBeWithDrawn) {
if(this.getAccountBalance()+this.getOdLimit()>amountToBeWithDrawn) {
this.setAccountBalance(this.getAccountBalance()-amountToBeWithDrawn);
return amountToBeWithDrawn;
}else {
return 0;
}
}
}







