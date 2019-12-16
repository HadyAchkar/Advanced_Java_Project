package barmanagment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class tableInterface extends BorderPane {

    private VBox vboxCategoriesRight;
    private Button[] categoryBtns;
    private FlowPane flowPaneWhiskey;
    private FlowPane flowPaneVodka;
    private FlowPane flowPaneCocktail;
    private FlowPane flowPaneSoftDrink;
    private Button[] softDrinkBtns;
    private Button[] whiskeyBtns;
    private Button[] vodkaBtns;
    private Button[] cocktailBtns;
    private FlowPane itemsPane;
    private BarManagment_2 stg;
    private TableView<Product> tableView;
    private ObservableList<Product> data;
    int counter = 1;

    public tableInterface(BarManagment_2 stg) {

        this.variableConstruction();

        this.paneLayouts();

        this.buttonLayouts();

        this.categorySetOnAction();

        this.addTable();

        this.drinkSetOnAction();

        this.setRight(vboxCategoriesRight);

        this.setLeft(tableView);

        this.setCenter(itemsPane);

    }

    private void addTable() {
        TableColumn<Product, String> quantityCol = new TableColumn("Quantity");
        TableColumn<Product, String> itemNameCol = new TableColumn("Item Name");
        TableColumn<Product, Double> itemPriceCol = new TableColumn("Price");
        quantityCol.setCellValueFactory(new PropertyValueFactory("quantity"));
        itemNameCol.setCellValueFactory(new PropertyValueFactory("name"));
        itemPriceCol.setCellValueFactory(new PropertyValueFactory("price"));

        tableView.setItems(data);
        tableView.getColumns().addAll(quantityCol, itemNameCol, itemPriceCol);

    }

    private void variableConstruction() {
        this.stg = stg;
        data = FXCollections.observableArrayList();

        tableView = new TableView();
        vboxCategoriesRight = new VBox(10);

        itemsPane = new FlowPane();
        flowPaneSoftDrink = new FlowPane();
        flowPaneVodka = new FlowPane();
        flowPaneCocktail = new FlowPane();
        flowPaneWhiskey = new FlowPane();
        categoryBtns = new Button[4];
        softDrinkBtns = new Button[4];
        whiskeyBtns = new Button[4];
        vodkaBtns = new Button[4];
        cocktailBtns = new Button[4];

        categoryBtns[0] = new Button("Soft Drink");
        categoryBtns[1] = new Button("Whiskey");
        categoryBtns[2] = new Button("Vodka");
        categoryBtns[3] = new Button("Cocktail");

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

    }

    private void paneLayouts() {

        itemsPane.setHgap(10);
        itemsPane.setVgap(10);
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
        vboxCategoriesRight.getChildren().addAll(categoryBtns);

    }

    private void buttonLayouts() {
        for (Button categoryBtn : categoryBtns) {
            categoryBtn.setMinSize(80, 80);
        }
        for (Button whiskeyBtn : whiskeyBtns) {
            whiskeyBtn.setMinSize(80, 80);
        }
        for (Button vodkaBtn : vodkaBtns) {
            vodkaBtn.setMinSize(80, 80);
        }
        for (Button cocktailBtn : cocktailBtns) {
            cocktailBtn.setMinSize(80, 80);
        }
        for (Button softDrinkBtn : softDrinkBtns) {
            softDrinkBtn.setMinSize(80, 80);
        }
    }

    private void categorySetOnAction() {
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

    }

    private void drinkSetOnAction() {

        for (Button softDrinkBtn : softDrinkBtns) {
            softDrinkBtn.setOnAction(e -> {

                data.add(new Product(1, softDrinkBtn.getText(), 0));

            });
        }
        for (Button whiskeyBtn : whiskeyBtns) {
            whiskeyBtn.setOnAction(e -> {
                data.add(new Product(1, whiskeyBtn.getText(), 0));
            });
        }
        for (Button vodkabtn : vodkaBtns) {
            vodkabtn.setOnAction(e -> {
                data.add(new Product(1, vodkabtn.getText(), 0));
            });
        }

        for (int i = 0; i < cocktailBtns.length; i++) {
            cocktailBtns[i].setOnAction(e -> {

                for (int j = 0; j < data.size(); j++) {
                    if (data.get(j).equals(cocktailBtns[i])) {
                        data.set(j, new Product(counter++, cocktailBtns[i].getText(), 0));
                    }
                    else data.add(new Product(1, "whatever", 0));
                }

            });

        }

    }
}
