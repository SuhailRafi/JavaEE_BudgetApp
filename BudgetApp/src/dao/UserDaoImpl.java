package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import util.DatabaseConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean add(User user) {
		
		Connection con = DatabaseConnection.getConnection();
		String sql="insert into user values(?,?,?)";

		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, user.getEmail());
			p.setString(2, user.getName() );
			p.setString(3, user.getPassword() );
			
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean checkUser(String email,String pass) {

		Connection con = DatabaseConnection.getConnection();
		String sql="select * from user where email=? and password=? ";

		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1, email);
			p.setString(2, pass);
			ResultSet rs = p.executeQuery();
//			System.out.println(rs.getFetchSize());
//			System.out.println("++++++++++++");
			if(rs.next()) {
//				System.out.println("*********");
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
