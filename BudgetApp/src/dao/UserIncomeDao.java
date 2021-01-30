package dao;

import java.util.List;

import model.UserExpense;
import model.UserIncome;

public interface UserIncomeDao {
	
	public boolean addIncome(UserIncome exp);
	public List<UserIncome> getIncomeList(String email);
}
