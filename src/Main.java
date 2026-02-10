import java.util.Scanner;

// Base Class: Account
class Account {
    // protected property
    protected double balance;

    public Account(double init_balance) {
        if (init_balance > 0) {
            this.balance = init_balance;
        } else {
            this.balance = 0;
            System.out.println("Invalid amount entered!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }
}

// Child Class: SavingsAccount
class SavingsAccount extends Account {
    private float interestRate;

    public SavingsAccount(double init_balance, float rate) {
        super(init_balance); // referring to the Super/Base/Parent class Account
        this.interestRate = rate;
    }

    public double calcInterest() {
        return balance * interestRate;
    }
}

// Child Class: CheckingAccount
class CheckingAccount extends Account {
    private double transactionFee;

    public CheckingAccount(double init_balance, double fee) {
        super(init_balance);
        this.transactionFee = fee;
    }

    @Override
    public boolean withdraw(double amount) {
        amount += transactionFee;
        if (super.withdraw(amount)) {
            return true;
        }
        return false;
    }
}

public class Main {
    static void main(String[] args) {

        // Create Scanner object to accept user input
        Scanner sc = new Scanner(System.in);

        // Initialize Account objects
        SavingsAccount savings = new SavingsAccount(1000, 0.05f);
        CheckingAccount checking = new CheckingAccount(5000, 2.50);

        // Account security
        int userPin = 1234;
        int attempts = 0;
        boolean authenticated = false;

        System.out.println("**********  Welcome to Wilbank! **********");

        while (attempts < 3 && !authenticated) {
            System.out.println("Enter your PIN (Attempt " + (attempts + 1) + "): ");
            int enteredPin = sc.nextInt();

            if (enteredPin == userPin) {
                authenticated = true;
            } else {
                attempts++;
                System.out.println("Invalid PIN. Attempts remaining: " + (3 - attempts));
            }
        }

        if(!authenticated) {
            System.out.println("Account locked. Please contact support.");
            return;
        }

        // Interactive user menu
        int choice = 0;
        while(choice != 5) {
            System.out.println("\n----MAIN MENU----");
            System.out.println("1. View Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Apply Interest (5%)");
            System.out.println("5. Exit");
            System.out.println("Selection: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Savings: $%.2f | Checking: $%.2f\n",
                            savings.getBalance(), checking.getBalance());
                    break;
                case 2:
                    System.out.println("Amount to deposit: ");
                    savings.deposit(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Amount to withdraw: ");
                    double amount = sc.nextDouble();
                    if (checking.withdraw(amount)) {
                        System.out.println("Withdrawal successful.");
                    }
                    break;
                case 4:
                    double interest = savings.calcInterest();
                    savings.deposit(interest);
                    System.out.printf("Interest of $%.2f added.\n", interest);
                    break;
                case 5:
                    System.out.println("Thanks for using Wilbank. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        // close scanner object
        sc.close();

    }
}
 