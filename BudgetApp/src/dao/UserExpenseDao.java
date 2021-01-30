package dao;

import java.util.List;

import model.UserExpense;

public interface UserExpenseDao {
	
	public boolean addExpense(UserExpense exp);
	public List<UserExpense> getExpenseList(String email);

}
