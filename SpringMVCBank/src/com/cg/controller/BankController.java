package com.cg.controller;

import java.io.IOException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.factory.MMBankFactory;
import com.cg.serviceLayer.MoneyMoneyBankService;
/**
 * Servlet implementation class BankController
 */
@WebServlet("*.app")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MMBankFactory mmBankFactory = new MMBankFactory();
		Map<String,Object> account=new HashMap<>();
		HttpSession session = request.getSession();
		MoneyMoneyBankService serviceLayer = new MoneyMoneyBankService();
		String name = request.getServletPath();
		System.out.println(name);
		switch (name) {
		case "/addNewAccount.app":
			System.out.println("HELLO");
			account.put("accountHolderName", request.getParameter("customerName"));
			account.put("gender", request.getParameter("gender"));
			String dob = request.getParameter("dob");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dob, formatter);
			account.put("dateOfBirth", date);
			account.put("contactNumber", request.getParameter("contact_no"));
			account.put("houseNo", request.getParameter("houseNo"));
			account.put("street", request.getParameter("street"));
			account.put("city", request.getParameter("city"));
			account.put("state", request.getParameter("state"));
			account.put("pincode", request.getParameter("pincode"));
			account.put("email", request.getParameter("email"));
			account.put("nationality", request.getParameter("nationality"));
			account.put("accountType", request.getParameter("accountType"));
			System.out.println("&************************&");
			if (request.getParameter("accountType").equals("savingAccount")) {
				if (request.getParameter("salaried").equals("salaried")) {
					account.put("salaried", true);
					account.put("accountBalance", request.getParameter("savSbalance"));
				} else {
					account.put("salaried", false);
					account.put("accountBalance", request.getParameter("savNbalance"));
				}
				System.out.println();
				System.out.println("Map : " +account);
				System.out.println();
				System.out.println(mmBankFactory.createNewSavingsAccount(account));
				serviceLayer.addBankAccount(mmBankFactory.createNewSavingsAccount(account));
				session.setAttribute("createdbankAccount", mmBankFactory.createNewSavingsAccount(account));
				response.sendRedirect("addNewSuccess.jsp");
			} else {
				account.put("odLimit", request.getParameter("overDraft"));
				account.put("accountBalance", request.getParameter("currentbalance"));
				System.out.println(mmBankFactory.createNewCurrentAccount(account));
				serviceLayer.addBankAccount(mmBankFactory.createNewCurrentAccount(account));
				session.setAttribute("createdbankAccount", mmBankFactory.createNewCurrentAccount(account));
				response.sendRedirect("addNewSuccess.jsp");
			}
			break;
		case "/viewAccount.app":
			System.out.println("*********************1");
			String accountToSearched = request.getParameter("typedAccount");
			int accountToSearched2 = Integer.parseInt(accountToSearched);
			System.out.println("Account number : "+ accountToSearched2);
			System.out.println(serviceLayer.getAccountByAccountNumber(accountToSearched2));
			System.out.println("*********************2");
			session.setAttribute("createdbankAccount", serviceLayer.getAccountByAccountNumber(accountToSearched2));
			System.out.println("*********************3");
			response.sendRedirect("viewAccount.jsp");
			break;
			
		case "/viewAllAccount.app":
			System.out.println("All Accounts : " + serviceLayer.getBankAccounts());
			session.setAttribute("BankAccounts", serviceLayer.getBankAccounts());
			response.sendRedirect("viewAllCustomers.jsp");
			break;


		case "/depositForm.app":
			String accountNumber = request.getParameter("typedAccount");
			int accountNumber2 = Integer.parseInt(accountNumber);
			session.setAttribute("accountInDeposit", accountNumber2);
			String Amount = request.getParameter("typedAmount");
			double Amount2 = Integer.parseInt(Amount);
			session.setAttribute("amountInDeposit", Amount2);
			double check = serviceLayer.depositAmount(accountNumber2, Amount2);
			if (check == 0.0) {
				response.sendRedirect("errorDeposit.jsp");
			} else {
				response.sendRedirect("depositSuccess.jsp");
			}
			break;

		case "/withdraw.app":
			accountNumber = request.getParameter("typedAccount");
			accountNumber2 = Integer.parseInt(accountNumber);
			session.setAttribute("accountInWithdraw", accountNumber2);
			Amount = request.getParameter("typedAmount");
			Amount2 = Integer.parseInt(Amount);
			session.setAttribute("amountInWithdraw", Amount2);
			check = serviceLayer.depositAmount(accountNumber2, Amount2);
			if (check == 0.0) {
				response.sendRedirect("errorWithdraw.jsp");
			} else {
				Map<Integer, Integer> denomination = new HashMap<Integer, Integer>();
				denomination = giveDenominations(check);
				System.out.println("deno : "+denomination.values());
				System.out.println("\n");
				session.setAttribute("denomination", denomination);
				response.sendRedirect("withdrawSuccess.jsp");
			}
			break;

		case "/fundTransfer.app":
			String typedFromAccount = request.getParameter("typedFromAccount");
			int typedFromAccount2 = Integer.parseInt(typedFromAccount);
			session.setAttribute("accountInWithdrawTransfer", typedFromAccount2);
			String typedToAccount = request.getParameter("typedToAccount");
			int typedToAccount2 = Integer.parseInt(typedToAccount);
			session.setAttribute("accountInDepositTransfer", typedToAccount2);
			Amount = request.getParameter("typedAmount");
			Amount2 = Integer.parseInt(Amount);
			session.setAttribute("amountInTransfer", Amount2);

			check = serviceLayer.performFundTransfer(typedToAccount2, typedFromAccount2, Amount2);
			if (check == 0.0) {
				response.sendRedirect("errorfundTransfer.jsp");
			} else {
				response.sendRedirect("fundTransferSuccess.jsp");
			}
			break;
		}
	}

	private Map<Integer, Integer> giveDenominations(double check) {
		Map<Integer, Integer> denomination = new HashMap<Integer, Integer>();
		if (check >= 2000) {
			denomination.put(2000, (int) check / 2000);
			check %= 2000;
		}
		if (check >= 500) {
			denomination.put(500, (int) check / 500);
			check %= 500;
		}
		if (check >= 200) {
			denomination.put(200, (int) check / 200);
			check %= 200;
		}
		if (check >= 100) {
			denomination.put(100, (int) check / 100);
			check %= 100;
		}
		if (check >= 50) {
			denomination.put(50, (int) check / 50);
			check %= 50;
		}
		if (check >= 10) {
			denomination.put(10, (int) check / 10);
			check %= 10;
		}
		if (check >= 1) {
			denomination.put(1, (int) check / 1);
			check %= 1;
		}
		return denomination;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
