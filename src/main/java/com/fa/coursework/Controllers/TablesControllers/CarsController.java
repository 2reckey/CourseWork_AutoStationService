package com.fa.coursework.Controllers.TablesControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import com.fa.coursework.TableClasses.Car;
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

public class CarsController extends Controller {

    @FXML
    private TextField nameSearch;

    @FXML
    private TextField signSearch;
    @FXML
    private TableColumn<Car, String> model;

    @FXML
    private TableColumn<Car, Integer> id;

    @FXML
    private TableColumn<Car, Integer> year;

    @FXML
    private Label loginLAB;

    @FXML
    private TableColumn<Car, String> name;

    @FXML
    private TableColumn<Car, String> sign;

    @FXML
    private TableView<Car> table;

    @FXML
    void addNewCar(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddCarView.fxml", getDataBase());
    }

    @FXML
    void refreshData(ActionEvent event) {
        ObservableList<Car> client_list = FXCollections.observableArrayList();

        String select = "SELECT cars.*, clients.client_name " +
                "FROM cars JOIN clients on cars.client_id=clients.client_id ";
        if (("".equals(signSearch.getText().trim())) == (nameSearch.getText().trim().equals(""))) {
            select += "WHERE cars.car_sign LIKE '%" + signSearch.getText().trim() + "%' " +
                    "OR clients.client_name LIKE '%" + nameSearch.getText().trim() + "%';";
        } else if (signSearch.getText().trim().equals("")) {
            select += "WHERE clients.client_name LIKE '%" + nameSearch.getText().trim() + "%';";
        } else {
            select += "WHERE cars.car_sign LIKE '%" + signSearch.getText().trim() + "%';";
        }

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) client_list.add(new Car(reSet));
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
        name.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        sign.setCellValueFactory(new PropertyValueFactory<>("sign"));
        year.setCellValueFactory(new PropertyValueFactory<>("year"));

        refreshData(null);
    }

}
