
package Bar_Managment1_3;


public class tableViewFields {
    private int Qty;
    private String itemName;

    public tableViewFields(int Qty, String itemName) {
        this.Qty = Qty;
        this.itemName = itemName;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
}
