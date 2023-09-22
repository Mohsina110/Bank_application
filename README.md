# Bank_application

Requirement:
Write a console program to maintain a bank branch.

At start of the program there is one account with number 999 with balance 1000 which cannot be closed.

Account numbers are positive integers and amounts are BigDecimal. 

The program should support the following commands:
• O number Should open a new account with account number supplied and balance 0 
• T source destination amount Should transfer amount from source to destination account. Source should have sufficient funds. 
• B number Should print the balance of account number supplied 
• L Should print the list of account numbers, sorted numerically ascending 
• Q Should exit the program
