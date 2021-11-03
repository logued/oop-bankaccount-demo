package dkit.oop;

/**
 * A BankAccount has an account number and
 * a balance that can be changed by deposits and withdrawals.
 *
 * A static (or class) variable "lastAssignedNumber" is used to
 * maintain a sequence account number to be used as the account number
 * for initializing the next BankAccount object created.
 */
public class BankAccount {
    private double balance;
    private int accountNumber;

    // Class variables are defined using "static" keyword
    private static int nextBankAccountNumber = 1000;  // Bank Account number
    // 'static' makes this a class variable, so all objects share this one
    // variable.  (i.e. each object does not have its own instance )

    public static final double OVERDRAFT_FEE = 20.00;  // final => can't be changed after initialization

    // constructors
    public BankAccount() {
        accountNumber = nextBankAccountNumberr; // assign value from static variable to instance
        nextBankAccountNumber++;
        balance = 0.00;
    }

    public BankAccount(double initialBalance) {
        accountNumber = nextBankAccountNumber;
        nextBankAccountNumber++;
        balance = initialBalance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            balance = balance - amount;
            balance = balance - OVERDRAFT_FEE; // deduct fee
        } else {
            balance = balance - amount;
        }
    }

    // adds interest (at year end?) to the current balance based on a rate
    public void addInterest(double rate) {
        balance = balance + FinancialUtility.percentOf(rate, balance);
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
