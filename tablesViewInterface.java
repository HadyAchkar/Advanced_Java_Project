package barmanagment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Date;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class tablesViewInterface extends BorderPane {

    private HBox hboxTop;
    private HBox hboxBot;
    private VBox vboxRight;
    private GridPane gridPaneTables;
    private int row, column;
    private Button btBack;
    private Button btLogout;
    private Image imageBack;
    private ImageView imgViewLogo;
    private Time currentTime;
    private Date currentDate;
    private FileInputStream input;
    private Button btTest1;
    private Button btTest2;
    private Button btTest3;
    private Button btTest4;

    public tablesViewInterface(BarManagment_2 stg) throws FileNotFoundException {
        hboxTop = new HBox();
        hboxBot = new HBox();
        vboxRight = new VBox();
        btBack = new Button("Back");
//        input = new FileInputStream("img/backicon");
//        imageBack = new Image(input);
//        imgViewLogo = new ImageView(imageBack);
        btLogout = new Button("Logout");
//        currentTime = new Time(row);
//        currentDate = new Date();
        btTest1 = new Button("test1");
        btTest2 = new Button("test2");
        btTest3 = new Button("test3");
        btTest4 = new Button("test4");
        
        btBack.setOnAction(e->{stg.setTablesNumpadScene();});
        gridPaneTables = new GridPane();
        hboxTop.getChildren().addAll(btBack,btLogout);
        hboxTop.setAlignment(Pos.TOP_RIGHT);
        hboxTop.setMinHeight(150.0);
        vboxRight.getChildren().addAll(btTest1,btTest2);
        hboxBot.getChildren().addAll(btTest3,btTest4);
        hboxBot.setAlignment(Pos.BASELINE_RIGHT);
        gridPaneTables.setAlignment(Pos.TOP_LEFT);
        hboxBot.setMinHeight(150.0);
        addbtnGrid();

        this.setCenter(gridPaneTables);
        this.setTop(hboxTop);
        this.setBottom(hboxBot);
    }

    public void addbtnGrid() {
        for (int n = 1; n <= 9; n++) {
            row = (n - 1) / 3;
            column = n - (3 * row) - 1;
            Button bt = new Button(n + "");
            bt.setMinSize(100, 100);
//          bt.setOnAction(e-> {loginTextField.setText(loginTextField.getText() + bt.getText());});
            bt.setOnAction(e -> {
                System.out.println("test");
            });
            gridPaneTables.add(bt, column, row);
        }

    }

}
