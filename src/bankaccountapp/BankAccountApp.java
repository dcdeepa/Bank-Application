package bankaccountapp;

import java.util.LinkedList;
import java.util.List;
import utilities.CSV;

public class BankAccountApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file = "C:\\Users\\jmd\\Desktop\\Java Project\\Project\\NewBankAccounts.csv";
		
		/*Checking ch = new Checking("Tom Wilson" , "3245678", 1500);
		Saving sc = new Saving("Raz","23684738",1242);
		sc.showInfo();
		sc.deposit(5000);
		sc.withdraw(1578);
		sc.transfer("Mohan", 150);
		sc.compound();
		System.out.println("******************************");
		ch.showInfo();
		ch.deposit(45678.90);
		ch.withdraw(563);
		ch.transfer("Rohan", 5468);
		ch.compound();*/
		
		//read a csv file then create new accounts based on that data
		List<Account> account = new LinkedList<Account>();
		
		List<String[]> newCustomers = utilities.CSV.read(file);
		for(String[] Customers : newCustomers)
		{
			//System.out.println("New Account");
			String name = Customers[0];
			String sSN = Customers[1];
			String accountType = Customers[2];
			double initDeposit = Double.parseDouble(Customers[3]);
			if(accountType.equals("Savings"))
			{
				//System.out.println("Opens a Savings Account");
				account.add(new Saving(name,sSN,initDeposit));
			}
			else if(accountType.equals("Checking"))
			{
				//System.out.println("Opens a Checking Account");
				account.add(new Checking(name,sSN,initDeposit));
			}
			else
			{
				System.out.println("Error reading account type");
			}
			
		}
		
		for(Account acc : account)
		{
			System.out.println("\n****************");
			acc.showInfo();
			
		}

	}

}
