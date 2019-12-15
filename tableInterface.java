package Bar_Managment1_3;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class tableInterface extends BorderPane {

    private GridPane invoiceGrid;
    private VBox vboxCategoriesRight;
    private Button[] categoryBtns;
    private FlowPane flowPaneWhiskey;
    private FlowPane flowPaneVodka;
    private FlowPane flowPaneCocktail;
    private FlowPane flowPaneSoftDrink;
    private Button[] itemBtns;
    private int row, column;
    private Button[] softDrinkBtns;
    private Button[] whiskeyBtns;
    private Button[] vodkaBtns;
    private Button[] cocktailBtns;
    private FlowPane itemsPane;
    private BarManagment_2 stg;
    private TableView tableView;

    public tableInterface(BarManagment_2 stg) {
        this.stg = stg;
//        invoiceGrid = new GridPane();
        tableView = new TableView();

        vboxCategoriesRight = new VBox(10);
        categoryBtns = new Button[4];
        flowPaneSoftDrink = new FlowPane();

        flowPaneVodka = new FlowPane();
        flowPaneCocktail = new FlowPane();
        softDrinkBtns = new Button[4];
        whiskeyBtns = new Button[4];
//        flowPaneVodka.setMaxSize(500,500);
//        flowPaneWhiskey.setMaxSize(500, 500);
//        flowPaneCocktail.setMaxSize(500, 500);
        flowPaneWhiskey = new FlowPane();
        vodkaBtns = new Button[4];
        cocktailBtns = new Button[4];
        softDrinkBtns[0] = new Button("Pepsi");
        softDrinkBtns[1] = new Button("7-UP");
        softDrinkBtns[2] = new Button("Sprite");
        softDrinkBtns[3] = new Button("Fanta");

        whiskeyBtns[0] = new Button("Red Label");
        whiskeyBtns[1] = new Button("Black Label");
        whiskeyBtns[2] = new Button("J&D");
        whiskeyBtns[3] = new Button("Crown Royal Canadian");
        vodkaBtns[0] = new Button("Absolut");
        vodkaBtns[1] = new Button("Smirnoff");
        vodkaBtns[2] = new Button("Grey Goose");
        vodkaBtns[3] = new Button("Stolichnaya");
        cocktailBtns[0] = new Button("Old Fashioned");
        cocktailBtns[1] = new Button("Negroni");
        cocktailBtns[2] = new Button("Whiskey Sour");
        cocktailBtns[3] = new Button("Daiquiri");

        softDrinkBtns[0].setOnAction(e -> {
            tableView.getItems().add(new tableViewFields(1, "Pepsi"));
            tableView.getItems().add(new tableViewFields(1, "7-UP"));
        });

        itemsPane = new FlowPane();
        itemsPane.setHgap(10);
        itemsPane.setVgap(10);

        categoryBtns[0] = new Button("Soft Drink");
        categoryBtns[1] = new Button("Whiskey");
        categoryBtns[2] = new Button("Vodka");
        categoryBtns[3] = new Button("Cocktail");

        vboxCategoriesRight.getChildren().addAll(categoryBtns);

        flowPaneWhiskey.getChildren().addAll(whiskeyBtns);
        flowPaneWhiskey.setHgap(10);
        flowPaneWhiskey.setVgap(10);
        flowPaneVodka.getChildren().addAll(vodkaBtns);
        flowPaneVodka.setHgap(10);
        flowPaneVodka.setVgap(10);
        flowPaneCocktail.getChildren().addAll(cocktailBtns);
        flowPaneCocktail.setHgap(10);
        flowPaneCocktail.setVgap(10);
        flowPaneSoftDrink.getChildren().addAll(softDrinkBtns);
        flowPaneSoftDrink.setHgap(10);
        flowPaneSoftDrink.setVgap(10);
        itemsPane.setMaxSize(20, 20);
        itemsPane.setAlignment(Pos.TOP_CENTER);

        categoryBtns[0].setOnAction(e -> {
            itemsPane.getChildren().removeAll();
            itemsPane.getChildren().add(flowPaneSoftDrink);

        });
        categoryBtns[1].setOnAction(e -> {
            itemsPane.getChildren().removeAll();
            itemsPane.getChildren().add(flowPaneWhiskey);
        });
        categoryBtns[2].setOnAction(e -> {
            itemsPane.getChildren().removeAll();
            itemsPane.getChildren().add(flowPaneVodka);

        });
        categoryBtns[3].setOnAction(e -> {
            itemsPane.getChildren().removeAll();
            itemsPane.getChildren().add(flowPaneCocktail);

        });
//        for (int i = 0; i < categoryBtns.length; i++) {
//            if (i == 0) 
//                categoryBtns[0].setOnAction(e -> {
//                    itemsPane.getChildren().removeAll();
//                    itemsPane.getChildren().add(flowPaneSoftDrink);
//                });
//             else if (i == 1) 
//                categoryBtns[1].setOnAction(e -> {
//                    itemsPane.getChildren().removeAll();
//                    itemsPane.getChildren().add(flowPaneWhiskey);
//                });
//             else if (i == 2) 
//                categoryBtns[2].setOnAction(e -> {
//                    itemsPane.getChildren().removeAll();
//                    itemsPane.getChildren().add(flowPaneVodka);
//                });
//           
//            else
//                categoryBtns[3].setOnAction(e -> {
//                    itemsPane.getChildren().removeAll();
//                    itemsPane.getChildren().add(flowPaneCocktail);
//
//                });
//            
//        }

        this.addTable();
        this.setRight(vboxCategoriesRight);
        this.setLeft(tableView);
        this.setCenter(itemsPane);
        for (int i = 0; i < categoryBtns.length; i++) {
            categoryBtns[i].setMinSize(80, 80);
        }
        for (int i = 0; i < whiskeyBtns.length; i++) {
            whiskeyBtns[i].setMinSize(80, 80);
        }
        for (int i = 0; i < vodkaBtns.length; i++) {
            vodkaBtns[i].setMinSize(80, 80);
        }
        for (int i = 0; i < cocktailBtns.length; i++) {
            cocktailBtns[i].setMinSize(80, 80);
        }
        for (int i = 0; i < softDrinkBtns.length; i++) {
            softDrinkBtns[i].setMinSize(80, 80);
        }
    }

    private void addTable() {
        TableColumn Qty = new TableColumn();

        TableColumn itemName = new TableColumn();

    }

}
