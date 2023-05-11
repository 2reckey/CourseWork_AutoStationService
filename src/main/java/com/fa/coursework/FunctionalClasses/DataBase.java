package com.fa.coursework.FunctionalClasses;

import java.sql.*;

public class DataBase extends Const {
    private Connection connection;

    public String USER_LOGIN;

    private final String URL = "jdbc:mysql://" + dbHost + dbPort + dbName;

    public void setConnection() {
        try {
            connection = DriverManager.getConnection(URL, dbUser, dbPass);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к серверу");
        }
    }

    public boolean isUserInBase(String login, int hashPassword) {
        String select = "SELECT * FROM users WHERE user_login = ? AND user_hashpass = ?;";
        PreparedStatement PrSt = getPrSt(select);
        try {
            PrSt.setString(1, login);
            PrSt.setInt(2, hashPassword);
            ResultSet reSet = PrSt.executeQuery();

            return reSet.next();
        } catch (SQLException e) {
            System.out.println("Ошибка получения результатов из базы данных при попытке войти");
            return false;
        }
    }

    public ResultSet getReSet(String select) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(select);
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных");
            return null;
        }
    }

    public void updateData(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(update);
        } catch (SQLException e) {
            System.out.println("Ошибка при обновлении данных");
        }
    }

    public PreparedStatement getPrSt(String select) {
        try {
            PreparedStatement PrSt = connection.prepareStatement(select);
            return PrSt;
        } catch (SQLException e) {
            System.out.println("Ошибка получения результатов из базы данных");
            return null;
        }
    }
}
