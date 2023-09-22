package bank_application.main;

import java.math.BigDecimal;
import java.util.Scanner;

import bank_application.entity.User;
import bank_application.service.UserService;

public class Main {
	
	static Scanner scanner=new Scanner(System.in);
	static Main main=new Main();
	static UserService userService= new UserService();

	public static void main(String[] args) {
		
		
	   while(true) {
	    	
	    
		
		System.out.println("Enter the username");
		String username=scanner.next();
		
		
		System.out.println("Enter your password");
		String password=scanner.next();
		
		
		
		User user=userService.login(username, password);
		if(user!= null && user.getRole().equals("admin")) {
			main.initAdmin();
		}
		else if(user!= null && user.getRole().equals("user")) {
			main.initCustomer(user);
		}
		else {
			System.out.println("Login Failed!!");
		}
	}
	}
        
	private void initAdmin() {
		
		boolean flag=true;
		while(flag) {
        	System.out.println("Q. Exit/logout");
        	System.out.println("O. Open a New Customer Account");
        	System.out.println("L. List all accountNumbers in ascending order");
        	
        	int selectedOption=scanner.nextInt();
        	
        	switch(selectedOption) {  
        	     case 1:
        	    	 flag=false;
        	    	 System.out.println("You have logged out!");
        	         break;
        	     case 2:
        	    	main.addNewCustomer();
        	         break;
        	       
        	     default:
        	    	 System.out.println("Wrong Option");
        	    	 
        	    	 
        	}
        	}
	}
	
	private void addNewCustomer() {
		System.out.println("Enter username");
		String username=scanner.next();
		
		System.out.println("Enter password");
		String password=scanner.next();
		
		System.out.println("Enter accountNumber");
		int accountNumber=scanner.nextInt();
		
		boolean result=userService.addNewCustomer(username, password,accountNumber);
		
		if(result) {
			System.out.println("Customer Account is created!");
		}
		else {
			System.out.println("Customer Account Creation Failed!");
		}
	}
        
     private void initCustomer(User user) {
    	 boolean flag=true;
    	 while(flag) {
    	 System.out.println("Q. Exit/logout");
    	 
    	 System.out.println("B. Check Bank Balance");
    	 
    	 System.out.println("T. Transfer Amount");
    	 
    	 int selectedOption=scanner.nextInt();
     	
     	switch(selectedOption) {  
     	     case 1:
     	    	 flag=false;
     	    	 System.out.println("You have logged out!");
     	         break;
     	    case 2:
    	         BigDecimal Balance = main.checkBankBalance(user.getUsername());
    	         if(Balance!=null) {
    	        	 System.out.println("Bank Balance is"+   Balance);
    	         }
    	         else {
    	        	 System.out.println("Check your AccountNumber");
    	         }
    	         break;   
    	         
     	   case 3:
     		   main.amountTransfer(user);
     		   break;
  	        
     	    default:
     	    	 System.out.println("Wrong Option");
     	    	 
     	    	 
     	}
    	 
	}
     }
     
     private BigDecimal checkBankBalance(String username) {
    	 return userService.checkBankBalance(username);
    	 
    	 
     }
     
     private void amountTransfer(User userdetails) {
    	 
    	 System.out.println("Enter payee Account detail userid");
    	 String payeeaccountId=scanner.next();
    	 User user=getUser(payeeaccountId);
    	 if(user!=null) {
    		 System.out.println("Please Enter Amount to Transfer");
    		 BigDecimal amount=scanner.nextBigDecimal();
    		 BigDecimal userAcountBalance=checkBankBalance(userdetails.getUsername());
    		 if(userAcountBalance.compareTo(amount)>=1) {
    			 boolean result=userService.fundTransfer(userdetails.getUsername(), payeeaccountId, amount);
    			 
    			 if(result) {
    				 System.out.println("Amount transferred successfully");
    			 }
    			 else {
    				 System.out.println("Transfer failed!!");
    			 }
    		 }
    		 else {
    			 System.out.println("You have insufficient Balance:"+userAcountBalance );
    		 }
    		 

}
    	 else {
    		 System.out.println("Please Enter Valid username");
    		 
    	 }
    	 
     }
     private User getUser(String userid) {
    	 return userService.getUser(userid);
}
     
}