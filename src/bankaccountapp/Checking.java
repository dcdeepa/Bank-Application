package bankaccountapp;

public class Checking extends Account {
	
	//list specific properties to checking account
	private int debitCardNumber;
	private int debitCardPin;
	//constructor to intilize checking account properties
	public Checking(String name, String sSN, double initDeposit) {
		super(name , sSN , initDeposit);
		accountNumber = "2"+accountNumber;
		setDebitCardFunction();
		//System.out.println("New Checking Account"+" Account Number :"+accountNumber);
	}
	@Override
	public void setRate()
	{
		rate = getBaseRate()*1.5;
		System.out.println();
	}
	
	//list methods specific to checking account
	private void setDebitCardFunction()
	{
		debitCardNumber = (int)(Math.random()*Math.pow(10, 12));
	    debitCardPin = (int)(Math.random()*Math.pow(10, 4));
	}
	
	public void showInfo()
	{
		System.out.println("Account type :- Checking ");
		super.showInfo();
		System.out.println(
				" Your Checking Account Features "+
				"\n Debit Card Number:- "+debitCardNumber+
				"\n Debit Card Pin:- "+debitCardPin+
				"\n Rate:- "+rate
				);
	}
}
