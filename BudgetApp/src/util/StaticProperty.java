package util;

import dao.UserDaoImpl;
import dao.UserExpenseDaoImpl;
import dao.UserIncomeDaoImpl;
import model.User;

public class StaticProperty {
	
	public static UserDaoImpl userDao;
	public static User user;
	public static UserExpenseDaoImpl userExpenseDao;
	public static UserIncomeDaoImpl userIncomeDao;
	
	static {
		userDao = new UserDaoImpl();
		user = new User();
		userExpenseDao = new UserExpenseDaoImpl();
		userIncomeDao = new UserIncomeDaoImpl();
	}
}
