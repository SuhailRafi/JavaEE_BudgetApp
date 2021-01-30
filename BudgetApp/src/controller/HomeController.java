package controller;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class HomeController
 */

@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String email = (String)session.getAttribute("userEmail");
		List<UserExpense> expenseList = StaticProperty.userExpenseDao.getExpenseList(email);
		List<UserIncome> incomeList = StaticProperty.userIncomeDao.getIncomeList(email);
		
		request.setAttribute("incomeList", incomeList);
		request.setAttribute("expenseList", expenseList);
		
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
