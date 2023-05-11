module com.fa.coursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.fa.coursework to javafx.fxml;
    exports com.fa.coursework;
    exports com.fa.coursework.Controllers;
    opens com.fa.coursework.Controllers to javafx.fxml;
    exports com.fa.coursework.TableClasses;
    opens com.fa.coursework.TableClasses to javafx.fxml;
    exports com.fa.coursework.Controllers.TablesControllers;
    opens com.fa.coursework.Controllers.TablesControllers to javafx.fxml;
    exports com.fa.coursework.Controllers.AddControllers;
    opens com.fa.coursework.Controllers.AddControllers to javafx.fxml;
}