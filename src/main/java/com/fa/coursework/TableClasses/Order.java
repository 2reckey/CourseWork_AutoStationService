package com.fa.coursework.TableClasses;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Order {
    private int id;
    private String clientName;
    private String sign;
    private String employeeName;
    private String service;
    private Date date;
    private Date doneDate;

    public Order(ResultSet resultSet) throws SQLException {
        id = resultSet.getInt(1);
        clientName = resultSet.getString(2);
        sign = resultSet.getString(3);
        employeeName = resultSet.getString(4);
        service = resultSet.getString(5);
        date = resultSet.getDate(6);
        doneDate = resultSet.getDate(7);
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getSign() {
        return sign;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getService() {
        return service;
    }

    public Date getDate() {
        return date;
    }

    public Date getDoneDate() {
        return doneDate;
    }
}
