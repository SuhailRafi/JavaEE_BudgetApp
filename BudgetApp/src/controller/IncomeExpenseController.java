package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserExpense;
import model.UserIncome;
import util.StaticProperty;

@WebServlet("/incExp")
public class IncomeExpenseController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String description = request.getParameter("desc");
		double value = Integer.parseInt(request.getParameter("value"));
		HttpSession session  = request.getSession();
		String email = (String)session.getAttribute("userEmail");
	
		if(type.contentEquals("inc")) {
			UserIncome income = new UserIncome();
			income.setAmount(value);
			income.setDesc(description);
			income.setEmail(email);
			StaticProperty.userIncomeDao.addIncome(income);
		}
	
		else {
			UserExpense expense = new UserExpense();
			expense.setAmount(value);
			expense.setDesc(description);
			expense.setEmail(email);
			StaticProperty.userExpenseDao.addExpense(expense);
		}
		
		response.sendRedirect("home");
	}
}
