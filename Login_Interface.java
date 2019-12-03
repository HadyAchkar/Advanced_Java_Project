package advanced_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Login_Interface extends BorderPane {

    private GridPane loginGrid;
    private Button[] buttons;
    private final int size = 10;
    private TextField loginTextField;
    private Label loginLbl;
    private VBox loginVBoxTop;
    int counter = 0;
    private Button btClear;
    private Button btClearAll;
    private Button btEnter;
    private HBox loginHBoxBot;

    public Login_Interface() {
        loginGrid = new GridPane();
        buttons = new Button[size];
        loginTextField = new TextField();
        loginTextField.setMinSize(200, 100);
        
        
        loginLbl = new Label("Login");
        loginLbl.setMinSize(100, 100);
        loginVBoxTop = new VBox(10);
        
        btClear = new Button("Clear");
        btClearAll = new Button("Clear All");
        btEnter = new Button("Enter");
        loginHBoxBot = new HBox(10);
        
        btClear.setMinSize(150, 100);
        btClearAll.setMinSize(150, 100);
        btEnter.setMinSize(150, 100);
//        loginVBoxTop.setMinWidth(this.getWidth()/12);
//        loginVBoxTop.setMinHeight(this.getWidth()/12);
//        loginVBoxTop.prefHeightProperty().bind(this.heightProperty());
//        loginVBoxTop.prefWidthProperty().bind(this.widthProperty());
//        loginGrid.prefHeightProperty().bind(this.heightProperty());
//        loginGrid.prefHeightProperty().bind(this.heightProperty());

        loginVBoxTop.getChildren().addAll(loginLbl, loginTextField);
        loginVBoxTop.setAlignment(Pos.CENTER);
        this.setTop(loginVBoxTop);

        while (counter < 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    Button bt = new Button(String.valueOf(counter + 1));
                    bt.setMinSize(100,100);
                    loginGrid.add(bt, j, i);
                    counter++;
                }
            }
        }
        
        this.setBottom(loginHBoxBot);
        this.setCenter(loginGrid);
        loginGrid.setAlignment(Pos.CENTER);
        loginHBoxBot.getChildren().addAll(btClear, btClearAll, btEnter);
        loginHBoxBot.setAlignment(Pos.CENTER);
        
        this.setPadding(new Insets(10,10,10,10));
        this.setStyle("-fx-border-color : black;");
    }

    public GridPane getLoginGrid() {
        return loginGrid;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public VBox getLoginHBoxTop() {
        return loginVBoxTop;
    }

    public int getCounter() {
        return counter;
    }

    public Button getBtClear() {
        return btClear;
    }

    public Button getBtClearAll() {
        return btClearAll;
    }

    public Button getBtEnter() {
        return btEnter;
    }

    public HBox getLoginHBoxBot() {
        return loginHBoxBot;
    }

    public int getSize() {
        return size;
    }

    public TextField getLoginTextField() {
        return loginTextField;
    }

    public Label getLoginLbl() {
        return loginLbl;
    }

    public VBox getLoginHBox() {
        return loginVBoxTop;
    }

}
