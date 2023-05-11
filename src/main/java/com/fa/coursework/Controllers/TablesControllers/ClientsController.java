package com.fa.coursework.Controllers.TablesControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import com.fa.coursework.TableClasses.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;

public class ClientsController extends Controller {

    @FXML
    private TextField nameSearch;
    @FXML
    private TableColumn<Client, String> email;

    @FXML
    private TableColumn<Client, Integer> id;

    @FXML
    private Label loginLAB;

    @FXML
    private TableColumn<Client, String> name;

    @FXML
    private TableColumn<Client, String> phone;

    @FXML
    private TableView<Client> table;

    @FXML
    void addNewClient(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddClientView.fxml", getDataBase());
    }

    @FXML
    void refreshData(ActionEvent event) {
        ObservableList<Client> client_list= FXCollections.observableArrayList();

        String select = "SELECT * FROM clients WHERE client_name LIKE '%"+nameSearch.getText().trim()+"%';";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) client_list.add(new Client(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных");
        }

        table.setItems(client_list);
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "HomeView.fxml", getDataBase());
    }


    @Override
    public void start() {
        loginLAB.setText(getDataBase().USER_LOGIN);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        refreshData(null);
    }

}
