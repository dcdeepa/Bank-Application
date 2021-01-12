package bankaccountapp;

public abstract class Account implements IBaseRate {
	
	//list common properties for saving and checking accounts
	private String name;
	private String sSN;
	private double balance;
	private static int index = 1000;
	protected String accountNumber;
	protected double rate;
	
	//constructor to set base property and initilize account
	public Account(String name, String sSN, double initDeposit) {
		this.name = name ;
		this.sSN = sSN;
		this.balance = initDeposit;
		//System.out.println("Name:- "+name+" sSN:- "+sSN+" Balance:- "+balance);
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
		//System.out.println(getBaseRate());
		
		//set account number
	}
	public abstract void setRate();
	
	private String setAccountNumber()
	{
		String lastTwoOfsSN = sSN.substring(sSN.length()-2, sSN.length());
		int uniqueID = index;
		int randomNumber =(int) (Math.random()*Math.pow(10, 3));
		return lastTwoOfsSN+uniqueID+randomNumber;
	}
	
	public void compound()
	{
		double accruedInterest = balance* (rate/100);
		System.out.println("Accrued Interest:- "+accruedInterest);
	}
	
	//List common methods
	
	public void deposit(double amount)
	{
		balance = balance + amount ;
		System.out.println(amount+" is deposited in your Account "+ accountNumber);
		printBalance();
	}
	
	public void withdraw(double amount)
	{
		balance = balance - amount;
		System.out.println(amount+" is debited from your Account "+ accountNumber);
		printBalance();
	}
	
	public void transfer(String toWhere , double amount)
	{
		balance = balance - amount;
		System.out.println("Transferening amount $ "+amount+" to "+toWhere);
		printBalance();
	}
	
	public void printBalance()
	{
		System.out.println("Your balance is now:- $"+balance);
	}
	
	public void showInfo()
	{
		System.out.println(
				"Name:- "+name+
				"\nAccount Number:- "+accountNumber+
				"\nBank Balance:- "+balance
				
				);
	}
}
