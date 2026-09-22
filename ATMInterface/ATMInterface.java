import java.util.Scanner;

// ---- The Data Vault: handles balance & rules, knows nothing about console/menus ----
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false; // invalid amount
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false; // invalid amount
        }
        if (amount > balance) {
            return false; // insufficient balance
        }
        balance -= amount;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// ---- The Interface: handles menu, Scanner, messages ----
class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        int choice = -1;

        while (choice != 4) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Security Gate: validate int input before consuming it
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number (1-4): ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your current balance is: %.2f%n", account.checkBalance());
                    break;

                case 2:
                    double depositAmount = getValidAmount("Enter amount to deposit: ");
                    if (account.deposit(depositAmount)) {
                        System.out.printf("Deposit successful! New balance: %.2f%n", account.checkBalance());
                    } else {
                        System.out.println("Deposit failed! Amount must be greater than 0.");
                    }
                    break;

                case 3:
                    double withdrawAmount = getValidAmount("Enter amount to withdraw: ");
                    if (account.withdraw(withdrawAmount)) {
                        System.out.printf("Withdrawal successful! New balance: %.2f%n", account.checkBalance());
                    } else {
                        System.out.println("Withdrawal failed! Insufficient balance or invalid amount.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1-4.");
            }
        }

        sc.close();
    }

    // Helper: keeps asking until a valid double amount is entered
    private double getValidAmount(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! Enter a valid amount: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}

// ---- Entry point ----
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("ACC001", 1000.0);
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}
