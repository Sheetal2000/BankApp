import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = sc.nextDouble();
                    sc.nextLine();
                    bank.addAccount(new BankAccount(accNum, name, initialBalance));
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    BankAccount depositAccount = bank.findAccount(accNum);
                    if (depositAccount != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();
                        depositAccount.deposit(depositAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    BankAccount withdrawAccount = bank.findAccount(accNum);
                    if (withdrawAccount != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    BankAccount detailAccount = bank.findAccount(accNum);
                    if (detailAccount != null) {
                        detailAccount.displayAccountDetails();
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    accNum = sc.nextLine();
                    BankAccount historyAccount = bank.findAccount(accNum);
                    if (historyAccount != null) {
                        historyAccount.displayTransactionHistory();
                    }
                    break;

                case 6:
                    System.out.println("See you again😊... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
