/**
 * Created by Abdellatif on 4/15/2016.
 */
public class Item {
    // Add your implementation for Menu Items here.
    // Determine what data you want to store for each item
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
