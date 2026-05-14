package concepts.oops;

public class SecuredBankAccount2 {
    private double sBalance=2000; //locked this data

    //Getter
    public double getBalance() {
        return sBalance;
    }

    //Setter
    public void deposit(double amount) {
        if (amount > 0) {
            sBalance = sBalance + amount;
            System.out.println("Deposited amount is $" + amount);
        } else {
            System.out.println("Invalid amount, amount must be positive");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= sBalance) {
            sBalance = sBalance - amount;
            System.out.println("Withdrawn amount is $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }
}

   class TestIt{
    public void demonstrateGoodPractice() {
        SecuredBankAccount2 account = new SecuredBankAccount2();
        System.out.println("The good current balance is " + account.getBalance());
        account.deposit(500);
        System.out.println("The good current balance is " + account.getBalance());
        account.getBalance();
        System.out.println("The good balance is " + account.getBalance());
        account.withdraw(200);
        System.out.println("The good balance is " + account.getBalance());
    }

    public static void main(String[] args){
        TestIt testIt = new TestIt();
        testIt.demonstrateGoodPractice();
    }
}