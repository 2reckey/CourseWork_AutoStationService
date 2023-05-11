package com.fa.coursework.Controllers.AddControllers;

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

public class AddCarController extends Controller {

    @FXML
    private Label loginLAB;

    @FXML
    private TextField sign;

    @FXML
    private TextField model;

    @FXML
    private TextField year;

    @FXML
    private TableColumn<Client, String> nameClient;

    @FXML
    private TextField nameSearch;

    @FXML
    private TableView<Client> table;


    @FXML
    void AddNewCar(ActionEvent event) throws IOException {

        String CarSign = sign.getText().trim();
        if (CarSign.equals("")) {
            System.out.println("Не указан ГРЗ");
            return;
        }
        String CarModel = model.getText().trim();
        if (CarModel.equals("")) {
            System.out.println("Не указана модель автомобиля");
            return;
        }
        int CarYear;
        try {
            CarYear = Integer.parseInt(year.getText());
        } catch (Exception e) {
            System.out.println("Неверно указан год");
            return;
        }
        int ClientId;
        try {
            Client selectedClient = table.getSelectionModel().getSelectedItem();
            ClientId = selectedClient.getId();
        } catch (Exception e) {
            System.out.println("Клиент не выбран");
            return;
        }

        String update = "INSERT INTO cars (car_sign, car_model, car_year, client_id) " +
                "VALUES ('" + CarSign + "', '" + CarModel + "', " + CarYear + ", " + ClientId + ");";

        getDataBase().updateData(update);

        toHome(event);
    }

    @FXML
    void toAddNewClient(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddClientView.fxml", getDataBase());
    }

    @FXML
    void refreshData(ActionEvent event) {
        ObservableList<Client> client_list = FXCollections.observableArrayList();

        String select = "SELECT * FROM clients WHERE client_name LIKE '%" + nameSearch.getText().trim() + "%';";

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

        nameClient.setCellValueFactory(new PropertyValueFactory<>("name"));

        refreshData(null);
    }

}
