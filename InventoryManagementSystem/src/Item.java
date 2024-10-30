import javax.swing.*;
import java.beans.PropertyChangeSupport;

public class Item {
    private String name;
    private int quantity;
    private double price;
    private PropertyChangeSupport support;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.support = new PropertyChangeSupport(this);
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        support.firePropertyChange("name", oldName, name);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        int oldQuantity = this.quantity;
        this.quantity = quantity;
        support.firePropertyChange("quantity", oldQuantity, quantity);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        double oldPrice = this.price;
        this.price = price;
        support.firePropertyChange("price", oldPrice, price);
    }
}
