package testing;

public class Product {

    private String name;
    public int quantity;
    private double price;

    public Product(int qty, String name, double price) {
        this.quantity = qty;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

}
