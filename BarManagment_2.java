package barmanagment;

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
    Scene loginScene;
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        stg = primaryStage;
        
        Login_Interface loginInterfaceInstance = new Login_Interface(this);
        loginScene = new Scene(loginInterfaceInstance, 488, 702);
        Tables_Numpad tablesNumpadInstance = new Tables_Numpad(this);
        tableNumpadScene = new Scene(tablesNumpadInstance,650,800);
        // just for testing
        password_Interface pf = new password_Interface(this);
        nextPasswordScene = new Scene(pf, 488, 702);
        
        tablesViewInterface tablesInterfaceInstnce = new tablesViewInterface(this);
         tableScene = new Scene(tablesInterfaceInstnce, 800, 800);
        tableInterface tableInterfaceInstance = new tableInterface(this);
        tableInterfaceScene = new Scene(tableInterfaceInstance,1900,1000);


        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(loginScene);
//        primaryStage.setFullScreen(true);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public void setTableInterFaceInstanceScene(){
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
    public void setTablesNumpadScene(){
        stg.setScene(tableNumpadScene);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
