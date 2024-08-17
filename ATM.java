package atmsim;
import java.util.Scanner;
public class ATM {
	//Check Balance, Deposit, Withdraw, Change Pin , Exit
	private int balance;
	private int pin;
	
	public ATM(int balance, int pin){ 
		this.balance = balance;
		this.pin = pin;
	}
	
	public void menuDisplay() {
		System.out.println(" ");
		System.out.println("1. Check Balance " );
		System.out.println("2. Deposit " );
		System.out.println("3. Withdrawal " );
		System.out.println("4. Change Pin " );
		System.out.println("5. Exit " );
		System.out.println("Please select any of the below options: ");
	}

	
	public void deposit(int amount) {
		balance += amount; //deposit is adding of money to balance using compound assignment
	}
	
	public void withdrawal(int amount) {   //withdrawal is subtracting of money from balance using compound assignment 
		if(balance<amount) {		// only if the withdrawal amount is greater than that of balance we can withdraw
			System.out.println("Insufficient Balance" );
			return; 
		}
		balance -= amount;
	}
	
	public int balanceEnquiry() {
		return balance;
	}
	
	public boolean isPinvalid(int pin) {
		return this.pin==pin;		//returns true or false depending upon entering of pin
	}
	
	public void changePin(int newPin) {
		pin = newPin;    //changing of pin by assigning this.pin to new pin
		System.out.println("New Pin is changed ");
		System.out.println("  ");
	}
	public static void main(String[] args) {
		ATM atm = new ATM(1000,1234);
		System.out.print("Enter the Pin: ");
		Scanner sc = new Scanner(System.in);
		int pin = sc.nextInt();
		if(atm.isPinvalid(pin)) {
			int option = 0;
			while(option !=5) {
				atm.menuDisplay();
				option = sc.nextInt();
				switch(option) {
				case 1: 
					System.out.println("Current Balance is: "+ atm.balanceEnquiry());
					break;
				case 2: 
					System.out.println("Enter the deposit amount: ");
					int amount= sc.nextInt();
					atm.deposit(amount);
					break;
				case 3: 
					System.out.println("Enter the withdrawal amount: ");
					amount= sc.nextInt();
					atm.withdrawal(amount);
					break;
				case 4: 
					System.out.println("Enter the new Pin: ");
					int newPin = sc.nextInt();
					atm.changePin(newPin);
					break;
				case 5: 
					System.out.println("Thank You for using ATM , Have a Nice Day! ");
					break;
				default:
					System.out.println("Only enter number within 1-5");
					break;
				}
			}
		}
		else {
			System.out.println("You have entered incorrect pin");
		}
	}
}
