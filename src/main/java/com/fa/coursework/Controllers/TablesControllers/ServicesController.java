package com.fa.coursework.Controllers.TablesControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import com.fa.coursework.TableClasses.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.ResultSet;

public class ServicesController extends Controller {

    @FXML
    private TableColumn<Service, Integer> price;

    @FXML
    private TableColumn<Service, Integer> id;

    @FXML
    private Label loginLAB;

    @FXML
    private TableColumn<Service, String> name;

    @FXML
    private TableColumn<Service, String> description;

    @FXML
    private TableView<Service> table;

    @FXML
    void addNewService(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddServiceView.fxml", getDataBase());
    }

    @FXML
    void refreshData(ActionEvent event) {
        ObservableList<Service> service_list = FXCollections.observableArrayList();

        String select = "SELECT * FROM services;";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) service_list.add(new Service(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных");
        }

        table.setItems(service_list);
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
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        refreshData(null);
    }

}
