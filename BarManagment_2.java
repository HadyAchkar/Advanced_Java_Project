package Bar_Managment_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BarManagment_2 extends Application {
    private Scene nextScene;
    private Stage stg;
    
    @Override
    public void start(Stage primaryStage) {
        stg = primaryStage;
        Login_Interface lg = new Login_Interface(this);
        Scene loginScene = new Scene(lg,488,702);
        
        
        
        // just for testing
        Button b = new Button("fff");
        nextScene = new Scene(b,488,702);
        
//        StackPane stk = new StackPane(new Button("test"));
//        Scene scene = new Scene(stk, 1920, 1080);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setNextScene(){
        stg.setScene(nextScene);
        System.out.print("Changed");
    }
}
