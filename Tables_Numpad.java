package barmanagment;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

class Tables_Numpad extends BorderPane {

    private VBox vboxTop;
    private HBox hboxBot;
    private Label lblChooseTable;
    private GridPane gridTablesNumpad;
    private Button btEnter;
    private Button btClear;
    private Button btClearAll;
    private TextField tableNumberTextField;
    private int row, column;
    private HBox hboxVboxInner;

    public Tables_Numpad(BarManagment_2 stg) {
        hboxVboxInner = new HBox();
        vboxTop = new VBox();
        hboxBot = new HBox();
        lblChooseTable = new Label("Choose your table");
        gridTablesNumpad = new GridPane();
        btEnter = new Button("Enter");
        btClear = new Button("Clear");
        btClearAll = new Button("Clear All");
        tableNumberTextField = new TextField();

        //add children
        hboxBot.getChildren().add(btEnter);
        vboxTop.getChildren().addAll(lblChooseTable, hboxVboxInner);
        hboxVboxInner.getChildren().add(tableNumberTextField);
        //node styles
        lblChooseTable.setStyle("-fx-font-size:24;-fx-font-color:#292826;-fx-font-weight:BOLD");
        lblChooseTable.setPadding(new Insets(0, 0, 10, 0));
        btEnter.setMinSize(520, 90);
        btEnter.setStyle("-fx-Color:#292826;-fx-font-size:48;-fx-font-weight:BOLD");
        gridTablesNumpad.setScaleX(1.65);
        gridTablesNumpad.setScaleY(1.2);
        gridTablesNumpad.setMinWidth(465);
        gridTablesNumpad.setMaxWidth(465);
        gridTablesNumpad.setAlignment(Pos.CENTER);
        gridTablesNumpad.setPadding(new Insets(10, 0, 0, 0));
        tableNumberTextField.setMinWidth(465);
        tableNumberTextField.setMaxWidth(465);
        tableNumberTextField.setMinHeight(40);
        tableNumberTextField.setStyle("-fx-background-color:#F9D342;-fx-font-size:30");
        tableNumberTextField.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.intValue() > oldValue.intValue()) {
                    char ch = tableNumberTextField.getText().charAt(oldValue.intValue());
                    String s = tableNumberTextField.getText();
                    if(s.length()>2)
                        tableNumberTextField.setText(tableNumberTextField.getText(0, tableNumberTextField.getLength() - 1));
                    // Check if the new character is the number or char
                    if (!(ch >= '0' && ch <= '9')) {
                        // if it's not number then just delete the char
                        if (tableNumberTextField.getLength() > 0) {
                            tableNumberTextField.setText(tableNumberTextField.getText(0, tableNumberTextField.getLength() - 1));
                        }

                    }
                }
            }
        });

        hboxBot.setAlignment(Pos.CENTER);
        hboxBot.setPadding(new Insets(10, 0, 10, 0));
        vboxTop.setAlignment(Pos.CENTER);
        vboxTop.setPadding(new Insets(10, 10, 10, 10));
        vboxTop.setMinHeight(40);
        vboxTop.setMinWidth(465);
        vboxTop.setStyle("-fx-border-width:4;-fx-background-color:#F9D342;-fx-border-color:#292826;");
        hboxVboxInner.setStyle("-fx-border-width:2;-fx-border-color:#292826;-fx-font-weight:BOLD");

        for (int n = 1; n <= 12; n++) {
            row = (n - 1) / 3;
            column = n - (3 * row) - 1;
            Button bt = new Button(n + "");
            bt.setMinSize(100, 100);
            bt.setStyle("-fx-Color:#F9D342;-fx-font-size:28;-fx-font-weight:BOLD");
//          bt.setOnAction(e-> {passwordField.setText(passwordField.getText() + bt.getText());});
            bt.setOnAction(e -> {
                tableNumberTextField.appendText(bt.getText());
                
                
            });
            if(n==1){
            bt.setOnAction(e->{
            stg.setTableInterFaceInstanceScene();
            });}
            if (n == 10) {
                bt.setText("CLEAR");
                bt.setStyle("-fx-Color:#292826;-fx-font-size:20;-fx-font-weight:BOLD");
                bt.setOnAction(e -> {
                    if (tableNumberTextField.getLength() > 0) {
                        tableNumberTextField.setText(tableNumberTextField.getText(0, tableNumberTextField.getLength() - 1));
                    } else {
                        return;
                    }
                });
            }
            if (n == 11) {
                bt.setText("Tables");
                bt.setStyle("-fx-Color:#F9D342;-fx-font-size:22;-fx-font-weight:BOLD");
                bt.setOnAction(e -> {
                    stg.setTableScene();
                });

            }
            if (n == 12) {

                bt.setText("CLEAR ALL");
                bt.setStyle("-fx-Color:#292826;-fx-font-size:20;-fx-font-weight:BOLD");
                bt.setWrapText(true);
                bt.setPrefSize(USE_PREF_SIZE, USE_PREF_SIZE);
                bt.setTextAlignment(TextAlignment.CENTER);
                bt.setOnAction(e -> {
                    tableNumberTextField.clear();
                });
            }
            gridTablesNumpad.setVgap(10);
            gridTablesNumpad.setHgap(10);
            gridTablesNumpad.add(bt, column, row);
        }

        this.setTop(vboxTop);
        this.setCenter(gridTablesNumpad);
        this.setBottom(hboxBot);
//        this.setPadding(new Insets(0, 0, 10, 10));
        this.setStyle("-fx-border-color : black;-fx-background-color:#D3D3D3");

    }

}
