package com.fa.coursework.Controllers.AddControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddServiceController extends Controller {

    @FXML
    private TextField price;

    @FXML
    private Label loginLAB;

    @FXML
    private TextField name;

    @FXML
    private TextField description;

    @FXML
    void AddNewService(ActionEvent event) throws IOException {
        String ServiceName = name.getText().trim();
        if (ServiceName.equals("")) {
            System.out.println("Не указано название");
            return;
        }
        String ServiceDescription = description.getText().trim();
        if (ServiceDescription.equals("")) {
            System.out.println("Не выбранно описание");
            return;
        }

        int ServicePrice;
        try {
            ServicePrice = Integer.parseInt(price.getText());
        } catch (Exception e) {
            System.out.println("Неверно указанна цена");
            return;
        }
        String update = "INSERT INTO services (service_name, service_description, service_price)" +
                " VALUES ('" + ServiceName + "', '" + ServiceDescription + "', " + ServicePrice + ");";
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
