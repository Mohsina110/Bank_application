package bank_application.service;

import java.math.BigDecimal;

import bank_application.entity.User;
import bank_application.repository.UserRepository;

public class UserService {
	UserRepository userRepository=new UserRepository();
	public void printUsers() {
		userRepository.printUsers();
	}
		public User login(String username,String password) {
			return userRepository.login(username,password);
		}
		
		public boolean addNewCustomer(String username, String password,int accountNumber) {
			return userRepository.addNewCustomer(username, password,accountNumber);
	}
		
		 public BigDecimal checkBankBalance(String username) {
			 return userRepository.checkBankBalance( username);
	    	 
	    	 
	     }
		 
		public User getUser(String userid) {
			return userRepository.getUser(userid);
}
		
		public boolean fundTransfer(String userid,String payeeUserid,BigDecimal amount) {
			
			return userRepository.fundTransfer(userid, payeeUserid, amount);
			
			
		}
		
		 
		
}

