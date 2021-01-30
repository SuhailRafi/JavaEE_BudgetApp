package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UserExpense;
import model.UserIncome;
import util.DatabaseConnection;

public class UserIncomeDaoImpl implements UserIncomeDao {

	@Override
	public boolean addIncome(UserIncome exp) {

		Connection con = DatabaseConnection.getConnection();
		String sql="insert into user_income (amount, description,email) values(?,?,?)";

		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setDouble(1, exp.getAmount());
			p.setString(2, exp.getDesc() );
			p.setString(3, exp.getEmail() );
			
			p.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public List<UserIncome> getIncomeList(String email) {

		List<UserIncome> ls = new ArrayList<UserIncome>();
		Connection con = DatabaseConnection.getConnection();
		String sql="select * from user_income where email=?";

		try {
			PreparedStatement p = con.prepareStatement(sql);
			p.setString(1,email );
			
			ResultSet rs = p.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getDouble("amount"));
				UserIncome in = new UserIncome();
				in.setAmount(rs.getDouble("amount"));
				in.setEmail(rs.getString("email"));
				in.setDesc(rs.getString("description"));
				in.setId(rs.getInt("id"));
				ls.add(in);
				
			}
//			return true;
		} catch (SQLException e) {
//			return false;
		}
		
		return ls;
	}
}
