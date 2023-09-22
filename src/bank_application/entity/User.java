package bank_application.entity;

import java.math.BigDecimal;
import java.util.Objects;

//Model class

public class User {
	
	private String username;
	private String password;
	private String role;
	private int accountnumber;
    private BigDecimal amount;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(int accountnumber) {
		this.accountnumber = accountnumber;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public User(String username, String password, String role, int accountnumber, BigDecimal amount) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.accountnumber = accountnumber;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", accountnumber="
				+ accountnumber + ", amount=" + amount + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountnumber, password, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return accountnumber == other.accountnumber && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	
    
    
	

}
