package dao;

import model.User;

public interface UserDao {
	
	public boolean add(User user);
	public boolean checkUser(String email,String pass);
}
