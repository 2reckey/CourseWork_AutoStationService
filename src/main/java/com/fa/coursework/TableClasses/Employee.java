package com.fa.coursework.TableClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
    private int id;
    private String name;

    private String position;
    private String phone;
    private String email;

    private String address;

    public Employee(ResultSet resultSet) throws SQLException {
        id=resultSet.getInt(1);
        name=resultSet.getString(2);
        position=resultSet.getString(3);
        phone=resultSet.getString(4);
        email=resultSet.getString(5);
        address=resultSet.getString(6);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPosition() {
        return position;
    }
}
