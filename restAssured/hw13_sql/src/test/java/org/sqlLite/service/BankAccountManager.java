package org.sqlLite.service;

import org.sqlLite.util.DatabaseConnection;

import java.sql.*;

public class BankAccountManager extends DatabaseConnection {

    private double getCurrentBalance(int accountId) throws SQLException {
        double balance = 0.0;

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(IS_BALANCE_WITHIN_LIMITS_QUERY)) {
            pstmt.setInt(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        }
        return balance;
    }

    public void getUsersBalance() {

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(GET_USERS_BALANCE_QUERY)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("userId") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("currency") + "\t" +
                        resultSet.getDouble("total_balance"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deposit(int accountId, double amount) throws SQLException {
        if (amount <= 0 || amount > 100000000) {
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        double currentBalance = getCurrentBalance(accountId);
        double newBalance = currentBalance + amount;
        newBalance = Math.round(newBalance * 1000) / 1000.0; // Округление до трех десятичных знаков

        if (newBalance > 2000000000) {
            throw new IllegalArgumentException("Balance limit exceeded");
        }

        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ACCOUNTS_QUERY)) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        }
    }

    public void withdrawal(int accountId, double amount) throws SQLException {
        if (amount <= 0 || amount > 100000000) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        double currentBalance = getCurrentBalance(accountId);
        double newBalance = currentBalance - amount;
        newBalance = Math.round(newBalance * 1000) / 1000.0;

        if (newBalance < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }

        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_ACCOUNTS_QUERY)) {
            preparedStatement.setDouble(1, newBalance);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        }
    }
}



