package com.fa.coursework.Controllers.AddControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddClientController extends Controller {

    @FXML
    private TextField email;

    @FXML
    private Label loginLAB;

    @FXML
    private TextField name;

    @FXML
    private TextField phone;

    @FXML
    void AddNewClient(ActionEvent event) throws IOException {
        String clientName = name.getText().trim();
        if (clientName.equals("")) {
            System.out.println("Имя не указано");
            return;
        }
        String clientPhone = phone.getText().trim();
        String clientEmail = email.getText().trim();

        String update = "INSERT INTO clients (client_name, client_phone, client_email)" +
                " VALUES ('" + clientName + "', '" + clientPhone + "', '" + clientEmail + "');";
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
