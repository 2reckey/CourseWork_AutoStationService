package com.fa.coursework.Controllers;

import com.fa.coursework.FunctionalClasses.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AuthorizationController extends Controller {

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    void signIn(ActionEvent event) throws IOException {
        getDataBase().USER_LOGIN = LoginField.getText().trim();

        int hashPassword = (getDataBase().USER_LOGIN + "@" + PasswordField.getText().trim()).hashCode();

        if (getDataBase().isUserInBase(getDataBase().USER_LOGIN, hashPassword))
            Const.ReplaceView(event, "HomeView.fxml", getDataBase());
        else {
            System.out.println("Неверный логин или пароль");
            LoginField.clear();
            PasswordField.clear();
        }
    }

    @Override
    public void start() {
        getDataBase().setConnection();
    }


}