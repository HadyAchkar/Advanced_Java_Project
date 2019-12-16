package barmanagment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class password_Interface extends BorderPane {

    private GridPane passwordGrid;
    private Button[] buttons;
    private final int size = 10;
    private PasswordField passwordField;
    private Label passwordLbl;
    private VBox passwordVBoxTop;
    int counter = 0;
    private Button btClear;
    private Button btClearAll;
    private Button btEnter;
    private HBox passwordHBoxBot;
    private int row, column;
    private HBox passwordHboxTop;
    private BarManagment_2 stg;

    public password_Interface(BarManagment_2 stg) {
        this.stg = stg;
        passwordGrid = new GridPane();
        buttons = new Button[size];
        passwordHboxTop = new HBox(10);
        passwordField = new PasswordField();
        passwordField.requestFocus();
        passwordField.setDisable(false);
        passwordField.setFont(Font.font(40));
        passwordField.setMinSize(300, 40);
        passwordField.setStyle("-fx-font-weight:BOLD;");
        passwordHboxTop.setMaxWidth(470);
        passwordHboxTop.setMinWidth(470);
        passwordHboxTop.setMinHeight(40);
        passwordHboxTop.setAlignment(Pos.CENTER);
        passwordGrid.setScaleX(1.45);
        passwordGrid.setMinWidth(465);
        passwordGrid.setMaxWidth(465);
        this.setStyle("-fx-background-color:#D3D3D3");
        passwordLbl = new Label("Password");
        passwordLbl.setStyle("-fx-background-color:#F9D342;-fx-font-size:25;-fx-font-weight:BOLD;");
        passwordLbl.setAlignment(Pos.CENTER);
        passwordLbl.setMinSize(120, 85);
        passwordField.setStyle("-fx-background-color:#F9D342;-fx-font-color:#292826");
        passwordVBoxTop = new VBox(10);
        btClear = new Button("CLEAR");
        btClearAll = new Button("CLEAR ALL");
        btEnter = new Button("ENTER");
        passwordHBoxBot = new HBox(10);
        passwordHboxTop.setStyle("-fx-border-width: 4;-fx-border-color:#292826");
        passwordHboxTop.setPadding(new Insets(10, 5, 10, 15));
        btEnter.setOnAction((e) -> {
            if (this.checkPassword()) {
                stg.setTablesNumpadScene();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
            }
        });
        this.passwordField.setOnAction(e -> {
            if (this.checkPassword()) {
                stg.setTablesNumpadScene();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Look, an Error Dialog");
                alert.setContentText("Ooops, there was an error!");
                alert.showAndWait();
            }
        });
        passwordField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = passwordField.getText().charAt(oldValue.intValue());
                    // Check if the new character is the number or other's
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just setText to previous one
                        if (passwordField.getLength() > 0) {
                            passwordField.setText(passwordField.getText(0, passwordField.getLength() - 1));
                        }

                    }
                }
            }
        });
//        btClear.setMinSize(150, 100);
        btClearAll.setMinSize(150, 100);
        btEnter.setMinSize(460, 90);
        btEnter.setStyle("-fx-Color:#292826;-fx-font-size:48;-fx-font-weight:BOLD");
        passwordVBoxTop.getChildren().addAll(passwordLbl, passwordField);
        passwordVBoxTop.setAlignment(Pos.CENTER);
//        while (counter < 9) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    Button bt = new Button(String.valueOf((counter + 1));
//                    bt.setMinSize(100,100);
//                    passwordGrid.add(bt, j, i);
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
//          bt.setOnAction(e-> {passwordField.setText(passwordField.getText() + bt.getText());});
            bt.setOnAction(e -> {
                passwordField.appendText(bt.getText());
            });
            if (n == 10) {
                bt.setText("CLEAR");
                bt.setStyle("-fx-Color:#292826;-fx-font-size:20;-fx-font-weight:BOLD");
                bt.setOnAction(e -> {
                    if (passwordField.getLength() > 0) {
                        passwordField.setText(passwordField.getText(0, passwordField.getLength() - 1));
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
                    passwordField.clear();
                });
            }
            passwordGrid.setVgap(10);
            passwordGrid.setHgap(10);
            passwordGrid.add(bt, column, row);
        }
        passwordHboxTop.getChildren().addAll(passwordLbl, passwordField);
        this.setBottom(passwordHBoxBot);
        this.setCenter(passwordGrid);
        this.setTop(passwordHboxTop);
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setStyle("-fx-border-color : black;");
        passwordGrid.setAlignment(Pos.CENTER);
        passwordHBoxBot.getChildren().add(btEnter);
        passwordHBoxBot.setAlignment(Pos.CENTER);
    }

    public boolean checkPassword() {
        String p = "123";
        return (passwordField.getText().equals(p));
    }

    public GridPane getLoginGrid() {
        return passwordGrid;
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
        return passwordVBoxTop;
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
        return passwordHBoxBot;
    }

    public int getSize() {
        return size;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Label getLoginLbl() {
        return passwordLbl;
    }

    public VBox getLoginHBox() {
        return passwordVBoxTop;
    }
}
