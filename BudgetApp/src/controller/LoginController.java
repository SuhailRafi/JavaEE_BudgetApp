package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
import util.StaticProperty;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		boolean check = StaticProperty.userDao.checkUser(email, pass);
		if(check == true) {
			HttpSession session = request.getSession();
			session.setAttribute("userEmail", email);
			//response.sendRedirect("welcome.jsp");
			response.sendRedirect("home");
		}
		
		else {
			PrintWriter pw = response.getWriter();
				pw.write("<h1 align=\"center\">Sign in Failed...!</h1");
				RequestDispatcher rd = request.getRequestDispatcher("signIn.html");
				rd.include(request,response);	
		}
	}

}
