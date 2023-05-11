package com.fa.coursework.Controllers.TablesControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import com.fa.coursework.TableClasses.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;

public class OrdersController extends Controller {

    @FXML
    private TableColumn<Order, String> carSign;

    @FXML
    private TableColumn<Order, String> clientName;

    @FXML
    private TableColumn<Order, Date> date;

    @FXML
    private TableColumn<Order, Date> doneDate;

    @FXML
    private TableColumn<Order, String> employeeName;

    @FXML
    private TableColumn<Order, Integer> id;

    @FXML
    private Label loginLAB;

    @FXML
    private TableColumn<Order, String> service;

    @FXML
    private TableView<Order> table;

    @FXML
    void addNewOrder(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddOrderView.fxml", getDataBase());
    }

    @FXML
    void refreshData(ActionEvent event) {
        ObservableList<Order> order_list = FXCollections.observableArrayList();

        String select = "SELECT orders.order_id, clients.client_name, cars.car_sign, " +
                "employees.employee_name, services.service_name, orders.order_date, " +
                "orders.order_done_date FROM orders JOIN cars ON cars.car_id=orders.car_id " +
                "JOIN services ON orders.service_id=services.service_id " +
                "JOIN clients ON cars.client_id=clients.client_id " +
                "JOIN employees ON orders.employee_id=employees.employee_id;";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) order_list.add(new Order(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных");
        }

        table.setItems(order_list);
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "HomeView.fxml", getDataBase());
    }

    @FXML
    void setDone() {
        Order selectedOrder = table.getSelectionModel().getSelectedItem();
        if (selectedOrder == null) {
            System.out.println("Ничего не выбранно");
            return;
        }
        if (selectedOrder.getDoneDate() != null) {
            System.out.println("Задача уже выполненна");
            return;
        }
        String update = "UPDATE orders SET order_done_date = '" + new Date(System.currentTimeMillis())
                + "' WHERE order_id = " + selectedOrder.getId();
        getDataBase().updateData(update);

        refreshData(null);
    }


    @Override
    public void start() {
        loginLAB.setText(getDataBase().USER_LOGIN);

        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        clientName.setCellValueFactory(new PropertyValueFactory<>("clientName"));
        carSign.setCellValueFactory(new PropertyValueFactory<>("sign"));
        employeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        service.setCellValueFactory(new PropertyValueFactory<>("service"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        doneDate.setCellValueFactory(new PropertyValueFactory<>("doneDate"));


        refreshData(null);
    }

}
