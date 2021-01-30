package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
import util.StaticProperty;

@WebServlet("/signUp")
public class SignUpController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name")	;
		String email = request.getParameter("email")	;
		String pass = request.getParameter("password")	;
		
		System.out.println(name + email + pass);
		
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setPassword(pass);
		boolean check = StaticProperty.userDao.add(user);
		PrintWriter pw = response.getWriter();

		if(check == true) {
			pw.write("<h1 align=\"center\">Sign Up Successfully...!</h1");
			RequestDispatcher rd = request.getRequestDispatcher("signIn.html");
			rd.include(request,response);
		}

		else {
			pw.write("<h1 align=\"center\">Sign Up Failed...!</h1");
			RequestDispatcher rd = request.getRequestDispatcher("signUp.html");
			rd.include(request,response);
		}
	}
}
