package bank_application.repository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import bank_application.entity.User;

//All data related part in Repository class

public class UserRepository {
	
	//as maintaining single copy for storing users details hence using keyword static
	
	private static Set<User>users=new HashSet<>();  
	
	static {
	
	User user1= new User("admin","admin","admin",700,new BigDecimal(1000.00));
	User user2= new User("user1","user1","user",999,new BigDecimal(1000.00));
	User user3= new User("user2","user2","user",1,new BigDecimal(0.00));
	User user4= new User("user3","user3","user",20,new BigDecimal(2000.00));
	User user5= new User("user4","user4","user",5,new BigDecimal(3000.00));

	
	users.add(user1);
	users.add(user2);
	users.add(user3);
	users.add(user4);
	users.add(user5);
	
	
	
	}
	
	public void printUsers() {
		System.out.println(users);
	}
	
	public User login(String username, String password) {
		  List<User>finalList=users.stream()
				                   .filter(user->user.getUsername().equals(username) && user.getPassword().equals(password))
		                           .collect(Collectors.toList());
		  
		  if (!finalList.isEmpty()) {
			  return finalList.get(0);
		  }
		  else {
			  return null;
		  }
	}
	public boolean addNewCustomer(String username, String password,int accountNumber) {
		User user=new User(username,password,"user",1,new BigDecimal(0.00));
		return users.add(user);
	}
	
	 public BigDecimal checkBankBalance(String username) {
	       List<User>result= users.stream().filter(user->user.getUsername().equals(username))
			               .collect(Collectors.toList());
	
	if(!result.isEmpty()) {
		return result.get(0).getAmount();
	}
	else {
		return null;
	}
    	 
    	 
     }
	 
	 public User getUser(String userid) {
		List<User>result= users.stream().filter(user->user.getUsername().equals(userid)).collect(Collectors.toList());
		if(!result.isEmpty()) {
			return result.get(0);
		}
		else {
			return null;
	}
}

		public boolean fundTransfer(String userid,String payeeUserid,BigDecimal amount) {
			
			boolean isdebit=debit(userid,amount);
			boolean iscredit=credit(payeeUserid,amount);
			
			return isdebit && iscredit;
			
			
		}
		
		
		private boolean debit(String userid,BigDecimal amount) {
			User user=getUser(userid);
			
			BigDecimal accountBalance=user.getAmount();
			
			users.remove(user);
			
			BigDecimal FinalBalance=accountBalance.subtract(amount);
			user.setAmount(FinalBalance);
			
			return users.add(user);
		}
		

       private boolean credit(String userid,BigDecimal amount) {
	       User user=getUser(userid);
	
	      BigDecimal accountBalance=user.getAmount();
	
	      users.remove(user);
	
	      BigDecimal FinalBalance=accountBalance.add(amount);
	      user.setAmount(FinalBalance);
	
	      return users.add(user);
}
       
      
    	       
       }

