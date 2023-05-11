package com.fa.coursework.Controllers.AddControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddEmployeeController extends Controller {

    @FXML
    private TextField email;

    @FXML
    private Label loginLAB;

    @FXML
    private TextField name;

    @FXML
    private TextField position;

    @FXML
    private TextField address;

    @FXML
    private TextField phone;

    @FXML
    void AddNewEmployee(ActionEvent event) throws IOException {
        String EmployeeName = name.getText().trim();
        if (EmployeeName.equals("")) {
            System.out.println("Имя не указанно");
            return;
        }
        String EmployeePosition = position.getText().trim();
        if (EmployeePosition.equals("")) {
            System.out.println("Не указанна должность");
            return;
        }
        String EmployeePhone = phone.getText().trim();
        if (EmployeePhone.equals("")) {
            System.out.println("Не указан номер мобильного телефона");
            return;
        }
        String EmployeeEmail = email.getText().trim();
        if (EmployeeEmail.equals("")) {
            System.out.println("Не указан адресс электронной почты");
            return;
        }
        String EmployeeAddress = address.getText().trim();
        if (EmployeeAddress.equals("")) {
            System.out.println("Не указан адрес проживания");
            return;
        }

        String update = "INSERT INTO employees (employee_name, employee_position, " +
                "employee_phone, employee_email, employee_address)" +
                " VALUES ('" + EmployeeName + "', '" + EmployeePosition + "', '" +
                EmployeePhone + "', '" + EmployeeEmail + "', '" + EmployeeAddress + "');";

        getDataBase().updateData(update);

        toHome(event);
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "HomeView.fxml", getDataBase());
    }

    @Override
    public void start() {
        loginLAB.setText(getDataBase().USER_LOGIN);
    }

}
