package org.sqlLite.runner;

import org.sqlLite.service.BankAccountManager;
import org.sqlLite.service.DatabaseManager;

import java.sql.SQLException;
import java.util.Scanner;

public class Application {

    private static DatabaseManager dbManager = new DatabaseManager();
    static BankAccountManager bankAccountManager = new BankAccountManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Choose one of the following:" +
                "\n1 - New user registration\n2 - Adding an account to a new user" +
                "\n3 - deposit\n4 - withdrawal\n5 - print all users" +
                "\n6 - print all users, accounts and transactions data" +
                "\n7 - get all users balance");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                registerUser();
                break;
            case 2:
                addAccount();
                break;
            case 3:
                depositToAccount(true);
                break;
            case 4:
                withdrawFromAccount();
                break;
            case 5:
                printAllUsers();
                break;
            case 6:
                printAllUsersAccountsTransactionsData();
                break;
            case 7:
                getAllUsersBalance();
                break;
        }
    }

    public static void registerUser() {

        System.out.println("Enter username:");
        String name = scanner.nextLine();
        System.out.println("Enter address:");
        String address = scanner.nextLine();
        dbManager.addUser(name, address);
    }

    public static void addAccount() {

        System.out.println("Enter User ID:");
        int userId = scanner.nextInt();
        System.out.println("Enter starting balance:");
        double balance = scanner.nextDouble();
        System.out.println("Enter currency:");
        scanner.nextLine();
        String currency = scanner.nextLine();
        dbManager.addAccount(userId, balance, currency);
    }

    public static void depositToAccount(boolean deposit) {

        System.out.println("Enter User ID:");
        int accountId = scanner.nextInt();
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        if (!deposit) {
            amount = -amount;
        }
        try {
            bankAccountManager.deposit(accountId, amount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void withdrawFromAccount() {
        System.out.println("Введите ID аккаунта:");
        int accountId = scanner.nextInt();
        System.out.println("Введите сумму снятия:");
        double amount = scanner.nextDouble();
        try {
            bankAccountManager.withdrawal(accountId, amount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deposit(int accountId, double amount) {
        try {
            bankAccountManager.deposit(accountId, amount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void printAllUsers() {
        dbManager.selectAllUsers();
    }

    public static void printAllUsersAccountsTransactionsData() {
        dbManager.selectUsersAccountsTransactions();
    }

    public static void getAllUsersBalance() {
        bankAccountManager.getUsersBalance();
    }
}
