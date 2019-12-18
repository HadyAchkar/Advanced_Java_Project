package testing;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BarManagment_2 extends Application {

    private Scene nextPasswordScene;
    private Stage stg;
    private Scene tableScene;
    private Scene tableNumpadScene;
    private Scene tableInterfaceScene;
    private Login_Interface loginInterfaceInstance;
    private tablesViewInterface tablesInterfaceInstnce;
    private tableInterface tableInterfaceInstance;
    private password_Interface passwordFieldInstance;
    private Scene loginScene;

    @Override

    public void start(Stage primaryStage) throws FileNotFoundException {
        stg = primaryStage;

        loginInterfaceInstance = new Login_Interface(this);
        loginScene = new Scene(loginInterfaceInstance, 488, 702);

        Tables_Numpad tablesNumpadInstance = new Tables_Numpad(this);
        tableNumpadScene = new Scene(tablesNumpadInstance, 650, 800);
        // just for testing
        passwordFieldInstance = new password_Interface(this);
        nextPasswordScene = new Scene(passwordFieldInstance, 488, 702);

        tablesInterfaceInstnce = new tablesViewInterface(this);
        tableScene = new Scene(tablesInterfaceInstnce, 800, 800);
        tableInterfaceInstance = new tableInterface(this);
        tableInterfaceScene = new Scene(tableInterfaceInstance, 1900, 1000);
        loginInterfaceInstance.getStylesheets().add(getClass().getResource("aragorn.css").toString());
        passwordFieldInstance.getStylesheets().add(getClass().getResource("aragorn.css").toString());
        tablesInterfaceInstnce.getStylesheets().add(getClass().getResource("aragorn.css").toString());
        tableInterfaceInstance.getStylesheets().add(getClass().getResource("aragorn.css").toString());

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(loginScene);
//        primaryStage.setFullScreen(true);
        primaryStage.show();
        primaryStage.setResizable(true);
    }

    public void setTableInterFaceInstanceScene() {
        stg.setScene(tableInterfaceScene);
        stg.setMaximized(true);
    }

    public void setPasswordScene() {
        stg.setScene(nextPasswordScene);
//        stg.setMaximized(true);
//        stg.setFullScreen(true);
    }

    public void setTableScene() {
        stg.setScene(tableScene);
    }

    public void setTablesNumpadScene() {
        stg.setScene(tableNumpadScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
