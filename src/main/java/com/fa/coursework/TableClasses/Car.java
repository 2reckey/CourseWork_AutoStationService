package com.fa.coursework.TableClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {
    private int id;
    private String sign;
    private String model;

    private int year;
    private String clientName;

    public Car(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt(1);
        sign = resultSet.getString(2);
        model = resultSet.getString(3);
        year = resultSet.getInt(4);
        clientName = resultSet.getString(6);
    }

    public int getId() {
        return id;
    }


    public String getSign() {
        return sign;
    }

    public String getModel() {
        return model;
    }

    public String getClientName() {
        return clientName;
    }

    public int getYear() {
        return year;
    }
}
