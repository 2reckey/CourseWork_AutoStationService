package com.fa.coursework.Controllers;

import com.fa.coursework.FunctionalClasses.Const;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HomeController extends Controller {

    @FXML
    private Label loginLAB;

    @FXML
    void toClients(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"TablesView/ClientsView.fxml",getDataBase());
    }

    @FXML
    void toNewOrder(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"AddView/AddOrderView.fxml",getDataBase());
    }

    @FXML
    void toOrders(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"TablesView/OrdersView.fxml",getDataBase());
    }

    @FXML
    void toCars(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"TablesView/CarsView.fxml",getDataBase());
    }


    @FXML
    void toEmployees(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"TablesView/EmployeesView.fxml",getDataBase());
    }

    @FXML
    void toServices(ActionEvent event) throws IOException {
        Const.ReplaceView(event,"TablesView/ServicesView.fxml", getDataBase());
    }

    @Override
    public void start() {
        loginLAB.setText(getDataBase().USER_LOGIN);
    }

}
