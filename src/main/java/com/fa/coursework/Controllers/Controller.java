package com.fa.coursework.Controllers;

import com.fa.coursework.FunctionalClasses.DataBase;

public abstract class Controller{

    private DataBase database=new DataBase();
    public DataBase getDataBase() {
        return database;
    }

    public void setDataBase(DataBase database) {
        this.database = database;
    }
     public void start(){}
}
