package com.fa.coursework.TableClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {
    private int id;
    private String name;
    private String description;
    private int price;

    public Service(ResultSet resultSet) throws SQLException {
        id=resultSet.getInt(1);
        name=resultSet.getString(2);
        description=resultSet.getString(4);
        price=resultSet.getInt(3);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
