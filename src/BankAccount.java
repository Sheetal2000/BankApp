import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private StringBuilder transactionHistory;

    // Date-time formatter
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new StringBuilder();
        logTransaction("Account created with balance: ₹" + initialBalance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction("Deposited: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            logTransaction("Withdrew: ₹" + amount + " | New Balance: ₹" + balance);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }

    public void displayTransactionHistory() {
        System.out.println("---- Transaction History ----");
        System.out.println(transactionHistory.toString());
    }

    private void logTransaction(String details) {
        String timeStamp = LocalDateTime.now().format(formatter);
        transactionHistory.append("[").append(timeStamp).append("] ").append(details).append("\n");
    }
}
