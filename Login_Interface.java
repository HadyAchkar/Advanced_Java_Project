package barmanagment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

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
    private int row, column;
    private HBox loginHboxTop;
    private BarManagment_2 stg;

    public Login_Interface(BarManagment_2 stg) {
        this.stg = stg;
        loginGrid = new GridPane();
        buttons = new Button[size];
        loginHboxTop = new HBox(10);
        loginTextField = new TextField();
        loginTextField.setDisable(false);
        loginTextField.setFont(Font.font(40));
        loginTextField.setMinSize(300, 40);
        loginTextField.setStyle("-fx-font-weight:BOLD;");
        loginTextField.requestFocus();
        loginHboxTop.setMaxWidth(470);
        loginHboxTop.setMinWidth(470);
        loginHboxTop.setMinHeight(40);
        loginHboxTop.setAlignment(Pos.CENTER);
        loginGrid.setScaleX(1.45);
        loginGrid.setMinWidth(465);
        loginGrid.setMaxWidth(465);
        this.setStyle("-fx-background-color:#D3D3D3");
        loginLbl = new Label("Your ID");
        loginLbl.setStyle("-fx-background-color:#F9D342;-fx-font-size:30;-fx-font-weight:BOLD;");
        loginLbl.setAlignment(Pos.CENTER);
        loginLbl.setMinSize(120, 85);
        loginTextField.setStyle("-fx-background-color:#F9D342;-fx-font-color:#292826");
        loginVBoxTop = new VBox(10);
        btClear = new Button("CLEAR");
        btClearAll = new Button("CLEAR ALL");
        btEnter = new Button("ENTER");
        loginHBoxBot = new HBox(10);
        loginHboxTop.setStyle("-fx-border-width: 4;-fx-border-color:#292826");
        loginHboxTop.setPadding(new Insets(10, 5, 10, 15));
        btEnter.setOnAction((e) -> {
            if (checkID()) {
                stg.setPasswordScene();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
            }
        });

        this.loginTextField.setOnAction(e -> {
            if (checkID()) {
                stg.setPasswordScene();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
            }
        });
        loginTextField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = loginTextField.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (loginTextField.getLength() > 0) {
                            loginTextField.setText(loginTextField.getText(0, loginTextField.getLength() - 1));
                        }

                    }
                }
            }
        });
        btClear.setMinSize(150, 100);
        btClearAll.setMinSize(150, 100);
        btEnter.setMinSize(460, 90);
        btEnter.setStyle("-fx-Color:#292826;-fx-font-size:48;-fx-font-weight:BOLD");
        loginVBoxTop.getChildren().addAll(loginLbl, loginTextField);
        loginVBoxTop.setAlignment(Pos.CENTER);

//        while (counter < 9) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    Button bt = new Button(String.valueOf((counter + 1));
//                    bt.setMinSize(100,100);
//                    loginGrid.add(bt, j, i);
//                    counter++;
//                }
//            }
//        }
        for (int n = 1; n <= 12; n++) {
            row = (n - 1) / 3;
            column = n - (3 * row) - 1;
            Button bt = new Button(n + "");
            bt.setMinSize(100, 100);
            bt.setStyle("-fx-Color:#F9D342;-fx-font-size:28;-fx-font-weight:BOLD");
//          bt.setOnAction(e-> {loginTextField.setText(loginTextField.getText() + bt.getText());});
            bt.setOnAction(e -> {
                loginTextField.appendText(bt.getText());
            });
            if (n == 10) {
                bt.setText("CLEAR");
                bt.setStyle("-fx-Color:#292826;-fx-font-size:20;-fx-font-weight:BOLD");
                bt.setOnAction(e -> {
                    if (loginTextField.getLength() > 0) {
                        loginTextField.setText(loginTextField.getText(0, loginTextField.getLength() - 1));
                    } else {
                        return;
                    }
                });
            }
            if (n == 11) {
                bt.setText("0");
                bt.setStyle("-fx-Color:#F9D342;-fx-font-size:28;-fx-font-weight:BOLD");

            }
            if (n == 12) {
                bt.setText("CLEAR ALL");
                bt.setStyle("-fx-Color:#292826;-fx-font-size:20;-fx-font-weight:BOLD");
                bt.setWrapText(true);
                bt.setPrefSize(USE_PREF_SIZE, USE_PREF_SIZE);
                bt.setTextAlignment(TextAlignment.CENTER);
                bt.setOnAction(e -> {
                    loginTextField.clear();
                });
            }
            loginGrid.setVgap(10);
            loginGrid.setHgap(10);
            loginGrid.add(bt, column, row);
        }
        loginHboxTop.getChildren().addAll(loginLbl, loginTextField);
        this.setBottom(loginHBoxBot);
        this.setCenter(loginGrid);
        this.setTop(loginHboxTop);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setStyle("-fx-border-color : black;");

        loginGrid.setAlignment(Pos.CENTER);
        loginHBoxBot.getChildren().add(btEnter);
        loginHBoxBot.setAlignment(Pos.CENTER);
    }

    public boolean checkID() {
        String u1 = "123";
        return (loginTextField.getText().equals(u1));
    }

    public GridPane getLoginGrid() {
        return loginGrid;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
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

    public String getLoginTextFieldData() {
        return this.getLoginTextFieldData();
    }

}
