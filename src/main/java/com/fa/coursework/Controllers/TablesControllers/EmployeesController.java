package com.fa.coursework.Controllers.TablesControllers;

import com.fa.coursework.Controllers.Controller;
import com.fa.coursework.FunctionalClasses.Const;
import com.fa.coursework.TableClasses.Employee;
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

public class EmployeesController extends Controller {

    @FXML
    private TextField nameSearch;
    @FXML
    private TableColumn<Employee, String> email;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private Label loginLAB;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, String> phone;

    @FXML
    private TableColumn<Employee, String> position;

    @FXML
    private TableColumn<Employee, String> address;

    @FXML
    private TableView<Employee> table;

    @FXML
    void addNewEmployee(ActionEvent event) throws IOException {
        Const.ReplaceView(event, "AddView/AddEmployeeView.fxml", getDataBase());
    }

    @FXML
    void refreshData(ActionEvent event) {
        ObservableList<Employee> employee_list = FXCollections.observableArrayList();

        String select = "SELECT * FROM employees WHERE employee_name LIKE '%" + nameSearch.getText().trim() + "%';";

        try {
            ResultSet reSet = getDataBase().getReSet(select);
            while (reSet.next()) employee_list.add(new Employee(reSet));
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных");
        }

        table.setItems(employee_list);
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
        position.setCellValueFactory(new PropertyValueFactory<>("position"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));

        refreshData(null);
    }

}
