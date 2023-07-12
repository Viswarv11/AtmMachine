import java.util.Scanner;

class Bank{
    private int balance=10000;
    public int getBalance() {
        return balance;
    }
    public  int deposit(int amount) throws InvalidAmountException {
        if(amount<0){
            throw new InvalidAmountException("Please enter a valid Amount");
        }else{
            this.balance=balance+amount;
        }
        return getBalance();
    }
    public  void withdraw(int initialamount,int amount) throws InvalidAmountException, InsufficientFundsException {
        if(amount<=initialamount && amount>=0){
            this.balance=balance-amount;
            System.out.println("Your amount "+amount+" has been withdrawn. Remaining "+getBalance());
        }else if(amount<0){
            throw new InvalidAmountException("The amount is Invalid");
        }else{
            throw new InsufficientFundsException("The amount is exceeded ");
        }

    }
}
public class AtmMachine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Bank b1=new Bank();
        System.out.println("Balance "+b1.getBalance());

        try {
            int option;
            do {
                System.out.println("1.Withdraw\n2.CheckBalance\n3.Deposit\n4.Exit");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter the amount to be Withdrawn: ");
                        int amount = scanner.nextInt();
                        b1.withdraw(b1.getBalance(), amount);
                        break;
                    case 2:
                        System.out.println("Your A/c Balance is: " + b1.getBalance());
                        break;
                    case 3:
                        System.out.println("Enter the amount to be Deposited: ");
                        int amount1 = scanner.nextInt();
                        System.out.println("Your current Balance :" + b1.deposit(amount1));
                        break;
                    case 4:
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid Option");
                }
            } while (option != 4);

        }
        catch (InvalidAmountException | InsufficientFundsException exception){
            System.out.println(exception);
        }

    }

}
class InvalidAmountException extends Exception{

    public InvalidAmountException(String errorMessage) {
        super(errorMessage);

    }

}
class InsufficientFundsException extends Exception{

    public InsufficientFundsException(String errorMessage) {
   super(errorMessage);
    }
}