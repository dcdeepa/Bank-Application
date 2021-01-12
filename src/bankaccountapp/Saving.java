package bankaccountapp;

public class Saving extends Account {
	
	//list specific properties to saving account
	private int safetyDepositBoxID;
	private int safetyDepositBoxKey;
	
	//constructor to intilize saving account properties
	public Saving(String name, String sSN, double initDeposit) {
		super(name , sSN , initDeposit);
		//System.out.println("New Savings Account");
		accountNumber = "1"+accountNumber;
		//System.out.println("New Savings Account"+" Account Number :"+accountNumber);
		setSafetyDepositBox();

	}
	
	@Override
	public void setRate()
	{
		rate = getBaseRate()-0.25;
	}
	
	//list methods specific to saving account
	
	private void setSafetyDepositBox()
	{
		safetyDepositBoxID = (int)(Math.random()*Math.pow(10, 3));
		safetyDepositBoxKey = (int)(Math.random()*Math.pow(10, 4));
		//System.out.println(safetyDepositBoxID);
	}
	public void showInfo()
	{
		System.out.println("Account type :- Savings ");
		super.showInfo();
		System.out.println(
				" Your Savings Account features "+
				"\n Safety Deposit Box ID:- "+safetyDepositBoxID+
				"\n Safety Deposit Box Key:- "+safetyDepositBoxKey+
				"\n Rate:- "+rate
				);
	}

}
