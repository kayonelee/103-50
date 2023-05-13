import java.text.DecimalFormat; //formatting to two decimal places
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccount {
    private double balance;
    private String accountHolder;
    private int accountNumber;
    private static int nextAccountNumber = 2030; //ADDED RANDOM NEXT ACCOUNT NUMBER FOR USER

    public BankAccount(double balance, String accountHolder, int accountNumber) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber; //ADDED ACCT NUMBER
    }

    public BankAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.print("What is the name of the account holder? ");
        this.accountHolder = input.nextLine();

        System.out.print("Can you tell me the beginning balance for the account? ");
        this.balance = input.nextDouble();

        this.accountNumber = nextAccountNumber;
        nextAccountNumber++;
    }

//DEPOSIT METHOD-takes a double amount to deposit as the parameter. Add the passed amount to the account balance.
    public void deposit(double amount) {
        balance += amount;
    }

//WITHDRAWAL METHOD-takes a double amount to withdraw as the parameter. Subtract the passed amount from the account balance.
    public void withdrawal(double amount) {
        balance -= amount;
    }
//ACCOUNT DETAIL METHOD-Print+empty line for spacing/formatting
    public void accountDetails() {
        DecimalFormat currencyFormat = new DecimalFormat("$#,##0.00");
        String formattedBalance = currencyFormat.format(balance);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name of Account: " + accountHolder);
        System.out.println("Current Balance: " + formattedBalance);
        System.out.println();
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(); //VARIABLE DECLARATION CREATING NEW ARRAYLIST-HOLD LIST OF OBJECT
        Scanner input = new Scanner(System.in);

        BankAccount account1 = new BankAccount(500.00, "Kayone Lee", 1001); //ADDED ACCT NUMBERS FOR TODAYS ASSIGNMENT
        BankAccount accountTom = new BankAccount(5000.00, "Tommy Lee", 1002); //ADDED ACCT NUMBERS FOR TODAYS ASSIGNMENT
        BankAccount accountTim = new BankAccount(300.00, "Tim Lee", 1003); //ADDED ACCT NUMBERS FOR TODAYS ASSIGNMENT

        BankAccount newAccount = new BankAccount();
        accounts.add(newAccount);
        accounts.add(account1);   //ADDED SO TRANSFER CAN READ ACCT NUMBER 1001
        accounts.add(accountTom); //ADDED SO TRANSFER CAN READ ACCT NUMBER 1002
        accounts.add(accountTim); //ADDED SO TRANSFER CAN READ ACCT NUMBER 1003


        System.out.println("Greetings, " + newAccount.accountHolder + "!");
        System.out.println(); //JUST FOR SPACING/FORMATTING PURPOSES

        mainMenu(newAccount, accounts);

        System.out.println("Thank you for choosing CTAC banking system. Goodbye!");
    }


    public static void mainMenu(BankAccount currentAccount, ArrayList<BankAccount> accounts) {
        Scanner input = new Scanner(System.in);

//ADDED WHILE LOOP TO CONTINUE RUNNING UNTIL A USER SELECTS ONE OF THE FOLLOWING OPTION-OTHERWISE PROMPT INVALID MESSAGE
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdrawal Request");
            System.out.println("3. Deposit Request");
            System.out.println("4. Transfer Funds");
            System.out.println("0. EXIT");

            int choice = input.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                currentAccount.accountDetails();
            } else if (choice == 2) {
                System.out.print("Enter the dollar amount: ");
                double amount = input.nextDouble();
                currentAccount.withdrawal(amount);
                System.out.println("Your withdrawal of " + amount + " was successfully completed.");
                currentAccount.accountDetails();
            } else if (choice == 3) {
                System.out.print("Enter the dollar amount: ");
                double amount = input.nextDouble();
                currentAccount.deposit(amount);
                System.out.println("Your deposit of " + amount + " was successfully completed.");
                currentAccount.accountDetails();
            } else if (choice == 4) {
                System.out.print("Enter the dollar amount: ");
                double amount = input.nextDouble();
                System.out.print("Transfer to Account Number: ");
                int accountNumber = input.nextInt();
                boolean found = false;
                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == accountNumber) {
                        account.deposit(amount);
                        currentAccount.withdrawal(amount);
                        found = true;
                        System.out.println("Your transfer of " + amount + " to account " + accountNumber + " was successfully completed.");
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid Account Number, please try again.");
                }
                currentAccount.accountDetails();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

