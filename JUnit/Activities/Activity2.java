package Demo;

public class Activity2 {
	
	    private Integer balance;
	    
	    // Create a constructor
	    public Activity2(Integer initialBalance) {
	        balance = initialBalance;
	    }

	  
	    public Integer withdraw(Integer amount) {
	        if (balance < amount) {
	            throw new NotEnoughFundsException(amount, balance);
	        }
	        balance -= amount;
	        return balance;
	    }
	}


