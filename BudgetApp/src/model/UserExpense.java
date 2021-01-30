package model;

public class UserExpense {
	
	private int id;
	private double amount;
	private String desc;
	private String email;
	public UserExpense() {

	}

	public UserExpense( double amount, String desc, String email) {
		this.amount = amount;
		this.desc = desc;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
