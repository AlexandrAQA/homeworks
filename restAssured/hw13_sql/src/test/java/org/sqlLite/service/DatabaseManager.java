package org.sqlLite.service;

import org.sqlLite.util.DatabaseConnection;

import java.sql.*;

public class DatabaseManager extends DatabaseConnection {

    public void addUser(String name, String address) {

        try (Connection connection = this.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_EMPLOYEE_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAccount(int userId, double balance, String currency) {

        if (!isUserCanAddAccount(userId, currency)) {
            System.out.println("This user already has an account in this currency.");
            return;
        }

        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(ADD_ACCOUNTS_QUERY)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setDouble(2, balance);
            preparedStatement.setString(3, currency);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isUserCanAddAccount(int userId, String currency) {

        try (Connection conn = this.connect();
             PreparedStatement preparedStatement = conn.prepareStatement(IS_USER_CAN_ADD_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, currency);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) == 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private void addTransaction(int accountId, double amount) {
        String sql = "INSERT INTO Transactions(accountId, amount) VALUES(?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            pstmt.setDouble(2, amount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectAllUsers() {

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS_QUERY)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("userId") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("address"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectUsersAccountsTransactions() {

        try (Connection connection = this.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_USERS_ACCOUNTS_TRANSACTIONS_JOIN_QUERY)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("userId") + "\t" +
                        resultSet.getString("name") + "\t" +
                        resultSet.getString("address") + "\t" +
                        resultSet.getInt("accountId") + "\t" +
                        resultSet.getDouble("balance") + "\t" +
                        resultSet.getString("currency") + "\t" +
                        resultSet.getInt("transactionId") + "\t" +
                        resultSet.getDouble("amount"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
