package org.sqlLite.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    protected static final String ADD_EMPLOYEE_QUERY = "INSERT INTO Users(name, address) VALUES(?,?)";
    protected static final String ADD_ACCOUNTS_QUERY = "INSERT INTO Accounts(userId, balance, currency) VALUES(?,?,?)";
    protected static final String IS_USER_CAN_ADD_ACCOUNT_QUERY = "SELECT COUNT(*) FROM Accounts WHERE userId = ? AND currency = ?";
    protected static final String UPDATE_ACCOUNTS_QUERY = "UPDATE Accounts SET balance = balance + ? WHERE accountId = ?";
    protected static final String IS_BALANCE_WITHIN_LIMITS_QUERY = "SELECT balance FROM Accounts WHERE accountId = ?";
    protected static final String SELECT_ALL_USERS_QUERY = "SELECT * FROM Users";
    protected static final String SELECT_USERS_ACCOUNTS_TRANSACTIONS_JOIN_QUERY =
            "SELECT * FROM Users\n" +
                    "JOIN Accounts ON Users.userId = Accounts.userId\n" +
                    "JOIN Transactions ON Accounts.accountId = Transactions.accountId";
    protected static final String GET_USERS_BALANCE_QUERY = "SELECT " +
            "    Users.userId,\n" +
            "    Users.name,\n" +
            "    Accounts.currency,\n" +
            "    SUM(Accounts.balance) as total_balance\n" +
            "FROM \n" +
            "    Users\n" +
            "FULL JOIN \n" +
            "    Accounts ON Users.userId = Accounts.userId\n" +
            "GROUP BY \n" +
            "    Users.name, Accounts.currency\n";

    private static final String CONNECTION_STRING_URL = "jdbc:sqlite:C:\\Users\\alex.panaev\\sqlite.db";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
