package com.fa.coursework.TableClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {
    private int id;
    private String name;
    private String phone;
    private String email;

    public Client(ResultSet resultSet) throws SQLException {
        id=resultSet.getInt(1);
        name=resultSet.getString(2);
        phone=resultSet.getString(3);
        email=resultSet.getString(4);
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
}
