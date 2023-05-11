package com.fa.coursework.Controllers.AddControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import com.fa.coursework.TableClasses.Car;
import com.fa.coursework.TableClasses.Client;
import com.fa.coursework.TableClasses.Employee;
import com.fa.coursework.TableClasses.Service;
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
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;

public class AddOrderController extends Controller {

    @FXML
    private Label loginLAB;

    @FXML
    private TableView<Service> ServiceTable;

    @FXML
    private TableView<Car> carTable;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Car, String> carSign;

    @FXML
    private TableColumn<Employee, String> employeeName;

    @FXML
    private TableColumn<Service, String> serviceName;

    @FXML
    private TextField nameEmployeeSearch;

    @FXML
    private TextField nameServiceSearch;

    @FXML
    private TextField signCarSearch;

    @FXML
    void AddNewOrder(ActionEvent event) throws IOException {
        int carID;
        try {
            Car selectedCar = carTable.getSelectionModel().getSelectedItem();
            carID = selectedCar.getId();
        } catch (Exception e) {
            System.out.println("Машина не выбрана");
            return;
        }
        int employeeId;
        try {
            Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
            employeeId = selectedEmployee.getId();
        } catch (Exception e) {
            System.out.println("Сотрудник не выбран");
            return;
        }
        int serviceId;
        try {
            Service selectedClient = ServiceTable.getSelectionModel().getSelectedItem();
            serviceId = selectedClient.getId();
        } catch (Exception e) {
            System.out.println("Услуга не выбрана");
            return;
        }
        Date orderDate = new Date(System.currentTimeMillis());

        String update = "INSERT INTO orders (car_id, employee_id, service_id, order_date) " +
                "VALUES (" + carID + ", " + employeeId + ", " + serviceId + ", '" + orderDate + "');";

        getDataBase().updateData(update);

        toHome(event);
    }

    @FXML
    void refreshAllData(ActionEvent event) {
        refreshCarData(event);
        refreshEmployeeData(event);
        refreshServiceData(event);
    }

    @FXML
    void refreshCarData(ActionEvent event) {
        ObservableList<Car> car_list = FXCollections.observableArrayList();

        String select = "SELECT *, 0 FROM cars " +
                "WHERE car_sign LIKE '%" + signCarSearch.getText().trim() + "%';";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) car_list.add(new Car(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных машин");
        }

        carTable.setItems(car_list);
        carTable.sort();
    }

    @FXML
    void refreshEmployeeData(ActionEvent event) {
        ObservableList<Employee> employee_list = FXCollections.observableArrayList();

        String select = "SELECT * FROM employees " +
                "WHERE employee_name LIKE '%" + nameEmployeeSearch.getText().trim() + "%';";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) employee_list.add(new Employee(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных сотрудников");
        }

        employeeTable.setItems(employee_list);
    }

    @FXML
    void refreshServiceData(ActionEvent event) {
        ObservableList<Service> service_list = FXCollections.observableArrayList();

        String select = "SELECT * FROM services " +
                "WHERE service_name LIKE '%" + nameServiceSearch.getText().trim() + "%';";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) service_list.add(new Service(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных услуг");
        }

        ServiceTable.setItems(service_list);
    }

    @FXML
    void toAddNewCar(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddCarView.fxml", getDataBase());
    }

    @FXML
    void toAddNewEmployee(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddEmployeeView.fxml", getDataBase());
    }

    @FXML
    void toAddNewService(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddServiceView.fxml", getDataBase());
    }

    @FXML
    void toHome(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "HomeView.fxml", getDataBase());
    }

    @Override
    public void start() {
        loginLAB.setText(getDataBase().USER_LOGIN);

        carSign.setCellValueFactory(new PropertyValueFactory<>("sign"));
        employeeName.setCellValueFactory(new PropertyValueFactory<>("name"));
        serviceName.setCellValueFactory(new PropertyValueFactory<>("name"));

        refreshAllData(null);
    }

}
